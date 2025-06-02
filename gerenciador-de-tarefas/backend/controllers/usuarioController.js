
const Usuario = require("../models/usuarioModel");
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");

// Cadastro de usuário
exports.registrar = async (req, res) => {
  const { nome, email, senha } = req.body;
  if (!nome || !email || !senha) return res.status(400).json({ mensagem: "Preencha todos os campos." });

  const usuarioExistente = await Usuario.buscarPorEmail(email);
  if (usuarioExistente) return res.status(400).json({ mensagem: "E-mail já cadastrado." });

  const senhaHash = await bcrypt.hash(senha, 10);
  const id = await Usuario.criarUsuario(nome, email, senhaHash);
  res.status(201).json({ id, nome, email });
};

// Login de usuário
exports.login = async (req, res) => {
  const { email, senha } = req.body;
  const usuario = await Usuario.buscarPorEmail(email);
  if (!usuario) return res.status(401).json({ mensagem: "Usuário não encontrado." });

  const senhaValida = await bcrypt.compare(senha, usuario.senha);
  if (!senhaValida) return res.status(401).json({ mensagem: "Senha incorreta." });

  const token = jwt.sign({ id: usuario.id, nome: usuario.nome }, process.env.JWT_SECRET, { expiresIn: "1h" });
  res.json({ token, usuario: { id: usuario.id, nome: usuario.nome, email: usuario.email } });
};