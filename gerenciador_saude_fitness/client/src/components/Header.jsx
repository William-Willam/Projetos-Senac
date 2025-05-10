import "../styles/Home.css";

function Header() {
  return (
    <header className="header">
      <div className="logo">HealthFit</div>
      <nav className="nav-links">
        <a href="/login">Entrar</a>
        <a href="/register">Cadastrar</a>
      </nav>
    </header>
  );
}

export default Header;
