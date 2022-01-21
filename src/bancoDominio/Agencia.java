package bancoDominio;

import java.util.ArrayList;
import java.util.List;



public class Agencia {

	private String nome;
	private int numero;
	private List<Conta> contas;
	private int qtdContas;
	
	// Construtores recebendo (ou não) o nome e número da agência
	public Agencia() {
		this.contas = new ArrayList<>();
		this.qtdContas= 0;
	}
	
	public Agencia(String nome, int numero) {
		this();
		this.nome = nome;
		this.numero = numero;
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

	// retorna o nome e numero da agencia em uma String
	@Override
	public String toString() {
		return ">>\t " +  numero + "\t -  Agencia: " + nome;
	}
	
	// Imprime a lista de CONTAS pertencentes a essa AGENCIA
	public String listaContas() {
		String texto="";
		// TO DO 
		return texto;
	}
	
		
	
	
	
	
}
