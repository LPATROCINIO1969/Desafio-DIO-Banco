package bancoDominio;

public class ContaPoupanca extends Conta{

	public ContaPoupanca(Cliente novoCliente) {
		super(novoCliente);
		// TODO Auto-generated constructor stub
	}

	public void imprimirExtrato() {
		System.out.println(" ======  Extrato da Conta Poupança ===== ");
		super.imprimirInfComum();
	}

}
