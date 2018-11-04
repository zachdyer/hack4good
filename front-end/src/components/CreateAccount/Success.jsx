import React, { Component } from "react";
import Home from "./../../App";

export default class Success extends Component {
    constructor(props) {
        super(props)

        this.state = { seconds : 0 }
    }

    tick() {
        if (this.state.seconds > 8) {
            this.redirect = true;
        }
        this.setState(
            state => ({
                seconds : state.seconds + 1
            })
        )
    }

    componentDidMount() {
        this.interval = setInterval( () => this.tick(), 1000);
    }
    
    render() {
        if (this.redirect) {
            return <Home />
        }
        if (this.props.kind === "angel") {
            return (
            <div className="container Success">
                <img src="logo.png" className="mb-4" alt="" width="100%" />
                <p>
                    Thank you for your interest in becoming an Angel.
                    Your information will be reviewed, and you will be notified via email at {this.props.email} within 5-7 business days.
                    You will soon be redirected to the home page.
                </p>
            </div>)
        } else {
            return (
                <div className="container Success">
                    <img src="logo.png" className="mb-4" alt="" width="100%" /> 
                    <p>
                        Thank you. You will soon be redirected to the home page where you can be connected to an angel ASAP.
                    </p>
                </div>
            )
        }
    }
}