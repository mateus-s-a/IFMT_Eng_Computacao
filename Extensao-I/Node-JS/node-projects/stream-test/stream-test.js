const fs = require('fs');

const readableStream = fs.createReadStream('./large-file.txt', { encoding: 'utf8' });   // 1. Readable Stream from a large source file
const writableStream = fs.createWriteStream('./large-file-copy.txt');                   // 2. Writable Stream to a destination file

readableStream.pipe(writableStream);                                                    // 3. '.pipe()' connect them, reads chunks from readableStream and sends them to writableStream

readableStream.on('end', () => {                                                        // It's possible to listen for events on the Streams
    console.log("Finished reading the file.");
});

writableStream.on('finish', () => {
    console.log("Finished writing the file. The copy is completed.");
});

readableStream.on('error', (err) => {                                                   // Here, it handles any erros that might occur
    console.error("An error occurred while reading:", err);
});

writableStream.on('error', (err) => {
    console.error("An error occurred while writing:", err);
});

console.log("Piping data from one file to another...");