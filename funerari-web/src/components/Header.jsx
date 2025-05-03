import "../styles/Header.css";

export default function Header() {
  return (
    <header className="header">
      <section className="header-left">
        <a href="/"><img src={"/funeraria.png"} alt="logo da Funerária" className="logo" /></a>
        <h1 className="nome-funeraria">Funerária Esperança</h1>
      </section>
      <nav className="nav">
        <a href="#">Catálogo</a>
        <a href="/contato">Contatos</a>
        <a href="#" className="login-btn">
          Login
        </a>
        <a href="#" className="signup-btn">
          Cadastrar
        </a>
      </nav>
    </header>
  );
}
