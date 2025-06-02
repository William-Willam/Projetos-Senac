// Importa a conexão com o banco de dados (pool do mysql2/promise)
const db = require("../config/db");

const Usuario = {
    // Cria um novo usuário no banco de dados
    async criarUsuario(nome, email, senha) {
        const sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        const [result] = await db.execute(sql, [nome, email, senha]);
        return result.insertId; // retorna o id do novo usuário
    },

    // Busca um usuário pelo e-mail
    async buscarPorEmail(email) {
        const sql = "SELECT * FROM usuarios WHERE email = ?";
        const [rows] = await db.execute(sql, [email]);
        return rows[0]; // retorna o usuário encontrado ou undefined
    },

    // Busca um usuário pelo id
    async buscarPorId(id) {
        const sql = "SELECT * FROM usuarios WHERE id = ?";
        const [rows] = await db.execute(sql, [id]);
        return rows[0];
    }
};

module.exports = Usuario;