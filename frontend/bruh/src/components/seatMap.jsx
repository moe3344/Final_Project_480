
// export default SeatMap;
import React from 'react';
import image from "../plane-transparent-web.png";

class SeatMap extends React.Component {
  render() {
    // Generating an array of 60 elements for the grid (10 rows, 6 columns)
    const row1 = Array.from({ length: 20 }, (_, index) => index + 1);
    const row2 = Array.from({ length: 20 }, (_, index) => index + 1)
    const row3 = Array.from({ length: 20 }, (_, index) => index + 1)

    return (
      <div className="plane-container" style={{ position: "relative", height: "100vh" }}>
        <img className="plane-image" src={image} alt="Plane" />
        <div className="button-grid" style={{ position: "absolute", top: "50%", left: "50%", transform: "translate(-50%, -50%)", textAlign: "center" }}>
          <div className='top-row'>
            <div>
              {row1.map((number) => (
                <button className={`seat-button`} key={number} id='seat-f'>
                  F
                </button>
              ))}
            </div>
            <div>
              {row2.map((number) => (
                <button className={`seat-button`} key={number} id='seat-e'>
                  E
                </button>
              ))}
            </div>
            <div>
              {row3.map((number) => (
                <button className={`seat-button`} key={number} id='seat-d'>
                  D
                </button>
              ))}
            </div>
          </div>

          <div className='seat-numbers-row'></div>
                1 2 3 4  
          <div className='bottom-row'>
            <div >
              {row1.map((number) => (
                <button className={`seat-button`} key={number} id='seat-c'>
                  C
                </button>
              ))}
            </div>
            <div>
              {row2.map((number) => (
                <button className={`seat-button`} key={number} id='seat-b'>
                  B
                </button>
              ))}
            </div>
            <div>
              {row3.map((number) => (
                <button className={`seat-button`} key={number} id='seat-a'>
                  A
                </button>
              ))}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default SeatMap;





