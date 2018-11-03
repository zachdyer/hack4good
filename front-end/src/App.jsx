import React, { Component } from 'react';
// import ReactDOM from 'react-dom'
// import logo from './logo.svg';
import './App.css';
import Login from "./Login";
import CreateAccount from "./CreateAccount"

class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      create : false,
      login : false,
      immediate : false
    }
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  // When you clickity-click, change the states
  // Each state is like the US states, finicky and slow
  // but it will render the right page on click. Ain't that neat.
  handleSubmit(e){
    // console.log(e.target.value)
    if (e.target.value === "create") {
      this.setState(state => ({
        create: true,
        login: false,
        immediate: false
      }));
    } else if (e.target.value === "login") {
      this.setState(state => ({
        create: false,
        login: true,
        immediate: false
      }));
    } else if (e.target.value === "immediate") {
      this.setState(state => ({
        create: false,
        login: false,
        immediate: true
      }));
    }
  }

  render() {
    let home = (<div>
      <img class="mb-4" src="logo.png" alt="" width="100%"/>
      <div className="btn-group-vertical">
        <button onClick={this.handleSubmit} value={"immediate"} className="btn btn-primary btn-lg">
          Get immediate help
        </button>
        <button onClick={this.handleSubmit} value={"login"} className="btn btn-primary btn-lg">
          login
        </button>
        <button onClick={this.handleSubmit} value={"create"} className="btn btn-primary btn-lg">
          Create an account
        </button>
      </div>
    </div>);

    
    if (this.state.login === true) {
      return <Login />;
    } else if (this.state.create) {
      return <CreateAccount />;
    } else {
      return home;
    }
  }
}

export default Home;
