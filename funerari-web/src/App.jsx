import { onAuthStateChanged } from "firebase/auth";
import { auth } from "./firebase/config";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { useEffect, useState } from "react";
import { Toaster } from "react-hot-toast";
import Header from "./components/Header";
import Home from "./pages/home";
import Contato from "./pages/contato";
import Login from "./pages/login";
import Catalogo from "./pages/catalogo";
import Loader from "./components/Loader";
import { UsuarioContext } from "./contexts/UserContext";

function App() {
  const [usuarioLogado, setusuarioLogado] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    console.log("app");
    onAuthStateChanged(auth, (user) => {
      setusuarioLogado(user);
      setLoading(false);
    });
  }, []);

  //carregamento em caso de demora
  if (loading) {
    return <Loader />;
  }

  return (
    <UsuarioContext.Provider value={usuarioLogado}>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/contato" element={<Contato />} />
          <Route path="/login" element={<Login />} />
          <Route path="/catalogo" element={<Catalogo />} />
        </Routes>
      </BrowserRouter>
      <Toaster position="top-center" />
    </UsuarioContext.Provider>
  );
}

export default App;
