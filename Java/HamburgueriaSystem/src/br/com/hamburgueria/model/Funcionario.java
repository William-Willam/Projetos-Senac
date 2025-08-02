package br.com.hamburgueria.model;

public class Funcionario {

    private int id;
    private String nome;
    private String usuario;
    private String senha;
    private boolean isAdmin;

    // Construtor completo
    public Funcionario(int id, String nome, String usuario, String senha, boolean isAdmin) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.isAdmin = isAdmin;
    }

    // Construtor para novos funcionários (sem ID)
    public Funcionario(String nome, String usuario, String senha, boolean isAdmin) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.isAdmin = isAdmin;
    }
    
    // Construtor padrão
    public Funcionario() {
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}