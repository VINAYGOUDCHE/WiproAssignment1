import React, { useState } from 'react';

// Laptop brands
const brands = ['Dell', 'HP', 'Lenovo', 'Asus'];

// Static product name
const name = 'Laptop';

// Main component
const Electronics = () => {
  // State for brand
  const [brand, setBrand] = useState('Asus');

  // State for price
  const [price, setPrice] = useState(45000);

  // Handle brand selection
  const handleBrandChange = (event) => {
    setBrand(event.target.value);
  };

  // Handle price increase
  const handlePriceIncrease = () => {
    setPrice(prevPrice => prevPrice + 2000);
  };

  // Component's UI
  return (
    <div className="container text-center my-5">
      <h1 className="display-4 fw-bold">Electronic Item Details</h1>
      <div 
        className="card p-4 shadow-lg mx-auto rounded-3" 
        style={{ maxWidth: '400px' }}
      >
        {/* Display name */}
        <h2 className="fs-3 fw-normal mb-3">Name: {name}</h2>
        {/* Display brand */}
        <h2 className="fs-3 fw-normal mb-3">Brand: {brand}</h2>
        {/* Display price */}
        <h2 className="fs-3 fw-normal">Price: ₹{price}</h2>
      </div>
      <div className="d-flex justify-content-center align-items-center mt-4 gap-3">
        {/* Brand selection dropdown */}
        <select 
          className="form-select" 
          value={brand} 
          onChange={handleBrandChange} 
          style={{ width: '200px' }}
        >
          {/* Create brand options */}
          {brands.map((b) => (
            <option key={b} value={b}>{b}</option>
          ))}
        </select>
        {/* Price increase button */}
        <button 
          className="btn btn-primary rounded-3 shadow-sm" 
          onClick={handlePriceIncrease}
        >
          Increase Price
        </button>
      </div>
    </div>
  );
};

// Export component
export default Electronics;
