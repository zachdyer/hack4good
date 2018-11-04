import React, { Component } from 'react';
import { Widget, addResponseMessage } from 'react-chat-widget';
import Home from "./App.jsx";
import 'react-chat-widget/lib/styles.css';
import './Chat.css';

class App extends Component {
    constructor(props) {
      super(props);
      this.state = {
        create : false,
        login : false,
        immediate : false
      }
      this.toggleHome = this.toggleHome.bind(this);
    }
    
    componentDidMount() {
        addResponseMessage("Welcome to this awesome chat!");
      }
  
    handleNewUserMessage = (newMessage) => {
        console.log(`New message incoming! ${newMessage}`);
        // Now send the message throught the backend API
        addResponseMessage("How can I help you?");
      }
      
    toggleHome() {
        this.setState(
            state => ({
                home: true
            })
        );
    }
    render() {
      if(this.state.home) {
        return (<Home />)
      }
      return (
        <div className="container Chat">
          <a onClick={this.toggleHome}>
              <img src="logo.png" className="mb-4" alt="" width="100%" />
          </a>
          <Widget 
              handleNewUserMessage={this.handleNewUserMessage}
              title="Chat Window"
              subtitle="We are connecting you to an angel now..."
          />
        </div>
      );
    }
}

export default App;