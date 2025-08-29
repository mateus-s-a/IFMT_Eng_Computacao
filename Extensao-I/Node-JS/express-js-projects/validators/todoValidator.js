const Joi = require('joi');

const createTodoSchema = Joi.object({           // Schema para a criação de um 'todo' item
    task: Joi.string().min(1).required(),       // Define que task deve ser uma string, com no mínimo 1 caractere, e é obrigatória
    completed: Joi.boolean(),                   // 'completed' é opcional na criação
});

const updateTodoSchema = Joi.object({           // Schema para a atualização de um 'todo' item
    task: Joi.string().min(1),
    completed: Joi.boolean(),
}).min(1);                                      // Exige que pelo menos um dos campos seja preenchido



module.exports = {
    createTodoSchema,
    updateTodoSchema
};