// Header.jsx
import { Link, useNavigate } from "react-router-dom";
import "../styles/Header.css";
import { useContext, useState, useEffect } from "react";
import { UsuarioContext } from "../contexts/UserContext";
import { logout } from "../firebase/auth";

function Header() {
  const usuario = useContext(UsuarioContext);
  const navigate = useNavigate();

  const [profilePic, setProfilePic] = useState("/img/fotoperfil.png");

  useEffect(() => {
    if (usuario) {
      const savedProfilePic = localStorage.getItem(`profilePic_${usuario.uid}`);
      if (savedProfilePic) {
        setProfilePic(savedProfilePic);
      } else {
        setProfilePic("/img/fotoperfil.png");
      }
    }
  }, [usuario]);

  function handleLogout() {
    logout().then(() => {
      navigate("/login");
    });
  }

  function handleProfilePicChange(event) {
    const file = event.target.files[0];
    if (file && usuario) {
      const reader = new FileReader();
      reader.onloadend = () => {
        const profilePicURL = reader.result;
        setProfilePic(profilePicURL);
        localStorage.setItem(`profilePic_${usuario.uid}`, profilePicURL);
      };
      reader.readAsDataURL(file);
    }
  }

  return (
    <header className="header">
      <section className="header-left">
        <Link to="/" className="logo">
          <img src="/funeraria.png" alt="Logo da Funerária" width={50} />
          <span className="nome-funeraria">Funerária Esperança</span>
        </Link>
      </section>

      <nav className="header-nav">
        <Link to="/contato" className="nav-link">Contato</Link>
        {!usuario ? (
          <Link to="/login" className="nav-link">Iniciar Sessão</Link>
        ) : (
          <div className="nav-icons">
            <img src={profilePic} alt="Foto de Perfil" width={40} height={40} className="rounded-circle" />
            <div className="dropdown">
              <button className="dropbtn">Menu de {usuario.displayName}</button>
              <div className="dropdown-content">
                <label htmlFor="upload-photo">
                  Mudar a foto
                  <input type="file" accept="image/*" onChange={handleProfilePicChange} className="d-none" id="upload-photo" />
                </label>
                <Link to="/catalogo">Catalogo</Link>
                <span onClick={handleLogout} className="nav-link">Desconectar</span>
              </div>
            </div>
          </div>
        )}
      </nav>
    </header>
  );
}

export default Header;
