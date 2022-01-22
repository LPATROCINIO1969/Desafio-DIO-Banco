package bancoDominio;

public class ContaPoupanca extends Conta{
	
	private final int tipoContaPF = 13;
	private final int tipoContaPJ = 22;
	

	public ContaPoupanca(Cliente novoCliente, Agencia agencia) {
		super(novoCliente,  agencia);
		this.tipoConta = (novoCliente.getFlagPessoaFisica()?tipoContaPF:tipoContaPJ);

	}

	public void imprimirExtrato() {
		System.out.println(" ======  Extrato da Conta Poupança ===== ");
		super.imprimirInfComum();
	}

}
