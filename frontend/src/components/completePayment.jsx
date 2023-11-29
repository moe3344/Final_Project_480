import React, { useState } from 'react';

import Form from 'react-bootstrap/Form';
import Col from 'react-bootstrap/esm/Col';
import Row from "react-bootstrap/esm/Row"
import Button from 'react-bootstrap/esm/Button';

function PaymentMethod(props) {
    const [cardNumber, setCardNumber] = useState(''); // State to store input value
    const [experationDate, setExperationDate] = useState(''); // State to store input value
    const [cvvValue, setCvvValue] = useState(0); // State to store input value
    const [emailAddress, setEmailAddress] = useState(''); // State to store input value
    const [phoneNumber, setPhoneNumber] = useState(''); // State to store input value
    const [city, setCity] = useState(''); // State to store input value
    const [country, setCountry] = useState(''); // State to store input value
    const [state, setState] = useState(''); // State to store input value
    const [zipCode, setZipCode] = useState(''); // State to store input value
    const [streetName, setStreetName] = useState(''); // State to store input value
    const [streetNumber, setStreetNumber] = useState(''); // State to store input value
    const [payed, setPayed] = useState(false); // State to store input value

    const generateRandom16DigitNumber = () => {
      let min = 100000000000; // Minimum 16-digit number
      let max = 999999999999; // Maximum 16-digit number
  
      // Generate a random number within the specified range
      let randomNumber = Math.floor(Math.random() * (max - min + 1)) + min;
      let intparse = parseInt(randomNumber)
  
      return intparse;
  };

    const completePayment = async () => {
        try {
          // Perform an asynchronous operation (e.g., fetch data from an API)
          let url = `http://localhost:8080/api/makepayment`
          console.log("Payment sent to url: " + url);
          const headers = {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer YourAccessToken', // Replace with your authorization token if needed
            username: props.username,
            password: props.password,
            insurance: false, // TODO add this button
            recieptNumber: 4,
            seatNumber: props.selectedSeat,
            seatLetter: props.selectedLetter,
            flightId: props.flightId,
            phoneNumber: phoneNumber,
            city: city,
            country: country,
            state: state,
            zipCode: zipCode,
            streetName: streetName,
            streetNumber: streetNumber,
            cardNumber: cardNumber,
            expirationDate: experationDate,
            cvvNumber: cvvValue
            // Add more headers as needed
        };
          const response = await fetch(url, {
            method: "GET",
            headers: headers
          });
          if (!response.ok) {
            alert("Payment Not Valid!\n Please enter a Valid Credit Card")
            return 0;
          }
          const data = await response.json();
          console.log(data)
          if (data === true){
            console.log("Payment Completed")
            return 1;
          }
          alert("Payment Not Valid!\n Please enter a Valid Credit Card")
          return 0;
    
        } catch (error) {
          // Handle any errors that occur during the asynchronous operation
          console.error('Error fetching data:', error.message);
          throw error; // Re-throw the error for handling in the component
        }
      };
  return (
    <div>
      <Form>
    <h2> Enter Current Personal Information </h2>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Control type="phone" placeholder="Enter Phone Number" 
          onChange={(e) => setPhoneNumber(e.target.value)}/>
      </Form.Group>
      <Row className="mb-3">
        <Col>
          <Form.Control placeholder="Enter City"
          onChange={(e) => setCity(e.target.value)} />
        </Col>
        <Col>
          <Form.Control placeholder="Enter Country" 
          onChange={(e) => setCountry(e.target.value)}/>
        </Col>
      </Row>
      <Row className="mb-3">
        <Col>
          <Form.Control placeholder="Enter State"
          onChange={(e) => setState(e.target.value)} />
        </Col>
        <Col>
          <Form.Control placeholder="Enter Zip Code" 
          onChange={(e) => setZipCode(e.target.value)}/>
        </Col>
      </Row>
      <Row className="mb-3">
        <Col>
          <Form.Control placeholder="Enter Street Name"
          onChange={(e) => setStreetName(e.target.value)} />
        </Col>
        <Col>
          <Form.Control placeholder="Enter Street Number" 
          onChange={(e) => setStreetNumber(e.target.value)}/>
        </Col>
      </Row>
    </Form>
    <Form>
    <h2> Enter Credit Card Information </h2>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Control type="email" placeholder="Enter Card Number" 
          onChange={(e) => setCardNumber(e.target.value)}/>
      </Form.Group>
      <Row className="mb-3">
        <Col>
          <Form.Control placeholder="Enter Experation Date"
          onChange={(e) => setExperationDate(e.target.value)} />
        </Col>
        <Col>
          <Form.Control placeholder="Enter CVV" 
          onChange={(e) => setCvvValue(e.target.value)}/>
        </Col>
      </Row>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Control type="email" placeholder="Enter Email for Reciept / Ticket" 
        onChange={(e) => setEmailAddress(e.target.value)}/>
      </Form.Group>
      <Button variant="primary" size="lg" onClick={completePayment}>
        Pay For Ticket
      </Button>
    </Form>
    </div>
  );
}

export default PaymentMethod;