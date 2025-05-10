import db from './db.js';

export const buscarDadosUsuario = async (userId) => {
  const [res] = await db.query('SELECT peso, altura, imc, exercicio FROM dados_usuarios WHERE user_id = ?', [userId]);
  return res[0];
};

export const atualizarDadosUsuario = async (userId, peso, altura, imc, exercicio) => {
  const [res] = await db.query(
    `INSERT INTO dados_usuarios (user_id, peso, altura, imc, exercicio)
     VALUES (?, ?, ?, ?, ?)
     ON DUPLICATE KEY UPDATE peso = ?, altura = ?, imc = ?, exercicio = ?, atualizado_em = NOW()`,
    [userId, peso, altura, imc, exercicio, peso, altura, imc, exercicio]
  );
  return res;
};
