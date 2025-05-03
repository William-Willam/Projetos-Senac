import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Toaster } from "react-hot-toast";
import Header from "./components/Header";
import Home from "./pages/home";
import Contato from "./pages/contato"
import Login from "./pages/login";
import Catalogo from "./pages/catalogo";


function App() {
  return (
    <BrowserRouter>
    <Header/>
    <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path="/contato" element={<Contato/>}/>
      <Route path="/login" element={<Login/>}/>
      <Route path="/catalogo" element={< Catalogo/>}/>
    </Routes>
    <Toaster position="top-right" />
    </BrowserRouter>
  )
}

export default App
