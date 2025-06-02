// Middleware global para tratamento de erros no Express
module.exports = (err, req, res, next) => {
  // Exibe o erro no console para debug
  console.error("Erro capturado pelo middleware:", err);

  // Retorna uma resposta padrão de erro para o cliente
  res.status(err.status || 500).json({
    mensagem: err.message || "Erro interno do servidor.",
    // Em produção, evite expor detalhes do erro:
    // detalhes: process.env.NODE_ENV === "development" ? err : undefined
  });
};