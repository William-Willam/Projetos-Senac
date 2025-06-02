const Projeto = require("../models/projetoModel");

// Cria um novo projeto
exports.criar = async (req, res) => {
  try {
    const { titulo, descricao, prazo, status, usuario_id } = req.body;
    if (!titulo || !usuario_id) return res.status(400).json({ mensagem: "Título e usuário são obrigatórios." });
    const id = await Projeto.criar({ titulo, descricao, prazo, status, usuario_id });
    res.status(201).json({ id, titulo, descricao, prazo, status, usuario_id });
  } catch (err) {
    res.status(500).json({ mensagem: "Erro ao criar projeto." });
  }
};

// Lista projetos de um usuário
exports.listarPorUsuario = async (req, res) => {
  try {
    const { usuario_id } = req.params;
    const projetos = await Projeto.listarPorUsuario(usuario_id);
    res.json(projetos);
  } catch (err) {
    res.status(500).json({ mensagem: "Erro ao listar projetos." });
  }
};

// Atualiza um projeto
exports.atualizar = async (req, res) => {
  try {
    const { id } = req.params;
    const alteradas = await Projeto.atualizar(id, req.body);
    if (alteradas) return res.json({ mensagem: "Projeto atualizado com sucesso." });
    res.status(404).json({ mensagem: "Projeto não encontrado." });
  } catch (err) {
    res.status(500).json({ mensagem: "Erro ao atualizar projeto." });
  }
};

// Deleta um projeto
exports.deletar = async (req, res) => {
  try {
    const { id } = req.params;
    const deletadas = await Projeto.deletar(id);
    if (deletadas) return res.json({ mensagem: "Projeto deletado com sucesso." });
    res.status(404).json({ mensagem: "Projeto não encontrado." });
  } catch (err) {
    res.status(500).json({ mensagem: "Erro ao deletar projeto." });
  }
};