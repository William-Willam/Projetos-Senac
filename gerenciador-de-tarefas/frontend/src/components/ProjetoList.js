import React, { useEffect, useState } from "react";
import api from "../services/api";

function ProjetoList({ usuarioId }) {
  const [projetos, setProjetos] = useState([]);
  const [erro, setErro] = useState("");
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    setLoading(true);
    api.get(`/projetos/${usuarioId}`)
      .then(res => {
        setProjetos(res.data);
        setErro("");
      })
      .catch(() => setErro("Erro ao carregar projetos"))
      .finally(() => setLoading(false));
  }, [usuarioId]);

  return (
    <div className="container mb-4" style={{ maxWidth: 800 }}>
      <h2 className="mb-3 text-primary">Projetos</h2>
      {erro && <div className="alert alert-danger">{erro}</div>}
      {loading ? (
        <div>Carregando...</div>
      ) : projetos.length === 0 ? (
        <div className="alert alert-info">Nenhum projeto cadastrado.</div>
      ) : (
        <div className="table-responsive">
          <table className="table table-bordered table-hover align-middle">
            <thead className="table-light">
              <tr>
                <th>Título</th>
                <th>Descrição</th>
                <th>Prazo</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
              {projetos.map(proj => (
                <tr key={proj.id}>
                  <td>{proj.titulo}</td>
                  <td>{proj.descricao}</td>
                  <td>{proj.prazo ? new Date(proj.prazo).toLocaleDateString() : "-"}</td>
                  <td>{proj.status}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default ProjetoList;