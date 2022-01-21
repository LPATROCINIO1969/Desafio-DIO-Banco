package bancoDominio;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente novoCliente) {
		super(novoCliente);
		// TODO Auto-generated constructor stub
	}

	public void imprimirExtrato() {
		System.out.println(" ======  Extrato da Conta Corrente ===== ");
		super.imprimirInfComum();
	}
	
}
