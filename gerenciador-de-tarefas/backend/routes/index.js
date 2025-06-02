const express = require("express");
const router = express.Router();

// Importa os controllers
const projetoController = require("../controllers/projetoController");
const tarefaController = require("../controllers/tarefasController");
const usuarioController = require("../controllers/usuarioController");

// Importa os middlewares
const auth = require("../middleware/auth"); // Middleware de autenticação JWT
const validarProjeto = require("../middleware/validarProjeto"); // Middleware de validação de projeto

// Rotas de usuário (registro e login não precisam de autenticação)
router.post("/usuarios/registrar", usuarioController.registrar);
router.post("/usuarios/login", usuarioController.login);

// Rotas de projetos (protegidas por autenticação)
router.post("/projetos", auth, validarProjeto, projetoController.criar);
router.get("/projetos/:usuario_id", auth, projetoController.listarPorUsuario);
router.put("/projetos/:id", auth, validarProjeto, projetoController.atualizar);
router.delete("/projetos/:id", auth, projetoController.deletar);

// Rotas de tarefas (protegidas por autenticação)
router.post("/tarefas", auth, tarefaController.criar);
router.get("/tarefas/:projeto_id", auth, tarefaController.listarPorProjeto);
router.put("/tarefas/:id", auth, tarefaController.atualizar);
router.delete("/tarefas/:id", auth, tarefaController.deletar);

module.exports = router;