import React, { useState, useEffect } from 'react';

const GetDataComponent = () => {
  const [data, setData] = useState('');

  useEffect(() => {
    fetch('https://localhost:8080/api/greeting') // Replace with your backend endpoint
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.text(); // Assuming the response is plain text
      })
      .then(text => {
        setData(text);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div>
      <h1>Main Screen</h1>
      <p>Data from the server: {data}</p>
    </div>
  );
};

export default GetDataComponent;