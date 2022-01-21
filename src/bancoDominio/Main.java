package bancoDominio;

public class Main {

	public static void main(String[] args) {
		/*
		 * Cliente cliente1 = new Cliente(); cliente1.setNome("João da Silva"); Cliente
		 * cliente2 = new Cliente(); cliente2.setNome("Maria do Carmo");
		 * 
		 * 
		 * Conta cc = new ContaCorrente(cliente1); Conta cp = new
		 * ContaPoupanca(cliente2);
		 * 
		 * cc.depositar(200); cc.transferir(50, cp);
		 * 
		 * cc.imprimirExtrato(); cp.imprimirExtrato();
		 */
		
		
		// Teste de inclusão de bancos no sistema bancário e emissão de listagem de bancos
		SistemaBancario sistema = new SistemaBancario();
		Banco novoBanco = new Banco("Santander", 109);
		novoBanco.addAgencia(new Agencia("Praia da Costa", 1090));
		novoBanco.addAgencia(new Agencia("Centro", 1095));
		novoBanco.addAgencia(new Agencia("Ibes", 1093));
		
			
		sistema.addBanco(novoBanco);
		sistema.addBanco(new Banco("Banco do Brasil", 100));
		sistema.addBanco(new Banco("Banco Itaú", 300));
		System.out.println(sistema.listaBancos());

		System.out.println(sistema.listaBancosAgencias());
		novoBanco.removeAgencia(1090);
		System.out.println(sistema.listaBancosAgencias());
		
		// Teste de remoção do banco da lista de bancos do sistema bancário
		sistema.removeBanco(100);
		System.out.println(sistema.listaBancos());
		sistema.removeBanco("Santander");
		System.out.println(sistema.listaBancos());
		
		
	}
	
	

}
