package aplicacao;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Label lblMensagem;

    @FXML
    private void entrar() {
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (usuario.equals("admin") && senha.equals("123")) {
            lblMensagem.setText("Login bem-sucedido!");
            lblMensagem.setStyle("-fx-text-fill: green;");
        } else {
            lblMensagem.setText("Usuário ou senha inválidos!");
            lblMensagem.setStyle("-fx-text-fill: red;");
        }
    }
}
