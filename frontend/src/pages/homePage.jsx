import React, { useState, useEffect } from 'react';

import TextLinkExample from '../components/navBar';
import DisplayFlights from '../components/flightDisplayHeader';
import ShowMap from '../components/showFlightMap';
import GetRequest from '../api/getRequest'; 

const HomePage = (props) => {
    const [selectedFlight, setSelectedFlight] = useState(0);
    const [data, setData] = useState(null);

    useEffect(() => {
      // Define the URL of your localhost server
      const url = 'http://localhost:8080/api/flightData'; // Replace with your localhost URL
  
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
          console.log(data);
        })
        .catch(error => {
          // Handle errors
          console.error('There was a problem with the fetch operation:', error);
        });
    }, []); // Empty dependency array ensures the effect runs only once (on mount)
  return (
    <div>
        < TextLinkExample email={props.email}/>
        {selectedFlight !== 0 && <ShowMap flightProp={selectedFlight}/>}
        <h1> Select From Avaliable Flights</h1>
        <DisplayFlights selectedID={setSelectedFlight} data={data}/>

    </div>
  );
};

export default HomePage;
