import React, { Component } from 'react';
import './App.css';
import Login from "./components/Login/Login";
import CreateAccount from "./components/CreateAccount/CreateAccount"
import Chat from "./components/Chat/Chat";

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

  donation() {
    window.open("https://4agc.com/donation_pages/c9252832-caf3-4cf1-99eb-7450c0dc4699?gift_id=3fbcc69f-54aa-4581-b01b-93106c58b131");
  }

  // When you clickity-click, change the states
  // Each state is like the US states, finicky and slow
  // but it will render the right page on click. Ain't that neat.
  handleSubmit(e){
    console.log(e.target.value)
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
    } else if (e.target.value === "home") {
      this.setState(state => ({
        create: false,
        login: false,
        immediate: false,
        home: true
      }));
    }
  }

  render() {
    let home = (<div className="container home" id="home">
      <img className="mb-4" src="logo.png" width="100%" alt=""/>
      <button
        onClick={this.handleSubmit} 
        value={"immediate"} 
        className="btn btn-primary btn-lg btn-block">
        Get immediate help
      </button>
      
      <button 
        onClick={this.handleSubmit} 
        value={"login"} 
        className="btn btn-primary btn-lg btn-block">
        login
      </button>
      <button onClick={this.handleSubmit} value={"create"} className="btn btn-primary btn-lg btn-block">
        Create an account
      </button>
      <button onClick={this.donation} className="btn btn-primary btn-lg btn-block">
        Donate
      </button>
      
      <small>At any time before login, press the logo to return here</small>
    </div>
    );

    if (this.state.login) {
      return <Login />;
    } else if (this.state.create) {
      return <CreateAccount />;
    } else  if (this.state.immediate) {
      return <Chat />
    } else if(this.state.home){
      return <Home />;
    } else {
      return home;
    }
  }
}

export default Home;
