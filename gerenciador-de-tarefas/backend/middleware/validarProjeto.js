// Middleware para validar os dados de um projeto antes de criar ou atualizar
module.exports = (req, res, next) => {
  const { titulo } = req.body;
  // Verifica se o título está presente e não é vazio
  if (!titulo || typeof titulo !== "string" || titulo.trim() === "") {
    return res.status(400).json({ mensagem: "Título do projeto é obrigatório." });
  }
  // Se estiver tudo certo, segue para o próximo middleware/controller
  next();
};