import React, { Component } from "react";
// import Popover from "rm-react-popover";
export default class Regular extends Component {
    
    constructor(props) {
        
        super(props);

        this.state = {
            username: "",
            email: "",
            password: "",
            fname: "",
            lname: "",
            nickname: "",
            age: -1,
            gender: "",
            city: "",
            state: "",
            acct_type: "PERSON_IN_NEED"
        }
    }

    render() {
        return (
            <div className="regular">
                <div>
                    <form
                    onSubmit={this.handleSubmit}
                    >
                    <div
                    className="form-group"
                    >
                        <input
                        autoFocus
                        className="form-control"
                        type="email"
                        id="username"
                        placeholder="Username"
                        value={this.state.username}
                        onChange={this.handleChange}
                        data-toggle="popover"
                        title="Invalid email"
                        data-content="The email you have entered is invalid"
                        >
                        </input>
                    </div>
                    <div
                    className="form-group"
                    >
                        <input
                        className="form-control"
                        type="password"
                        id="password"
                        placeholder="Passwprd"
                        value={this.state.password}
                        onChange={this.handleChange}
                        data-toggle="popover"
                        title="Invalid Password"

                        >
                        </input>
                    </div>
                        <input>
                        </input>
                    </form>
                </div>
            </div>
        );
    }
}