import Table from 'react-bootstrap/Table';

function DisplayFlights(props) {
    

    const DisplayList = (data) => {
        return data.map((item) => (
            <tr onClick={() => props.selectedID(item)}>
                <td>{item.id}</td>
                <td>{item.takeOff}</td>
                <td>{item.destination}</td>
                <td>{item.seats}</td>
                <td>{item.cost}</td>
            </tr>
          ));
      };
  return (
    <Table striped bordered hover>
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