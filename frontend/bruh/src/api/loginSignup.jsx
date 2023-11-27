const loginAndSignUp = async (url, updateLogin) => {
    try {
      // Perform an asynchronous operation (e.g., fetch data from an API)
      const response = await fetch(url);
      if (!response.ok) {
        return 0;
      }
      const data = await response.json();
      console.log(data)
      if (data === true){
        console.log("here")
        updateLogin(true)
        return 1;
      }
      alert("Login Not Worked Please Sign Up")
      return 0;

    } catch (error) {
      // Handle any errors that occur during the asynchronous operation
      console.error('Error fetching data:', error.message);
      throw error; // Re-throw the error for handling in the component
    }
  };
  
export default loginAndSignUp;