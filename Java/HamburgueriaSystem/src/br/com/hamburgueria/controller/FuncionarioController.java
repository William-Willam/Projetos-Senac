package br.com.hamburgueria.controller;

import br.com.hamburgueria.dao.FuncionarioDAO;
import br.com.hamburgueria.model.Funcionario;
import java.util.List;

public class FuncionarioController {

	private FuncionarioDAO funcionarioDAO;

	public FuncionarioController() {
		this.funcionarioDAO = new FuncionarioDAO();
	}

	/**
	 * Autentica um funcionário com base no usuário e senha.
	 * 
	 * @param usuario O nome de usuário.
	 * @param senha   A senha.
	 * @return O objeto Funcionario se a autenticação for bem-sucedida, ou null caso
	 *         contrário.
	 */
	public Funcionario autenticar(String usuario, String senha) {
		Funcionario funcionario = funcionarioDAO.buscarPorUsuario(usuario);
		if (funcionario != null && funcionario.getSenha().equals(senha)) {
			// Em uma implementação real, a senha deveria ser comparada após o hash
			return funcionario;
		}
		return null;
	}

	/**
	 * Salva um novo funcionário.
	 * 
	 * @param funcionario O objeto Funcionario a ser salvo.
	 */
	public void salvarFuncionario(Funcionario funcionario) {
		// Implementar a lógica de negócio, como validações
		funcionarioDAO.salvar(funcionario);
	}

	/**
	 * Atualiza um funcionário existente.
	 * 
	 * @param funcionario O objeto Funcionario com os dados a serem atualizados.
	 */
	public void atualizarFuncionario(Funcionario funcionario) {
		funcionarioDAO.atualizar(funcionario);
	}

	/**
	 * Exclui um funcionário pelo seu ID.
	 * 
	 * @param id O ID do funcionário a ser excluído.
	 */
	public void excluirFuncionario(int id) {
		funcionarioDAO.excluir(id);
	}

	/**
	 * Busca um funcionário pelo seu ID.
	 * 
	 * @param id O ID do funcionário.
	 * @return O objeto Funcionario.
	 */
	public Funcionario buscarFuncionarioPorId(int id) {
		return funcionarioDAO.buscarPorId(id);
	}

	/**
	 * Retorna uma lista com todos os funcionários.
	 * 
	 * @return Uma lista de objetos Funcionario.
	 */
	public List<Funcionario> listarTodosFuncionarios() {
		return funcionarioDAO.listarTodos();
	}
}