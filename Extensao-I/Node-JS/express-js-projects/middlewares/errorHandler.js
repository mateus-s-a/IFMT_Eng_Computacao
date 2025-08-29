const errorHandler = (err, req, res, next) => {
    console.error(err.stack);                                                   // Logando o erro para depuração

    const statusCode = res.statusCode ? res.statusCode : 500;                   // Definindo um status code padrão de 500 (Internal Server Error)

    res.status(statusCode).json({                                               // Envia uma resposta JSON formatada e consistente para o cliente
        title: "An Error Occurred",
        message: err.message,
        //stack: process.env.NODE_ENV === 'production' ? null : err.stack,        // Ambiente de produção, não se vaza o 'stack' do erro
    });
};

module.exports = errorHandler;