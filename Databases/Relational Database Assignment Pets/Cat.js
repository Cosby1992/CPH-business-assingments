const Pet = require("./Pet");

module.exports = class Cat extends Pet {

    constructor(conn, name, age, lifeCount = 9){
        super(conn, 'cat', name, age)
        this._lifeCount = parseInt(lifeCount)
        this._conn = conn
    }

    getLifeCount = () => {
        return this._lifeCount
    }

    setLifeCount = (lifeCount) => {
        this._lifeCount = parseInt(lifeCount)
    }


}