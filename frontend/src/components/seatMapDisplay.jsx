import React from 'react';
import image from "../images/planeTransparent.png"
import "../css/cssSeats.css"


class SeatMapDisplay extends React.Component {


  componentDidMount() {
    let blockedSeats = this.props.flightProp.availableBusinessSeats + 
                        "-" + this.props.flightProp.availableComfortSeats 
                        + "-" + this.props.flightProp.availableOrdinarySeats
    // Function to run after the component is rendered
    makeButtonsGray(blockedSeats);
  }


  render() {
    // Generating an array of 60 elements for the grid (10 rows, 6 columns)
    const rows = Array.from({ length: 20 }, (_, index) => index + 1);
    const seatLetters1 = ['A', 'B', 'C'];
    const seatLetters2 = ['D', 'E', 'F'];
    console.log(this.props.flightProp);

    return (
      <div className="plane-container" style={{ position: "relative", height: "100vh" }}>
        <img className="plane-image" src={image} alt="Plane" />
        <div className="button-grid" style={{ position: "absolute", top: "50%", left: "50%", transform: "translate(-50%, -50%)", textAlign: "center" }}>
          <div className='top-row'>
            {seatLetters1.map((letter) => (
              <div key={letter}>
                {rows.map((number) => (
                  <button
                    className={`seat-button ${number <= 2 ? 'first-class' : (number <= 6 ? 'comfort' : 'ordinary')}`}
                    key={`${number}${letter}`}
                    id={`${number}${letter}`}
                    onClick={() => {
                      this.props.selectedLetter(letter);
                      this.props.selectedSeat(number);
                      

                    }}
                  >
                    {letter}
                  </button>
                ))}
              </div>
            ))}
          </div>

          <div className='seat-numbers-row'></div>
          <div className='bottom-row'>
            {seatLetters2.map((letter) => (
              <div key={letter}>
                {rows.map((number) => (
                  <button
                    className={`seat-button ${number <= 2 ? 'first-class' : (number <= 6 ? 'comfort' : 'ordinary')}`}
                    key={`${ number}${letter}`}
                    id={`${number}${letter}`}
                    onClick={() => {
                      this.props.selectedLetter(letter);
                      this.props.selectedSeat(number);

                    }}
                  >
                    {letter}
                  </button>
                ))}
              </div>
            ))}
          </div>
        </div>
      </div>
    );
  }
}

export default SeatMapDisplay;

function makeButtonsGray(seatIdString) {
  // Parse the seat ID string into an array
  const seatIds = seatIdString.split('-');

  // Iterate through each seat ID and update the button style
  seatIds.forEach((seatId) => {
    const button = document.getElementById(seatId);

    // Check if the button element exists before trying to modify its style
    if (button) {
      // Set the button style to make it gray
      button.style.backgroundColor = 'gray';
      // Make the button unclickable
      button.disabled = true;
      // You can also modify other styles as needed
    } else {
      console.error(`Element with ID ${seatId} not found.`);
    }
  });
}
