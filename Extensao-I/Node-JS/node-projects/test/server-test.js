const http = require('http');                                                       // Importing modules (Core and Third-Party)
const fs = require('fs/promises');
const path = require('path');
const os = require('os');
const _ = require('lodash');                                                        // From 'npm'

const PORT = 4000;                                                                  // Defining a PORT to the server

const server = http.createServer(async (req, res) => {                              // Creation of the HTTP server, doing the request handler 'async' to use 'await' inside it
    if (req.url === '/') {                                                          // Basic URL route based on the request (main)
        const greeting = 'welcome to our all-in-one server!';                       // 'Homepage' route

        res.writeHead(200, { 'content-type': 'text/plain' });
        res.end(_.startCase(greeting));                                             // Using 'lodash' to 'startCase()' format
    } else if (req.url === '/status') {
        const statusInfo = {                                                        // 'Status' route
            platform: os.platform(),
            cpus: os.cpus().length,
            freeMemory: `${(os.freemem() / 1024 / 1024).toFixed(2)} MB`,
            uptime: `${(os.uptime() / 60).toFixed(2)} minutes`
        };

        res.writeHead(200, { 'content-type': 'application/json' });                 // Respond with JSON data
        res.end(JSON.stringify(statusInfo, null, 4));
    } else if (req.url === '/create-file') {
        try {                                                                       // 'File Creation' route
            const filePath = path.join(__dirname, 'newly-created-file.txt');        // Using 'path' module for safety
            const fileContent = `File created at: ${new Date().toISOString()}`;

            await fs.writeFile(filePath, fileContent);                              // using 'async/await' with the 'fs/promises' module

            res.writeHead(200, { 'content-type': 'text/plain' });
            res.end('File was created successfully.');
        } catch (error) {
            console.error("Error writing file:", error);
            res.writeHead(500, { 'content-type': 'text/plain' });
            res.end('Server error: Could not create the file.');
        }
    } else {
        res.writeHead(400, { 'content-type': 'text/plain' });                       // 404 Not Found route for any other URL
        res.end('404 - Page Not Found');
    }
});


server.listen(PORT, () => {
    console.log(`Server is listening on http://localhost:${PORT}`);
});