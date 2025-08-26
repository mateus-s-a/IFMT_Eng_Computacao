require('dotenv').config();                                                 // Load variables from .env file into 'process.env'

const http = require('http');

const PORT = process.env.PORT || 3000;                                      // Read the configuration from 'process.env', with defaults
const GREETING = process.env.GREETING_MESSAGE || "Hello, welcome.";

const server = http.createServer((req, res) => {
    res.writeHead(200, { 'content-type': 'text/plain' });
    res.end(GREETING);
});

server.listen(PORT, () => {
    console.log(`Server's running on ${PORT}: http://localhost:${PORT}`);
});