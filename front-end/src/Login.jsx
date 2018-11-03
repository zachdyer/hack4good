import React, { Component } from "react";
import "./Login.css";
import CreateAccount from "./CreateAccount";

class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {
            authorized : false,
            create : false,
            forgot : false,
            identifier : "",
            password : ""
        };

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.validateForm = this.validateForm.bind(this);
        this.toggleCreate = this.toggleCreate.bind(this);
    }


    validateForm() {
        return (
            this.state.identifier.length > 0 
            &&
            this.state.password.length > 8
        )
    }

    handleSubmit(e) {
        console.log("We in here")
    }

    handleChange(e) {
        e.persist();
        this.setState(
            state => ({
                [e.target.id]: e.target.value
            })
        );
    }

    toggleCreate() {
        this.setState(
            state => ({
                create : true
            })
        )
    }

    render() {
        let create = <CreateAccount />;
        let login = (
            <div className="Login">
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <input 
                        autoFocus
                        type="text"
                        id="identifier"
                        placeholder="Email or username"
                        value={this.state.identifier}
                        onChange={this.handleChange}
                        >
                        </input>
                    </div>
                    <div>
                        <input
                        type="text"
                        id="password"
                        placeholder="Password"
                        value={this.state.password}
                        onChange={this.handleChange}
                        >
                        </input>
                    </div>
                    <div>
                        <button 
                        disabled={!this.validateForm()}
                        type="submit"
                        >
                        Login
                        </button>
                    </div>
                </form>
                <p>Need an account? <button className="anchor_look_alike" onClick={this.toggleCreate}>Create an account</button></p>
            </div>
        )

        if (this.state.create === true) {
            return create;
        } else if (this.state.forgot === true) {
            return 
        } else {
            return login;
        }
    }
}

export default Login;