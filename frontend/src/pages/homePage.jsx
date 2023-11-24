import React, { useState } from 'react';

import TextLinkExample from '../components/navBar';
import DisplayFlights from '../components/flightDisplayHeader';
import ShowMap from '../components/showFlightMap';

const HomePage = (props) => {
    const [selectedFlight, setSelectedFlight] = useState(0);
    const practiceDataFlight = [
        { id: 1, takeOff: 'Alice', destination: "Calgary", seats: 25, cost: 25 },
        { id: 2, takeOff: 'Alice', destination: "Edmonton", seats: 25, cost: 25 }
        // ... more objects
      ];

  return (
    <div>
        < TextLinkExample email={props.email}/>
        <h1> Select From Avaliable Flights</h1>
        <DisplayFlights selectedID={setSelectedFlight} data={practiceDataFlight}/>
        {selectedFlight !== 0 && <ShowMap flightProp={selectedFlight}/>}

    </div>
  );
};

export default HomePage;
