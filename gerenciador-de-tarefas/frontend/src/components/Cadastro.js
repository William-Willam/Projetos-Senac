import React, { useState } from "react";
import api from "../services/api";

function Cadastro({ onCadastro }) {
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [erro, setErro] = useState("");
  const [sucesso, setSucesso] = useState("");
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErro(""); setSucesso(""); setLoading(true);
    try {
      await api.post("/usuarios/registrar", { nome, email, senha });
      setSucesso("Cadastro realizado com sucesso! Faça login.");
      setNome(""); setEmail(""); setSenha("");
      if (onCadastro) onCadastro();
    } catch {
      setErro("Erro ao cadastrar. E-mail já cadastrado?");
    }
    setLoading(false);
  };

  return (
    <div className="container mt-5" style={{ maxWidth: 400 }}>
      <form className="card p-4 shadow" onSubmit={handleSubmit} autoComplete="off">
        <h2 className="mb-4 text-center text-primary">Cadastro</h2>
        {erro && <div className="alert alert-danger">{erro}</div>}
        {sucesso && <div className="alert alert-success">{sucesso}</div>}
        <div className="mb-3">
          <label className="form-label">Nome</label>
          <input
            className="form-control"
            value={nome}
            onChange={e => setNome(e.target.value)}
            placeholder="Digite seu nome"
            required
          />
        </div>
        <div className="mb-3">
          <label className="form-label">E-mail</label>
          <input
            type="email"
            className="form-control"
            value={email}
            onChange={e => setEmail(e.target.value)}
            placeholder="Digite seu e-mail"
            required
          />
        </div>
        <div className="mb-4">
          <label className="form-label">Senha</label>
          <input
            type="password"
            className="form-control"
            value={senha}
            onChange={e => setSenha(e.target.value)}
            placeholder="Crie uma senha"
            required
            minLength={6}
          />
        </div>
        <button className="btn btn-primary w-100" type="submit" disabled={loading}>
          {loading ? "Cadastrando..." : "Cadastrar"}
        </button>
      </form>
    </div>
  );
}

export default Cadastro;