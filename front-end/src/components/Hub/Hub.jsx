import React, { Component } from "react";

export default class Hub extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return(
            <div>
                Hey, you're authenticated by the server. Cool, huh?
            </div>
        )
    }
}