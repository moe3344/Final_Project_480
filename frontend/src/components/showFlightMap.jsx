import React, { useState } from 'react';


import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';


//TODO could add image later to card make it look better?
// <Card.Img variant="top" src="https://media.united.com/images/Media%20Database/SDL/Travel/inflight/aircraft/777-200/777_200_(50_24_202)_V1_2272x649.gif" />


function ShowMap(props) {
    const [boughtTicket, setBoughtTicket] = useState(false);


  return (
    <div>
    <Card style={{ width: '18rem', display: "contents"}}>
      <Card.Body>
        <Card.Title>Flight To {props.flightProp.destination}</Card.Title>
        <Card.Text>
          Buy a ticket for flight {props.flightProp.takeOff} to {props.flightProp.destination} 
          for {props.flightProp.cost}$, {props.flightProp.seats} seats left for purchase!
        </Card.Text>
        <Button variant="primary" onClick={() => setBoughtTicket(true)}>Buy Tickets</Button>
      </Card.Body>
    </Card>
    {boughtTicket && <h2>Succesfully Purchased Ticket! Check Email for Reciept and Ticket </h2>}
    </div>
  );
}

export default ShowMap;