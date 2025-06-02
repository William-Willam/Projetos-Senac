const db = require("../config/db");

const Tarefa = {
  async criar({ nome, descricao, prazo, status, prioridade, projeto_id, usuario_id }) {
    const [result] = await db.query(
      `INSERT INTO tarefas (nome, descricao, prazo, status, prioridade, projeto_id, usuario_id)
       VALUES (?, ?, ?, ?, ?, ?, ?)`,
      [nome, descricao, prazo, status, prioridade, projeto_id, usuario_id]
    );
    return result.insertId;
  },

  async listarPorProjeto(projeto_id) {
    const [rows] = await db.query(
      "SELECT * FROM tarefas WHERE projeto_id = ? ORDER BY prazo ASC",
      [projeto_id]
    );
    return rows;
  },

  async atualizar(id, dados) {
    const { nome, descricao, prazo, status, prioridade } = dados;
    const [result] = await db.query(
      `UPDATE tarefas SET nome = ?, descricao = ?, prazo = ?, status = ?, prioridade = ? 
       WHERE id = ?`,
      [nome, descricao, prazo, status, prioridade, id]
    );
    return result.affectedRows;
  },

  async deletar(id) {
    const [result] = await db.query("DELETE FROM tarefas WHERE id = ?", [id]);
    return result.affectedRows;
  },
};

module.exports = Tarefa;
