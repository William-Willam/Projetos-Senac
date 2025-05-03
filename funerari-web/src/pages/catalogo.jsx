import { logout } from "../firebase/auth";
import { useNavigate } from "react-router-dom";

export default function Catalogo() {
  const navigate = useNavigate();

  const handleLogout = async () => {
    try {
      await logout();
      navigate("/login"); // Redireciona para login
    } catch (error) {
      console.error("Erro ao sair:", error);
    }
  };

  return (
    <div>
      <h1>Catálogo</h1>
      <p>Em desenvolvimento!</p>
      <button onClick={handleLogout} className="logout-button">Sair</button>
    </div>
  );
}
