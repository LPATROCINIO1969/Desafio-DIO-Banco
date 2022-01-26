package bancoGUI;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import bancoDominio.*;

public class ContaGUI {

	@SuppressWarnings("resource")
	public static void criar(SistemaBancario sistema) {
		
		int codigoBanco;
		String codigoCliente;
		int codigoAgencia;
		String confirmacao="";
		String texto;
		String tipoConta;
	
		Scanner leitura;
		Conta conta;
		Banco banco;
		Agencia agencia;
		Cliente cliente;
		
		// Limpa a tela
		try {
			LimpaConsole.limparTela();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, e);
		}		
		
		while (!confirmacao.toUpperCase().equals("S") && !confirmacao.toUpperCase().equals("N")  ) {	
			conta = null;
			banco = null;
			agencia = null;
			cliente = null;
			tipoConta="";
			
			texto="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tCadastro de Contas \n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			
			
			// Entrada de dados da nova Conta
			System.out.print("\nCódigo do Banco: ");
			while (banco==null) {
				leitura = new Scanner(System.in);
				codigoBanco= leitura.nextInt();
				banco=sistema.getBanco(codigoBanco);
				if (banco==null) {
//					JOptionPane.showMessageDialog(null, "Erro: Banco Não Cadastrado. Tente novamente.");
					System.out.println(">>> Erro: Banco não cadastrado.");
				}
			}

			System.out.print("Código da agencia: ");			
			while (agencia==null) {
				leitura = new Scanner(System.in);
				codigoAgencia= leitura.nextInt();
				agencia=banco.getAgencia(codigoAgencia);
				if (agencia==null) {
					//JOptionPane.showMessageDialog(null, "Erro: Agência Não Cadastrada. Tente novamente.");
					System.out.println(">>> Erro: Agência não cadastrada.");
				}
			}

			System.out.print("CPF/CNPJ do cliente: ");			
			while (cliente==null) {
				leitura = new Scanner(System.in);
				codigoCliente= leitura.nextLine();
				cliente=sistema.getCliente(codigoCliente);
				if (agencia==null) {
//					JOptionPane.showMessageDialog(null, "Erro: Cliente Não Cadastrado. Tente novamente.");
					System.out.println(">>> Erro: Cliente não cadastrado.");
				}
			}
			
			System.out.println("\nTipo de Conta: ");
			System.out.println("[C] Conta Corrente ");
			System.out.println("[P] Conta Poupança ");
			System.out.print(">> Opção: ");
			while (!tipoConta.toUpperCase().equals("C") && !tipoConta.toUpperCase().equals("P") )
			{
				leitura = new Scanner(System.in);
				tipoConta= leitura.nextLine();
				if (!tipoConta.toUpperCase().equals("C") && !tipoConta.toUpperCase().equals("P") ) {
					//JOptionPane.showMessageDialog(null, "Aviso: Digite C ou P");
					System.out.println("erro");
				}
			}
			
			System.out.println("");
			System.out.print("Confirma cadastro da nova conta? <S/N> ");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine();
			
			// armazena a conta na lista de contas da agência
			if  (confirmacao.toUpperCase().equals("S")) {
			
				// Cria o objeto adequado para armazenar a nova conta
				if (tipoConta.toUpperCase().equals("C"))	{
					conta = new ContaCorrente(cliente,agencia);
				} else {
					conta = new ContaPoupanca(cliente,agencia);
				}

				// Apresenta os dados da nova conta para confirmação
				System.out.println("\n==================================================================================================");
				System.out.println("Dados da nova conta:");
				System.out.println(banco);
				System.out.println(agencia);
				System.out.println(cliente);
				System.out.println("> \t Conta: " + conta.getNumero() + " - Tipo de conta: " + conta.getTipoConta());
				System.out.println("\n==================================================================================================");
				System.out.println("\nConta cadastrada!");
			}
			
		}
		
		System.out.println("\n==================================================================================================\n");
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		leitura.nextLine();
		
	}
	
	@SuppressWarnings("resource")
	public static void listar(SistemaBancario sistema) {
		
		Scanner leitura;
		String texto;		
		
		// Limpa a tela
		try {
				LimpaConsole.limparTela();
			} catch (IOException | InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
		}		
			
		texto="";
		texto+= "\n==================================================================================================\n";
		texto+= "\t\t\t\t\tListagem de Contas \n";
		texto+= "==================================================================================================";
		System.out.println(texto);
		System.out.println(sistema.listaContas());
		System.out.println("==================================================================================================");
		
		
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		
		leitura.nextLine();
	}
	
	
	@SuppressWarnings("resource")
	public static void pesquisar(SistemaBancario sistema) {
		String texto;
		String tecla;
		String confirmacao="S";
		int identificador;
		Scanner leitura;
		Conta conta;
		
		while (confirmacao.toUpperCase().equals("S")) {
			// Limpa a tela
			try {
				LimpaConsole.limparTela();
			} catch (IOException | InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
			}		
		
			
			texto ="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tPesquisa de Contas\n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			System.out.print("Entre com o número da Conta: ");
			leitura = new Scanner(System.in);
			identificador = leitura.nextInt();
			
			// retorna dados de pesquisa
			conta = sistema.encontraConta(identificador);
			
			if (conta!=null) {
				// Apresenta os dados relativos ao Cliente
				System.out.println("==================================================================================================");
				System.out.println(conta.dadosConta());
				System.out.println("==================================================================================================");
				System.out.print("Deseja fazer outra pesquisa? <S/N> ");
				leitura = new Scanner(System.in);
				confirmacao = leitura.nextLine();
			} else {
				System.out.println("Este Conta não está cadastrada.");
			}
				
		}
		
			
		System.out.println("==================================================================================================\n");
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		tecla = leitura.nextLine();	
		
		
	}
	
	@SuppressWarnings("resource")
	public static void excluir(SistemaBancario sistema) {
		String texto;
		String tecla;
		String confirmacao="S";
		int identificador;
		Scanner leitura;
		Conta conta;
		
		while (confirmacao.toUpperCase().equals("S")) {
			// Limpa a tela
			try {
				LimpaConsole.limparTela();
			} catch (IOException | InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
			}		
		
			
			texto ="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tExclusao de Conta \n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			System.out.print("Entre com o número da Conta: ");
			leitura = new Scanner(System.in);
			identificador = leitura.nextInt();
			
			// retorna dados de pesquisa
			conta = sistema.encontraConta(identificador);
						
			if (conta==null) {
				System.out.println(">>> Esta CONTA não está cadastrada no Sistema Bancário.");
				return;
			} else {
				System.out.println(conta);
			}
			
			// Verifica se a conta possui movimentações cadastradas. Neste caso, não permite a exclusão.
			if(!conta.getTransacoes().isEmpty()) {
				System.out.println(">>> Esta CONTA não pode ser excluída, pois possui movimentações cadastradas.");
			} else {
				System.out.print("Confirma Exclusão <S/N>?");
				leitura = new Scanner(System.in);
				confirmacao = leitura.nextLine().toUpperCase();
				if (confirmacao.equals("S")) {
					conta.excluir();
					System.out.println("Exclusão efetuada!");
				}
			}
				
			System.out.print("Deseja efetuar outra Exclusão <S/N>?");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine().toUpperCase();
		}
		System.out.println("\n==================================================================================================\n");
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		tecla = leitura.nextLine();	
			
	}
	
	
	
	
	
}
