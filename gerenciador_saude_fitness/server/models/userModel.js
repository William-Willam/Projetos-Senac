import db from './db.js';

export const criarUsuario = async (nome, email, senhaHash) => {
  const [res] = await db.query(
    'INSERT INTO users (nome, email, senha_hash) VALUES (?, ?, ?)',
    [nome, email, senhaHash]
  );
  return res.insertId;
};

export const buscarPorEmail = async (email) => {
  const [res] = await db.query('SELECT * FROM users WHERE email = ?', [email]);
  return res[0];
};
