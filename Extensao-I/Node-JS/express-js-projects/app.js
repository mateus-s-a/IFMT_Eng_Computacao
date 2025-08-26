const express = require('express');                                             // 1. Importing 'Express.js'
const os = require('os');

const app = express();                                                          // 2. Create an Express application instance

const PORT = 3000;                                                              // 3. Define the PORT


app.get('/', (req, res) => {                                                    // 'Homepage' route
    res.send('<h1>Welcome to our Express.js Server!</h1>');
});

app.get('/status', (req, res) => {                                              // 'Status' route
    const statusInfo = {
        platform: os.platform(),
        cpus: os.cpus(),
        freeMemory: `${(os.freemem() / 1024 / 1024).toFixed(2)} MB`,
        uptime: `${(os.uptime() / 60).toFixed(2)} minutes`
    };

    res.json(statusInfo);           // 'res.json()' automatically converts a JS object to JSON, and sets the correct 'content-type' header
});

app.listen(PORT, () => {                                                        // Starts the Server
    console.log(`Express.js server running on: http://localhost:${PORT}`);
});