package banco;

public abstract class Conta implements iConta{
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	
	
	
	public Conta(Cliente novoCliente) { 
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++; 
		this.saldo = 0; 
		this.cliente = novoCliente;
	}
	 

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public void sacar(double valorSacado) {
		saldo = saldo - valorSacado;
		
	}

	@Override
	public void depositar(double valorDepositado) {
		saldo = saldo + valorDepositado;
		
	}

	@Override
	public void transferir(double valorTransferido, Conta contaDestino) {
		this.sacar(valorTransferido);
		contaDestino.depositar(valorTransferido);
		
	}
	
	protected void imprimirInfComum() {
		System.out.println(String.format("Agencia: %d",this.agencia));
		System.out.println(String.format("Conta: %d",this.numero));
		System.out.println(String.format("Titular: %s",this.cliente.getNome()));
		System.out.println(String.format("Saldo: %.2f",this.saldo));
		
	}
	
}
