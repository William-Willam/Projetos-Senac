import bcrypt from 'bcrypt';
import jwt from 'jsonwebtoken';
import { criarUsuario, buscarPorEmail } from '../models/userModel.js';

export const cadastrar = async (req, res) => {
  const { nome, email, senha } = req.body;
  const usuarioExistente = await buscarPorEmail(email);
  if (usuarioExistente) return res.status(400).json({ msg: 'Usuário já existe' });

  const senhaHash = await bcrypt.hash(senha, 10);
  const id = await criarUsuario(nome, email, senhaHash);
  res.status(201).json({ id, nome, email });
};

export const login = async (req, res) => {
  const { email, senha } = req.body;
  const usuario = await buscarPorEmail(email);
  if (!usuario) return res.status(400).json({ msg: 'Credenciais inválidas' });

  const valido = await bcrypt.compare(senha, usuario.senha_hash);
  if (!valido) return res.status(400).json({ msg: 'Senha incorreta' });

  const token = jwt.sign({ id: usuario.id }, process.env.JWT_SECRET, { expiresIn: '1d' });
  res.json({ token, usuario: { id: usuario.id, nome: usuario.nome } });
};

export const verificarToken = (req, res, next) => {
  const token = req.headers['authorization'];
  if (!token) return res.status(401).json({ msg: 'Token não fornecido' });

  jwt.verify(token, process.env.JWT_SECRET, (err, decoded) => {
    if (err) return res.status(403).json({ msg: 'Token inválido' });
    req.usuarioId = decoded.id;
    next();
  });
};

