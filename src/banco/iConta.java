package banco;

public interface iConta {
	
	void sacar(double valorSacado);
	
	void depositar(double valorDepositado);
	
	void transferir(double valorTransferido, Conta contaDestino);
	
	void imprimirExtrato();
}
