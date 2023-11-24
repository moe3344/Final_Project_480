import React, { useState } from 'react';

const Login = (props) => {
  const [formData, setFormData] = useState({
    username: '',
    password: ''
  });

  const handleInputChange = event => {
    const { name, value } = event.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = event => {
    event.preventDefault();
    // TODO Add logic here to validate that it is the right login
    props.loggedInProp(true); // Set logged in to true
    props.emailProp(formData.username)
    props.passwordProp(formData.password)
    // Perform authentication logic with formData.username and formData.password
    // For simplicity, let's just log the values for demonstration purposes
    console.log('Submitted Username:', formData.username);
    console.log('Submitted Password:', formData.password);
    // Add your authentication logic here (e.g., API call to authenticate the user)
  };

  return (
    <div>
      <h1>Login</h1>
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
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;