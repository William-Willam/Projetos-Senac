// Configuração do banco de dados MySQL usando mysql2/promise
// Importa o módulo mysql2/promise para trabalhar com MySQL de forma assíncrona
const mysql = require('mysql2/promise');
// Importa o módulo dotenv para carregar variáveis de ambiente do arquivo .env
require('dotenv').config();

// Cria uma conexão com o banco de dados MySQL usando as variáveis de ambiente
const pool = mysql.createPool({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME,
  waitForConnections: true,
  connectionLimit: 10,
  queueLimit: 0,
});

// Testa a conexão com o banco de dados
pool.getConnection()
  .then(() => console.log('✅ Conectado ao MySQL com sucesso!'))
  .catch(err => console.error('❌ Erro ao conectar ao MySQL:', err));

module.exports = pool;
