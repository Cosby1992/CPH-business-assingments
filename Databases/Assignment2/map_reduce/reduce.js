
// reduce the number array to it's sum
const numbers = [1,2,3,4,5];

const reduced = numbers.reduce((total, num) => {
    return total + num
}, 0);

console.log(reduced);

// reduce the x values in the objects to their sum
const objects = [{x: 1},{x: 2},{x: 3}];

const reducedX = objects.reduce((total, object) => {
    return total + object.x
}, 0);

console.log(reducedX);

// reduce the x values in the objects to their sum
const arrayToFlatten = [[1,2],[3,4],[5,6]];

const flattenedArray = arrayToFlatten.reduce((arr, inner) => {
    arr.push(inner[0])
    arr.push(inner[1])
    return arr
}, []);

console.log(flattenedArray);


//Use reduce to return an array of the positive numbers: [-3, -1, 2, 4, 5]

const reduceToPositiveNumbers = [-3, -1, 2, 4, 5]

const positiveNumberArray = reduceToPositiveNumbers.reduce((arr, number) => {
    if(number >= 0){
        arr.push(number)
    }
    return arr
}, [])

console.log(positiveNumberArray);