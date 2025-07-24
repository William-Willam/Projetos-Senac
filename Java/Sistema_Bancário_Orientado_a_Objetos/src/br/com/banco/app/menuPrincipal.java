package br.com.banco.app;

import br.com.banco.model.Conta;
import br.com.banco.model.Tributavel;
import br.com.banco.contas.ContaCorrente;
import br.com.banco.contas.ContaPoupanca;

public class menuPrincipal {
    public static void main(String[] args) {
        Conta cc = new ContaCorrente(1, "João", 1000.0);
        Conta cp = new ContaPoupanca(2, "Maria", 1200.0);

        // Operações
        cc.sacar(50);
        cp.depositar(0); 

        // Polimorfismo em array
        Conta[] contas = {cc, cp};

        for (Conta conta : contas) {
            System.out.println("Conta " + conta.getClass().getSimpleName().replace("Conta", "") + " - " + conta.getTitular());
            conta.exibirSaldo();

            if (conta instanceof Tributavel) {
                Tributavel t = (Tributavel) conta;
                System.out.println("Tributo: R$ " + String.format("%.2f", t.calcularTributo()));
            }

            System.out.println();
        }
    }
}
