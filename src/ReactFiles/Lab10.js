import React from 'react';

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

export const TailorShop = () => {
  let output = '';

  // --- Define Layout ---
  const colWidths = [15, 15, 17]; // Adjusted widths for better spacing
  const totalWidth = colWidths.reduce((sum, width) => sum + width, 0) + colWidths.length * 3 + 1;

  const dottedLine = (width) => `+${'-'.repeat(width - 2)}+\n`;
  const rowSeparator = `+${'-'.repeat(colWidths[0] + 2)}+${'-'.repeat(colWidths[1] + 2)}+${'-'.repeat(colWidths[2] + 2)}+\n`;
  const blouseSeparator = `+${'-'.repeat(colWidths[0] + 2)}+\n`;

  // --- Header ---
  output += dottedLine(totalWidth);
  const headerText = 'Tailoring Services';
  const headerPadding = (totalWidth - headerText.length - 2) / 2;
  output += `|${' '.repeat(Math.floor(headerPadding))}${headerText}${' '.repeat(Math.ceil(headerPadding))}|\n`;
  output += dottedLine(totalWidth);

  // --- Top Row (3 items) ---
  const topRowServices = services.slice(0, 3);
  const serviceNames = topRowServices.map(s => s.serviceName);
  const prices = topRowServices.map(s => `Price: $${s.price}`);
  const fabricsHeader = 'Fabrics:';

  output += `| ${serviceNames[0].padEnd(colWidths[0] + 1)} | ${serviceNames[1].padEnd(colWidths[1] + 1)} | ${serviceNames[2].padEnd(colWidths[2] + 1)} |\n`;
  output += `| ${prices[0].padEnd(colWidths[0] + 1)} | ${prices[1].padEnd(colWidths[1] + 1)} | ${prices[2].padEnd(colWidths[2] + 1)} |\n`;
  output += `| ${fabricsHeader.padEnd(colWidths[0] + 1)} | ${fabricsHeader.padEnd(colWidths[1] + 1)} | ${fabricsHeader.padEnd(colWidths[2] + 1)} |\n`;

  const maxFabrics = Math.max(...topRowServices.map(s => s.fabricsAvailable.length));
  for (let i = 0; i < maxFabrics; i++) {
    const fabric1 = `- ${topRowServices[0].fabricsAvailable[i] || ''}`;
    const fabric2 = `- ${topRowServices[1].fabricsAvailable[i] || ''}`;
    const fabric3 = `- ${topRowServices[2].fabricsAvailable[i] || ''}`;
    output += `| ${fabric1.padEnd(colWidths[0] + 1)} | ${fabric2.padEnd(colWidths[1] + 1)} | ${fabric3.padEnd(colWidths[2] + 1)} |\n`;
  }
  output += rowSeparator;

  // --- Bottom Row (1 item) ---
  const blouse = services[3];
  output += `| ${blouse.serviceName.padEnd(colWidths[0] + 1)} |\n`;
  output += `| ${`Price: $${blouse.price}`.padEnd(colWidths[0] + 1)} |\n`;
  output += `| ${'Fabrics:'.padEnd(colWidths[0] + 1)} |\n`;
  blouse.fabricsAvailable.forEach(fabric => {
    output += `| ${`- ${fabric}`.padEnd(colWidths[0] + 1)} |\n`;
  });
  output += blouseSeparator;


  return <pre>{output}</pre>;
};

export default TailorShop;