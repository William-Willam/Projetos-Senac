package testeFX;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    private TableView<Pessoas> tabelaPessoas;
    private ObservableList<Pessoas> dadosPessoas;
    private TextField txtNome;
    private TextField txtIdade;
    private Button btnAdicionar;
    private Button btnAtualizar;
    private Button btnApagar;

    // Campo para armazenar a pessoa selecionada na tabela
    private Pessoas pessoaSelecionada;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cadastro de Pessoas");

        // Layout principal
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.getStyleClass().add("fundo");
        layout.setAlignment(Pos.TOP_CENTER);

        // Título
        Label lblTitulo = new Label("Cadastro de Pessoas");
        lblTitulo.getStyleClass().add("titulo");

        // Formulário de entrada
        txtNome = new TextField();
        txtNome.setPromptText("Nome");
        txtIdade = new TextField();
        txtIdade.setPromptText("Idade");
        
        VBox formCampos = new VBox(10, txtNome, txtIdade);
        formCampos.getStyleClass().add("form-campos");
        formCampos.setPrefWidth(250);
        formCampos.setAlignment(Pos.CENTER);

        // Botões de ação
        btnAdicionar = new Button("Adicionar");
        btnAdicionar.getStyleClass().add("botao");
        btnAdicionar.setOnAction(e -> adicionarPessoa());
        
        btnAtualizar = new Button("Atualizar");
        btnAtualizar.getStyleClass().add("botao");
        btnAtualizar.setOnAction(e -> atualizarPessoa());
        btnAtualizar.setDisable(true); // Começa desabilitado
        
        btnApagar = new Button("Apagar");
        btnApagar.getStyleClass().add("botao");
        btnApagar.setOnAction(e -> apagarPessoa());
        btnApagar.setDisable(true); // Começa desabilitado

        HBox formBotoes = new HBox(10, btnAdicionar, btnAtualizar, btnApagar);
        formBotoes.setAlignment(Pos.CENTER);
        
        VBox formArea = new VBox(15, lblTitulo, formCampos, formBotoes);
        formArea.getStyleClass().add("form-area");
        formArea.setAlignment(Pos.CENTER);
        formArea.setPadding(new Insets(10));
        
        // Tabela para exibir as pessoas
        tabelaPessoas = new TableView<>();
        tabelaPessoas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabelaPessoas.setPlaceholder(new Label("Nenhuma pessoa cadastrada."));

        TableColumn<Pessoas, Integer> colunaId = new TableColumn<>("ID");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaId.setPrefWidth(60);

        TableColumn<Pessoas, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Pessoas, Integer> colunaIdade = new TableColumn<>("Idade");
        colunaIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colunaIdade.setPrefWidth(80);

        tabelaPessoas.getColumns().addAll(colunaId, colunaNome, colunaIdade);
        
        // Lógica para carregar os dados no formulário ao selecionar uma pessoa
        tabelaPessoas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                pessoaSelecionada = newSelection;
                txtNome.setText(pessoaSelecionada.getNome());
                txtIdade.setText(String.valueOf(pessoaSelecionada.getIdade()));
                btnAdicionar.setDisable(true);
                btnAtualizar.setDisable(false);
                btnApagar.setDisable(false);
            } else {
                pessoaSelecionada = null;
                limparCampos();
                btnAdicionar.setDisable(false);
                btnAtualizar.setDisable(true);
                btnApagar.setDisable(true);
            }
        });

        carregarDados();

        layout.getChildren().addAll(formArea, tabelaPessoas);

        Scene cena = new Scene(layout, 600, 500);
        cena.getStylesheets().add(getClass().getResource("estilo.css").toExternalForm());

        primaryStage.setScene(cena);
        primaryStage.show();
    }

    private void adicionarPessoa() {
        try {
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            if (nome.isEmpty() || idade <= 0) {
                mostrarAlerta(Alert.AlertType.WARNING, "Dados Inválidos", "Preencha o nome e a idade corretamente.");
                return;
            }
            Pessoas novaPessoa = new Pessoas(0, nome, idade);
            DatabaseConnector.adicionarPessoa(novaPessoa);
            carregarDados();
            limparCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro de Entrada", "A idade deve ser um número inteiro.");
        }
    }

    private void atualizarPessoa() {
        if (pessoaSelecionada != null) {
            try {
                String nome = txtNome.getText();
                int idade = Integer.parseInt(txtIdade.getText());
                if (nome.isEmpty() || idade <= 0) {
                    mostrarAlerta(Alert.AlertType.WARNING, "Dados Inválidos", "Preencha o nome e a idade corretamente.");
                    return;
                }
                
                pessoaSelecionada.setNome(nome);
                pessoaSelecionada.setIdade(idade);
                DatabaseConnector.atualizarPessoa(pessoaSelecionada);
                
                carregarDados();
                limparCampos();
                tabelaPessoas.getSelectionModel().clearSelection();
            } catch (NumberFormatException e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Erro de Entrada", "A idade deve ser um número inteiro.");
            }
        }
    }

    private void apagarPessoa() {
        if (pessoaSelecionada != null) {
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Confirmar Exclusão");
            confirmacao.setHeaderText("Tem certeza que deseja apagar esta pessoa?");
            confirmacao.setContentText("Nome: " + pessoaSelecionada.getNome());
            
            confirmacao.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    DatabaseConnector.apagarPessoa(pessoaSelecionada.getId());
                    carregarDados();
                    limparCampos();
                    tabelaPessoas.getSelectionModel().clearSelection();
                }
            });
        }
    }

    private void carregarDados() {
        List<Pessoas> listaPessoas = DatabaseConnector.listarPessoas();
        dadosPessoas = FXCollections.observableArrayList(listaPessoas);
        tabelaPessoas.setItems(dadosPessoas);
    }
    
    private void limparCampos() {
        txtNome.clear();
        txtIdade.clear();
    }
    
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}