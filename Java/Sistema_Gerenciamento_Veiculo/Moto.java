package Sistema_Gerenciamento_Veiculo;

public class Moto extends Veiculo implements Operacoes {
    private int cilindradas;

    public Moto(String marca, String modelo, int ano, double preco, boolean disponivel, int cilindradas) {
        super(marca, modelo, ano, preco, disponivel);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() { return cilindradas; }
    public void setCilindradas(int cilindradas) { this.cilindradas = cilindradas; }

    public void ligar() { System.out.println("Moto ligada."); }
    public void desligar() { System.out.println("Moto desligada."); }

    public void exibirInformacoes() {
        System.out.println("Moto: " + getMarca() + " " + getModelo() +
            ", Ano: " + getAno() + ", Preço: R$" + getPreco() +
            ", Cilindradas: " + cilindradas + ", Disponível: " + disponivel);
    }

    public double calcularSeguro() {
        return getPreco() * 0.06 * (1 + (2025 - getAno()) * 0.01);
    }
}