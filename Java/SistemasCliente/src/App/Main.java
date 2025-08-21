package App;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteDAO dao =  new ClienteDAO();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Deletar Cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Cliente cliente = new Cliente(nome, email);
                    dao.inserir(cliente);
                    break;

                case 2:
                    List<Cliente> clientes = dao.listarClientes();
                    System.out.println("\n--- Lista de Clientes ---");
                    for (Cliente c : clientes) {
                        System.out.println(c.getId() + " - " + c.getNome() + " (" + c.getEmail() + ")");
                    }
                    break;

                case 3:
                    System.out.print("ID do cliente para atualizar: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = sc.nextLine();

                    Cliente clienteAtualizado = new Cliente(idAtualizar, novoNome, novoEmail);
                    dao.atualizar(clienteAtualizado);
                    break;

                case 4:
                    System.out.print("ID do cliente para deletar: ");
                    int idDeletar = sc.nextInt();
                    dao.deletar(idDeletar);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}