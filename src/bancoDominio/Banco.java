package bancoDominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco implements Comparable<Banco>{
	private String nome;
	private int numero;
	private List<Agencia> agencias;
	private int numAgencia;
	
		
	public Banco() {
		this.agencias = new ArrayList<>();
		this.numAgencia=0;
	}
	
	public Banco(String nome, int numero) {
		this();
		this.nome = nome;
		this.numero = numero;
	}
	
	
	public void addAgencia(Agencia novaAgencia) {
		this.agencias.add(novaAgencia);
		this.numAgencia++;
		
	}
	
	
	public int getNumeroAgencias() {
		return this.numAgencia;
	}
	
	private void removeAgencia(Agencia Agencia) {
		this.agencias.remove(Agencia);
		this.numAgencia--;
	}
	
	public void removeAgencia(int numeroAgencia) {
		Agencia agencia;
		if (!agencias.isEmpty()){
			Iterator<Agencia> it = this.agencias.iterator();
			
			while(it.hasNext()) {	
				agencia = it.next();
				if (agencia.getNumero()==numeroAgencia) {
					this.removeAgencia(agencia);
					break;
				}
			}
					
		}
	}
	
	public void removeAgencia(String nome) {
		Agencia agencia;
		if (!agencias.isEmpty()){
			Iterator<Agencia> it = this.agencias.iterator();
			
			while(it.hasNext()) {	
				agencia= it.next();
				if (agencia.getNome().toUpperCase().equals(nome.toUpperCase())) this.removeAgencia(agencia);
			}
		}
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numBanco) {
		this.numero = numBanco;
	}
	
	public Agencia getAgencia(int codigo) {
		for (Agencia agencia:this.agencias) {
			if (agencia.getNumero()== codigo)return agencia;
		}
		
		return null;
	}
	
	
	@Override
	public String toString() {
		return ">\t " +  numero + "\t -  Banco: " + nome;
	}
	
	public String listaAgencias() {
		String texto = "";
		texto += String.format("%-40s",this.toString()) + " (Número de agências: " + this.getNumeroAgencias() + ")\n";

		if(agencias.isEmpty()) return texto; 
		
		for(Agencia agencia:agencias) {
			texto+=agencia.toString() + "\n";
		}
		return texto;
	}

	@Override
	public int compareTo(Banco outroBanco) {
		if (this.getNumero() > outroBanco.getNumero()) return 1;
		else if (this.getNumero() < outroBanco.getNumero()) return -1;
		return 0;
	}
	
	// Retorna iterator de lista de agencias
		public Iterator<Agencia> getIteratorListaAgencia(){
			Iterator<Agencia> it = agencias.iterator();
			return it;
		}
	
}
