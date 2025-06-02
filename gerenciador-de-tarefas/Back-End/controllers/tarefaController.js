const Tarefas = require("../models/tarefaModel");

// Busca todas as tarefas
exports.getTarefas = (req, res) => {
    Tarefas.getTarefas((err, tarefas) => {
        if (err) {
            return res.status(500).json({ error: "Erro ao buscar tarefas" });
        }
        res.json(tarefas);
    });
};

// Cria uma nova tarefa
exports.createTarefa = (req, res) => {
    const tarefa = req.body;
    Tarefas.createTarefa((err, result) => {
        if (err) {
            return res.status(500).json({ error: "Erro ao criar tarefa" });
        }
        res.status(201).json({ id: result.insertId, ...tarefa });
    }, tarefa);
};

// Atualiza uma tarefa existente
exports.updateTarefa = (req, res) => {
    const tarefa = req.body;
    Tarefas.updateTarefa((err, result) => {
        if (err) {
            return res.status(500).json({ error: "Erro ao atualizar tarefa" });
        }
        if (result.affectedRows === 0) {
            return res.status(404).json({ error: "Tarefa não encontrada" });
        }
        res.json({ message: "Tarefa atualizada com sucesso" });
    }, tarefa);
};

// Deleta uma tarefa pelo id
exports.deleteTarefa = (req, res) => {
    const id = req.params.id;
    Tarefas.deleteTarefa((err, result) => {
        if (err) {
            return res.status(500).json({ error: "Erro ao deletar tarefa" });
        }
        if (result.affectedRows === 0) {
            return res.status(404).json({ error: "Tarefa não encontrada" });
        }
        res.json({ message: "Tarefa deletada com sucesso" });
    }, id);
};

