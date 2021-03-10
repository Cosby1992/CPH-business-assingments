const Pet = require("./Pet");

module.exports = class Cat extends Pet {

    constructor(name, age, lifeCount = 9){
        super('cat', name, age)
        this.lifeCount = parseInt(lifeCount)
    }
}