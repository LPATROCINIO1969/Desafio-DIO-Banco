package banco;

public class Main {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente();
		cliente1.setNome("João da Silva");
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Maria do Carmo");
		
		
		Conta cc = new ContaCorrente(cliente1);
		Conta cp = new ContaPoupanca(cliente2);
		
		cc.depositar(200);
		cc.transferir(50, cp);
		
		cc.imprimirExtrato();
		cp.imprimirExtrato(); 
	}

}
