import React from 'react';

// Define an array of objects. Each object represents a tailoring service.
const services = [
  {
    serviceName: 'Shirt', // The name of the service
    price: 20, // The price for the service
    fabricsAvailable: ['Cotton', 'Linen', 'Polyester'], // A list of available fabrics
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

// This is a React functional component named 'TailorShop'.
// It will display the services data in a text-based table format.
export const TailorShop = () => {
  // 'output' is a string variable that we will build up to create the final text table.
  let output = '';

  // --- Define Layout ---
  // Set the widths for the three columns in our table.
  const colWidths = [15, 15, 17];
  // Calculate the total width of the table for the main header.
  const totalWidth = colWidths.reduce((sum, width) => sum + width, 0) + colWidths.length * 3 + 1;

  // A helper function to create a horizontal dotted line for the table border.
  const dottedLine = (width) => `+${'-'.repeat(width - 2)}+\n`;
  // Creates the separator line between the rows of services (with dividers for 3 columns).
  const rowSeparator = `+${'-'.repeat(colWidths[0] + 2)}+${'-'.repeat(colWidths[1] + 2)}+${'-'.repeat(colWidths[2] + 2)}+\n`;
  // Creates the separator for the last item which only spans one column.
  const blouseSeparator = `+${'-'.repeat(colWidths[0] + 2)}+\n`;

  // --- Header ---
  // Add the top border of the main header.
  output += dottedLine(totalWidth);
  // The main title text for the table.
  const headerText = 'Tailoring Services';
  // Calculate the padding needed to center the header text.
  const headerPadding = (totalWidth - headerText.length - 2) / 2;
  // Add the centered header text to the output string.
  output += `|${' '.repeat(Math.floor(headerPadding))}${headerText}${' '.repeat(Math.ceil(headerPadding))}|\n`;
  // Add the bottom border of the main header.
  output += dottedLine(totalWidth);

  // --- Top Row (displays the first 3 services) ---
  // Get the first three services from our 'services' array.
  const topRowServices = services.slice(0, 3);
  // Get just the names of the services.
  const serviceNames = topRowServices.map(s => s.serviceName);
  // Get the prices and format them.
  const prices = topRowServices.map(s => `Price: $${s.price}`);
  // A simple label for the fabrics section.
  const fabricsHeader = 'Fabrics:';

  // Add the row with service names, using padEnd to make sure columns align.
  output += `| ${serviceNames[0].padEnd(colWidths[0] + 1)} | ${serviceNames[1].padEnd(colWidths[1] + 1)} | ${serviceNames[2].padEnd(colWidths[2] + 1)} |\n`;
  // Add the row with prices.
  output += `| ${prices[0].padEnd(colWidths[0] + 1)} | ${prices[1].padEnd(colWidths[1] + 1)} | ${prices[2].padEnd(colWidths[2] + 1)} |\n`;
  // Add the row with the "Fabrics:" label.
  output += `| ${fabricsHeader.padEnd(colWidths[0] + 1)} | ${fabricsHeader.padEnd(colWidths[1] + 1)} | ${fabricsHeader.padEnd(colWidths[2] + 1)} |\n`;

  // Find out the maximum number of fabrics any of the top 3 services has.
  const maxFabrics = Math.max(...topRowServices.map(s => s.fabricsAvailable.length));
  // Loop that many times to print all fabrics for each service.
  for (let i = 0; i < maxFabrics; i++) {
    // Get the fabric for the first service (or an empty string if it doesn't exist).
    const fabric1 = `- ${topRowServices[0].fabricsAvailable[i] || ''}`;
    // Get the fabric for the second service.
    const fabric2 = `- ${topRowServices[1].fabricsAvailable[i] || ''}`;
    // Get the fabric for the third service.
    const fabric3 = `- ${topRowServices[2].fabricsAvailable[i] || ''}`;
    // Add the row containing the fabrics to the output string.
    output += `| ${fabric1.padEnd(colWidths[0] + 1)} | ${fabric2.padEnd(colWidths[1] + 1)} | ${fabric3.padEnd(colWidths[2] + 1)} |\n`;
  }
  // Add the line that separates the top row from the bottom row.
  output += rowSeparator;

  // --- Bottom Row (displays the last 1 item) ---
  // Get the fourth service from the array (the Blouse).
  const blouse = services[3];
  // Add the service name for the blouse.
  output += `| ${blouse.serviceName.padEnd(colWidths[0] + 1)} |\n`;
  // Add the price for the blouse.
  output += `| ${`Price: $${blouse.price}`.padEnd(colWidths[0] + 1)} |\n`;
  // Add the "Fabrics:" label for the blouse.
  output += `| ${'Fabrics:'.padEnd(colWidths[0] + 1)} |\n`;
  // Loop through each fabric for the blouse and add it on a new line.
  blouse.fabricsAvailable.forEach(fabric => {
    output += `| ${`- ${fabric}`.padEnd(colWidths[0] + 1)} |\n`;
  });
  // Add the final closing line for the blouse section.
  output += blouseSeparator;

  // The component returns the final 'output' string.
  // It's wrapped in a <pre> tag, which tells the browser to
  // preserve whitespace and line breaks, so our text table looks correct.
  return <pre>{output}</pre>;
};

// This makes the 'TailorShop' component available to be used in other files.
export default TailorShop;