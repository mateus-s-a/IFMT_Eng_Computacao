const myBuffer = Buffer.from("Hello, Buffer");                  // Creating a Buffer from a String

console.log(myBuffer);                                          // Seeing the Raw binary data in hexadecimal
// <Buffer 48 65 6c 6c 6f 2c 20 42 75 66 66 65 72>

console.log(myBuffer.toString());                               // Converting the Buffer back to a String
// 'Hello, Buffer'
console.log(myBuffer.length);                                   // Length of the Buffer in bytes
// 13
console.log(myBuffer.toJSON());                                 // Converting the Buffer to a JSON object

console.log('First byte (ASCII for "H"):', myBuffer[0]);        // 72

const viewBuffer = myBuffer.subarray(0, 5);                        // Creating a sub-buffer (view) from the original Buffer
console.log(viewBuffer);
// <Buffer 48 65 6c 6c 6f>