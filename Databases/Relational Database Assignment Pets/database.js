// imports
const { Client } = require("pg"); // Postgresql connection package
const dotenv = require("dotenv"); // enviroment (.env) file reader

// import classes
const Pet = require("./classes/Pet");
const Cat = require("./classes/Cat");
const Dog = require("./classes/Dog");

// Initialize process.env with enviroment file
dotenv.config();

getConn = () => {
  // Create db client for db connection
  return new Client({
    user: process.env.DBUSER,
    host: process.env.DBHOST,
    database: process.env.DBNAME,
    password: process.env.DBPASS,
    port: process.env.DBPORT,
  });
};

// Method fetches all pets from database
// Parameter: method to handle list of classes
// Example: [Cat,Cat,Pet,Pet,Dog,Pet]
module.exports.getAllPets = (callback) => {

  const client = getConn()
  client.connect(); // Connect to database

  // Query database and handle response
  client
    .query("SELECT * FROM pets") // Query
    .then((response) => {
      console.log("Query Successful, result:");
      console.table(response.rows); // Print result in a table

      // If callback argument is given
      // Call callback with the list of classes
      // returned by the 'dbRowsToArrayOfClasses'
      // method
      callback?.(dbRowsToArrayOfClasses(response.rows));
    })
    .catch((error) => {
      // In case an error occures
      console.log("Query Failed!");
      console.log(error.stack);
    })
    .finally(() => {
      // Close connection regardsless of result
      client.end();
    });
};

module.exports.insertPet = (pet) => {

  const client = getConn()
  client.connect(); // Connect to database

  // Build query (prepared statement)
  const query = {
    // give the query a unique name
    name: "pet_insert_prepared",
    text: "CALL insert_other_type_animal($1,$2,$3)",
    values: [pet.type, pet.name, pet.age],
  };

  // execute query
  client
    .query(query)
    .then((res) => console.info("INSERT PET:", res.command, "executed successfully"))
    .catch((e) => console.error(e.stack))
    .finally(() => client.end())
};

module.exports.insertCat = (cat) => {

  const client = getConn()
  client.connect(); // Connect to database

  // Build query (prepared statement)
  const query = {
    // give the query a unique name
    name: "cat_insert_prepared",
    text: "CALL insert_cat($1,$2,$3)",
    values: [cat.name, cat.age, cat.lifeCount],
  };

  // execute query
  client
    .query(query)
    .then((res) => console.info("INSERT CAT:", res.command, "executed successfully"))
    .catch((e) => console.error(e.stack))
    .finally(() => client.end())
};

module.exports.insertDog = (dog) => {

  const client = getConn()
  client.connect(); // Connect to database

  // Build query (prepared statement)
  const query = {
    // give the query a unique name
    name: "dog_insert_prepared",
    text: "CALL insert_dog($1,$2,$3)",
    values: [dog.name, dog.age, dog.barkPitch],
  };

  // execute query
  client
    .query(query)
    .then((res) => console.info("INSERT DOG:", res.command, "executed successfully"))
    .catch((e) => console.error(e.stack))
    .finally(() => client.end())
};

// This method is used to parse JSON objects
// to instanses of classes of correct type (Dog, Cat, Pet)
// Parameter: JSON object from database
// Returns: Array of objects
dbRowsToArrayOfClasses = (rows) => {
  let classesArray = []; // array to be returned
  var pet = {}; // current pet from a row

  // Iterate through all db rows
  // for each row create an instance
  // of a class of correct type and
  // push it to the classes array
  rows.forEach((row) => {
    switch (row.d_type) {
      case "dog":
        pet = new Dog(row.name, row.age, row.bark_pitch);
      case "cat":
        pet = new Cat(row.name, row.age, row.live_count);
      default:
        pet = new Pet(row.d_type, row.name, row.age);
    }

    // Push pet to array
    classesArray.push(pet);
  });

  // Return the array containing
  // all pets as classes
  return classesArray;
};
