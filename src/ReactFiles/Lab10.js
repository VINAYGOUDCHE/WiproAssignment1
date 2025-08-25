import React from 'react';

// Define an array of objects, where each object represents a service
const services = [
  {
    serviceName: 'Shirt',
    price: 20,
    fabricsAvailable: ['Cotton', 'Linen', 'Polyester'],
  },
  {
    serviceName: 'Pants',
    price: 30,
    fabricsAvailable: ['Denim', 'Wool', 'Chino'],
  },
  {
    serviceName: 'Lehenga',
    price: 150,
    fabricsAvailable: ['Silk', 'Georgette', 'Chiffon'],
  },
  {
    serviceName: 'Blouse',
    price: 40,
    fabricsAvailable: ['Cotton', 'Silk', 'Satin'],
  },
];

// Define the main component for the Tailor Shop display
export const TailorShop = () => {
  // Initialize an empty string to build the text-based table
  let output = '';

  // --- Define Layout ---
  // Set the widths for the three columns in the table
  const colWidths = [15, 15, 15];
  // Calculate the total width of the table for the main header
  const totalWidth = colWidths.reduce((sum, width) => sum + width, 0) + colWidths.length * 3 + 1;

  // Helper function to create a dotted line for the top and bottom of the header
  const dottedLine = (width) => `+${'-'.repeat(width - 2)}+\n`;
  // Create the separator line that goes between rows
  const rowSeparator = `+${'-'.repeat(colWidths[0] + 2)}+${'-'.repeat(colWidths[1] + 2)}+${'-'.repeat(colWidths[2] + 2)}+\n`;

  // --- Header ---
  // Add the top border of the main header
  output += dottedLine(totalWidth);
  // Define the header text
  const headerText = 'Tailoring Services';
  // Calculate padding to center the header text
  const headerPadding = (totalWidth - headerText.length - 2) / 2;
  // Add the centered header text to the output
  output += `|${' '.repeat(Math.floor(headerPadding))}${headerText}${' '.repeat(Math.ceil(headerPadding))}|\n`;
  // Add the bottom border of the main header
  output += dottedLine(totalWidth);

  // --- Top Row (3 items) ---
  // Get the first three services from the data array
  const topRowServices = services.slice(0, 3);
  // Extract the names of the services for the top row
  const serviceNames = topRowServices.map(s => s.serviceName);
  // Extract the prices for the top row and format them
  const prices = topRowServices.map(s => `Price: $${s.price}`);
  // Define the header for the fabrics list
  const fabricsHeader = 'Fabrics:';

  // Add the row with service names to the output, padding each to fit its column
  output += `| ${serviceNames[0].padEnd(colWidths[0] + 1)} | ${serviceNames[1].padEnd(colWidths[1] + 1)} | ${serviceNames[2].padEnd(colWidths[2] + 1)} |\n`;
  // Add the row with prices to the output
  output += `| ${prices[0].padEnd(colWidths[0] + 1)} | ${prices[1].padEnd(colWidths[1] + 1)} | ${prices[2].padEnd(colWidths[2] + 1)} |\n`;
  // Add the row with the "Fabrics:" header to the output
  output += `| ${fabricsHeader.padEnd(colWidths[0] + 1)} | ${fabricsHeader.padEnd(colWidths[1] + 1)} | ${fabricsHeader.padEnd(colWidths[2] + 1)} |\n`;

  // Find the service with the most fabrics to determine how many rows are needed
  const maxFabrics = Math.max(...topRowServices.map(s => s.fabricsAvailable.length));
  // Loop to add a row for each available fabric
  for (let i = 0; i < maxFabrics; i++) {
    // Get the fabric for each service, or an empty string if it doesn't exist
    const fabric1 = `- ${topRowServices[0].fabricsAvailable[i] || ''}`;
    const fabric2 = `- ${topRowServices[1].fabricsAvailable[i] || ''}`;
    const fabric3 = `- ${topRowServices[2].fabricsAvailable[i] || ''}`;
    // Add the formatted fabric row to the output
    output += `| ${fabric1.padEnd(colWidths[0] + 1)} | ${fabric2.padEnd(colWidths[1] + 1)} | ${fabric3.padEnd(colWidths[2] + 1)} |\n`;
  }
  // Add the separator line after the top row is complete
  output += rowSeparator;

  // --- Bottom Row (1 item at the start) ---
  // Get the fourth service (Blouse) from the data array
  const blouse = services[3];
  // Create empty strings to fill the unused columns in the second row
  const emptyCol2 = ''.padEnd(colWidths[1] + 1);
  const emptyCol3 = ''.padEnd(colWidths[2] + 1);

  // Add the service name for the blouse in the first column
  output += `| ${blouse.serviceName.padEnd(colWidths[0] + 1)} | ${emptyCol2} | ${emptyCol3} |\n`;
  // Add the price for the blouse in the first column
  output += `| ${`Price: $${blouse.price}`.padEnd(colWidths[0] + 1)} | ${emptyCol2} | ${emptyCol3} |\n`;
  // Add the "Fabrics:" header for the blouse in the first column
  output += `| ${'Fabrics:'.padEnd(colWidths[0] + 1)} | ${emptyCol2} | ${emptyCol3} |\n`;
  // Loop through each fabric for the blouse and add it as a new row
  blouse.fabricsAvailable.forEach(fabric => {
    output += `| ${`- ${fabric}`.padEnd(colWidths[0] + 1)} | ${emptyCol2} | ${emptyCol3} |\n`;
  });
  // Add the final separator line at the bottom of the table
  output += rowSeparator;

  // Return the final output string inside a <pre> tag to preserve the text formatting
  return <pre>{output}</pre>;
};

// Export the TailorShop component so it can be used in other parts of the application
export default TailorShop;