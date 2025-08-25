import React, { useEffect, useState } from 'react';

// A simple component to display a loading message
const LoadingComponent = () => (
  <div className="alert alert-info text-center">Loading product details...</div>
);

// A simple component to display an error message
const ErrorComponent = () => (
  <div className="alert alert-warning text-center">⚠️ Error fetching product details</div>
);

// This component displays the details of a single product
const ProductComponent = ({ product }) => (
  <div className="card p-3 text-start">
    <h5>Electronic Product Details</h5>
    {/* Display basic product information */}
    <p><strong>Name:</strong> {product.name}</p>
    <p><strong>Brand:</strong> {product.brand}</p>
    <p><strong>Price:</strong> ₹{product.price}</p>
    <p><strong>Category:</strong> {product.category}</p>
    {/* Display "Premium" or "Budget" based on the price */}
    <p><strong>Brand:</strong> {product.price > 50000 ? "Premium Product" : "Budget Product"}</p>
    {/* Display warranty information or "No Warranty" */}
    <p><strong>Warranty:</strong> {product.warranty > 0 ? `${product.warranty} years` : "No Warranty"}</p>
    {/* Display "In Stock" or "Out of Stock" based on availability */}
    <p>{product.availability ? "✅ In Stock" : "❌ Out of Stock"}</p>
    {/* Display a special offer only if the product category is "Laptop" */}
    <p>{product.category === "Laptop" ? "🎒 Free Laptop Bag Offer" : null}</p>
  </div>
);


// This is the main component that controls the logic
const Lab17 = () => {
  // State to track if data is currently loading
  const [loading, setLoading] = useState(true);
  // State to track if an error occurred while fetching data
  const [error, setError] = useState(false);
  // State to hold the product data once it's fetched
  const [product, setProduct] = useState(null);

  // useEffect runs after the component is first rendered
  useEffect(() => {
    // Simulate a network delay (like fetching from an API) for 4 seconds
    setTimeout(() => {
      
      // This variable simulates a successful or failed API call.
      // Change to false to see the error message.to get output
      const success = true; 

      // Check if the simulated fetch was successful
      if (success) {
        // If successful, update the product state with the fetched data
        setProduct({
          name: "Sony Bravia TV",
          brand: "Sony",
          price: 65000,
          category: "TV",
          warranty: 2,
          availability: true
        });
      } else {
        // If it failed, set the error state to true
        setError(true);
      }

      // After the delay, set loading to false to hide the loading message
      setLoading(false);
    }, 4000); // 4000 milliseconds = 4 seconds
  }, []); // The empty array [] means this effect runs only once

  // This is what the component will render on the screen
  return (
    <div className="container mt-5">
      <h4 className="text-center mb-4">Conditional Rendering with Multiple Components</h4>
      {
        // Use conditional (ternary) operators to decide which component to show
        loading
          ? <LoadingComponent />   // If loading is true, show the loading component
          : error
            ? <ErrorComponent />     // If loading is false and error is true, show the error component
            : <ProductComponent product={product} /> // Otherwise, show the product details
      }
    </div>
  );
};

// Export the Lab17 component so it can be used in other files
export default Lab17;