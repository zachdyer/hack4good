import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

function isLoggedIn() {
    return true;
}

class App extends Component {
  render() {
    if(isLoggedIn()) {
      console.log("user is logged in");
      return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <p>
              User is logged in.
            </p>
            <a
              className="App-link"
              href="https://reactjs.org"
              target="_blank"
              rel="noopener noreferrer"
            >
              Learn React
            </a>
          </header>
        </div>
      );
    } else {
      console.log("user is not logged in");
      return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <p>
              User is not logged in.
            </p>
            <a
              className="App-link"
              href="https://reactjs.org"
              target="_blank"
              rel="noopener noreferrer"
            >
              Learn React
            </a>
          </header>
        </div>
      );
    }
    
  }
}

export default App;
