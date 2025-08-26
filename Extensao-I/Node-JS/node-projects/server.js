const http = require('http');                                       // 1. Import the built-in 'http' module

const hostname = 'localhost';                                       // 2. Define the host and port the server will run on
const port = 3000;                                                  // 'localhost' (or 127.0.0.1) means it will only be accessible from your computer

const server = http.createServer((req, res) => {                    // 3. Create the server
    if (req.url === '/') {                                          // The 'createServer()' method takes a function that runs for every singles request
        res.writeHead(200, { 'content-type': 'text/plain' });       // This function receives two objects: 'req' (request) and 'res' (response)
        res.end('Welcome to the homepage');
    } else if (req.url === '/about') {
        res.writeHead(200, { 'content-type': 'text/plain' });
        res.end('This is the about page');
    } else {
        res.writeHead(404, { 'content-type': 'text/plain' });
        res.end('404 - Page Not Found');
    }
});

server.listen(port, hostname, () => {                               // 4. Start the server and have it listen on the defined port
    console.log(`Server running at http://${hostname}:${port}/`);   // The callback function will run once the server is successfully started
});