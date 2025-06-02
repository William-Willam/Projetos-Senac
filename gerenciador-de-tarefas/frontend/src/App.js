import React, { useState } from "react";
import { BrowserRouter, Routes, Route, Link, NavLink, Navigate } from "react-router-dom";
import Login from "./components/Login";
import Cadastro from "./components/Cadastro";
import ProjetoList from "./components/ProjetoList";
import ProjetoForm from "./components/ProjetoForm";
import TarefaList from "./components/TarefaList";
import TarefaForm from "./components/TarefaForm";
import Home from "./pages/Home";

function App() {
  const [usuario, setUsuario] = useState(null);
  const isAutenticado = usuario || localStorage.getItem("token");
  const usuarioId = usuario?.id || localStorage.getItem("usuarioId");

  const handleLogout = () => {
    localStorage.clear();
    setUsuario(null);
    window.location.href = "/";
  };

  return (
    <BrowserRouter>
      {/* Navbar Bootstrap aprimorada */}
      <nav className="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
        <div className="container">
          <Link className="navbar-brand fw-bold" to="/">
            <i className="bi bi-kanban-fill me-2"></i>
            Gerenciador de Projetos
          </Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainNavbar" aria-controls="mainNavbar" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="mainNavbar">
            <ul className="navbar-nav ms-auto align-items-center">
              {!isAutenticado ? (
                <>
                  <li className="nav-item">
                    <NavLink className="btn btn-outline-primary me-2" to="/login">
                      <i className="bi bi-box-arrow-in-right me-1"></i> Login
                    </NavLink>
                  </li>
                  <li className="nav-item">
                    <NavLink className="btn btn-success" to="/cadastro">
                      <i className="bi bi-person-plus-fill me-1"></i> Cadastro
                    </NavLink>
                  </li>
                </>
              ) : (
                <>
                  <li className="nav-item">
                    <NavLink className="nav-link" to="/projetos">
                      <i className="bi bi-folder2-open me-1"></i> Projetos
                    </NavLink>
                  </li>
                  <li className="nav-item">
                    <NavLink className="nav-link" to="/tarefas">
                      <i className="bi bi-list-task me-1"></i> Tarefas
                    </NavLink>
                  </li>
                  <li className="nav-item ms-2">
                    <button className="btn btn-danger" onClick={handleLogout}>
                      <i className="bi bi-box-arrow-right me-1"></i> Sair
                    </button>
                  </li>
                </>
              )}
            </ul>
          </div>
        </div>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={
          isAutenticado ? <Navigate to="/projetos" /> : <Login onLogin={setUsuario} />
        } />
        <Route path="/cadastro" element={
          isAutenticado ? <Navigate to="/projetos" /> : <Cadastro />
        } />
        <Route path="/projetos" element={
          isAutenticado ? (
            <>
              <ProjetoForm usuarioId={usuarioId} onProjetoCriado={() => window.location.reload()} />
              <ProjetoList usuarioId={usuarioId} />
            </>
          ) : <Navigate to="/login" />
        } />
        <Route path="/tarefas" element={
          isAutenticado ? (
            <>
              <TarefaForm usuarioId={usuarioId} />
              <TarefaList usuarioId={usuarioId} />
            </>
          ) : <Navigate to="/login" />
        } />
        <Route path="*" element={<Navigate to="/" />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;