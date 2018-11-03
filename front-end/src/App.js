import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

function isLoggedIn() {
    return false;
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
              Welcome, {userInfo.name}!
            </p>
          </header>
          
        </div>
      );
    } else {
      console.log("user is not logged in");
      return (
        <div className="App" id="app">
          <header className="App-header">
            <form class="form-signin">
              <img src={logo} className="App-logo" alt="logo" />
              <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
              <label for="inputEmail" class="sr-only">Email address</label>
              <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus/>
              <label for="inputPassword" class="sr-only">Password</label>
              <input type="password" id="inputPassword" class="form-control" placeholder="Password" required/>
              <div class="checkbox mb-3">
                <label>
                  <input type="checkbox" value="remember-me"/> Remember me
                </label>
              </div>
              <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
              <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
            </form>
            
          </header>
        </div>
      );
    }
    
  }
}

export default App;
