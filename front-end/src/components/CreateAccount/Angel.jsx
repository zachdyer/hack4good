import React, { Component } from "react";
import Success from "./Success";

// =====================================================================
// This is the form for the Angel registration and application process.
// It handles all of the mandatory data that is asked in order for the
// application to succeed.
// =====================================================================
export default class AngelRegister extends Component {
    constructor(props) {

        super(props);

        // =====================================================================
        // Many of these states are simply made in order to help store the form
        // information that will eventually be sent to the backend to be placed
        // in a database.
        // =====================================================================
        this.state = {
            username: "",
            email: "",
            password: "",
            confirm: "",
            fname: "",
            lname: "",
            aliases: "None",
            nickname: "",
            phone: -1,
            age: -1,
            reason: "None",
            refs: "None",
            address: "",
            experience: "None",
            volunteering: "None",
            permit_bgc: false,
            criminal_history: "None",
            gender: "",
            city: "",
            state: "",
            acct_type: "ANGEL"
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.validateForm = this.validateForm.bind(this);
        
    }
    

    // =====================================================================
    // Basic form validation done on the server side to prevent submission
    // without criterias to be met:
    // TODO: add in tool tips to tell the user what may or may not be wrong.
    // =====================================================================
    validateForm() {
        return (
            this.state.username.length > 3
            &&
            this.state.email !== ""
            &&
            this.state.password.length > 8
            &&
            this.state.confirm === this.state.password
            &&
            this.state.age >= 18
            && 
            this.state.age <= 140
            &&
            this.state.fname !== ""
            && 
            this.state.lname !== ""
            &&
            this.state.address !== ""
            &&
            this.state.phone.length === 10
            &&
            this.state.refs !== ""
            &&
            this.state.experience !== ""
            &&
            this.state.reason !== ""
            &&
            this.state.volunteering !== ""
            &&
            this.state.criminal_history !== ""
        )
    }

    // =====================================================================
    // A state change handler for the entry forms.
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
    // The handler for submitting the information to the back end server.
    // TODO: create post AJAX call to the backend.
    // =====================================================================
    handleSubmit(e) {
        console.log("Submitted");
        this.setState(
            state => ({
                redirect : true
            })
        )
    }

    render() {
        if (this.state.redirect) {
            return <Success kind="angel" email={this.state.email}/>
        }
        return (
            <div className="register mb-5 container">
                <div className="container">
                    <a href="/">
                        <img src="logo.png" className="mb-4" alt="" width="100%" />
                    </a>
                    <form
                        onSubmit={this.handleSubmit}
                    >
                        <h3>Required</h3>
                        <div
                            className="form-group"
                        >
                            <input
                                autoFocus
                                className="form-control"
                                type="text"
                                id="username"
                                placeholder="Username"
                                value={this.state.username}
                                onChange={this.handleChange}
                                data-toggle="popover"
                                title="Invalid username"
                                data-content="The username you entered is either too short or too long"
                            >
                            </input>
                            <small>(*Username length must be between 3-64 characters)</small>
                        </div>

                        <div
                            className="form-group"
                        >
                            <input
                                className="form-control"
                                type="email"
                                id="email"
                                placeholder="Email"
                                value={this.state.email}
                                onChange={this.handleChange}
                            >
                            </input>
                            <small>(e.g. JaneSmith@gmail.com)</small>
                        </div>

                        <div
                            className="form-group"
                        >
                            <input
                                className="form-control"
                                type="password"
                                id="password"
                                placeholder="Password"
                                minLength="8"
                                value={this.state.password}
                                onChange={this.handleChange}
                                data-toggle="popover"
                                data-placement="right"
                                title="Invalid Password"
                                data-content="The entered password is invalid"
                            >
                            </input>
                            <small>(*Passwords must have a minimum length of 8)</small>
                        </div>
                        <div
                            className="form-group"
                        >
                            <input
                                className="form-control"
                                type="password"
                                id="confirm"
                                placeholder="Confirm Password"
                                value={this.state.confirm_password}
                                onChange={this.handleChange}
                                data-toggle="tooltip"
                                data-placement="right"
                                title="Passwords do not match"
                            >
                            </input>
                        </div>

                        <div
                            className="form-group"
                        >
                            <input
                                className="form-control"
                                type="text"
                                id="fname"
                                placeholder="First Name"
                                value={this.state.fname}
                                onChange={this.handleChange}
                            >
                            </input>
                        </div>
                        <div
                            className="form-group"
                        >
                            <input
                                className="form-control"
                                type="text"
                                id="lname"
                                placeholder="last Name"
                                value={this.state.lname}
                                onChange={this.handleChange}
                            >
                            </input>
                        </div>

                        <div
                            className="form-group"
                        >
                            <textarea
                                className="form-control"
                                type="text"
                                id="aliases"
                                placeholder="Other legal names"
                                onChange={this.handleChange}
                            >
                            </textarea>
                        </div>

                        <div
                            className="form-group"
                        >
                            <input
                                className="form-control"
                                type="text"
                                id="address"
                                placeholder="Address"
                                value={this.state.address}
                                onChange={this.handleChange}
                            >
                            </input>
                        </div>
                        <div
                            className="form-group"
                        >
                            <input
                                className="form-control"
                                type="phone"
                                id="phone"
                                maxLength="10"
                                placeholder="Phone Number (eg. 1234567890)"
                                onChange={this.handleChange}
                            >
                            </input>
                        </div>
                        <div
                            className="form-group"
                        >
                            <textarea
                                className="form-control"
                                type="text"
                                id="refs"
                                placeholder="References comma separated"
                                onChange={this.handleChange}
                            >
                            </textarea>
                        </div>
                        <div
                            className="form-group"
                        >
                            <textarea
                                className="form-control"
                                type="textarea"
                                id="reason"
                                placeholder="Reason(s) why you want to become an angel..."
                                onChange={this.handleChange}
                            >
                            </textarea>
                        </div>
                        <div
                            className="form-group"
                        >
                            <textarea
                                className="form-control"
                                type="textarea"
                                id="experience"
                                placeholder="Experience helping others in crisis..."
                                onChange={this.handleChange}
                            >
                            </textarea>
                        </div>

                        <div
                            className="form-group"
                        >
                            <textarea
                                className="form-control"
                                type="textarea"
                                id="volunteering"
                                placeholder="Volunteer history or experience..."
                                onChange={this.handleChange}
                            >
                            </textarea>
                        </div>

                        <div
                            className="form-group"
                        >
                            <textarea
                                className="form-control"
                                type="text"
                                id="criminal_history"
                                placeholder="History of criminal or legal convictions"
                                onChange={this.handleChange}
                            >
                            </textarea>
                        </div>

                        <div
                            className="form-group"
                        >
                            <input
                                className="form-control"
                                type="number"
                                id="age"
                                maxLength="2"
                                min="18"
                                placeholder="Age"
                                onChange={this.handleChange}
                            >
                            </input>
                        </div>
                        
                        <h3>Optional</h3>


                        <div
                            className="form-group"
                        >
                            <input
                                className="form-control"
                                type="text"
                                id="nickname"
                                placeholder="Nickname"
                                value={this.state.nickname}
                                onChange={this.handleChange}
                            >
                            </input>
                        </div>

                        <div
                            className="form-group"
                        >
                            <select
                                className="form-control"
                                type="select"
                                id="gender"
                                onChange={this.handleChange}
                            >
                                <option value="" disabled defaultValue>Gender</option>
                                <option value="MALE">Male</option>
                                <option value="FEMALE">Female</option>
                                <option value="NONBINARY">Non-binary</option>
                            </select>
                        </div>

                        <div
                            className="form-group"
                        >
                            <input
                                className="form-control"
                                type="text"
                                id="city"
                                placeholder="City"
                                value={this.state.city}
                                onChange={this.handleChange}
                            >
                            </input>
                        </div>

                        <div
                            className="form-group"
                        >
                            <input
                                className="form-control"
                                type="text"
                                maxLength="2"
                                id="state"
                                placeholder="State"
                                value={this.state.state}
                                onChange={this.handleChange}
                            >
                            </input>
                        </div>
                        <button
                            className="form-control btn-primary"
                            disabled={!this.validateForm()}
                            type="submit"
                        >
                            Register
                        </button>
                    </form>
                </div>
            </div>
        );
    }
}