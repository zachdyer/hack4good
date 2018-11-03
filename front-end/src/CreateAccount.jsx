import React, { Component } from "react";
import Register from "./Register";
import AngelRegister from "./Angel";
export default class CreateAccount extends Component {
    
    constructor(props) {
        super(props);

        this.state = {
            angel_form : false,
            user_form : false
        };

        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(e) {
        if (e.target.value === "user") {
            this.setState(
                state => ({
                    user_form : true
                })
            )
        } else {
            this.setState(
                state => ({
                    angel_form : true
                })
            )
        }
    }

    render() {
        let angel = <AngelRegister />;
        let register = <Register />;
        let choices = (
            <div className="container CreateAccount">
                <img className="mb-4" src="logo.png" width="100%" alt="" />
                <button
                    onClick={this.handleChange}
                    value={"user"}
                    className="btn btn-primary btn-lg btn-block"
                >
                Register as a user
                </button>

                <button
                    onClick={this.handleChange}
                    value={"angel"}
                    className="btn btn-primary btn-lg btn-block"
                >
                    Apply to become an angel!
                </button>
            </div>
        )

        if (this.state.user_form === true) {
            return register;
        } else if (this.state.angel_form === true) {
            return angel;
        } else {
            return choices;
        }

    }
}