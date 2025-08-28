const express = require('express');
const todoRoutes = require('./routes/todos');                   // Importanto o módulo de rotas de to-dos

const app = express();
const PORT = 3000;

// --- MIDDLEWARES GLOBAIS ---
app.use(express.json());                        // Middleware para parse de JSON

// --- MONTAGEM DAS ROTAS ---
// Qualquer requisição ('req') que comece com '/todos' será
// gerenciada pelo nosso 'todoRoutes'
app.use('/todos', todoRoutes);

app.listen(PORT, () => {
    console.log(`Server's running on http://localhost:${PORT}`);
})