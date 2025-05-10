import axios from 'axios';
import "../styles/Planos.css";


function Planos() {
  const usuario = JSON.parse(localStorage.getItem('usuario'));

  const escolherPlano = async (planoId) => {
    try {
      await axios.post('http://localhost:5000/api/planos/escolher', {
        userId: usuario.id,
        planoId: planoId,
      });
      alert('Plano escolhido com sucesso!');
    } catch (err) {
      alert('Erro ao escolher plano.');
    }
  };

  return (
    <div className="planos-container">
      <h2>Escolha seu plano</h2>
      <div className="planos-grid">
        <div className="plano-card basico" onClick={() => escolherPlano(1)}>
          <h3>Básico</h3>
          <p>Recursos essenciais de saúde</p>
          <span>R$ 0 / mês</span>
        </div>
        <div className="plano-card ouro" onClick={() => escolherPlano(2)}>
          <h3>Ouro</h3>
          <p>Acompanhamento mais completo</p>
          <span>R$ 49,90 / mês</span>
        </div>
        <div className="plano-card platina" onClick={() => escolherPlano(3)}>
          <h3>Platina</h3>
          <p>Experiência premium total</p>
          <span>R$ 89,90 / mês</span>
        </div>
      </div>
    </div>
  );
}

export default Planos;