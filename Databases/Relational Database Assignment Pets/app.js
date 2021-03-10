// import classes
const Pet = require("./classes/Pet");
const Cat = require("./classes/Cat");
const Dog = require("./classes/Dog");

// import database functions
const { getAllPets, insertPet, insertDog, insertCat } = require("./database");

// Creating some new pets to insert 
// into the database
const mittens = new Cat('Mr. Mittens', 2) // Third param = lifecount is default 9
const justincat = new Cat('Justin cat', 8, 5)
const barkly = new Dog('Charles Barkly', 5, 'E4')
const horsely = new Pet('horse', 'Charles Horsely', 22)

// Insert the pet object to database
insertCat(mittens)
insertCat(justincat)
insertDog(barkly)
insertPet(horsely)

// Show all pets in console and print after 
// the pets from db is parsed to classes

// getAllPets fetches all pets from the 
// database and passes them to callback function
// Pets are passed as array of objects of correct type 
// ex. [Cat, Dog, Pet, Cat, Pet, Dog]
getAllPets((pets) => {
  pets.forEach((pet) => { 
    pet.prettyPrint();
  });
});






