// imports
const { Client } = require("pg"); // Postgresql connection package
const dotenv = require("dotenv"); // enviroment (.env) file reader
const Dog = require("./Dog");

// initialize process.env with enviroment file
dotenv.config();

const dbClient = new Client({
  user: process.env.DBUSER,
  host: process.env.DBHOST,
  database: process.env.DBNAME,
  password: process.env.DBPASS,
  port: process.env.DBPORT,
});

var pet = new Dog(dbClient, 'hejscorp death', 10, 'E4'); 
console.log(pet.getName());
console.log(pet.getType());
console.log(pet.getBarkPitch());

// dbClient.connect();

// dbClient
//   .query("SELECT * FROM cats_view")
//   .then((res) => {
//     console.table(res.rows);
//   })
//   .catch((err) => {
//     console.log(err.stack);
//   })
//   .finally(() => {
//     dbClient.end();
//   });
