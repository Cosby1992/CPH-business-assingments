const Pet = require("./Pet");

module.exports = class Dog extends Pet {

    constructor(conn, name, age, barkPitch){
        super(conn, 'dog', name, age)
        this._barkPitch = String(barkPitch)
    }

    getBarkPitch = () => {
        return this._barkPitch
    }

    setBarkPitch = (barkPitch) => {
        this._barkPitch = parseInt(barkPitch)
    }

}