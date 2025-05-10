import { logout } from "../firebase/auth";
import { useNavigate } from "react-router-dom";
import "../styles/Catalogo.css";

export default function Catalogo() {
  const navigate = useNavigate();

  const handleLogout = async () => {
    try {
      await logout();
      navigate("/login");
    } catch (error) {
      console.error("Erro ao sair:", error);
    }
  };

  const catalogo = {
    caixoes: [
      {
        nome: "Caixão Clássico",
        preco: 2500,
        descricao: "Modelo tradicional em madeira nobre.",
        imagem: "/caixaclassico.jpg",
      },
      {
        nome: "Caixão Luxo",
        preco: 4500,
        descricao: "Modelo com acabamento de luxo e detalhes em bronze.",
        imagem: "/caixaoluxo.jpg",
      },
      {
        nome: "Caixão Simples",
        preco: 1800,
        descricao: "Modelo básico para cerimônias simples.",
        imagem: "/caixaosimples.jpg",
      },
      {
        nome: "Caixão Infantil",
        preco: 1600,
        descricao: "Modelo adequado para cerimônias infantis.",
        imagem: "/caixaoinfantil.jpg",
      },
      {
        nome: "Caixão Branco",
        preco: 3200,
        descricao: "Modelo em madeira clara com detalhes prateados.",
        imagem: "/caixaobranco.jpg",
      },
      {
        nome: "Caixão Premium",
        preco: 6000,
        descricao: "Modelo premium com estofado interno personalizado.",
        imagem: "/caixaopremium.jpg",
      },
    ],

    flores: [
      {
        nome: "Coroa de Rosas",
        preco: 350,
        descricao: "Rosas vermelhas com mensagem personalizada.",
        imagem: "/coroarosas.jpg",
      },
      {
        nome: "Coroa Mista",
        preco: 280,
        descricao: "Flores variadas com acabamento elegante.",
        imagem: "/coroamista.jpg",
      },
      {
        nome: "Coroa de Lírios",
        preco: 400,
        descricao: "Lírios brancos para cerimônias sofisticadas.",
        imagem: "/coroalirio.jpg",
      },
      {
        nome: "Coroa de Girassóis",
        preco: 310,
        descricao: "Girassóis em homenagem à luz e esperança.",
        imagem: "/coroagirassois.jpg",
      },
      {
        nome: "Coroa Tropical",
        preco: 390,
        descricao: "Flores tropicais coloridas e vibrantes.",
        imagem: "/coroatropical.jpg",
      },
      {
        nome: "Coroa Premium",
        preco: 500,
        descricao: "Arranjo floral premium com flores importadas.",
        imagem: "/coroapremium.jpg",
      },
    ],

    servicos: [
      {
        nome: "Translado Nacional",
        preco: 1200,
        descricao: "Transporte do corpo entre cidades/estados.",
        imagem: "/Translado-Nacional.jpg",
      },
      {
        nome: "Velório Completo",
        preco: 1800,
        descricao: "Salas confortáveis, estrutura e atendimento.",
        imagem: "/Velório-Completo.jpg",
      },
      {
        nome: "Translado Internacional",
        preco: 5500,
        descricao: "Toda a documentação e transporte internacional.",
        imagem:
          "/Translado-Internacional.jpg",
      },
      {
        nome: "Serviço 24h",
        preco: 300,
        descricao: "Atendimento 24 horas por dia, 7 dias por semana.",
        imagem: "/Serviço.jpg",
      },
      {
        nome: "Assistência Jurídica",
        preco: 750,
        descricao: "Auxílio com documentos e certidões de óbito.",
        imagem: "/Assistência-Jurídica.jpg",
      },
      {
        nome: "Cerimônia Personalizada",
        preco: 2500,
        descricao: "Ritos personalizados conforme cultura e crença.",
        imagem:
          "/Cerimonia-funeraria.jpg",
      },
    ],
  };

  const Card = ({ item }) => (
    <article className="catalogo-card">
      <img src={item.imagem} alt={item.nome} className="card-imagem" />
      <div className="card-conteudo">
        <h3>{item.nome}</h3>
        <p>{item.descricao}</p>
        <strong>R$ {item.preco.toFixed(2)}</strong>
        <button className="btn-comprar">Comprar</button>
      </div>
    </article>
  );

  return (
    <main className="catalogo-container">
      <header className="catalogo-header">
        <h1>Catálogo de Serviços Funerários</h1>
        <button onClick={handleLogout} className="btn-sair">
          Sair
        </button>
      </header>

      <section>
        <h2>Caixões</h2>
        <div className="catalogo-grid">
          {catalogo.caixoes.map((item, index) => (
            <Card key={index} item={item} />
          ))}
        </div>
      </section>

      <section>
        <h2>Coroas de Flores</h2>
        <div className="catalogo-grid">
          {catalogo.flores.map((item, index) => (
            <Card key={index} item={item} />
          ))}
        </div>
      </section>

      <section>
        <h2>Serviços</h2>
        <div className="catalogo-grid">
          {catalogo.servicos.map((item, index) => (
            <Card key={index} item={item} />
          ))}
        </div>
      </section>
    </main>
  );
}
