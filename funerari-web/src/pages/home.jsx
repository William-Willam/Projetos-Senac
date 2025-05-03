import "../styles/Home.css";

export default function Home() {
  return (
    <main className="home-container">
      <header className="hero">
        <div className="hero-content">
          <h1>Bem-vindo à Funerária Esperença</h1>
          <p>Aqui nós auxiliamos no momento mais difícil</p>
          <a href="/login" className="btn btn-primary">
            Comece Agora
          </a>
        </div>
      </header>

      <section className="features">
        <h2>Nossos Serviços</h2>
        <ul className="feature-list">
          <li className="feature-item">
            <h3>⚰️ Organização de Velórios</h3>
            <p>
              Cuidamos de todos os detalhes do velório com respeito, conforto e
              dignidade para a família.
            </p>
          </li>
          <li className="feature-item">
            <h3>🛻 Traslado Funerário</h3>
            <p>
              Realizamos o transporte nacional e internacional do corpo com
              total segurança e legalidade.
            </p>
          </li>
          <li className="feature-item">
            <h3>📑 Documentação e Apoio Legal</h3>
            <p>
              Auxiliamos na emissão de certidões, autorizações e todos os
              trâmites legais necessários.
            </p>
          </li>
        </ul>
      </section>

      <section className="cta">
        <h2>Estamos aqui para ajudar</h2>
        <p>
          Conte com nosso apoio em um momento delicado. Estamos prontos para
          oferecer o cuidado que sua família merece.
        </p>
        <a href="/contato" className="btn btn-secondary">
          Fale Conosco
        </a>
      </section>

      <footer className="footer">
        <p>
          &copy; {new Date().getFullYear()} William dos Santos Rodrigues. Todos os direitos
          reservados.
        </p>
      </footer>
    </main>
  );
}
