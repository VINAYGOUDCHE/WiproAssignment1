import React, { useState } from 'react';

// --- Data for furniture items ---
const furnitureData = {
  Chair: {
    name: 'Office Chair',
    price: '₹ 2500',
    material: 'Plastic',
    size: '60cm x 60cm x 90cm',
    brand: 'Nilkamal',
  },
  Table: {
    name: 'Dining Table',
    price: '₹ 8000',
    material: 'Wood and Metal',
    size: '150cm x 90cm x 75cm',
    brand: 'IKEA',
  },
  Sofa: {
    name: '3-Seater Sofa',
    price: '₹ 22000',
    material: 'Fabric and Foam',
    size: '200cm x 90cm x 80cm',
    brand: 'Urban Ladder',
  },
  Bed: {
    name: 'King Size Bed',
    price: '₹ 35000',
    material: 'Solid Wood',
    size: '180cm x 200cm x 40cm',
    brand: 'Wakefit',
  },
};

// --- SVG Icons (for visual appeal) ---
const ChairIcon = () => (
  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" className="lucide lucide-chair">
    <path d="M7 16V9a3 3 0 0 1 3-3h4a3 3 0 0 1 3 3v7"/><path d="M5 21v-1a3 3 0 0 1 3-3h8a3 3 0 0 1 3 3v1"/><path d="M12 12V6"/><path d="M12 12h6"/><path d="M12 12H6"/>
  </svg>
);

const TableIcon = () => (
  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" className="lucide lucide-table">
    <path d="M12 3v18"/><path d="M21 9H3"/><path d="M21 15H3"/><rect width="18" height="18" x="3" y="3" rx="2" ry="2"/>
  </svg>
);

const SofaIcon = () => (
  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" className="lucide lucide-sofa">
    <path d="M21 9v6a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V9a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z"/><path d="M8 12h8"/><path d="M9 17v2a1 1 0 0 1-1 1H6a1 1 0 0 1-1-1v-2"/><path d="M15 17v2a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1v-2"/>
  </svg>
);

const BedIcon = () => (
  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" className="lucide lucide-bed">
    <path d="M2 4v16"/><path d="M22 4v16"/><path d="M2 8h18"/><path d="M2 14h18"/><path d="M2 20h18"/><path d="M12 2v20"/>
  </svg>
);

// --- Component for Chair details ---
const ChairDetails = ({ data }) => (
  <div className="flex flex-col items-center p-6 bg-white rounded-xl shadow-lg w-full transition-all duration-300 transform hover:scale-105">
    <div className="flex items-center space-x-2 text-2xl font-bold mb-4">
      <ChairIcon />
      <span>{data.name}</span>
    </div>
    <div className="text-left w-full space-y-2 text-gray-700">
      <p><strong>Name:</strong> {data.name}</p>
      <p><strong>Price:</strong> {data.price}</p>
      <p><strong>Material:</strong> {data.material}</p>
      <p><strong>Size:</strong> {data.size}</p>
      <p><strong>Brand:</strong> {data.brand}</p>
    </div>
  </div>
);

// --- Component for Table details ---
const TableDetails = ({ data }) => (
  <div >
    <div className="flex items-center space-x-2 text-2xl font-bold mb-4">
      <TableIcon />
      <span>{data.name}</span>
    </div>
    <div className="text-left w-full space-y-2 text-gray-700">
      <p><strong>Name:</strong> {data.name}</p>
      <p><strong>Price:</strong> {data.price}</p>
      <p><strong>Material:</strong> {data.material}</p>
      <p><strong>Size:</strong> {data.size}</p>
      <p><strong>Brand:</strong> {data.brand}</p>
    </div>
  </div>
);

// --- Component for Sofa details ---
const SofaDetails = ({ data }) => (
  <div className="flex flex-col items-center p-6 bg-white rounded-xl shadow-lg w-full transition-all duration-300 transform hover:scale-105">
    <div className="flex items-center space-x-2 text-2xl font-bold mb-4">
      <SofaIcon />
      <span>{data.name}</span>
    </div>
    <div className="text-left w-full space-y-2 text-gray-700">
      <p><strong>Name:</strong> {data.name}</p>
      <p><strong>Price:</strong> {data.price}</p>
      <p><strong>Material:</strong> {data.material}</p>
      <p><strong>Size:</strong> {data.size}</p>
      <p><strong>Brand:</strong> {data.brand}</p>
    </div>
  </div>
);

// --- Component for Bed details ---
const BedDetails = ({ data }) => (
  <div className="flex flex-col items-center p-6 bg-white rounded-xl shadow-lg w-full transition-all duration-300 transform hover:scale-105">
    <div className="flex items-center space-x-2 text-2xl font-bold mb-4">
      <BedIcon />
      <span>{data.name}</span>
    </div>
    <div className="text-left w-full space-y-2 text-gray-700">
      <p><strong>Name:</strong> {data.name}</p>
      <p><strong>Price:</strong> {data.price}</p>
      <p><strong>Material:</strong> {data.material}</p>
      <p><strong>Size:</strong> {data.size}</p>
      <p><strong>Brand:</strong> {data.brand}</p>
    </div>
  </div>
);

// --- Main App Component ---
export default function App() {
  const [selectedFurniture, setSelectedFurniture] = useState('Chair');

  const handleSelectChange = (event) => {
    setSelectedFurniture(event.target.value);
  };

  const renderFurnitureDetails = () => {
    switch (selectedFurniture) {
      case 'Chair':
        return <ChairDetails data={furnitureData.Chair} />;
      case 'Table':
        return <TableDetails data={furnitureData.Table} />;
      case 'Sofa':
        return <SofaDetails data={furnitureData.Sofa} />;
      case 'Bed':
        return <BedDetails data={furnitureData.Bed} />;
      default:
        return <p className="text-gray-500">Please select a furniture item.</p>;
    }
  };

  return (
    <div className="bg-gray-100 min-h-screen font-sans antialiased text-gray-800 flex flex-col items-center justify-center p-4">
      <div className="w-full max-w-lg text-center mb-8">
        <h1 className="text-4xl sm:text-5xl font-extrabold text-gray-900 leading-tight">Furniture Store</h1>
        <p className="mt-2 text-lg text-gray-600">Select an item to view its details.</p>
      </div>
      <div className="w-full max-w-sm">
        <div className="mb-4">
          <select
            value={selectedFurniture}
            onChange={handleSelectChange}
            className="block w-full px-4 py-3 text-lg bg-white border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500 transition-all duration-200 cursor-pointer appearance-none"
          >
            <option value="Chair">Chair</option>
            <option value="Table">Table</option>
            <option value="Sofa">Sofa</option>
            <option value="Bed">Bed</option>
          </select>
        </div>
        <div className="flex items-center justify-center w-full">
          {renderFurnitureDetails()}
        </div>
      </div>
    </div>
  );
}
