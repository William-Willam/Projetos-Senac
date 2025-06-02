const Tarefa = require("../models/tarefasModel");

exports.criar = async (req, res) => {
  try {
    const { nome, descricao, prazo, status, prioridade, projeto_id } = req.body;
    const usuario_id = req.usuario.id; // vem do middleware de autenticação

    if (!nome || !projeto_id) {
      return res.status(400).json({ mensagem: "Nome e projeto são obrigatórios." });
    }

    const id = await Tarefa.criar({
      nome, descricao, prazo, status, prioridade, projeto_id, usuario_id
    });

    res.status(201).json({ id, nome, descricao, prazo, status, prioridade, projeto_id });
  } catch (err) {
    console.error("Erro ao criar tarefa:", err);
    res.status(500).json({ mensagem: "Erro ao criar tarefa." });
  }
};

exports.listarPorProjeto = async (req, res) => {
  try {
    const { projeto_id } = req.params;
    const tarefas = await Tarefa.listarPorProjeto(projeto_id);
    res.json(tarefas);
  } catch (err) {
    console.error("Erro ao listar tarefas:", err);
    res.status(500).json({ mensagem: "Erro ao listar tarefas." });
  }
};

exports.atualizar = async (req, res) => {
  try {
    const { id } = req.params;
    const alteradas = await Tarefa.atualizar(id, req.body);
    if (alteradas) return res.json({ mensagem: "Tarefa atualizada com sucesso." });
    res.status(404).json({ mensagem: "Tarefa não encontrada." });
  } catch (err) {
    console.error("Erro ao atualizar tarefa:", err);
    res.status(500).json({ mensagem: "Erro ao atualizar tarefa." });
  }
};

exports.deletar = async (req, res) => {
  try {
    const { id } = req.params;
    const deletadas = await Tarefa.deletar(id);
    if (deletadas) return res.json({ mensagem: "Tarefa deletada com sucesso." });
    res.status(404).json({ mensagem: "Tarefa não encontrada." });
  } catch (err) {
    console.error("Erro ao deletar tarefa:", err);
    res.status(500).json({ mensagem: "Erro ao deletar tarefa." });
  }
};
