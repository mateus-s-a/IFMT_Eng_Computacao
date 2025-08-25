const fs = require('fs');                                           // First, we need to import the build-in 'fs' module

// We read the 'welcome.txt' file.
// 'fs.readFile' is asynchronous, meaning Node.js won't wait for it to finish.
// Instead, it takes a "callback" function to run once the file is read.

fs.readFile('./welcome.txt', 'utf8', (err, data) => {               // This functions runs after the file has been read.

    if (err) {                                                      // First, we handle any potential errors
        console.error("Error. Couldn't read the file: ", err);
        return;
    }

    console.log("Original text:", data);                           // 'data' contains the content of the file
    const newText = data.toUpperCase();                             // Creating a new text with all the 'data' letters in Upper Case

    fs.writeFile('./uppercase-welcome.txt', newText, (err) => {     // Write this new text to a new file
        if (err) {
            console.error("Error. Couldn't write the new file: ", err);
            return;
        }

        console.log("Successfully created the uppercase file.");
    });
});

console.log("Reading the file and preparing to write...");