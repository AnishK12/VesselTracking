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

// Gets value between min and max inclusive
function getDeadWeightTons(){
  min = 40000
  max = 60000
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

// Gets value between min and max inclusive
function getBuildYear(){
  min = 2000
  max = 2018
  return Math.floor(Math.random() * (max - min + 1)) + min;
}


for (var ship in ships.features){
  ships.features[ship].id = ship;
  ships.features[ship].properties.startport = ports[getRandomPort()];
  ships.features[ship].properties.endport = ports[getRandomPort()];
  ships.features[ship].properties.shiptype = shipTypes[getRandomShipType()];
  ships.features[ship].properties.deadweight = getDeadWeightTons().toString();
  ships.features[ship].properties.buildyear = getBuildYear().toString();
  var cargoNum = getRandomCargo();
  if (ships.features[ship].properties.shiptype == shipTypes[7]) {
    ships.features[ship].properties.cargo = cargoTypes[4];
  } else if (cargoNum == 4) {
      ships.features[ship].properties.cargo = cargoTypes[5];
  } else {
    ships.features[ship].properties.cargo = cargoTypes[cargoNum];
  }
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
