const express = require("express");
const router = express.Router();

const tarefaController = require("../controllers/tarefaController");
const projetoController = require("../controllers/projetoController");

// Rotas para tarefas
router.get("/tarefas", tarefaController.getTarefas);
router.post("/tarefas", tarefaController.createTarefa);
router.put("/tarefas/:id", tarefaController.updateTarefa); 
router.delete("/tarefas/:id", tarefaController.deleteTarefa);

// Rotas para projetos
router.get("/projetos", projetoController.getProjetos);
router.post("/projetos", projetoController.createProjeto);
router.put("/projetos/:id", projetoController.updateProjeto);
router.delete("/projetos/:id", projetoController.deleteProjeto);


// Exporta o roteador para ser usado no servidor principal
module.exports = router;