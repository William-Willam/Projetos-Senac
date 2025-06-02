// Importa o framework Express para criar o servidor
const express = require('express');
// Importa o CORS para permitir requisições de outros domínios
const cors = require('cors');
// Importa as rotas definidas no arquivo routes.js
const routes = require('./routes');
// Carrega as variáveis de ambiente do arquivo .env
require('dotenv').config();

// Cria uma instância do aplicativo Express
const app = express();

// Habilita o uso do CORS no servidor
app.use(cors());
// Permite que o servidor entenda requisições com JSON no corpo
app.use(express.json());

// Usa as rotas definidas, prefixando com /api
app.use('/api', routes);

// Define a porta do servidor (usa a variável de ambiente ou 5000 como padrão)
const PORT = process.env.PORT || 5000;
// Inicia o servidor e exibe mensagem no console quando estiver rodando
app.listen(PORT, () => {
  console.log(`Servidor rodando na porta ${PORT}`);
});