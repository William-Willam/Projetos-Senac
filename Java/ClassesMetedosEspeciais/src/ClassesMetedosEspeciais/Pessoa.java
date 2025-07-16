package ClassesMetedosEspeciais;

	//Encapsulamento = esconder alguma coisa
	
public class Pessoa {
	// Atributos públicos (podem ser acessados de qualquer lugar)
	public String nome;
	public int idade;
	public double altura;
	public char genero;

	// Atributos privados (só podem ser acessados dentro desta classe)
	private String cpf;
	private double contaBancaria;

	/*
	 * Construtor:
	 * Método especial chamado automaticamente quando criamos um objeto.
	 * Ele deve ter o mesmo nome da classe e nunca tem tipo de retorno.
	 * Usado para inicializar os atributos com os valores recebidos.
	 */
	public Pessoa(String nome, int idade, double altura, char genero, String cpf) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.altura = altura;
		this.genero = genero;
	}

	// Get e Set são métodos especiais para acessar (get) ou alterar (set) atributos privados.

	// Setter (modifica o nome)
	public void setNome(String nome) {
		this.nome = nome;
	}

	// Getter (retorna o nome)
	public String getNome() {
		return nome;
	}

	/*
	 * Criar conta bancária:
	 * Apenas pessoas com 18 anos ou mais podem criar uma conta.
	 * A conta começa com saldo 0.00.
	 */
	public void criarContaBancaria() {
		if (idade >= 18) {
			this.contaBancaria = 0.00;
			System.out.println("Sua conta foi criada com sucesso!");
		} else {
			System.out.println("Não é permitido criar uma conta bancária");
		}
	}

	// Consulta o saldo da conta (somente leitura, sem permitir alteração direta)
	public void consultarSaldo() {
		System.out.println("Saldo atual: R$ " + contaBancaria);
	}

	// Deposita um valor na conta bancária
	public void depositar(double valor) {
		contaBancaria += valor;
		System.out.println("Valor depositado com sucesso!");
	}

	// Realiza um saque da conta, se houver saldo suficiente
	public void sacar(double valor) {
		if (valor > contaBancaria) {
			System.out.println("Sem saldo suficiente!");
		} else {
			contaBancaria -= valor;
			System.out.println("Saque realizado com sucesso!");
		}
	}

	/*
	 * Método comum:
	 * Usado para apresentar uma mensagem com os dados da pessoa.
	 * Pode ser chamado de qualquer lugar que tenha acesso ao objeto.
	 */
	public void apresentacao() {
		System.out.println("Meu nome é: " + nome + " e tenho " + idade + " anos de idade!");
	}

	/*
	 * Modificadores de acesso:
	 * - public: acessível de qualquer lugar
	 * - private: acessível apenas dentro da classe
	 * - protected: acessível no mesmo pacote e por herança
	 * - default (sem modificador): acessível apenas no mesmo pacote
	 */
}
