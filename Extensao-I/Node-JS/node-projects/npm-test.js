const _ = require('lodash');                                // Import the 'lodash' package, looking in 'node_modules' folder


const numberArray = [1, 2, 2, 3, 4, 4, 5, 5, 5];
const uniqueNumbers = _.uniq(numberArray);                  // Using 'lodash' function to create an array of unique numbers

console.log("Original Array:", numberArray);
console.log("Unique Array:", uniqueNumbers);


const myString = "hello node js world";
const camelCaseString = _.camelCase(myString);              // 'camelCase' a string

console.log("Original String:", myString);
console.log("Camel Case String:", camelCaseString);