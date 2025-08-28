import React, { useEffect, useState } from 'react';

const LoadingComponent = () => (
  <div className="alert alert-info text-center">Loading product details...</div>
);

const ErrorComponent = () => (
  <div className="alert alert-warning text-center">⚠️ Error fetching product details</div>
);

const ProductComponent = ({ product }) => (
  <div className="card p-3 text-start">
    <h5>Electronic Product Details</h5>
    <p><strong>Name:</strong> {product.name}</p>
    <p><strong>Brand:</strong> {product.brand}</p>
    <p><strong>Price:</strong> ₹{product.price}</p>
    <p><strong>Category:</strong> {product.category}</p>
    <p><strong>Brand:</strong> {product.price > 50000 ? "Premium Product" : "Budget Product"}</p>
    <p><strong>Warranty:</strong> {product.warranty > 0 ? `${product.warranty} years` : "No Warranty"}</p>
    <p>{product.availability ? "✅ In Stock" : "❌ Out of Stock"}</p>
    <p>{product.category === "Laptop" ? "🎒 Free Laptop Bag Offer" : null}</p>
  </div>
);



const Lab17 = () => {
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [product, setProduct] = useState(null);

  useEffect(() => {
    setTimeout(() => {
      const success = true; // Change to false to test error state

      success
        ? setProduct({
            name: "Sony Bravia TV",
            brand: "Sony",
            price: 65000,
            category: "TV",
            warranty: 2,
            availability: true
          })
        : setError(true);

      setLoading(false);
    }, 2000);
  }, []);

  return (
    <div className="container mt-5">
      <h4 className="text-center mb-4">Conditional Rendering with Multiple Components</h4>
      {
        loading
          ? <LoadingComponent />
          : error
            ? <ErrorComponent />
            : <ProductComponent product={product} />
      }
    </div>
  );
};

export default Lab17;

