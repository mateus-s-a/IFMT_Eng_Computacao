require('dotenv').config();                                 // Load environment variables from '.env' file

const express = require('express');
const { Pool } = require('pg');                             // Import the 'pg'(Postgre) Pool object

const app = express();
const PORT = 3000;

const pool = new Pool({                                 // Create a new Pool instance to manage Database connections
    user: process.env.DB_USER,
    host: process.env.DB_HOST,
    database: process.env.DB_DATABASE,
    password: process.env.DB_PASSWORD,
    port: process.env.DB_PORT,
});

app.use(express.json());



// --- ROUTES (Now with async/await and DB queries) ---

app.get('/todos', async (req, res) => {                     // READ: Get all To-dos
    try {
        const result = await pool.query('SELECT * FROM todos ORDER BY id ASC');
        res.json(result.rows);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });       // 500 = Internal Server Error
    }
});

app.get('/todos/:id', async (req, res) => {                 // READ: Get a single To-do item by ID
    try {
        const { id } = req.params;
        // Use a parameterized query to prevent SQL Injection
        const result = await pool.query('SELECT * FROM todos WHERE id = $1', [id]);

        if (result.rows.length === 0) {
            return res.status(404).json({ error: 'To-do not found' });
        }
        res.json(result.rows[0]);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});

app.post('/todos', async (req, res) => {                    // CREATE: Add a new To-do
    try {
        const { task } = req.body;
        if (!task) {
            return res.status(400).json({ error: 'Task is required' });         // 400 = Bad Request
        }

        const result = await pool.query(                    // 'RETURNING *' gets the newly created row back from the DB
            'INSERT INTO todos (task) VALUES ($1) RETURNING *',
            [task]
        );
        res.status(201).json(result.rows[0]);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});

app.put('/todos/:id', async (req, res) => {                 // UPDATE: Modify an existing To-do item
    try {
        const { id } = req.params;
        const { task, completed } = req.body;
        const result = await pool.query(
            'UPDATE todos SET task = $1, completed = $2 WHERE id = $3 RETURNING *',
            [task, completed, id]
        );

        if (result.rows.length === 0) {
            return res.status(404).json({ error: 'To-do not found' });
        }
        res.json(result.rows[0]);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});

app.delete('/todos/:id', async (req, res) => {              // DELETE: Remove a To-do item
    try {
        const { id } = req.params;
        const result = await pool.query('DELETE FROM todos WHERE id = $1', [id]);

        if (result.rowCount === 0) {
            return res.status(404).json({ error: 'To-do not found' });
        }
        res.status(204).send();             // 204 = No Content
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});



app.listen(PORT, () => {
    console.log(`Database API server running on http://localhost:${PORT}`);
})