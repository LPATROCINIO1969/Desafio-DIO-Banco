package bancoDominio;

public class Cliente implements Comparable<Cliente>{
	private String nome;
	private String identificador;	  // CPF - pessoa física ; CNPJ - Pessoa Jurídica 			   
	private boolean flagPessoaFisica; // V - pessoa Fisica; F - pessoa jurídica 

		
	public Cliente(String nome, String cpf, boolean tipoPessoa) {
		this.nome = nome;
		this.identificador= cpf;
		this.flagPessoaFisica = tipoPessoa;
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
	
	@Override
	public String toString() {
		return (">\t " + String.format("%-30s",this.nome)+ " - CPF/CNPJ = " + String.format("%20s",this.identificador) + "\t - Tipo: "+ this.tipoPessoa());
	}

	
	@Override
	public int compareTo(Cliente outroCliente) {
		return this.getNome().toUpperCase().compareTo(outroCliente.getNome().toUpperCase());
	}
	
	
}
