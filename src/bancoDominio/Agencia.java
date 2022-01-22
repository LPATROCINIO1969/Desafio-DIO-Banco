package bancoDominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Agencia {

	private String nome;
	private int numero;
	private List<Conta> contas;
	private int qtdContas;
	
	
	public Agencia() {
		this.contas = new ArrayList<>();
		this.qtdContas= 0;
	}
	
	public Agencia(String nome, int numero) {
		this();
		this.nome = nome;
		this.numero = numero;
	}
	
	
	public void addConta(Conta novaConta) {
		this.contas.add(novaConta);
		this.qtdContas++;
	}
	
	private void removeConta(Conta conta) {
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
		return numero;
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
		return ">>\t " +  numero + "\t -  Agencia: " + nome;
	}
	
	// Imprime a lista de CONTAS pertencentes a essa AGENCIA
	public String listaContas() {
		String texto = "";
		texto += this.toString() + " (Número de Contas: " + this.getQtdContas() + ")\n";

		if(contas.isEmpty()) return texto; 
		
		for(Conta conta:contas) {
			texto+=conta.toString() + "\n";
		}
		return texto;
	}
	
		
	
	
	
	
}
