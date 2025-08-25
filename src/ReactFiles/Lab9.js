import React from 'react';

// An array of objects, where each object represents a temple.
// Each temple has an id, name, location, and a list of deities.
const temples = [
  {
    id: 1,
    name: "Bhadrachalam Temple",
    location: "Bhadradri Kothagudem, Telangana",
    deities: ["Rama"],
  },
  {
    id: 2,
    name: "Yadagirigutta Temple",
    location: "Yadadri Bhuvanagiri, Telangana",
    deities: ["Lakshmi Narasimha"],
  },
  {
    id: 3,
    name: "Rajarajeshwara Swamy Temple",
    location: "Vemulawada, Telangana",
    deities: ["Shiva"],
  },
  {
    id: 4,
    name: "Thousand Pillar Temple",
    location: "Warangal, Telangana",
    deities: ["Shiva", "Vishnu", "Surya"],
  },
];

// A functional component that displays a list of temples.
const TempleList = () => {
  return (
    // Main container for the component.
    <div className="container mt-4">
      {/* Page title with a temple emoji. */}
      <h1 className="mb-4">
        <span role="img" aria-label="temple-emoji" className="me-2">🏛️</span>
        Famous Temples in Telangana
      </h1>
      {/* Table to display the temple data. */}
      <div className="table-responsive">
        <table className="table table-striped table">
          {/* Table header with column names. */}
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Temple Name</th>
              <th scope="col">Location</th>
              <th scope="col">Deities</th>
            </tr>
          </thead>
          {/* Table body to render the data dynamically. */}
          <tbody>
            {/* Map through the 'temples' array to create a table row for each temple. */}
            {temples.map((temple) => (
              // Use a unique key for each row, which helps React optimize rendering.
              <tr key={temple.id}>
                <td>{temple.id}</td>
                <td>{temple.name}</td>
                <td>{temple.location}</td>
                <td>
                  {/* Create an unordered list for the deities of each temple. */}
                  <ul>
                    {/* Map through the 'deities' array to create a list item for each deity. */}
                    {temple.deities.map((deity, index) => (
                      <li key={index}>{deity}</li>
                    ))}
                  </ul>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

// Export the component so it can be used in other parts of the application.
export default TempleList;