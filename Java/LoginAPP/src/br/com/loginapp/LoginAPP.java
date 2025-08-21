package br.com.loginapp;

import java.util.*;

public class LoginAPP {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		UsuarioDAO dao = new UsuarioDAO();

		System.out.println("=========== Login ============");
		System.out.println();
		System.out.print("Usuario: ");
		String nomeUsuario = input.nextLine();
		System.out.print("Senha: ");
		String senhaUsuario = input.nextLine();
		
		Usuario usuario = new Usuario(nomeUsuario, senhaUsuario);
		
		if (dao.autenticar(usuario)) {
			System.out.println("Entrou !!!");
		} else {
			System.out.println("nao deu certo!!!");
		}
		input.close();
	}
}
