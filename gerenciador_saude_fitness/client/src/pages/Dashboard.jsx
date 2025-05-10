import { useState, useEffect } from 'react';
import axios from 'axios';
import "../styles/Dashboard.css";

function Dashboard() {
  const usuario = JSON.parse(localStorage.getItem('usuario'));
  const [dados, setDados] = useState({ peso: '', altura: '', imc: '', exercicio: '' });

  const buscarDados = async () => {
    try {
      const res = await axios.get(`http://localhost:5000/api/usuarios/${usuario.id}/dados`);
      if (res.data) setDados(res.data);
    } catch (err) {
      console.error('Erro ao buscar dados');
    }
  };

  const atualizarDados = async () => {
    const alturaNum = parseFloat(dados.altura);
    const pesoNum = parseFloat(dados.peso);
    const imc = alturaNum > 0 ? (pesoNum / (alturaNum * alturaNum)).toFixed(2) : 0;

    try {
      await axios.put(`http://localhost:5000/api/usuarios/${usuario.id}/dados`, {
        ...dados,
        imc,
      });
      alert('Dados atualizados com sucesso!');
      buscarDados();
    } catch (err) {
      alert('Erro ao atualizar dados');
    }
  };

  useEffect(() => {
    buscarDados();
  }, []);

  return (
    <div className="dashboard-container">
      <h2>Bem-vindo, {usuario.nome}</h2>
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
            onChange={(e) => setDados({ ...dados, exercicio: e.target.value })}
          />
        </div>
        <div className="input-card imc-card">
          <label>IMC calculado</label>
          <div className="imc-valor">{dados.imc || '---'}</div>
        </div>
      </div>
      <button className="atualizar-btn" onClick={atualizarDados}>Atualizar Dados</button>
    </div>
  );
}

export default Dashboard;
