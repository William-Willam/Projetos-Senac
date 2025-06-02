// Importa a conexão com o banco de dados
const db = require("../config/db");

// Busca todos os projetos no banco de dados
exports.getProjetos = (callback) => {
    db.query("SELECT * FROM projetos", callback);
}

// Cria um novo projeto no banco de dados
exports.createProjeto = (callback, projeto) => {
    const sql = "Insert into projetos (titulo, descricao, prazo, status) values (?, ?, ?, ?)";
    db.query(sql, [projeto.titulo, projeto.descricao, projeto.prazo, projeto.status], callback);
}

// Atualiza um projeto existente no banco de dados
exports.updateProjeto = (callback, projeto) => {
    db.query(
        "UPDATE projetos SET titulo = ?, descricao = ?, prazo = ?, status = ? WHERE id = ?",
        [projeto.titulo, projeto.descricao, projeto.prazo, projeto.status, projeto.id],
        callback
    );
}

// Deleta um projeto do banco de dados pelo id
exports.deleteProjeto = (callback, id) => {
    db.query("DELETE FROM projetos WHERE id = ?", [id], callback);
}