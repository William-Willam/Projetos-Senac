import { buscarDadosUsuario, atualizarDadosUsuario } from '../models/healthModel.js';

export const getDados = async (req, res) => {
  const userId = req.params.id;
  const dados = await buscarDadosUsuario(userId);
  res.json(dados || {});
};

export const putDados = async (req, res) => {
  const userId = req.params.id;
  const { peso, altura, imc, exercicio } = req.body;
  await atualizarDadosUsuario(userId, peso, altura, imc, exercicio);
  res.json({ msg: 'Dados atualizados' });
};
