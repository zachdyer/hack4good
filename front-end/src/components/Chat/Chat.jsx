import React, { Component } from 'react';
import { Widget, addResponseMessage } from 'react-chat-widget';
import Home from "./../../App.jsx";
import 'react-chat-widget/lib/styles.css';
import './Chat.css';


// =====================================================================
// Utilize a built App created by react-chat-widget that will open a
// chat window.
// =====================================================================
class App extends Component {
    constructor(props) {
      super(props);
      this.state = {
        create : false,
        login : false,
        immediate : false
      }
    }
    
    componentDidMount() {
        addResponseMessage("Welcome to this awesome chat!");
      }
  
    handleNewUserMessage = (newMessage) => {
        console.log(`New message incoming! ${newMessage}`);
        // Now send the message throught the backend API
        addResponseMessage("How can I help you?");
      }
      
    render() {
      if(this.state.home) {
        return (<Home />)
      }
      return (
        <div className="container Chat">
          <a href="/">
              <img src="logo.png" className="mb-4" alt="" width="100%" />
          </a>
          <Widget 
              handleNewUserMessage={this.handleNewUserMessage}
              title="Chat Window"
              subtitle=""
          />
        </div>
      );
    }
}

export default App;