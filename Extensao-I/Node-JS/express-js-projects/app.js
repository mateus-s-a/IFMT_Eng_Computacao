const express = require('express');
const todoRoutes = require('./routes/todos');                   // Importanto o módulo de rotas de to-dos
const usersRoutes = require('./routes/users');
const errorHandler = require('./middlewares/errorHandler');
const authRoutes = require('./routes/auth');

const app = express();
const PORT = 3000;

// --- MIDDLEWARES GLOBAIS ---
app.use(express.json());                            // Middleware para parse de JSON

// --- MONTAGEM DAS ROTAS ---
// Qualquer requisição ('req') que comece com '/todos' será
// gerenciada pelo nosso 'todoRoutes'
app.use('/api/auth', authRoutes);                   // Novas rotas de autenticação
app.use('/todos', todoRoutes);                      // Rotas 'todos' agora protegidas
app.use('/users', usersRoutes);

// --- MIDDLEWARE TRATAMENTO DE ERRO ---
app.use(errorHandler);                              // Deve estar adicionado abaixo das MONTAGEM DAS ROTAS

app.listen(PORT, () => {
    console.log(`Server's running on http://localhost:${PORT}`);
});