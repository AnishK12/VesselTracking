// The origional JS file that we pulled from the source
const ships = require('./ships.json');

// looked up a list of top 100 ports, used for start and end ports
// https://sdwerecruit.co.uk/wp-content/uploads/2017/10/Lloyds-List-Top-100-Ports-2017-Report.pdf
const ports = require('./ports.json');

// https://www.shiplilly.com/blog/the-most-common-types-of-cargo-ships/ list of a ship types
const shipTypes = require('./ShipTypes.json');

// https://transportgeography.org/?page_id=10258 lists the types of cargo
const cargoTypes = require('./CargoTypes.json');

// Gets value between min and max inclusive
function getRandomPort(){
  min = 0
  max = 99
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

// Gets value between min and max inclusive
function getRandomShipType(){
  min = 0
  max = 7
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

// Gets value between min and max inclusive
function getRandomCargo(){
  min = 0
  max = 4
  return Math.floor(Math.random() * (max - min + 1)) + min;
}


for (var ship in ships.features){
  ships.features[ship].ID = ship;
  ships.features[ship].properties.startPort = ports[getRandomPort()];
  ships.features[ship].properties.endPort = ports[getRandomPort()];
  ships.features[ship].properties.cargo = cargoTypes[getRandomCargo()];
  ships.features[ship].properties.shipType = shipTypes[getRandomShipType()];
}

console.log(ships.features[23]);
console.log(ships.features[99]);
console.log(ships.features[123]);
console.log(ships.features[1192]);

var jsonData = JSON.stringify(ships);
var fs = require('fs');
fs.writeFile("test.json", jsonData, function(err) {
  if (err) {
      console.log(err);
  }
});
