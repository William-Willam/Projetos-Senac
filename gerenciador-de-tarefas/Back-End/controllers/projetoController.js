const Projeto = require("../models/projeto");

// Busca todos os projetos
exports.getProjetos = (req, res) => {
    Projeto.getProjetos((err, projetos) => {
        if (err) {
            return res.status(500).json({ error: "Erro ao buscar projetos" });
        }
        res.json(projetos);
    });
};

// Cria um novo projeto
exports.createProjeto = (req, res) => {
    const projeto = req.body;
    Projeto.createProjeto((err, result) => {
        if (err) {
            return res.status(500).json({ error: "Erro ao criar projeto" });
        }
        res.status(201).json({ id: result.insertId, ...projeto });
    }, projeto);
};

// Atualiza um projeto existente
exports.updateProjeto = (req, res) => {
    const projeto = req.body;
    Projeto.updateProjeto((err, result) => {
        if (err) {
            return res.status(500).json({ error: "Erro ao atualizar projeto" });
        }
        if (result.affectedRows === 0) {
            return res.status(404).json({ error: "Projeto não encontrado" });
        }
        res.json({ message: "Projeto atualizado com sucesso" });
    }, projeto);
};

// Deleta um projeto pelo id
exports.deleteProjeto = (req, res) => {
    const id = req.params.id;
    Projeto.deleteProjeto((err, result) => {
        if (err) {
            return res.status(500).json({ error: "Erro ao deletar projeto" });
        }
        if (result.affectedRows === 0) {
            return res.status(404).json({ error: "Projeto não encontrado" });
        }
        res.json({ message: "Projeto deletado com sucesso" });
    }, id);
};  

