import React, { useState } from 'react';

// This is a functional component that manages baking items.
const BakingItemManager = () => {
  // `useState` hook to manage the state of the form input fields.
  const [item, setItem] = useState({
    itemName: '',
    quantity: '',
    ingredients: '',
    bakingTime: '',
    category: 'Cake',
  });

  // `useState` hook to store the list of submitted baking items.
  const [bakingItems, setBakingItems] = useState([]);

  // This function updates the `item` state as the user types in the form.
  const handleChange = (e) => {
    // Destructuring to get the name and value from the event target.
    const { name, value } = e.target;
    // Spreads the existing `item` state and updates the changed field.
    setItem({ ...item, [name]: value });
  };

  // This function handles the form submission.
  const handleSubmit = (e) => {
    // Prevents the default form behavior (page reload).
    e.preventDefault();
    // Checks if all required fields are filled.
    if (item.itemName && item.quantity && item.ingredients && item.bakingTime) {
      // Adds the new item to the `bakingItems` array.
      setBakingItems([...bakingItems, item]);
      // Resets the form fields to their initial empty values.
      setItem({
        itemName: '',
        quantity: '',
        ingredients: '',
        bakingTime: '',
        category: 'Cake',
      });
    }
  };

  // The return statement contains the component's JSX structure.
  return (
    <div className="container my-5 text-start">
      <div className="card shadow-sm mx-auto p-4" style={{ maxWidth: '800px' }}>
        <h4 className="card-title text-start mb-4">
          🎂 Baking Items Manager
        </h4>
        {/* The form with an `onSubmit` handler. */}
        <form onSubmit={handleSubmit}>
          {/* Input field for Item Name. */}
          <div className="mb-3 text-start">
            <label htmlFor="itemName" className="form-label">Item Name</label>
            <input
              type="text"
              className="form-control"
              id="itemName"
              name="itemName"
              // The input value is controlled by the `item` state.
              value={item.itemName}
              // The `onChange` event is handled by the `handleChange` function.
              onChange={handleChange}
              required
            />
          </div>

          {/* Input field for Quantity. */}
          <div className="mb-3 text-start">
            <label htmlFor="quantity" className="form-label">Quantity</label>
            <input
              type="number"
              className="form-control"
              id="quantity"
              name="quantity"
              value={item.quantity}
              onChange={handleChange}
              required
            />
          </div>

          {/* Textarea for Ingredients. */}
          <div className="mb-3 text-start">
            <label htmlFor="ingredients" className="form-label">Ingredients</label>
            <textarea
              className="form-control"
              id="ingredients"
              name="ingredients"
              value={item.ingredients}
              onChange={handleChange}
              rows="3"
              required
            ></textarea>
          </div>

          {/* Input field for Baking Time. */}
          <div className="mb-3 text-start">
            <label htmlFor="bakingTime" className="form-label">Baking Time (mins)</label>
            <input
              type="number"
              className="form-control"
              id="bakingTime"
              name="bakingTime"
              value={item.bakingTime}
              onChange={handleChange}
              required
            />
          </div>

          {/* Select dropdown for Category. */}
          <div className="mb-4 text-start">
            <label htmlFor="category" className="form-label">Category</label>
            <select
              className="form-select"
              id="category"
              name="category"
              value={item.category}
              onChange={handleChange}
            >
              <option value="Cake">Cake</option>
              <option value="Bread">Bread</option>
              <option value="Pastry">Pastry</option>
            </select>
          </div>

          {/* Submit button. */}
          <button type="submit" className="btn btn-success w-40 text-start">Add Baking Item</button>
        </form>
    

        {/* This section displays the list of submitted items. It only appears if there are items in the `bakingItems` array. */}
        {bakingItems.length > 0 && (
          <div className="mt-5" style={{ maxWidth: '1000px' }}>
            <h4 className="text-start mb-3">Submitted Baking Items</h4>
            <div className="table-responsive">
              <table className="table table-bordered table-striped text-center">
                <thead className="table-dark">
                  <tr>
                    <th>S.No</th>
                    <th>Item Name</th>
                    <th>Quantity</th>
                    <th>Ingredients</th>
                    <th>Baking Time</th>
                    <th>Category</th>
                  </tr>
                </thead>
                <tbody>
                  {/* Maps through the `bakingItems` array to render each item as a table row. */}
                  {bakingItems.map((bItem, index) => (
                    <tr key={index}>
                      <td>{index + 1}</td>
                      <td>{bItem.itemName}</td>
                      <td>{bItem.quantity}</td>
                      <td>{bItem.ingredients}</td>
                      <td>{bItem.bakingTime} mins</td>
                      <td>{bItem.category}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default BakingItemManager;