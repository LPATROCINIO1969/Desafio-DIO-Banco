package bancoDominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta implements iConta{
	
	private static int SEQUENCIAL = 1;
	protected Agencia agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected int tipoConta;
	protected List<Transacao> transacoes;
	
	public Conta(Cliente novoCliente, Agencia agencia) { 
		this.agencia = agencia;
		this.numero = SEQUENCIAL++; 
		this.saldo = 0; 
		this.cliente = novoCliente;
		this.tipoConta=0;
		this.agencia.addConta(this);
		this.transacoes = new ArrayList<>();
		
	}
	 

	public Agencia getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public int getTipoConta() {
		return this.tipoConta;
	}

	@Override
	public void sacar(double valorSacado) {
		this.transacoes.add(new Transacao("Saque", valorSacado,true, new Date()));
		saldo = saldo - valorSacado;
		
	}

	@Override
	public void depositar(double valorDepositado) {
		this.transacoes.add(new Transacao("Depósito", valorDepositado,false, new Date()));
		saldo = saldo + valorDepositado;
		
	}

	@Override
	public void transferir(double valorTransferido, Conta contaDestino) {
		this.sacar(valorTransferido);
		contaDestino.depositar(valorTransferido);
		
	}
	
		
	@Override
	public String toString() {
		return ("Conta " + this.getNumero() + " - " + this.cliente.getNome() + "Tipo: " + this.getTipoConta());
	}


	protected void imprimirInfComum() {
		System.out.println(String.format("Agencia: %d",this.agencia.getNumero()));
		System.out.println(String.format("Conta: %d",this.numero));
		System.out.println(String.format("Titular: %s",this.cliente.getNome()));
		System.out.println(String.format("Saldo: %.2f",this.saldo));
		
	}
	
}
