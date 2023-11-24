import React from 'react';

class SeatMap extends React.Component {
  render() {
    // Generating an array of 10 elements for the grid
    const buttonData = Array.from({ length: 10 }, (_, index) => index + 1);

    return (
      <div className="button-grid">
        {buttonData.map((number) => (
          <button key={number}>Button {number}</button>
        ))}
      </div>
    );
  }
}

export default SeatMap;