import React, { Component } from 'react';
import ReactDOM from 'react-dom'
import logo from './logo.svg';
import './App.css';

function isLoggedIn() {
    return true;
}

function getUserInfo() {
  return {
    name: "John Doe",
    email: "john.doe@gmail.com"
  }
}

class App extends Component {
  render() {
    var userInfo = getUserInfo();
    if(isLoggedIn()) {
      console.log("user is logged in");
      return (
        <div className="App" id="app">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <p>
              {userInfo.name} is logged in.
            </p>
          </header>
        </div>
      );
    } else {
      console.log("user is not logged in");
      return (
        <div className="App" id="app">
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
