import React, { useState } from 'react';
import loginAndSignUp from '../api/loginSignup';

const Login = (props) => {
  const [signUp, setSignUp] = useState(false);
  const [formData, setFormData] = useState({
    username: '',
    password: ''
  });

  const textStyle = {
    textAlign: 'center',
    color: 'blue',
    fontSize: '18px',
    margin: '20px 0',
    cursor: 'pointer',
  };

  const handleInputChange = event => {
    const { name, value } = event.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = event => {
    event.preventDefault();
    let endpoint = "login"
    if (signUp) {
      endpoint = "signup"
    }
    let chosenurl = `http://localhost:8080/api/${endpoint}/${formData.username}/${formData.password}`;
    console.log(chosenurl)
    const validLogin = loginAndSignUp(chosenurl, props.loggedInProp);
    console.log(validLogin)
    props.emailProp(formData.username)
    props.passwordProp(formData.password)
    // Perform authentication logic with formData.username and formData.password
    // For simplicity, let's just log the values for demonstration purposes
    console.log('Submitted Username:', formData.username);
    console.log('Submitted Password:', formData.password);
  };

  return (
    <div>
      {signUp ? <h1>Sign Up</h1> : <h1>Login</h1>}
      <form onSubmit={handleSubmit}>
        <div>
          <label>Username or Email:</label>
          <input
            type="text"
            name="username"
            value={formData.username}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label>Password:</label>
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleInputChange}
          />
        </div>
        <button type="submit">Continue to Flights</button>
        {
          !signUp ?
        <p style={textStyle} onClick={() => setSignUp(!signUp)}>
        Click here to sign up
      </p> :
      <p style={textStyle} onClick={() => setSignUp(!signUp)}>
      Click here to log in
    </p> 
      }
      </form>
    </div>
  );
};

export default Login;