import React from "react";

// The Juice component is a child component that displays a single juice item in a table row.
// It receives id, name, and price as props from its parent component.
const Juice = ({ id, name, price }) => {
  return (
    <tr>
      <td>{id}</td>
      <td>{name}</td>
      <td>₹{price}</td>
    </tr>
  );
};

// The JuiceList component is the parent component that renders a list of juices.
// It manages the list of juices and maps over them to render the Juice child component for each one.
const JuiceList = () => {
  // An array of objects, where each object represents a different juice with its ID, name, and price.
  const juices = [
    { id: 1, name: "Orange Juice", price: 80 },
    { id: 2, name: "Apple Juice", price: 100 },
    { id: 3, name: "Mango Juice", price: 120 },
  ];

  return (
    <div className="container">
      <h4 className="mb-2">🥤 Juice Menu</h4>
      {/* This table displays the juice menu. */}
      <table className="table table-bordered table-sm w-50 mx-auto">
        <thead>
          <tr>
            <th>ID</th>
            <th>Juice Name</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {/* We use the map() method to iterate over the 'juices' array. */}
          {/* For each item in the array, we create a new 'Juice' component. */}
          {/* The 'key' prop is important for React to efficiently update the list. */}
          {juices.map((juice) => (
            <Juice key={juice.id} id={juice.id} name={juice.name} price={juice.price} />
          ))}
        </tbody>
      </table>
    </div>
  );
};

// Export the JuiceList component to be used in other parts of the application.
export default JuiceList;