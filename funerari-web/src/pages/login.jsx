import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { cadastrarUsuario, loginUsuario } from "../firebase/auth";
import { adicionarUsuario } from "../firebase/banco-usuario";
import "../styles/Login.css";

export default function Login() {
  const [modoCadastro, setModoCadastro] = useState(false);
  const [formData, setFormData] = useState({ nome: "", email: "", senha: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      if (modoCadastro) {
        const user = await cadastrarUsuario(formData.nome, formData.email, formData.senha);
        await adicionarUsuario({ uid: user.uid, nome: formData.nome, email: formData.email });
      } else {
        await loginUsuario(formData.email, formData.senha);
      }
      navigate("/catalogo");
    } catch (error) {
      console.error("Erro na autenticação:", error);
    }
  };

  return (
    <main className="login-container">
      <section className="login-card">
        <h1>
          {modoCadastro ? "Criar Conta" : "Entrar"}
        </h1>

        <form onSubmit={handleSubmit} className="space-y-4" aria-label={modoCadastro ? "Formulário de Cadastro" : "Formulário de Login"}>
          {modoCadastro && (
            <input
              type="text"
              name="nome"
              placeholder="Nome completo"
              className="input-field"
              value={formData.nome}
              onChange={handleChange}
              required
            />
          )}

          <input
            type="email"
            name="email"
            placeholder="E-mail"
            className="input-field"
            value={formData.email}
            onChange={handleChange}
            required
          />

          <input
            type="password"
            name="senha"
            placeholder="Senha"
            className="input-field"
            value={formData.senha}
            onChange={handleChange}
            required
          />

          <button
            type="submit"
            className="submit-button"
          >
            {modoCadastro ? "Cadastrar" : "Entrar"}
          </button>
        </form>

        <p className="mt-4 text-center text-sm text-gray-600">
          {modoCadastro ? "Já tem uma conta?" : "Ainda não tem uma conta?"}{" "}
          <button
            onClick={() => setModoCadastro(!modoCadastro)}
            className="toggle-button"
          >
            {modoCadastro ? "Entrar" : "Cadastrar-se"}
          </button>
        </p>
      </section>
    </main>
  );
}
