import React, { useState } from 'react';
import './App.css';

import GetDataComponent from './components/apiCall';
import Login from './pages/loginPage';
import HomePage from './pages/homePage';


function App() {

  // Two string state variables
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  // One boolean state variable
  const [loggedIn, setLoggedIn] = useState(false);


  return (
    <div className="App">
      {!loggedIn ? <Login emailProp={setEmail} passwordProp={setPassword}
      loggedInProp={setLoggedIn}/> :
      <div> <HomePage email={email}/> </div> }
    </div>
  );
}

export default App;
