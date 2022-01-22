package bancoDominio;

public class Main {

	public static void main(String[] args) {
				
		// Popular o sistema 
		
		SistemaBancario sistema = new SistemaBancario();
		
		Banco banco1 = new Banco("Santander", 109);
		sistema.addBanco(banco1);
		Agencia agencia1= new Agencia("Praia da Costa", 1090);
		Agencia agencia2= new Agencia("Centro", 1091);
		Agencia agencia3= new Agencia("Ibes", 1092);
		banco1.addAgencia(agencia1);
		banco1.addAgencia(agencia2);
		banco1.addAgencia(agencia3);
		Cliente cliente1 = new Cliente("João da Silva", "334.500.871-23", true);
		Cliente cliente2 = new Cliente("Maria Helena",  "923.759.343-44", true);
		Cliente cliente3 = new Cliente("Pandaria Dengosa", "88.112.221.0001-39", false);
		sistema.addCliente(cliente1);
		sistema.addCliente(cliente2);
		sistema.addCliente(cliente3);
		Conta conta1 = new ContaCorrente(cliente1,agencia2);
		Conta conta2 = new ContaPoupanca(cliente2,agencia2);
		Conta conta3 = new ContaCorrente(cliente3,agencia1);
		Conta conta4 = new ContaPoupanca(cliente2,agencia3);
		System.out.println(agencia1.listaContas());
		System.out.println(agencia2.listaContas());
		System.out.println(agencia3.listaContas());
		
		
		
		banco1 = new Banco("Banco do Brasil", 100);
		sistema.addBanco(banco1);
		agencia1= new Agencia("Jardim America", 1000);
		agencia2= new Agencia("Praia do Suá", 1001);
		agencia3= new Agencia("Terra Vermelha", 1002);
		banco1.addAgencia(agencia1);
		banco1.addAgencia(agencia2);
		banco1.addAgencia(agencia3);
		cliente1 = new Cliente("Herber Viana", "993.223.567-23", true);
		cliente2 = new Cliente("Viviane Almeida",  "823.789.343-44", true);
		cliente3 = new Cliente("Livraria Veneza", "99.112.221.0001-49", false);
		sistema.addCliente(cliente1);
		sistema.addCliente(cliente2);
		sistema.addCliente(cliente3);
		conta1 = new ContaCorrente(cliente1,agencia2);
		conta2 = new ContaPoupanca(cliente2,agencia2);
		conta3 = new ContaCorrente(cliente3,agencia1);
		conta4 = new ContaPoupanca(cliente2,agencia3);
		System.out.println(agencia1.listaContas());
		System.out.println(agencia2.listaContas());
		System.out.println(agencia3.listaContas());
		
		
//		System.out.println(sistema.listaBancos());
//		System.out.println(sistema.listaBancosAgencias());
//		System.out.println(sistema.listaClientes());
		
		

		/*ystem.out.println(sistema.listaBancosAgencias());
		novoBanco.removeAgencia(1090);
		System.out.println(sistema.listaBancosAgencias());
		
		// Teste de remoção do banco da lista de bancos do sistema bancário
		sistema.removeBanco(100);
		System.out.println(sistema.listaBancos());
		sistema.removeBanco("Santander");
		System.out.println(sistema.listaBancos());*/
		
		
	}
	
	

}
