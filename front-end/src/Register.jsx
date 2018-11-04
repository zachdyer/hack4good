import React, { Component } from "react";
// import Popover from "rm-react-popover";
export default class Register extends Component {
    
    constructor(props) {
        
        super(props);

        this.state = {
            username: "",
            email: "",
            password: "",
            confirm: "",
            fname: "",
            nickname: "",
            age: -1,
            gender: "",
            city: "",
            state: "",
            acct_type: "PERSON_IN_NEED"
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.validateForm = this.validateForm.bind(this);
        this.toggleHome = this.toggleHome.bind(this);
    }

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
            this.state.age >= 13
        )
    }

    handleChange(e) {
        e.persist();
        this.setState(
            state => ({
                [e.target.id]: e.target.value
            })
        );
    }

    handleSubmit(e) {
        console.log("Submitted");
        e.preventDefault();
    }
    
    toggleHome() {
        this.setState(
            state => ({
                home: true
            })
        );
    }

    render() {
        return (
            <div className="register mb-5 container">
                <a onClick={this.toggleHome}>
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
                            type="number"
                            id="age"
                            min="13"
                            maxLength="2"
                            placeholder="Age"
                            onChange={this.handleChange}
                        >
                        </input>
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
    
                    <h3>Optional</h3>
    
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
                            <option value="" disabled selected>Gender</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Non-binary">Non-binary</option>
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
        );
    }
}