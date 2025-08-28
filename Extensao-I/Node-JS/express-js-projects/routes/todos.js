const express = require('express');
const router = express.Router();
const pool = require('../db');


router.get('/', async (req, res) => {
    try {
        const result = await pool.query('SELECT * FROM todos ORDER BY id ASC');
        res.json(result.rows);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});

router.get('/:id', async (req, res) => {
    try {
        const { id } = req.params;
        const result = await pool.query('SELECT * FROM todos WHERE id = $1', [id]);

        if (result.rows.length === 0) {
            return res.status(404).json({ error: 'To-do not found' });
        }
        res.json(result.rows[0]);
    } catch (err) {
        console.error(err);
        res.status();
    }
});

router.post('/', async (req, res) => {
    try {
        const { task } = req.body;
        if (!task) {
            return res.status(400).json({ error: 'Task is required' });
        }

        const result = pool.query(
            'INSERT INTO todos (task) VALUES ($1) RETURNING *',
            [task]
        );
        res.status(201).json(result.rows[0]);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});

router.put('/:id', async (req, res) => {
    try {
        const { id } = req.params;
        const { task, completed } = req.body;
        const result = pool.query(
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

router.delete('/:id', async (req, res) => {
    try {
        const { id } = req.params;
        const result = pool.query('DELETE FROM todos WHERE id = $1', [id]);

        if (result.rowCount === 0) {
            return res.status(404).json({ error: 'Internal server error' });
        }
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal server error' });
    }
});



module.exports = router;