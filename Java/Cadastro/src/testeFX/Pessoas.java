package testeFX;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pessoas{
    // Usamos Simple...Property do JavaFX para que a tabela possa observar as mudanças
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nome;
    private final SimpleIntegerProperty idade;

    public Pessoas(int id, String nome, int idade) {
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.idade = new SimpleIntegerProperty(idade);
    }

    // Getters para as propriedades
    public int getId() {
        return id.get();
    }

    public String getNome() {
        return nome.get();
    }

    public int getIdade() {
        return idade.get();
    }
    
    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public void setIdade(int idade) {
        this.idade.set(idade);
    }
}