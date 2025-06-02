const Tarefa = require("../models/tarefasModel");

// Cria uma nova tarefa
exports.criar = async (req, res) => {
  try {
    const { nome, descricao, prazo, status, prioridade, projeto_id } = req.body;
    if (!nome || !projeto_id) return res.status(400).json({ mensagem: "Nome e projeto são obrigatórios." });
    const id = await Tarefa.criar({ nome, descricao, prazo, status, prioridade, projeto_id });
    res.status(201).json({ id, nome, descricao, prazo, status, prioridade, projeto_id });
  } catch (err) {
    res.status(500).json({ mensagem: "Erro ao criar tarefa." });
  }
};

// Lista tarefas de um projeto
exports.listarPorProjeto = async (req, res) => {
  try {
    const { projeto_id } = req.params;
    const tarefas = await Tarefa.listarPorProjeto(projeto_id);
    res.json(tarefas);
  } catch (err) {
    res.status(500).json({ mensagem: "Erro ao listar tarefas." });
  }
};

// Atualiza uma tarefa
exports.atualizar = async (req, res) => {
  try {
    const { id } = req.params;
    const alteradas = await Tarefa.atualizar(id, req.body);
    if (alteradas) return res.json({ mensagem: "Tarefa atualizada com sucesso." });
    res.status(404).json({ mensagem: "Tarefa não encontrada." });
  } catch (err) {
    res.status(500).json({ mensagem: "Erro ao atualizar tarefa." });
  }
};

// Deleta uma tarefa
exports.deletar = async (req, res) => {
  try {
    const { id } = req.params;
    const deletadas = await Tarefa.deletar(id);
    if (deletadas) return res.json({ mensagem: "Tarefa deletada com sucesso." });
    res.status(404).json({ mensagem: "Tarefa não encontrada." });
  } catch (err) {
    res.status(500).json({ mensagem: "Erro ao deletar tarefa." });
  }
};