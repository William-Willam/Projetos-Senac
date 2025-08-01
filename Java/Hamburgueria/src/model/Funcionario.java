package model;

public class Funcionario {
    // atributos do funcionario
    private int id;
    private String nome;
    private String usuario;
    private String senha;
    private String tipo;

    // ✅ Construtor padrão (necessário para criar o objeto vazio)
    public Funcionario() {
    }

    // Construtor com todos os atributos
    public Funcionario(int id, String nome, String usuario, String senha, String tipo) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
    }

    // GET e SET
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
