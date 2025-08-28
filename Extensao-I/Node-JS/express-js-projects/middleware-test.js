const express = require('express');                                             // 1. Importing 'Express.js'
const os = require('os');

const app = express();                                                          // 2. Create an Express application instance
const PORT = 3000;                                                              // 3. Define the PORT


// --- MIDDLEWARE ---
const logger = (req, res, next) => {                                                // This is a custom logger middleware
    console.log(`[${new Date().toISOString}] ${req.method} ${req.originalUrl}`);    // Log the request method and the original URL

    next();                                                                         // Call 'next()' to pass control to the next middleware/route handler
}

// --- APPLY THE MIDDLEWARE ---
app.use(logger);                                // It tells Express.js to 'use()' 'logger' for every single request that comes in. MUST be replaced before the routes

// --- SERVE STATIC FILLES (public) ---
app.use(express.static('public'));              // This Middleware tells Express.js to look for any requestered files in the 'public' folder

app.use(express.json());                        // This Middleware parses incoming JSON and makes it avaible on 'req.body'


// --- ROUTES ---
app.get('/', (req, res) => {                                                    // 'Homepage' route
    res.send('<h1>Welcome to our Express.js Server!</h1>');
});

app.get('/status', (req, res) => {                                              // 'Status' route
    const statusInfo = {
        platform: os.platform(),
        cpus: os.cpus().length,
        freeMemory: `${(os.freemem() / 1024 / 1024).toFixed(2)} MB`,
        uptime: `${(os.uptime() / 60).toFixed(2)} minutes`
    };

    res.json(statusInfo);                       // 'res.json()' automatically converts a JS object to JSON, and sets the correct 'content-type' header
});

app.post('/api/users', (req, res) => {                                          // 'API' route to create a new user
    const newUser = req.body;                                                   // Thanks to 'express.json()' middleware, 'req.body' contains the parsed JSON
    console.log("Received a new user data: ", newUser);

    if (!newUser.name || !newUser.email) {                                      // Sending back only a confirmation
        return res.status(400).json({ error: 'Name and Email are required.' }); // If data is missing: Bad Request 400
    }

    res.status(201).json({                                                      // 201 = Created
        message: 'User created successfully',
        user: newUser
    });
});




app.listen(PORT, () => {                                                        // Starts the Server
    console.log(`Express.js server running on: http://localhost:${PORT}`);
});