require('dotenv').config();

const http = require('http');

const PORT = process.env.PORT || 3000;
const GREETING = process.env.GREETING_MESSAGE || "Hello, welcome.";

const server = http.createServer((req, res) => {
    res.writeHead(200, { 'content-type': 'text/plain' });
    res.end(GREETING);
});

server.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}, following: http://localhost:${PORT}`);
});