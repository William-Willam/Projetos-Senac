const db = require("../config/db");

const Projeto = {
  // Cria um novo projeto
  async criar({ titulo, descricao, prazo, status, usuario_id }) {
    const [result] = await db.query(
      "INSERT INTO projetos (titulo, descricao, prazo, status, usuario_id) VALUES (?, ?, ?, ?, ?)",
      [titulo, descricao, prazo, status, usuario_id]
    );
    return result.insertId;
  },

  // Lista todos os projetos de um usuário, ordenados por prazo
  async listarPorUsuario(usuario_id) {
    const [rows] = await db.query(
      "SELECT * FROM projetos WHERE usuario_id = ? ORDER BY prazo ASC",
      [usuario_id]
    );
    return rows;
  },

  // Atualiza um projeto pelo id
  async atualizar(id, dados) {
    const { titulo, descricao, prazo, status } = dados;
    const [result] = await db.query(
      "UPDATE projetos SET titulo = ?, descricao = ?, prazo = ?, status = ? WHERE id = ?",
      [titulo, descricao, prazo, status, id]
    );
    return result.affectedRows; // retorna quantas linhas foram alteradas
  },

  // Deleta um projeto pelo id
  async deletar(id) {
    const [result] = await db.query("DELETE FROM projetos WHERE id = ?", [id]);
    return result.affectedRows; // retorna quantas linhas foram deletadas
  },
};

module.exports = Projeto;