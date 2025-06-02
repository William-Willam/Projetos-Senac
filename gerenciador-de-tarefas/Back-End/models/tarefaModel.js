const db = require("../config/db");

exports.getTarefasByProjeto = (callback, projetoId) => {
  db.query("SELECT * FROM tarefas WHERE projeto_id = ?", [idProjeto], callback);
};

exports.createTarefa = (callback, tarefa) => {
  const sql =
    "INSERT INTO tarefas (titulo, descricao, prazo, status, projeto_id) VALUES (?, ?, ?, ?, ?)";
  db.query(
    sql,
    [
      tarefa.titulo,
      tarefa.descricao,
      tarefa.prazo,
      tarefa.status,
      tarefa.projeto_id,
    ],
    callback
  );
};

exports.updateTarefa = (callback, tarefa) => {
    db.query(
        "UPDATE tarefas SET titulo = ?, descricao = ?, prazo = ?, status = ? WHERE id = ?",
        [
        tarefa.titulo,
        tarefa.descricao,
        tarefa.prazo,
        tarefa.status,
        tarefa.id,
        ],
        callback
    );
}

exports.deleteTarefa = (callback, id) => {
    db.query("DELETE FROM tarefas WHERE id = ?", [id], callback);
}
