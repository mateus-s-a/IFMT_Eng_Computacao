const express = require('express');
const router = express.Router();
const pool = require('../db');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const asyncHandler = require('express-async-handler');


router.post('/register', asyncHandler(async (req, res) => {                 // ROTA DE REGISTRO
    const { name, email, password } = req.body;

    if (!name || !email || !password) {                         // Validação simples (em um app real, Joi aqui)
        return res.status(400).json({ message: 'Please, fill in all fields' });
    }

    const salt = await bcrypt.genSalt(10);                      // Criptografar a senha
    const hashedPassword = await bcrypt.hash(password, salt);

    const newUser = await pool.query(                           // Inserir usuário no Banco de Dados 'tododb'
        'INSERT INTO users (name, email, password) VALUES ($1, $2, $3) RETURNING id, name, email',
        [name, email, hashedPassword]
    );

    res.status(201).json(newUser.rows[0]);
}));

router.post('/login', asyncHandler(async (req, res) => {                    // ROTA DE LOGIN
    const { email, password } = req.body;

    const userResult = await pool.query('SELECT * FROM users WHERE email = $1', [email]);       // Encontrar o usuário pelo email
    if (userResult.rows.length === 0) {
        return res.status(401).json({ message: 'Invalid credentials' });            // 401 = Unauthorized
    }

    const user = userResult.rows[0];

    const isMatch = await bcrypt.compare(password, user.password);          // Comparar a senha enviada com a senha criptografada no banco
    if (!isMatch) {
        return res.status(401).json({ message: 'Invalid credentials' });
    }

    // Payload: informações que queremos no token
    const token = jwt.sign(             // Se as senhas combinam, gerar o JWT (o "crachá")
        { id: user.id },                
        process.env.JWT_SECRET,         // A chave secreta
        { expiresIn: '1h' },            // Options: token expira em 1 hora
    );

    res.json({ token });
}));



module.exports = router;