const express = require('express');
const app = express();
const PORT = 3000;

app.use(express.json());            // Middleware to parse JSON bodies


// --- In-Memory Database ---
let todos = [                       // Using a simple array to act as a Database for now
    { id: 1, task: 'Learn Node.js basics', completed: true },
    { id: 2, task: 'Build a REST API', completed: false },
];


// --- ROUTES ---
app.get('/todos', (req, res) => {                       // READ: Get all to-do items
    res.json(todos);
});

app.get('/todos/:id', (req, res) => {                   // READ: Get a single to-do item by ID
    const todoId = parseInt(req.params.id);             // Get the ID from the route parameters and convert it to a number
    const todo = todos.find(t => t.id === todoId);

    if (todo) {
        res.json(todo);
    } else {
        res.status(404).json({ error: 'To-do not found' });     // If not found, send a 404 status
    }
});

app.post('/todos', (req, res) => {                      // CREATE: Add a new to-do item
    if (!req.body.task) {
        return res.status(404).json({ error: 'Task is required' });
    }

    const newTodo = {
        id: Date.now(),                                 // Simple way to generate an unique ID
        task: req.body.task,
        completed: false
    };

    todos.push(newTodo);
    res.status(201).json(newTodo);                      // Send a 201 status (Created) with the new resource
});

app.put('/todos/:id', (req, res) => {                   // UPDATE: Modify an existing to-do item
    const todoId = parseInt(req.params.id);
    const todo = todos.find(t => t.id === todoId);

    if (!todo) {
        return res.status(404).json({ error: 'To-do not found'} );
    }

    // Update the 'task' and 'completed' status from the request body
    todo.task = req.body.task || todo.task;
    todo.completed = req.body.completed !== undefined ? req.body.completed : todo.completed;

    res.json(todo);
});

app.delete('/todos/:id', (req, res) => {                // DELETE: Remove a to-do item
    const todoId = parseInt(req.params.id);
    const todoIndex = todos.findIndex(t => t.id === todoId);

    if (todoIndex === -1) {
        res.status(404).json({ error: 'To-do not found' });
    }

    todos.splice(todoIndex, 1);                         // Remove the item from the array
    res.status(204).send();                             // Send a 204 (No Content) status for successfull deletion
});


app.listen(PORT, () => {                                // Start the Server
    console.log(`API server is running on: http://localhost:${PORT}`);
})