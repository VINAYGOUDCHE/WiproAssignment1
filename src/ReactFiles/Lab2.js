import React, { Component } from "react";
//its a Class compenent
class Car extends Component {
  // (render) mandatory method to display
  render() {
    // destructuring properties
    //values are stored in this.props
    const { brand, model, color, year } = this.props;

    return (
      <div >
        <h2>Car Details:</h2>
        {/* printing details */}
        <p><b>Brand:</b> {brand}</p>
        <p><b>Model:</b> {model}</p>
        <p><b>Color:</b> {color}</p>
        <p><b>Year:</b> {year}</p>
      </div>
    );
  }
}

export default Car;