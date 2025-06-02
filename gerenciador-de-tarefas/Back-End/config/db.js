// Importa o módulo mysql2 para conectar ao banco de dados MySQL
const mysql = require('mysql2');

// Carrega as variáveis de ambiente do arquivo .env
require('dotenv').config();

// Cria uma conexão com o banco de dados usando as variáveis de ambiente
const db = mysql.createConnection({
  host: process.env.DB_HOST,       // Endereço do servidor MySQL
  user: process.env.DB_USER,       // Usuário do banco de dados
  password: process.env.DB_PASSWORD, // Senha do banco de dados
  database: process.env.DB_NAME,   // Nome do banco de dados
});

// Tenta conectar ao banco de dados
db.connect((err) => {
  if (err) {
    // Se houver erro, exibe mensagem de erro no console
    console.error('Erro ao conectar ao MySQL:', err);
  } else {
    // Se conectar com sucesso, exibe mensagem de sucesso
    console.log('Conectado ao MySQL!');
  }
});

// Exporta a conexão para ser usada em outros arquivos do projeto
module.exports = db;