const pool = require('../db');
const jwt = require('jsonwebtoken');
const asyncHandler = require('express-async-handler');

const protect = asyncHandler(async (req, res, next) => {
    let token;

    if (req.headers.authorization && req.headers.authorization.startsWith('Bearer')) {
        token = req.headers.authorization.split(' ')[1];                // 1. Extrair o 'token' do cabeçalho 'Bearer <token>'
        
        const decoded = jwt.verify(token, process.env.JWT_SECRET);      // 2. Verificar se o 'token' é válido

        // 3. Anexar o usuário à requisição 'req' para uso posterior
        // Busca-se o usuário no Data Base para garantir que ele ainda existe
        const userResult = await pool.query('SELECT id, name, email FROM users WHERE id = $1', [decoded.id]);
        if (userResult.rows.length === 0) {
            res.status(401);                    // Define o status específico para este caso = Unauthorized
            throw new Error("User not found, token's user doesn't exist anymore");
        }
        req.user = userResult.rows[0];
        
        next();                 // Passa para o próximo middleware/rota 'next()'
    }

    if (!token) {
        res.status(401);
        throw new Error('Not authorized, token missing');
    }
});

module.exports = protect;