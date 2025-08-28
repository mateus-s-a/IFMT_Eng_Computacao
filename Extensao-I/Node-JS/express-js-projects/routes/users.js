const express = require('express');
const router = express.Router();
const pool = require('../db');

router.get('/', async (req, res) => {
    res.send('Lista de todos os usuários');             // Lógica para buscar usuários na tabela 'users' do banco de dados viria aqui
});

module.exports = router;