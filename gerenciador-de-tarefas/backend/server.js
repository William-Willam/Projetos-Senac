// Importa os módulos necessários
const express = require("express");
const cors = require("cors");
require("dotenv").config();

// Importa as rotas da aplicação
const routes = require("./routes");

// Cria a instância do aplicativo Express
const app = express();

// Middleware para permitir requisições de outros domínios (CORS)
app.use(cors());

// Middleware para interpretar JSON no corpo das requisições
app.use(express.json());

// Usa as rotas definidas na pasta routes
app.use("/api", routes);

// Middleware global para tratamento de erros (opcional)
const errorHandler = require("./middleware/errorHandler");
app.use(errorHandler);

// Define a porta do servidor (usa a variável de ambiente ou 5000 como padrão)
const PORT = process.env.PORT || 5000;

// Inicia o servidor e exibe mensagem no console
app.listen(PORT, () => {
  console.log(`Servidor rodando na porta ${PORT}`);
});