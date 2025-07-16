package ClassesMetedosEspeciais;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa p1 = new Pessoa("William", 29, 1.85, 'M', "051.852.369-01");
		

		// exibir dados
		/*p1.apresentacao();
		p1.criarContaBancaria();
		p1.depositar(26000.00);
		p1.sacar(15000);
		p1.consultarSaldo();*/
		
		System.out.println(p1.getNome());
	}

}
