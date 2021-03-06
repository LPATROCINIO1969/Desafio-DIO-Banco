package bancoDominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Agencia {

	private String nome;
	private int numero;
	private List<Conta> contas;
	private int qtdContas;
	private Banco banco;
	
	
	public Agencia() {
		this.contas = new ArrayList<>();
		this.qtdContas= 0;
	}
	
	public Agencia(String nome, int numero, Banco banco) {
		this();
		this.nome = nome.toUpperCase();
		this.numero = numero;
		this.banco = banco;
	}
	
	
	public void addConta(Conta novaConta) {
		this.contas.add(novaConta);
		this.qtdContas++;
	}
	
	public void removeConta(Conta conta) {
		if (this.contas.isEmpty()) return;
		this.contas.remove(conta);
		this.qtdContas--;
	}
	
	public void removeConta(int numero) {
		Conta conta;
		if (!contas.isEmpty()){
			Iterator<Conta> it = this.contas.iterator();
			
			while(it.hasNext()) {	
				conta= it.next();
				if (conta.getNumero()==numero) {
					this.removeConta(conta);
					break;
				}
			}
		}
	}
	

	

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return this.numero;
	}
	
	public Banco getBanco() {
		return this.banco;
	}
	
	public List<Conta> getContas(){
		return contas;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	public int getQtdContas() {
		return this.qtdContas;
	}

	// retorna o nome e numero da agencia em uma String
	@Override
	public String toString() {
		return ">\t " +  numero + "\t -  Agencia: " + nome;
	}
	
	// Imprime a lista de CONTAS pertencentes a essa AGENCIA
	public String listaContas() {
		String texto = "";
		texto += this.toString() + " (Número de Contas: " + this.getQtdContas() + ")\n";

		if(contas.isEmpty()) return texto; 
		
		for(Conta conta:contas) {
			texto+=">>\t\t\t"+conta.toString() + "\n";
		}
		return texto;
	}
	

	
}
