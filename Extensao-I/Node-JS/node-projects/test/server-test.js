const http = require('http');
const fs = require('fs/promises');
const path = require('path');
const os = require('os');
const _ = require('lodash');

const PORT = 4000;

const server = http.createServer(async (req, res) => {
    if (req.url === '/') {
        const greeting = 'welcome to our all-in-one server!';

        res.writeHead(200, { 'content-type': 'text/plain' });
        res.end(_.startCase(greeting));
    } else if (req.url === '/status') {
        const statusInfo = {
            platform: os.platform(),
            cpus: os.cpus().length,
            freeMemory: `${(os.freemem() / 1024 / 1024).toFixed(2)} MB`,
            uptime: `${(os.uptime() / 60).toFixed(2)} minutes`
        };

        res.writeHead(200, { 'content-type': 'application/json' });
        res.end(JSON.stringify(statusInfo, null, 4));
    } else if (req.url === '/create-file') {
        try {
            const filePath = path.join(__dirname, 'newly-created-file.txt');
            const fileContent = `File created at: ${new Date().toISOString()}`;

            await fs.writeFile(filePath, fileContent);

            res.writeHead(200, { 'content-type': 'text/plain' });
            res.end('File was created successfully.');
        } catch (error) {
            console.error("Error writing file:", error);
            res.writeHead(500, { 'content-type': 'text/plain' });
            res.end('Server error: Could not create the file.');
        }
    } else {
        res.writeHead(400, { 'content-type': 'text/plain' });
        res.end('404 - Page Not Found');
    }
});


server.listen(PORT, () => {
    console.log(`Server is listening on http://localhost:${PORT}`);
});