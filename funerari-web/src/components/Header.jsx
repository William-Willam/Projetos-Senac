import "../styles/Header.css";

export default function Header() {
    return(
        <header className="header">
            <div className="header-left">
                <img src={"/funeraria.png"} alt="logo da Funerária" className="logo"/>
                <h1 className="nome-funeraria">Funerária Esperança</h1>
            </div>
            <nav className="nav">
                <a href="#">Catálogo</a>
                <a href="#">Quem Somos</a>
                <a href="#" className="login-btn">Login</a>
            </nav>
        </header>
    );
}