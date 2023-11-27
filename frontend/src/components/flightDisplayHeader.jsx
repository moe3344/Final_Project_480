import Table from 'react-bootstrap/Table';

function DisplayFlights(props) {

    const DisplayList = (data) => {
      if (!data) return; // Check if not data exist currently

        return data.map((item) => (
            <tr onClick={() => props.selectedID(item)}>
                <td>{item.flightNumber}</td>
                <td>{item.flightStartPoint}</td>
                <td>{item.flightDest}</td>
                <td>{item.seats}</td>
                <td>{item.flightCost}</td>
            </tr>
          ));
      };
  return (
    <Table striped bordered hover style={{maxHeight: "20px", overflowY: "auto"}}>
      <thead>
        <tr>
          <th>FlightID</th>
          <th>Take Off</th>
          <th>Destination</th>
          <th>Available Seats</th>
          <th>Flight Cost</th>
        </tr>
      </thead>
      <tbody>
        {DisplayList(props.data)}
      </tbody>
    </Table>
  );
}

export default DisplayFlights;