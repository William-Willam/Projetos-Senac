package Sistema_Gerenciamento_Veiculo;

import java.util.ArrayList;

public class principal {
    public static void main(String[] args) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        Carro carro = new Carro("Toyota", "Corolla", 2020, 80000, true, 4);
        Moto moto = new Moto("Honda", "CB 500", 2019, 35000, false, 500);
        Caminhao caminhao = new Caminhao("Volvo", "FH", 2018, 250000, true, 20);

        veiculos.add(carro);
        veiculos.add(moto);
        veiculos.add(caminhao);

        for (Veiculo v : veiculos) {
            if (v instanceof Operacoes operacao) {
                operacao.ligar();
                operacao.exibirInformacoes();
                operacao.desligar();
            }
            System.out.printf("Valor do seguro: R$ %.2f\n\n", v.calcularSeguro());
        }

        // Desafio extra: filtrar veículos disponíveis
        System.out.println("=== Veículos Disponíveis ===");
        for (Veiculo v : veiculos) {
            if (v.disponivel && v instanceof Operacoes operacao) {
                operacao.exibirInformacoes();
                System.out.println();
            }
        }
    }
}
