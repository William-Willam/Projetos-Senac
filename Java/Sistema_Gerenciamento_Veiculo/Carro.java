package Sistema_Gerenciamento_Veiculo;

public class Carro extends Veiculo implements Operacoes {
    private int numeroPortas;

    public Carro(String marca, String modelo, int ano, double preco, boolean disponivel, int numeroPortas) {
        super(marca, modelo, ano, preco, disponivel);
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() { return numeroPortas; }
    public void setNumeroPortas(int numeroPortas) { this.numeroPortas = numeroPortas; }

    public void ligar() { System.out.println("Carro ligado."); }
    public void desligar() { System.out.println("Carro desligado."); }

    public void exibirInformacoes() {
        System.out.println("Carro: " + getMarca() + " " + getModelo() +
            ", Ano: " + getAno() + ", Preço: R$" + getPreco() +
            ", Portas: " + numeroPortas + ", Disponível: " + disponivel);
    }

    public double calcularSeguro() {
        return getPreco() * 0.04 * (1 + (2025 - getAno()) * 0.01);
    }
}