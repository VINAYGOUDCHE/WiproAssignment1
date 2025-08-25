import React from 'react';

// CanteenItem component (Child)
const CanteenItem = ({ name, price, category, available }) => {
  const availabilityText = available ? 'Available' : 'No Available';
  const priceDisplay = `₹ ${price}`;

  return (
    <li>
      {name} - Price: {priceDisplay} - Castegory: {category} {available ? '' : `- ${availabilityText}`}
    </li>
  );
};

// CanteenMenu component (Parent)
const CanteenMenu = ({ canteenName, location, openHours }) => {
  const menuItems = [
    {
      name: 'Idli',
      price: 30,
      category: 'Breakfast',
      available: true,
    },
    {
      name: 'Dosa',
      price: 5,
      category: 'Breakfast',
      available: true,
    },
    {
      name: 'Vada',
      price: 2,
      category: 'Snack',
      available: false,
    },
    {
      name: 'Poori',
      price: 40,
      category: 'Breakfast',
      available: true,
    },
    {
      name: 'Meals',
      price: 120,
      category: 'Lunch',
      available: true,
    },
  ];

  return (
    <div style={{ margin: '20px' }}>
      <h1>Canteen Name:</h1>
      <h1>{canteenName}</h1>
      <p>Location: {location}</p>
      <p>Open Hours: {openHours}</p>
      <h2>Canteen Menu:</h2>
      <ul className="d-inline-block text-start" >
        {menuItems.map((item, index) => (
          <CanteenItem key={index} {...item} />
        ))}
      </ul>
    </div>
  );
};

export default CanteenMenu;