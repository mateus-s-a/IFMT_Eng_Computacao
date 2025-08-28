const express = require('express');
const router = express.Router();                    // 1. Cria uma instância do Router
const pool = require('../db');                      // 2. Precisa-se do 'pool' de conexões criado anteriormente

// NOTA: Os caminhos agora são relativos a '/todos'
// GET '/' é o mesmo que '/todos' no arquivo principal


router.get('/', async (req, res) => {                       // READ: Get all todos
    try {
        const result = await pool.query('SELECT * FROM todos ORDER BY id ASC');
        res.json(result.rows);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});

router.get('/:id', async (req, res) => {                    // READ: Get a single todo by ID
    try {
        const { id } = req.params;
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

router.post('/', async (req, res) => {                      // CREATE: Add a new todo
    try {
        const { task } = req.body;
        if (!task) {
            return res.status(400).json({ error: 'Task is required' });         // 400 = Bad Request
        }

        const result = await pool.query(
            'INSERT INTO todos (task) VALUES ($1) RETURNING *',
            [task]
        );
        res.status(201).json(result.rows[0]);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});

router.put('/:id', async (req, res) => {                    // UPDATE: Modify an existing code
    try {
        const { id } = req.params;
        const { task, completed } = req.body;
        const result = await pool.query(
            'UPDATE todos SET task = $1, completed = $2 WHERE id = $3 RETURNING *',
            [task, completed, id]
        );

        if (result.rows.length === 0) {
            res.status(404).json({ error: 'To-do not found' });
        }
        res.json(result.rows[0]);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});

router.delete('/:id', async (req, res) => {                 // DELETE: Remove a todo
    try {
        const { id } = req.params;
        const result = await pool.query('DELETE FROM todos WHERE id = $1', [id]);

        if (result.rowCount === 0) {
            return res.status(404).json({ error: 'Internal server error' });
        }
        res.status(204).send();             // 204 = No Content
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});



module.exports = router;                        // 3. Exportar o 'router' para ser usado em outros arquivos