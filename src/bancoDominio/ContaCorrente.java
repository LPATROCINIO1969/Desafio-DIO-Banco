package bancoDominio;

public class ContaCorrente extends Conta {
	
	private final int tipoContaPF = 1;
	private final int tipoContaPJ = 3;
	

	public ContaCorrente(Cliente novoCliente,Agencia agencia) {
		super(novoCliente,agencia);
		this.tipoConta = (novoCliente.getFlagPessoaFisica()?tipoContaPF:tipoContaPJ);
	}

			
//	public void imprimirExtrato() {
//		System.out.println(" ======  Extrato da Conta Corrente ===== ");
//		super.imprimirInfComum();
//	}
	
}
