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
		this.cliente.addConta(this);
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
	
	public int getProximoNumeroConta() {
		return (Conta.SEQUENCIAL+1);
	}
	
	public void excluir() {
		this.cliente.removeConta(this);
		this.agencia.removeConta(this);
	}

	public List<Transacao> getTransacoes(){
		return this.transacoes;
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
		return ("Conta " + String.format("%04d", this.getNumero())  + " - " + String.format("%-20s", this.cliente.getNome()) + "\t- Tipo: " + String.format("%03d", this.getTipoConta()) + "\t- Saldo:" + String.format("%.2f", this.saldo));
	}


	public String dadosConta() {
		String texto="";
		texto += String.format("Banco: %04d",this.agencia.getBanco().getNumero()) + " - " + this.agencia.getBanco().getNome() +"\n";
		texto += String.format("Agencia: %d",this.agencia.getNumero()) + " - " + this.agencia.getNome() + "\n";
		texto += String.format("Conta: %08d",this.numero) + "\n" ;
		texto += String.format("Titular: %-20s",this.cliente.getNome()) + "\n";
		texto += String.format("Saldo: R$ %.2f",this.saldo) + "\n";
		return texto;
	}
	
	private String mostraMovimento() {
		String texto="";
		for(Transacao ts:this.transacoes) {
			texto+=ts.toString();
		}
		return texto;
	}
	
	
	public String emitirExtrato() {
		String texto="";
		texto += dadosConta();
		texto += "==================================================================================================\n";
		texto += "Data" + "\t\tOperação" + "\tDocumento" + "\tValor\n";
		texto += "==================================================================================================\n";
		texto += mostraMovimento();
		texto += "==================================================================================================\n";
		return texto;
	}
	
}
