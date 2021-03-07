
module.exports = class Pet {
  constructor(conn, d_type, name, age) {
    this._type = String(d_type);
    this._name = String(name);
    this._age = parseInt(age);
    this._conn = conn;
  }

  persist = () => {
    
    console.log(typeof this._type);
    console.log(typeof this._name);
    console.log(typeof this._age);

    // this._conn.connect();

    // this._conn
    //   .query("SELECT * FROM dogs_view")
    //   .then((res) => {

    //     console.table(res.rows);
    //   })
    //   .catch((err) => {
    //     console.log(err.stack);
    //   })
    //   .finally(() => {
    //     client.end();
    //   });
  };

  getType = () => {
    return this._type;
  };

  setType = (type) => {
    this._type = String(type);
  };

  getName = () => {
    return this._name;
  };

  setName = (name) => {
    this._name = String(name);
  };

  getAge = () => {
    return this.age;
  };

  setAge = (age) => {
    this._age = parseInt(age);
  };
}