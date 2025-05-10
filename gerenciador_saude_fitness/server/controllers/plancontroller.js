import { atribuirPlano } from '../models/planModel.js';

export const escolherPlano = async (req, res) => {
  const { userId, planoId } = req.body;
  try {
    await atribuirPlano(userId, planoId);
    res.status(200).json({ msg: 'Plano atribuído com sucesso' });
  } catch (err) {
    res.status(500).json({ msg: 'Erro ao atribuir plano' });
  }
};
