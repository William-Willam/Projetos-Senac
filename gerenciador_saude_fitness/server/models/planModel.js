import db from './db.js';

export const atribuirPlano = async (userId, planoId) => {
  const [res] = await db.query('UPDATE users SET plano_id = ? WHERE id = ?', [planoId, userId]);
  return res;
};
