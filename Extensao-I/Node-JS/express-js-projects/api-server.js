const express = require('express');
const app = express();
const PORT = 3000;

app.use(express.json());


let todos = [
    { id: 1, task: 'Learn Node.js basics', completed: true },
    { id: 2, task: 'Build a REST API', completed: false },
];


app.get('/todos', (req, res) => {
    res.json(todos);
});

app.get('/todos/:id', (req, res) => {
    const todoId = parseInt(req.params.id);
    const todo = todos.find(t => t.id === todoId);

    if (todo) {
        res.json(todo);
    } else {
        res.status(404).json({ error: 'To-do not found' });
    }
});

app.post('/todos', (req, res) => {
    if (!req.body.task) {
        return res.status(404).json({ error: 'Task is required' });
    }

    const newTodo = {
        id: Date.now(),
        task: req.body.task,
        completed: false
    };

    todos.push(newTodo);
    res.status(201).json(newTodo);
});

app.put('/todos/:id', (req, res) => {
    const todoId = parseInt(req.params.id);
    const todo = todos.find(t => t.id === todoId);

    if (!todo) {
        return res.status(404).json({ error: 'To-do not found'} );
    }

    todo.task = req.body.task || todo.task;
    todo.completed = req.body.completed !== undefined ? req.body.completed : todo.completed;

    res.json(todo);
});

app.delete('/todos/:id', (req, res) => {
    const todoId = parseInt(req.params.id);
    const todoIndex = todos.findIndex(t => t.id === todoId);

    if (todoIndex === -1) {
        res.status(404).json({ error: 'To-do not found' });
    }

    todos.splice(todoIndex, 1);
    res.status(204).send();
});


app.listen(PORT, () => {
    console.log(`API server is running on: http://localhost:${PORT}`);
})