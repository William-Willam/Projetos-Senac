import React, { useState } from "react";
import api from "../services/api";

function Login({ onLogin }) {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [erro, setErro] = useState("");
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErro("");
    setLoading(true);
    try {
      const res = await api.post("/usuarios/login", { email, senha });
      // Salva o token e o id do usuário no localStorage
      localStorage.setItem("token", res.data.token);
      localStorage.setItem("usuarioId", res.data.usuario.id);
      if (onLogin) onLogin(res.data.usuario);
    } catch {
      setErro("E-mail ou senha inválidos");
    }
    setLoading(false);
  };

  return (
    <div className="container mt-5" style={{ maxWidth: 400 }}>
      <form className="card p-4 shadow" onSubmit={handleSubmit} autoComplete="off">
        <h2 className="mb-4 text-center text-primary">Login</h2>
        {erro && <div className="alert alert-danger">{erro}</div>}
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
            placeholder="Digite sua senha"
            required
          />
        </div>
        <button className="btn btn-primary w-100" type="submit" disabled={loading}>
          {loading ? "Entrando..." : "Entrar"}
        </button>
      </form>
    </div>
  );
}

export default Login;