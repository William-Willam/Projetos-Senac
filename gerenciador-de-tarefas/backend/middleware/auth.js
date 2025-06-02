const jwt = require("jsonwebtoken");

// Middleware para proteger rotas que exigem autenticação
module.exports = (req, res, next) => {
  const authHeader = req.headers.authorization;
  // Verifica se o header Authorization está presente
  if (!authHeader) {
    return res.status(401).json({ mensagem: "Token não fornecido." });
  }

  // Espera o formato "Bearer token"
  const token = authHeader.split(" ")[1];
  try {
    // Verifica e decodifica o token
    const decoded = jwt.verify(token, process.env.JWT_SECRET);
    req.usuario = decoded; // Adiciona os dados do usuário à requisição
    next(); // Continua para o próximo middleware ou controller
  } catch (err) {
    return res.status(401).json({ mensagem: "Token inválido ou expirado." });
  }
};