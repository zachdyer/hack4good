import React, { Component } from "react";
import "./Login.css";
import CreateAccount from "./CreateAccount";

// =========================================================
// The Login component for rendering the login page.
// =========================================================

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
            identifier : "",
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
            this.state.identifier.length > 0 
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
        console.log(this.state.password);
        console.log(this.state.identifier);
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
                <img className="mb-4" src="logo.png" width="100%"/>
                <form 
                onSubmit={this.handleSubmit}
                className="form-signin"
                >
                    <div>
                        <input 
                        autoFocus
                        className="form-control"
                        type="email"
                        id="identifier"
                        placeholder="Email or username"
                        value={this.state.identifier}
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
        } else {
            return login;
        }
    }
}

export default Login;