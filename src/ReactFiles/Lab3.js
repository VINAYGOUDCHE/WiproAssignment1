import React, { useState } from "react";

const Phone = () => {
  // Declare a state object 'phone' with brand, model, and price
  const [phone, setPhone] = useState({
    brand: "Nothing",
    model: "2A",
    price: 30000,
  });

  // Function to increase the price
  const increasePrice = () => {
    // Create a new object with the same properties as 'phone'
    const newPhone = {
      brand: phone.brand,
      model: phone.model,
      price: phone.price + 2000, // Update the price
    };
    // Update the state with the new object
    setPhone(newPhone);
  };

  // Render the component's UI
  return (
    <div className="container text-center mt-5">
      <h2>📱 Phone Details</h2>
      <p>
        <b>Brand: </b> {phone.brand}
      </p>
      <p>
        <b>Model: </b> {phone.model}
      </p>
      <p>
        <b>Price: </b> ₹{phone.price}
      </p>
      <button onClick={increasePrice} className="btn btn-primary btn-lg mt-3">
        Increase Price
      </button>
    </div>
  );
};

export default Phone;