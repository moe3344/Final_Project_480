import React, { useState, useEffect } from 'react';

const GetRequest = () => {
  const [data, setData] = useState(null);

  useEffect(() => {
    // Define the URL of your localhost server
    const url = 'http://localhost:8080/flight/info'; // Replace with your localhost URL

    // Make a GET request using fetch
    fetch(url)
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        console.log(response)
        return response.json();
      })
      .then(data => {
        // Process the retrieved data
        setData(data);
      })
      .catch(error => {
        // Handle errors
        console.error('There was a problem with the fetch operation:', error);
      });
  }, []); // Empty dependency array ensures the effect runs only once (on mount)

  return (
    <div>
      <h1>GET Request to Localhost</h1>
      {data ? (
        <pre>{JSON.stringify(data, null, 2)}</pre>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
};

export default GetRequest;