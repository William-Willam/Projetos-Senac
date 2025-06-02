import React, { useEffect, useState } from "react";
import api from "../services/api";

function TarefaList({ projetoId, atualizar }) {
  const [tarefas, setTarefas] = useState([]);
  const [erro, setErro] = useState("");
  const [carregando, setCarregando] = useState(true);

  useEffect(() => {
    if (projetoId) {
      setCarregando(true);
      api.get(`/tarefas/${projetoId}`)
        .then(res => {
          setTarefas(res.data);
          setErro("");
        })
        .catch(() => setErro("Erro ao carregar tarefas."))
        .finally(() => setCarregando(false));
    }
  }, [projetoId, atualizar]);

  const formatarData = (data) => {
    return data ? new Date(data).toLocaleDateString("pt-BR") : "-";
  };

  const capitalizar = (texto) => {
    return texto ? texto[0].toUpperCase() + texto.slice(1).toLowerCase() : "-";
  };

  return (
    <div className="mt-5">
      <h4 className="mb-3 text-secondary">Tarefas</h4>

      {erro && <div className="alert alert-danger">{erro}</div>}

      {carregando ? (
        <p>Carregando tarefas...</p>
      ) : tarefas.length === 0 ? (
        <div className="alert alert-warning">Nenhuma tarefa encontrada.</div>
      ) : (
        <div className="table-responsive">
          <table className="table table-bordered table-hover align-middle">
            <thead className="table-light">
              <tr>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Prazo</th>
                <th>Status</th>
                <th>Prioridade</th>
              </tr>
            </thead>
            <tbody>
              {tarefas.map(tarefa => (
                <tr key={tarefa.id}>
                  <td>{tarefa.nome}</td>
                  <td>{tarefa.descricao || "-"}</td>
                  <td>{formatarData(tarefa.prazo)}</td>
                  <td>{capitalizar(tarefa.status)}</td>
                  <td>{capitalizar(tarefa.prioridade)}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default TarefaList;
