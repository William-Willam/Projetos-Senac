// Importa a conexão com o banco de dados
const db = require("../config/db");

// Busca todas as tarefas no banco de dados
exports.getTarefas = (callback) => {
    db.query("SELECT * FROM tarefas", callback);
}

// Cria uma nova tarefa no banco de dados
exports.createTarefa = (callback, tarefa) => {
    const sql = "INSERT INTO tarefas (titulo, descricao, prazo, status, projeto_id) VALUES (?, ?, ?, ?, ?)";
    db.query(sql, [tarefa.titulo, tarefa.descricao, tarefa.prazo, tarefa.status, tarefa.projeto_id], callback);
}

// Atualiza uma tarefa existente no banco de dados
exports.updateTarefa = (callback, tarefa) => {
    db.query(
        "UPDATE tarefas SET titulo = ?, descricao = ?, prazo = ?, status = ?, projeto_id = ? WHERE id = ?",
        [tarefa.titulo, tarefa.descricao, tarefa.prazo, tarefa.status, tarefa.projeto_id, tarefa.id],
        callback
    );
}

// Deleta uma tarefa do banco de dados pelo id
exports.deleteTarefa = (callback, id) => {
    db.query("DELETE FROM tarefas WHERE id = ?", [id], callback);
}