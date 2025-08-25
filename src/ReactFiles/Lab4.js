// SweetsList.jsx
import React from 'react';

// Functional component for a list of sweets
const SweetsList = () => {
  // Array of sweet objects
  const sweets = [
    { "id": 1, "name": "Rasmalai", "price": 85 },
    { "id": 2, "name": "Date Kova", "price": 90 },
    { "id": 3, "name": "Milk Cake", "price": 105 },
    { "id": 4, "name": "Doodh Peda", "price": 105 },
  ];

  // Render the list of sweets
  return (
    <div className="container mt-5">
      <h1>Sweets List:</h1>
      {/* Map through the sweets array to display each item */}
      <ul className="d-inline-block text-start">
        {sweets.map(sweet => (
          // Use a unique key for each list item
          <li key={sweet.id}>
            {sweet.name} - Price: ₹{sweet.price}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default SweetsList;