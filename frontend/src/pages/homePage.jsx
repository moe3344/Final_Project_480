import React, { useState, useEffect } from 'react';

import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';
import Button from 'react-bootstrap/esm/Button';

import TextLinkExample from '../components/navBar';
import DisplayFlights from '../components/flightDisplayHeader';
import SeatMapDisplay from '../components/seatMapDisplay';
import PaymentMethod from '../components/completePayment';


const HomePage = (props) => {
    const [selectedFlight, setSelectedFlight] = useState(0);
    const [seat, setSelectedSeat] = useState("Please Select Seat!");
    const [selectedTab, setSelectedTab] = useState('home');
    const [data, setData] = useState(null);
    const [enterPayment, setEnterPayment] = useState(true);
    const [seatLetter, setSeatLetter] = useState("");
    const [seatNumber, setSeatNumber] = useState(0);

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
        <h1>Welcome to SkyLuxeAirways</h1>
        <Tabs
          id="controlled-tab-example"
          activeKey={selectedTab}
          onSelect={(k) => setSelectedTab(k)}
          className="mb-3"
        >
          <Tab eventKey="home" title="Select Flight">
            <h2> Select From Avaliable Flights</h2>
            <DisplayFlights selectedID={setSelectedFlight} data={data}
            nextTab={setSelectedTab}/>
          </Tab>
          <Tab eventKey="seats" title="Select Seat">
            {selectedFlight !== 0 ?
            <div>
              <h2> Select Your Seat</h2>
              {seatLetter &&
              <div>
                <span>Currently Selected Seat: {seatLetter}-{seatNumber} for {selectedFlight.flightCost}$     </span>
                <Button  onClick={() => setSelectedTab("contact")}variant="primary">Click Here to Checkout</Button>{' '}
              </div> }
              <SeatMapDisplay flightProp={selectedFlight} seat={seat}
              selectedLetter={setSeatLetter} selectedSeat={setSeatNumber}/>
            </div> : 
            <h1>Please First Select a Flight<br/>Then Select your Seat!</h1>}
          </Tab>
          <Tab eventKey="contact" title="Pay For Ticket">
            {enterPayment && <PaymentMethod username={props.email} password={props.password} 
            selectedLetter={seatLetter} flightId={selectedFlight.flightNumber}
            selectedSeat={seatNumber}/>}
          </Tab>
        </Tabs>
    </div>
  );
};

export default HomePage;
