module Cadastro {
    // Declara que o seu projeto "Cadastro" precisa desses módulos para compilar e rodar.
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql; // Necessário para a conexão com o MySQL

    // A diretiva `opens` é crucial para a reflexão.
    // Ela permite que o código de um módulo acesse as classes e seus membros (métodos, atributos)
    // de outro módulo, mesmo que sejam privados. Isso é o que a TableView precisa para encontrar
    // seus métodos `get...` na classe `Pessoa`.

    // Abre o pacote 'testeFX' para o módulo de gráficos. Isso permite que o JavaFX Graphics
    // inicie sua classe principal (`Main`).
    opens testeFX to javafx.graphics, javafx.base;
    
    // Abre o pacote 'testeFX' para o módulo base. Isso permite que a TableView, que está no
    // módulo de controles, mas usa funcionalidades do base, acesse sua classe `Pessoa`.
    //opens testeFX to javafx.base;

    // A diretiva `exports` torna as classes públicas do seu pacote disponíveis para outros
    // módulos, caso eles queiram usá-las diretamente. É uma boa prática para APIs.
    exports testeFX;
}