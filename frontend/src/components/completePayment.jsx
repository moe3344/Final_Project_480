import React, { useState } from 'react';

import Form from 'react-bootstrap/Form';
import Col from 'react-bootstrap/esm/Col';
import Row from "react-bootstrap/esm/Row"
import Button from 'react-bootstrap/esm/Button';

function PaymentMethod() {
    const [cardNumber, setCardNumber] = useState(''); // State to store input value
    const [experationDate, setExperationDate] = useState(''); // State to store input value
    const [cvvValue, setCvvValue] = useState(0); // State to store input value
    const [emailAddress, setEmailAddress] = useState(''); // State to store input value

    const completePayment = async () => {
        try {
          // Perform an asynchronous operation (e.g., fetch data from an API)
          let url = `http://localhost:8080/api/pay/${cardNumber}/${experationDate}/${cvvValue}/${emailAddress}`
          console.log("Payment sent to url: " + url);
          const response = await fetch(url);
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
    <Form>
    <h1> Enter Credit Card Information </h1>
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
  );
}

export default PaymentMethod;