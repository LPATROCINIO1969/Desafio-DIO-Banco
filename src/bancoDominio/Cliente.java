package bancoDominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Comparable<Cliente>{
	private String nome;
	private String identificador;	  // CPF - pessoa física ; CNPJ - Pessoa Jurídica 			   
	private boolean flagPessoaFisica; // V - pessoa Fisica; F - pessoa jurídica 
	private List<Conta> contas;
	private int qtdContas = 0;

		
	public Cliente(String nome, String cpf, boolean tipoPessoa) {
		this.nome = nome;
		this.identificador= cpf;
		this.flagPessoaFisica = tipoPessoa;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String ident) {
		this.identificador = ident;
	}

	public String tipoPessoa() {
		return ((this.flagPessoaFisica)?"PF":"PJ");
	}
	
	public boolean getFlagPessoaFisica() {
		return this.flagPessoaFisica;
	}
	
	public void addConta(Conta conta) {
		this.contas.add(conta);
		this.qtdContas++;
	}

	public void removeConta(Conta conta) {
		this.contas.remove(conta);
		this.qtdContas--;
	}
	
	public String listaContas() {
		String texto = "";
		texto += this.toString() + " (Número de contas: " + this.qtdContas + ")\n";

		if(contas.isEmpty()) {
			texto+= "\t Não possui contas cadastradas";
			return texto; 
		}
		
		for(Conta conta:contas) {
			texto+=conta.toString() + "\n";
		}
		return texto;
	}
	
	@Override
	public String toString() {
		return (">\t " + String.format("%-20s",this.nome)+ " - CPF/CNPJ = " + String.format("%20s",this.identificador) + "\t - Tipo: "+ this.tipoPessoa());
	}

	
	
	public int getQtdContas() {
		return qtdContas;
	}

	

	@Override
	public int compareTo(Cliente outroCliente) {
		return this.getNome().toUpperCase().compareTo(outroCliente.getNome().toUpperCase());
	}
	
	
}
