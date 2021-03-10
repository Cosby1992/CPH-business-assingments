const Pet = require("./Pet");

module.exports = class Dog extends Pet {

    constructor(name, age, barkPitch){
        super('dog', name, age)
        this.barkPitch = String(barkPitch)
    }

}