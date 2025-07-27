package Sistema_Gerenciamento_Veiculo;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private double preco;
    public boolean disponivel;

    public Veiculo(String marca, String modelo, int ano, double preco, boolean disponivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public void alterarDisponibilidade(boolean status) { this.disponivel = status; }
    public abstract double calcularSeguro();
}