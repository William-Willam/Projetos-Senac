import { useState } from "react";
import "../styles/Contato.css";

const Contato = () => {
  const [formData, setFormData] = useState({
    tipo: "",
    nome: "",
    email: "",
    mensagem: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("https://formspree.io/f/mblravbe", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        alert("Mensagem enviada com sucesso.");
        setFormData({
          tipo: "",
          nome: "",
          email: "",
          mensagem: "",
        });
      } else {
        const errorText = await response.text();
        alert(`Erro ao enviar: ${errorText}`);
      }
    } catch (error) {
      alert(`Erro ao enviar mensagem: ${error.message}`);
    }
  };

  return (
    <div className="contato-container">
      <h1 className="titulo">Entre em Contato</h1>
      <p className="subtitulo">
        Estamos disponíveis para acolher você e sua família. Envie uma mensagem ou fale conosco pelo WhatsApp.
      </p>
      <form onSubmit={handleSubmit} className="contato-form">
        <div className="form-radio">
          <label className="label-titulo">Motivo do Contato:</label>
          <div className="radio-grupo">
            {["Atendimento", "Plano Funerário", "Serviço Imediato", "Outros"].map((opcao) => (
              <label className="radio-label" key={opcao}>
                <input
                  type="radio"
                  name="tipo"
                  value={opcao}
                  checked={formData.tipo === opcao}
                  onChange={handleChange}
                  required
                />
                {opcao}
              </label>
            ))}
          </div>
        </div>

        <div className="input-grupo">
          <label className="label-titulo">Nome Completo</label>
          <input
            type="text"
            name="nome"
            value={formData.nome}
            onChange={handleChange}
            className="input-text"
            required
          />
        </div>

        <div className="input-grupo">
          <label className="label-titulo">E-mail</label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            className="input-text"
            required
          />
        </div>

        <div className="input-grupo">
          <label className="label-titulo">Mensagem</label>
          <textarea
            name="mensagem"
            value={formData.mensagem}
            onChange={handleChange}
            className="input-textarea"
            required
          />
        </div>

        <div className="form-actions">
          <button type="submit" className="button-enviar">Enviar</button>

          <a
            href="https://wa.me/5511999999999?text=Olá!%20Gostaria%20de%20informações%20sobre%20os%20serviços%20da%20Funerária."
            className="whatsapp-btn"
            target="_blank"
            rel="noopener noreferrer"
          >
            <img src="/whatsapp.png" alt="WhatsApp" />
            <div className="whatsapp-texto">
              <p>Dúvidas ou urgência?</p>
              <p>Fale direto pelo WhatsApp</p>
            </div>
          </a>
        </div>
      </form>
    </div>
  );
};

export default Contato;
