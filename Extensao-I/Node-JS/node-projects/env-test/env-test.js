// 'process.env' contains all the environment variables
// It's possible to access them like properties of an object

const port = process.env.PORT || 3000;
const userName = process.env.USER_NAME || "Guest";

console.log(`Hello, ${userName}`);
console.log(`The application will run on port ${port}`);