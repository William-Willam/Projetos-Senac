import React, { useState } from "react";
import api from "../services/api";

function ProjetoForm({ usuarioId, onProjetoCriado }) {
  const [titulo, setTitulo] = useState("");
  const [descricao, setDescricao] = useState("");
  const [prazo, setPrazo] = useState("");
  const [status, setStatus] = useState("");
  const [erro, setErro] = useState("");
  const [sucesso, setSucesso] = useState("");
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErro(""); setSucesso(""); setLoading(true);
    try {
      await api.post("/projetos", { titulo, descricao, prazo, status, usuario_id: usuarioId });
      setTitulo(""); setDescricao(""); setPrazo(""); setStatus("");
      setSucesso("Projeto criado com sucesso!");
      if (onProjetoCriado) onProjetoCriado();
    } catch {
      setErro("Erro ao criar projeto. Verifique os dados e tente novamente.");
    }
    setLoading(false);
  };

  return (
    <div className="container mb-4" style={{ maxWidth: 500 }}>
      <form className="card p-4 shadow" onSubmit={handleSubmit} autoComplete="off">
        <h3 className="mb-4 text-primary text-center">Novo Projeto</h3>
        {erro && <div className="alert alert-danger">{erro}</div>}
        {sucesso && <div className="alert alert-success">{sucesso}</div>}
        <div className="mb-3">
          <label className="form-label">Título</label>
          <input
            className="form-control"
            value={titulo}
            onChange={e => setTitulo(e.target.value)}
            placeholder="Título do projeto"
            required
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Descrição</label>
          <input
            className="form-control"
            value={descricao}
            onChange={e => setDescricao(e.target.value)}
            placeholder="Descrição do projeto"
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
        <div className="mb-4">
          <label className="form-label">Status</label>
          <input
            className="form-control"
            value={status}
            onChange={e => setStatus(e.target.value)}
            placeholder="Status (ex: Em andamento, Concluído)"
          />
        </div>
        <button className="btn btn-primary w-100" type="submit" disabled={loading}>
          {loading ? "Criando..." : "Criar Projeto"}
        </button>
      </form>
    </div>
  );
}

export default ProjetoForm;