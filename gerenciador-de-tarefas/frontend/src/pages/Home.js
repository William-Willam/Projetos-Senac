import React from "react";

function Home() {
  return (
    <div className="container py-5">
      <div className="row align-items-center">
        <div className="col-md-6 mb-4 mb-md-0">
          <h1 className="display-4 fw-bold text-primary">
            Bem-vindo ao Gerenciador de Projetos
          </h1>
          <p className="lead text-secondary mt-4">
            Organize seus projetos e tarefas de forma simples, rápida e
            eficiente.
            <br />
            Cadastre projetos, adicione tarefas, acompanhe prazos e status, tudo
            em um só lugar.
          </p>
          <div className="mt-4">
            <a href="/login" className="btn btn-primary btn-lg me-2">
              Entrar
            </a>
            <a href="/cadastro" className="btn btn-success btn-lg">
              Cadastrar-se
            </a>
          </div>
        </div>
        <div className="col-md-6 text-center">
          <img
            src="https://images.unsplash.com/photo-1519389950473-47ba0277781c?auto=format&fit=crop&w=600&q=80"
            alt="Gerenciamento de Projetos"
            className="img-fluid rounded shadow"
            style={{ maxHeight: 350 }}
          />
        </div>
      </div>
      <footer className="bg-light py-4 mt-5 border-top shadow-sm">
        <div className="container text-center">
          <div className="mb-2">
            <span className="fw-bold text-primary">
              Gerenciador de Projetos
            </span>
          </div>
          <div className="mb-2 text-muted small">
            &copy; {new Date().getFullYear()} Desenvolvido por William
          </div>
          <div>
            <a
              href="mailto:seuemail@exemplo.com"
              className="text-decoration-none text-secondary me-3"
              title="Contato por e-mail"
            >
              <i className="bi bi-envelope-fill"></i> E-mail
            </a>
            <a
              href="https://github.com/seuusuario"
              className="text-decoration-none text-secondary"
              target="_blank"
              rel="noopener noreferrer"
              title="GitHub"
            >
              <i className="bi bi-github"></i> GitHub
            </a>
          </div>
        </div>
      </footer>
    </div>
  );
}

export default Home;
