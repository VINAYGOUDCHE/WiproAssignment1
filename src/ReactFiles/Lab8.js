import React, { Component } from "react";

// Child Component
class MenuItem extends Component {
  // Renders a single menu item with its details.
  render() {
    const { name, price, category, available } = this.props;

    // Checks if the item is available to set the correct text and style.
    const availabilityText = available ? "Available" : "Not Available";
    const availabilityClass = available ? "text-success" : "text-danger";

    return (
      <li style={{ textAlign: "left" }}>
        <strong>{name}</strong> - ₹{price} ({category})
        <span className={availabilityClass}> ({availabilityText})</span>
      </li>
    );
  }
}

// Parent Component
class Restaurant extends Component {
  // Renders the restaurant's information and menu.
  render() {
    return (
      <div className="container py-4">
        <h1 className="text-center mb-4">Restaurant Name: Spice Hub</h1>
        <p className="text-center">
          <strong>Location:</strong> Block B, First Floor
        </p>
        <p className="text-center">
          <strong>Open Hours:</strong> 10:00 AM – 10:00 PM
        </p>
        <h2 className="mt-4 mb-3 text-center">Restaurant Menu:</h2>

        {/* This div centers the list of menu items. */}
        <div className="d-flex justify-content-center">
          <ul style={{ paddingLeft: "0", listStylePosition: "inside" }}>
            {/* These are the individual menu items. */}
            <MenuItem name="Hyderabadi Biryani" price={300} category="Main Course" available="Yes" />
            <MenuItem name="Haleem" price={250} category="Stew" available="Yes" />
            <MenuItem name="Qubani Ka Meetha" price={120} category="Dessert" available="Yes" />
            <MenuItem name="Irani Chai" price={50} category="Beverage" available="Yes" />
            <MenuItem name="Mirchi Ka Salan" price={100} category="Side Dish" available="Yes" />
            <MenuItem name="Osmania Biscuits" price={60} category="Snack" available="Yes" />

          </ul>
        </div>
      </div>
    );
  }
}

export default Restaurant;