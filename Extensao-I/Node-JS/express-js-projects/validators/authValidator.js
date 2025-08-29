const Joi = require('joi');

const registerSchema = Joi.object({                     // Schema para o registro de um novo usuário
    name: Joi.string().min(3).max(100).required(),
    email: Joi.string().email().required(),
    password: Joi.string().min(6).required(),           // Exigir senha mínimo 6 caracteres
});

const loginSchema = Joi.object({                        // Schema para o login
    email: Joi.string().email().required(),
    password: Joi.string().required(),
});



module.exports = {
    registerSchema,
    loginSchema,
};