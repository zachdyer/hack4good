import React, { Component } from 'react';
import { Widget, addResponseMessage } from 'react-chat-widget';

import 'react-chat-widget/lib/styles.css';
import './Chat.css';

class App extends Component {
    componentDidMount() {
        addResponseMessage("Welcome to this awesome chat!");
      }
  
    handleNewUserMessage = (newMessage) => {
        console.log(`New message incoming! ${newMessage}`);
        // Now send the message throught the backend API
        addResponseMessage("How can I help you?");
      }
  render() {
    return (
      <div className="App">
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