package bancoDominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;


public class SistemaBancario {
	
	private List<Banco> bancos;
	private Set<Cliente> clientes;
	private int numBancos;
	private int numClientes;

	// Construtor
	public SistemaBancario() {
		this.bancos = new ArrayList<>();
		this.clientes = new TreeSet<>();
		this.numBancos = 0;
	}
	
	// Retorna iterator de lista de bancos
	public Iterator<Banco> getIteratorListaBanco(){
		Iterator<Banco> it = bancos.iterator();
		return it;
	}
	
	// Retorna iterator de lista de clientes
	public Iterator<Cliente> getIteratorListaClientes(){
		Iterator<Cliente> it = clientes.iterator();
		return it;
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
	
	// Remove um banco da listagem de bancos do sistema bancário
	private void removeCliente(Cliente cliente) {
		this.clientes.remove(cliente);
		this.numClientes--;
	}
	
	
	// Adiciona um cliente ao sistema bancário
	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
		this.numClientes++;
	}
	
	public Banco getBanco(int codigo) {
		Iterator<Banco> it = bancos.iterator();
		Banco banco;
		if (bancos.isEmpty()) return null;
		while (it.hasNext()) {
			banco = it.next();
			if (banco.getNumero()==codigo) return banco;
		}
		return null;
	}

	public Cliente getCliente(String codigo) {
		Iterator<Cliente> it = clientes.iterator();
		Cliente cliente;
		if (clientes.isEmpty()) return null;
		while (it.hasNext()) {
			cliente = it.next();
			if (cliente.getIdentificador().equals(codigo)) return cliente;
		}
		return null;
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
	
	// Remove um cliente da listagem de clientes por meio de pesquisa do "identificador"
	public void removeCliente(String numero) {
		Cliente cliente;
		if (!clientes.isEmpty()){
			Iterator<Cliente> it = this.clientes.iterator();
			
			while(it.hasNext()) {	
				cliente = it.next();
				if (cliente.getIdentificador().equals(numero)) {
					this.removeCliente(cliente);
					break;
				}
			}
					
		}
	}
	
	// Encontra uma determinada agência no sistema bancario
	public Agencia encontraAgencia(int codigo) {
		Agencia agencia = null;
		for (Banco banco:bancos) {
			agencia = banco.getAgencia(codigo);
			if (agencia!=null) break;
		}
		return agencia;
	}
	
	
	
	// Apresenta o número de bancos cadastrados no sistema bancário
	public int getNumeroBancos() {
		return this.numBancos;
	}
	
	// Apresenta o número de Clientes cadastrados no sistema bancário
		public int getNumClientes() {
			return this.numClientes;
		}

		
	// listagem dos bancos que faz parte do sistema bancário 
		public String listaBancos() {
			
			String texto = "";
			
			// Verifica se a listagem de bancos está vazia
			if(bancos.isEmpty()) return "Este sistema bancário ainda não possui bancos cadastrados."; 
			
			texto += "\nSistema Bancário - Lista de Bancos \n";
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
		
		public String listaClientes() {
			String texto = "";
			
			if(clientes.isEmpty()) return "Este sistema bancário ainda não possui clientes cadastrados."; 
			
			texto += "\nClientes do Sistema Bancário\n";
			for(Cliente cliente:clientes) texto += cliente.toString().toUpperCase() + "\n";
				
			texto+= "Total de Clientes: " + this.getNumClientes() + "\n";
			
			return texto;
		}
		
	
}
