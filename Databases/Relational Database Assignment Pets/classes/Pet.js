
module.exports = class Pet {
  constructor(d_type, name, age) {
    this.type = String(d_type);
    this.name = String(name);
    this.age = parseInt(age);
  }

  prettyPrint = () => {
    let name = String(this.name);
    let age = String(this.age);
    let type = String(this.type);

    for(let i = name.length; i < 17; i++){
        name = name + ' ';
    }

    for(let i = age.length; i < 5; i++){
        age = ' ' + age;
    }

    type = '  ' + type

    console.log(name, age, type);

}

}