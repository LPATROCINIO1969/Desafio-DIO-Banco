package bancoGUI;

import java.util.Scanner;

import bancoDominio.*;

public class AcessoClienteGUI {
	
	private static Cliente usuario;

	// Aprova o acesso do usuário ao 
	@SuppressWarnings("resource")
	public static boolean iniciarAcesso(SistemaBancario sistema) {
		String texto="";
		Scanner leitura;
		String identificador;

		texto+= "\n==================================================================================================\n";
		texto+= "\t\t\t\t\tAcesso do Cliente\n";
		texto+= "=================================================================================================="; 
		System.out.println(texto);
		System.out.print("Entre com o seu CPF/CNPJ: ");
		leitura = new Scanner(System.in);
		identificador = leitura.nextLine();
		
		texto = "=================================================================================================="; 
		System.out.println(texto);
		
		// localizando o cliente
		usuario = sistema.getCliente(identificador);
		
		if (usuario == null) {
			System.out.println(">>> Cliente não cadastrado no sistema bancário");
			return false;
		} else {
			System.out.println("\nBem vindo(a), Sr(a). " + usuario.getNome() + "!");
			System.out.println(">>> Acesso concedido.");
			texto = "=================================================================================================="; 
			System.out.println(texto);
			return true;
		}
	}
	
	
	// Encerra o acesso ao menu de operações do cliente
	public static void encerrarAcesso() {
		usuario=null;
	}
	
	
	// Lista as contas do cliente
	@SuppressWarnings("resource")
	public static void listarContas(SistemaBancario sistema) {

		String texto="";
		Scanner leitura;
		

		texto+= "\n==================================================================================================\n";
		texto+= "\t\t\t\t\tRelatório de Contas do Cliente\n";
		texto+= "=================================================================================================="; 
		System.out.println(texto);
		System.out.println(usuario.listaContas());
		texto = "=================================================================================================="; 
		System.out.println(texto);

		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		leitura.nextLine();	
		
	}
	
	// Retorna a idenficação do cliente que está usando o sistema
	public static Cliente getUsuario() {
		return usuario;
	}
	
	
	// Efetua a operação de depósito bancário
	@SuppressWarnings("resource")
	public static void depositar(SistemaBancario sistema) {
		String texto="";
		Scanner leitura;
		int numero;
		double valor;
		Conta conta;
		String confirmacao;
		
		
		texto+= "\n==================================================================================================\n";
		texto+= "\t\t\t\t\tDepósito em conta\n";
		texto+= "=================================================================================================="; 
		System.out.println(texto);
		System.out.println(usuario.listaContas());
		texto = "=================================================================================================="; 
		System.out.println(texto);
		
		System.out.print("Identifique o número da conta para depósito: ");
		leitura = new Scanner(System.in);
		numero = leitura.nextInt();

		System.out.print("Digite o valor a ser depositado: ");
		leitura = new Scanner(System.in);
		valor = Double.parseDouble(leitura.next());

		// localiza a conta
		conta = usuario.getConta(numero);		
		
		// verifica se a conta é válida 
		if (conta != null) {
			System.out.print("Confirma o depósito? <S/N> ");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine();
			if (confirmacao.toUpperCase().equals("S")) {
				conta.depositar(valor);
				System.out.println(">>> Depósito efetuado!");
			}
			
		} else {
			System.out.println(">>> Conta não encontrada no sistema bancário");
		}
		
		// Efetua a operação de depósito na conta
		texto = "=================================================================================================="; 
		System.out.println(texto);
		
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		leitura.nextLine();	
	}
	
	// Efetua a operação de saque bancário
	@SuppressWarnings("resource")
	public static void sacar(SistemaBancario sistema) {
		String texto="";
		Scanner leitura;
		int numero;
		double valor;
		Conta conta;
		String confirmacao;
		
		
		texto+= "\n==================================================================================================\n";
		texto+= "\t\t\t\t\tEfetuar Saque em conta\n";
		texto+= "=================================================================================================="; 
		System.out.println(texto);
		System.out.println(usuario.listaContas());
		texto = "=================================================================================================="; 
		System.out.println(texto);
		
		System.out.print("Identifique o número da conta para saque: ");
		leitura = new Scanner(System.in);
		numero = leitura.nextInt();

		System.out.print("Digite o valor a ser sacado: ");
		leitura = new Scanner(System.in);
		valor = Double.parseDouble(leitura.next());

		// localiza a conta
		conta = usuario.getConta(numero);		
		
		// verifica se a conta é válida 
		if (conta != null) {
			System.out.print("Confirma o saque? <S/N> ");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine();
			if (confirmacao.toUpperCase().equals("S")) {
				conta.sacar(valor);
				System.out.println(">>> Saque efetuado!");
			}
			
		} else {
			System.out.println(">>> Conta não encontrada no sistema bancário");
		}
		
		// Efetua a operação de depósito na conta
		texto = "=================================================================================================="; 
		System.out.println(texto);
		
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		leitura.nextLine();	
	}
	
	// Efetua a operação de saque bancário
		@SuppressWarnings("resource")
		public static void transferir(SistemaBancario sistema) {
			String texto="";
			Scanner leitura;
			int numeroOrigem, numeroDestino;
			double valor;
			Conta contaOrigem, contaDestino;
			String confirmacao;
			
			
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tTransferência entre contas\n";
			texto+= "=================================================================================================="; 
			System.out.println(texto);
			System.out.println(usuario.listaContas());
			texto = "=================================================================================================="; 
			System.out.println(texto);
			
			System.out.print("Digite o número da conta origem da transferência: ");
			leitura = new Scanner(System.in);
			numeroOrigem = leitura.nextInt();
			
			System.out.print("Digite o número da conta destino da transferência: ");
			leitura = new Scanner(System.in);
			numeroDestino = leitura.nextInt();

			System.out.print("Digite o valor a ser transferido: ");
			leitura = new Scanner(System.in);
			valor = Double.parseDouble(leitura.next());

					
			
			// localiza as contas
			contaOrigem  = usuario.getConta(numeroOrigem);		
			contaDestino = sistema.encontraConta(numeroDestino);
			
			texto = "=================================================================================================="; 
			System.out.println(texto);
			System.out.println ("Transferência do valor: " + String.format("%.2f",valor));
			System.out.println("De:  \t" + contaOrigem);
			System.out.println("Para:\t" + contaDestino);
			System.out.println(texto);
			
			
			
			// verifica se a conta é válida e efetua a operação de transferência
			if ((contaOrigem != null) && (contaDestino != null)) {
				System.out.print("Confirma a transferência? <S/N> ");
				leitura = new Scanner(System.in);
				confirmacao = leitura.nextLine();
				if (confirmacao.toUpperCase().equals("S")) {
					contaOrigem.transferir(valor, contaDestino);
					System.out.println(">>> Transferência efetuada!");
				}
				
			} else {
				System.out.println(">>> Conta(s) não encontrada(s) no sistema bancário");
			}
			
		
			texto = "=================================================================================================="; 
			System.out.println(texto);
			
			System.out.println("Aperte qualquer tecla para continuar...");
			leitura = new Scanner(System.in);
			leitura.nextLine();	
		}
	
		
		// Produz um relatório da movimentação de uma determinada conta
		@SuppressWarnings("resource")
		public static void emitirExtrato(SistemaBancario sistema) {
			String texto="";
			Scanner leitura;
			int numero;
			Conta conta;
			String confirmacao;
			
			
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tEmissão de Extrato da Conta\n";
			texto+= "=================================================================================================="; 
			System.out.println(texto);
			System.out.println(usuario.listaContas());
			texto = "=================================================================================================="; 
			System.out.println(texto);

			System.out.print("Digite o número da conta: ");
			leitura = new Scanner(System.in);
			numero = leitura.nextInt();
			
			// localiza a conta
			conta = usuario.getConta(numero);	
			
			
			// verifica se a conta é válida e efetua a emissão do extrato
			if (conta != null) {
				System.out.print("Confirma a emissão do extrato? <S/N> ");
				leitura = new Scanner(System.in);
				confirmacao = leitura.nextLine();
				if (confirmacao.toUpperCase().equals("S")) {
					texto = "=================================================================================================="; 
					System.out.println(texto);		
					System.out.println(conta.emitirExtrato());
					System.out.println(">>> Extrato emitido!");
				}
				
			} else {
				System.out.println(">>> Conta(s) não encontrada(s) no sistema bancário");
			}
			
		
			texto = "=================================================================================================="; 
			System.out.println(texto);
			
			System.out.println("Aperte qualquer tecla para continuar...");
			leitura = new Scanner(System.in);
			leitura.nextLine();	
			
			
		}
		
	
}
