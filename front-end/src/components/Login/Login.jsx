import React, { Component } from "react";
import Home from "./../../App.jsx"; 
import "./Login.css";
import CreateAccount from "./../CreateAccount/CreateAccount";

// =====================================================================
// The Login component for rendering the login page.
// =====================================================================

class Login extends Component {
    
    // =====================================================================
    // Constructor
    // =====================================================================
    constructor(props) {
        super(props);

        // =====================================================================
        // Initialize the state of page as expected.
        // - Authorized
        //      - Is used to keep track of the state of whether the
        //        user is authorized/authenticated
        //      - Initial value: null
        //      - Possible values
        //          - true : Under this condition, route the user to
        //            the appropriate screen for successful login.
        //          - false : Under this condition, the user failed
        //            to be authorized and therefore must try again.
        // - create
        //      - Used to toggle the rendering of the CreateAccount
        //        component.
        //      - Initialized to false and is toggled on button click.
        // - forgot
        //      - Used to toggle the routing to ForgotPassword component
        //      - Initialized to false andis toggled on button click.
        // - identifier
        //      - Holds the current state of the entry field for the
        //        username/email.
        // - password
        //      - Holds the current state of the entry field for the
        //        password.
        // =====================================================================
        this.state = {
            authorized : null,
            create : false,
            forgot : false,
            home: false,
            identifier : "",
            email : "",
            password : ""
        };
        
        // =====================================================================
        // Bind "this" to the different functions that require it.
        // =====================================================================
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.validateForm = this.validateForm.bind(this);
        this.toggleCreate = this.toggleCreate.bind(this);
        this.toggleForgot = this.toggleForgot.bind(this);
    }

    // =====================================================================
    // Validates the form to ensure it meets minimum requirements
    // e.g. the length of a username/email and the length of a password
    // =====================================================================
    validateForm() {
        return (
            this.state.email.length > 3 
            &&
            this.state.password.length > 8
        )
    }

    // =====================================================================
    // As of now, this simply ensures that the data
    // is available in the format that we have made.
    // Once the backend is ready, his will submit a GET
    // request to the end point APIs for authorizaiton/authnetication
    // =====================================================================
    handleSubmit(e) {
        
        let server = "http://ec2-18-216-155-150.us-east-2.compute.amazonaws.com:8080/login"

        let formBody = [];
        let componentKey = encodeURIComponent("email");
        let componentValue = encodeURIComponent(this.state.email);

        formBody.push(componentKey + "=" + componentValue);

        componentKey = encodeURIComponent("password");
        componentValue = encodeURIComponent(this.state.password);

        formBody.push(componentKey + "=" + componentValue);

        formBody = formBody.join("&")
        fetch(
            server, {
                method: "POST",
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
                },
                body: formBody
            }
        ).then(res => res.json()).then(
            (result) => {
                console.log(decodeURIComponent(result[1]));
            },
            (error) => {
                console.log("FAILED");
                console.log(error);
            }
        )


        e.preventDefault()
    }

    // =====================================================================
    // This function handles the changes in the entry fields.
    // It saves the state of those entry fields under the appropriate id.
    // It should only affect the following states:
    //      - Identifier (Email or Username)
    //      - Password (Must be of length > 8)
    // =====================================================================
    handleChange(e) {
        e.persist();
        this.setState(
            state => ({
                [e.target.id]: e.target.value
            })
        );
    }

    // =====================================================================
    // Toggles the create state in order to render the CreateAccount
    // component.
    // =====================================================================
    toggleCreate() {
        this.setState(
            state => ({
                create : true
            })
        )
    }

    // =====================================================================
    // Toggles the forgot state in order to render the ForgotPassword
    // component.
    // =====================================================================
    toggleForgot() {
        this.setState(
            state => ({
                forgot : true
            })
        )
    }
    

    // =====================================================================
    // Renders the page
    // =====================================================================
    render() {
        let create = <CreateAccount />;
        let forgot = null;
        let login = (
            <div className="container Login">
                <a href="/">
                    <img className="mb-4" src="logo.png" width="100%" alt=""/>
                </a>
                <form 
                onSubmit={this.handleSubmit}
                className="form-signin"
                >
                    <div>
                        <input 
                        autoFocus
                        className="form-control"
                        type="text"
                        id="email"
                        placeholder="Email or username"
                        value={this.state.email}
                        onChange={this.handleChange}
                        >
                        </input>
                    </div>
                    <div>
                        <input
                        className="form-control"
                        type="password"
                        id="password"
                        placeholder="Password"
                        value={this.state.password}
                        onChange={this.handleChange}
                        >
                        </input>
                    </div>
                    <div>
                        <button 
                        className="form-control btn-primary mt-5"
                        disabled={!this.validateForm()}
                        type="submit"
                        >
                        Login
                        </button>
                    </div>
                    <p>Need an account? <button className="anchor_look_alike" onClick={this.toggleCreate}>Create an account</button></p>
                    <button className="anchor_look_alike" onClick={this.toggleForgot}>Forgot Password</button>
                </form>
            </div>
        );

        if (this.state.create === true) {
            return create;
        } else if (this.state.forgot === true) {
            return forgot;
        } else if (this.state.home === true) {
            return <Home />;
        } else {
            return login;
        }
    }
}

export default Login;