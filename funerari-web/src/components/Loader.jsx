import { Container, Spinner } from "react-bootstrap";
import "../styles/Loader.css";

function Loader() {
  return (
    <Container className="mt-5 loader">
      <Spinner variant="light" />
      <span className="ms-1">Carregando...</span>
    </Container>
  );
}

export default Loader;
