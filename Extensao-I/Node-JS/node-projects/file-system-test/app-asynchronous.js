const fs = require('fs/promises');                                  // We import a special 'promises' version of the fs module.

async function main() {                                             // An 'async' function to use 'await'
    try {
        const data = await fs.readFile('./welcome.txt', 'utf8');    // 1. Read the file. 'await', pauses the function until the promise is settled.
        console.log("Original file:", data);

        const newText = data.toUpperCase();                         // 2. Prepare the new text (same rule)

        await fs.writeFile('./uppercase-welcome.txt', newText);     // 3. Write the new file. 'await' pauses again
        console.log("Successfully created the uppercase file.");
    } catch (err) {
        console.error("An error occurred:", err);                   // If any promise in the 'try' block fails, the 'catch' block will run
    }
}

console.log("Starting file operations...");
main();                                                             // Calling the 'main()' function
console.log("...file operations initiated.");