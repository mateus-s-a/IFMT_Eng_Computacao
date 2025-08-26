const path = require('path');
const os = require('os');


// --- OS Module ---
const currentUser = os.userInfo();                                  // Get information about the current user
console.log(`Current user: ${currentUser.username}`);

console.log(`Home directory: ${os.homedir()}`);                     // Get the home directory


// --- Path Module ---
const myFilePath = './path-module-test/document.txt';

console.log(`Directory: ${path.dirname(myFilePath)}`);              // Get the directory name

console.log(`Filename: ${path.basename(myFilePath)}`);              // Get the file name

console.log(`Extension: ${path.extname(myFilePath)}`);              // Get the file extension


const newPath = path.join(__dirname, 'uploads', 'image.jpg');       // Join path segments together safely for any OS
console.log(`OS-safe path: ${newPath}`);