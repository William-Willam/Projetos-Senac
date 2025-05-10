import { useState, useEffect } from "react";
import axios from "axios";
import "../styles/Dashboard.css";

function Dashboard() {
  const usuario = JSON.parse(localStorage.getItem("usuario"));
  const [dados, setDados] = useState({
    peso: "",
    altura: "",
    imc: "",
    exercicio: "",
  });

  const buscarDados = async () => {
    try {
      const res = await axios.get(
        `http://localhost:5000/api/usuarios/${usuario.id}/dados`
      );
      if (res.data) setDados(res.data);
    } catch (err) {
      console.error("Erro ao buscar dados");
    }
  };

  const atualizarDados = async () => {
    const alturaNum = parseFloat(dados.altura.replace(",", "."));
    const pesoNum = parseFloat(dados.peso.replace(",", "."));
    const imc =
      alturaNum > 0 ? (pesoNum / (alturaNum * alturaNum)).toFixed(2) : 0;

    try {
      await axios.put(
        `http://localhost:5000/api/usuarios/${usuario.id}/dados`,
        {
          ...dados,
          imc,
        }
      );
      alert("Dados atualizados com sucesso!");
      buscarDados();
    } catch (err) {
      alert("Erro ao atualizar dados");
    }
  };

  const getClassificacaoIMC = (imc) => {
    const valor = parseFloat(imc);
    if (isNaN(valor)) return { texto: "---", cor: "#000" };
    if (valor < 18.5) return { texto: "Abaixo do peso", cor: "#f39c12" };
    if (valor < 24.9) return { texto: "Peso ideal", cor: "#27ae60" };
    if (valor < 29.9) return { texto: "Sobrepeso", cor: "#f1c40f" };
    if (valor < 34.9) return { texto: "Obesidade grau 1", cor: "#e67e22" };
    if (valor < 39.9) return { texto: "Obesidade grau 2", cor: "#e74c3c" };
    return { texto: "Obesidade grau 3", cor: "#c0392b" };
  };

  useEffect(() => {
    buscarDados();
  }, []);

  return (
    <div className="dashboard-container">
      <div className="dashboard-header">
        <h2>Bem-vindo, {usuario.nome}</h2>
        <button
          className="logout-btn"
          onClick={() => {
            localStorage.removeItem("token");
            localStorage.removeItem("usuario");
            window.location.href = "/login";
          }}
        >
          Sair
        </button>
      </div>

      <div className="dados-grid">
        <div className="input-card">
          <label>Peso (kg)</label>
          <input
            type="number"
            placeholder="Ex: 70"
            value={dados.peso}
            onChange={(e) => setDados({ ...dados, peso: e.target.value })}
          />
        </div>
        <div className="input-card">
          <label>Altura (m)</label>
          <input
            type="number"
            placeholder="Ex: 1.75"
            value={dados.altura}
            onChange={(e) => setDados({ ...dados, altura: e.target.value })}
          />
        </div>
        <div className="input-card">
          <label>Exercício diário</label>
          <textarea
            placeholder="Descreva seu treino ou atividade"
            value={dados.exercicio}
            onChange={(e) =>
              setDados({ ...dados, exercicio: e.target.value })
            }
          />
        </div>
        <div className="input-card imc-card">
          <label>IMC calculado</label>
          {dados.imc ? (
            <div>
              <div
                className="imc-valor"
                style={{ color: getClassificacaoIMC(dados.imc).cor }}
              >
                {dados.imc}
              </div>
              <div className="imc-texto">{getClassificacaoIMC(dados.imc).texto}</div>
            </div>
          ) : (
            <div className="imc-valor">---</div>
          )}
        </div>
      </div>
      <button className="atualizar-btn" onClick={atualizarDados}>
        Atualizar Dados
      </button>
    </div>
  );
}

export default Dashboard;
