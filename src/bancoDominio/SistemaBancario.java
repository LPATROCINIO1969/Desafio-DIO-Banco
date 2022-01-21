package bancoDominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class SistemaBancario {
	
	private List<Banco> bancos;
	private int numBancos;

	// Construtor
	public SistemaBancario() {
		this.bancos = new ArrayList<>();
		this.numBancos = 0;
	}

	// Adiciona um banco na listagem de bancos do sistema bancário
	public void addBanco(Banco novoBanco) {
		this.bancos.add(novoBanco);
		this.numBancos ++;
	}
		
	// Remove um banco da listagem de bancos do sistema bancário
	private void removeBanco(Banco novoBanco) {
		this.bancos.remove(novoBanco);
		this.numBancos--;
	}

	// Remove um banco da listagem de bancos por meio de pesquisa do "número do banco"
	public void removeBanco(int numeroBanco) {
		Banco banco;
		if (!bancos.isEmpty()){
			Iterator<Banco> it = this.bancos.iterator();
			
			while(it.hasNext()) {	
				banco = it.next();
				if (banco.getNumero()==numeroBanco) {
					this.removeBanco(banco);
					break;
				}
			}
					
		}
	}
	
	// Remove um banco da listagem de bancos por meio de pesquisa do "nome do banco"
	public void removeBanco(String nome) {
		Banco banco;
		if (!bancos.isEmpty()){
			Iterator<Banco> it = this.bancos.iterator();
			
			while(it.hasNext()) {	
				banco = it.next();
				if (banco.getNome().toUpperCase().equals(nome.toUpperCase())) this.removeBanco(banco);
			}
					
		}
	
	}

	
	// Apresenta o número de bancos cadastrados no sistema bancário
	public int getNumeroBancos() {
		return this.numBancos;
	}
	

		
	// listagem dos bancos que faz parte do sistema bancário 
		public String listaBancos() {
			
			String texto = "";
			
			// Verifica se a listagem de bancos está vazia
			if(bancos.isEmpty()) return "Este sistema bancário ainda não possui bancos cadastrados."; 
			
			texto += "Sistema Bancário: \n";
			for(Banco banco:bancos) {
				texto+=banco.toString() + "\n";
			}
				
			texto+= "Total de Bancos: " + this.getNumeroBancos() + "\n";
			return texto;
		}
	
	// listagem dos bancos e respectivas agências que fazem parte do sistema bancário 
		public String listaBancosAgencias() {
			String texto = "";
			
			if(bancos.isEmpty()) return "Este sistema bancário ainda não possui bancos cadastrados."; 
			
			texto += "Sistema Bancário: \n";
			for(Banco banco:bancos) texto += banco.listaAgencias();
				
			texto+= "Total de Bancos: " + this.getNumeroBancos() + "\n";
			return texto;
		}
		
	
}