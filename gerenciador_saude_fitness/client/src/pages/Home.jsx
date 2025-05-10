import Header from "../components/Header";
import Footer from "../components/Footer";

import '../styles/Home.css';

function Home() {
  return (
    <>
      <Header />  

      <section className="hero">
        <div className="hero-content">
          <h1>Transforme sua saúde com o <span>HealthFit</span></h1>
          <p>Acompanhe seu peso, IMC, exercícios e mais. Tudo em um só lugar.</p>
          <a href="/register" className="cta-button">Comece agora</a>
        </div>
      </section>

      <section className="planos-home">
        <h2>Escolha o plano ideal para você</h2>
        <div className="cards">
          <div className="card basico">
            <h3>Plano Básico</h3>
            <p>Controle de peso, altura e cálculo automático de IMC.</p>
            <span>R$ 0 / mês</span>
          </div>
          <div className="card ouro">
            <h3>Plano Ouro</h3>
            <p>Todos os recursos do Básico + histórico de dados e lembretes de saúde.</p>
            <span>R$ 49,90 / mês</span>
          </div>
          <div className="card platina">
            <h3>Plano Platina</h3>
            <p>Inclui relatórios completos, suporte premium e integração com smartwatch.</p>
            <span>R$ 89,90 / mês</span>
          </div>
        </div>
      </section>

      <Footer />
    </>
  );
}

export default Home;
