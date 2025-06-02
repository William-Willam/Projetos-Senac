const db = require("../config/db");

exports.getProjetos = (callback) => {
    db.query("SELECT * FROM projetos", callback);
}

exports.createProjeto = (callback, projeto) => {
const sql = "Insert into projetos (titulo, descricao, prazo, status) values (?, ?, ?, ?)";
    db.query(sql, [projeto.titulo, projeto.descricao, projeto.prazo, projeto.status], callback);
}

exports.updateProjeto = (callback, projeto) => {
    db.query("UPDATE projetos SET titulo = ?, descricao = ?, prazo = ?, status = ? WHERE id = ?",
        [projeto.titulo, projeto.descricao, projeto.prazo, projeto.status, projeto.id], callback);
}


exports.deleteProjeto = (callback, id) => {
    db.query("DELETE FROM projetos WHERE id = ?", [id], callback);
}