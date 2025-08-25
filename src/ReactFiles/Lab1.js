import React from "react";
// this is the functional component
function GroceryList({ items }) {
  // Arrow Function to show alert when button is clicked
  const handleAddToCart = () => {
    alert("Groceries Added to Cart!");
  };

  return (
    <div className="text-center mt-4">
      {/* Heading for groceries */}
      <h2 className="fw-bold">Groceries List:</h2>

      {/* Dynamically creating list items using map() */}
      <ul className="d-inline-block text-start">
        {items.map((item, index) => (
          // key helps React to identify each element uniquely
          <li key={index} className="fw-medium">
            {item}
          </li>
        ))}
      </ul>
<br></br>
      {/* Button with Bootstrap styling */}
      <button className="btn btn-outline-dark mt-3" onClick={handleAddToCart}>
        Add to Cart
      </button>
    </div>
  );
}

export default GroceryList;