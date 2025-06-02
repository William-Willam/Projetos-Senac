import React, { useState, useEffect } from "react";
import api from "../services/api";
import TarefaList from "./TarefaList";

function TarefaForm({ usuarioId, projetoId }) {
  const [nome, setNome] = useState("");
  const [descricao, setDescricao] = useState("");
  const [prazo, setPrazo] = useState("");
  const [status, setStatus] = useState("");
  const [prioridade, setPrioridade] = useState("");
  const [projetos, setProjetos] = useState([]);
  const [projetoSelecionado, setProjetoSelecionado] = useState(projetoId || "");
  const [mensagem, setMensagem] = useState("");
  const [erro, setErro] = useState("");
  const [carregando, setCarregando] = useState(false);
  const [atualizar, setAtualizar] = useState(false);

  useEffect(() => {
    if (!projetoId && usuarioId) {
      api.get(`/projetos/${usuarioId}`)
        .then(res => setProjetos(res.data))
        .catch(() => setProjetos([]));
    }
  }, [usuarioId, projetoId]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErro("");
    setMensagem("");
    setCarregando(true);

    const idProjeto = projetoId || projetoSelecionado;

    if (!idProjeto) {
      setErro("Selecione um projeto.");
      setCarregando(false);
      return;
    }

    try {
      await api.post("/tarefas", {
        nome,
        descricao,
        prazo,
        status,
        prioridade,
        projeto_id: idProjeto,
      });
      setNome(""); setDescricao(""); setPrazo(""); setStatus(""); setPrioridade("");
      setMensagem("Tarefa criada com sucesso!");
      setAtualizar(!atualizar); // força atualização da lista
    } catch {
      setErro("Erro ao criar tarefa.");
    }

    setCarregando(false);
  };

  return (
    <div className="container my-4" style={{ maxWidth: 700 }}>
      <form onSubmit={handleSubmit} className="card p-4 shadow">
        <h3 className="mb-4 text-primary">Criar Nova Tarefa</h3>

        {erro && <div className="alert alert-danger">{erro}</div>}
        {mensagem && <div className="alert alert-success">{mensagem}</div>}

        {!projetoId && (
          <div className="mb-3">
            <label className="form-label">Projeto</label>
            <select
              className="form-select"
              value={projetoSelecionado}
              onChange={e => setProjetoSelecionado(e.target.value)}
              required
            >
              <option value="">Selecione</option>
              {projetos.map(p => (
                <option key={p.id} value={p.id}>{p.titulo}</option>
              ))}
            </select>
          </div>
        )}

        <div className="mb-3">
          <label className="form-label">Nome</label>
          <input
            className="form-control"
            value={nome}
            onChange={e => setNome(e.target.value)}
            required
            placeholder="Nome da tarefa"
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Descrição</label>
          <input
            className="form-control"
            value={descricao}
            onChange={e => setDescricao(e.target.value)}
            placeholder="Descrição (opcional)"
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Prazo</label>
          <input
            type="date"
            className="form-control"
            value={prazo}
            onChange={e => setPrazo(e.target.value)}
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Status</label>
          <input
            className="form-control"
            value={status}
            onChange={e => setStatus(e.target.value)}
            placeholder="Ex: Pendente, Em andamento, Concluída"
          />
        </div>

        <div className="mb-4">
          <label className="form-label">Prioridade</label>
          <input
            className="form-control"
            value={prioridade}
            onChange={e => setPrioridade(e.target.value)}
            placeholder="Ex: Alta, Média, Baixa"
          />
        </div>

        <button type="submit" className="btn btn-primary" disabled={carregando}>
          {carregando ? "Criando..." : "Criar Tarefa"}
        </button>
      </form>

      {/* Lista logo abaixo do formulário */}
      {(projetoId || projetoSelecionado) && (
        <TarefaList projetoId={projetoId || projetoSelecionado} atualizar={atualizar} />
      )}
    </div>
  );
}

export default TarefaForm;
