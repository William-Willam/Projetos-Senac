import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Home from "./pages/home";
import Contato from "./pages/contato"


function App() {
  return (
    <BrowserRouter>
    <Header/>
    <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path="/contato" element={<Contato/>}/>
    </Routes>
    </BrowserRouter>
  )
}

export default App
