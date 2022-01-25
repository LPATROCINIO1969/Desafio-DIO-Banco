package bancoGUI;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import bancoDominio.Cliente;
import bancoDominio.SistemaBancario;

public class ClienteGUI {

	@SuppressWarnings("resource")
	public static void criarNovoCliente(SistemaBancario sistema) {
		
		String nome="";
		String tecla;
		String confirmacao="";
		String identificador="";
		String tipoPessoa="";
		boolean tipoCliente=true;
		Scanner leitura;
		Cliente cliente;
		
		// Limpa a tela
		try {
			LimpaConsole.limparTela();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, e);
		}		
		
		while (!confirmacao.toUpperCase().equals("S")||!confirmacao.toUpperCase().equals("N") ) {	
			String texto ="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tCadastro de Clientes\n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			System.out.print("\nNome do Cliente: ");
			leitura = new Scanner(System.in);
			nome = leitura.nextLine().toUpperCase();
			System.out.print("CPF/CNPJ: ");
			leitura = new Scanner(System.in);
			identificador = leitura.nextLine();

			while (!tipoPessoa.equals("F")  && !tipoPessoa.equals("J")) {
				System.out.print("\nPessoa Física ou Jurídica <F/J>? ");
				leitura = new Scanner(System.in);
				tipoPessoa = leitura.nextLine().toUpperCase();
				tipoCliente = (tipoPessoa.equals("F"));
			}
			
			System.out.print("Confirma? <S/N> ");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine();
		}
		
		if  (confirmacao.toUpperCase().equals("S")) {
			cliente = new Cliente(nome, identificador,tipoCliente);
			sistema.addCliente(cliente);
			System.out.println(cliente);
		}
		
		System.out.println("\n==================================================================================================\n");
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		tecla = leitura.nextLine();
		
	}
	
	
	
	
	@SuppressWarnings("resource")
	public static void pesquisar(SistemaBancario sistema) {
		String texto;
		String tecla;
		String confirmacao="S";
		String identificador;
		Scanner leitura;
		Cliente cliente;
		
		while (confirmacao.toUpperCase().equals("S")) {
			// Limpa a tela
			try {
				LimpaConsole.limparTela();
			} catch (IOException | InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
			}		
		
			
			texto ="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tPesquisa de Clientes\n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			System.out.print("Entre com o CPF/CNPJ do cliente: ");
			leitura = new Scanner(System.in);
			identificador = leitura.nextLine();
			
			// retorna dados de pesquisa
			cliente = sistema.getCliente(identificador);
			
			if (cliente!=null) {
				// Apresenta os dados relativos ao Cliente
				System.out.println("==================================================================================================");
				System.out.println(cliente.listaContas());
				System.out.println("==================================================================================================");
				System.out.print("Deseja fazer outra pesquisa? <S/N> ");
				leitura = new Scanner(System.in);
				confirmacao = leitura.nextLine();
			} else {
				System.out.println("Este cliente não está cadastrado.");
			}
				
		}
		
			
		System.out.println("==================================================================================================\n");
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		tecla = leitura.nextLine();	
		
		
	}
	
	
	@SuppressWarnings("resource")
	public static void excluiCliente(SistemaBancario sistema) {
		String texto;
		String tecla;
		String confirmacao="S";
		String identificador="";
		Scanner leitura;
		Cliente cliente;
		
		while (confirmacao.toUpperCase().equals("S")) {
			// Limpa a tela
			try {
				LimpaConsole.limparTela();
			} catch (IOException | InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
			}		
		
			
			texto ="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tExclusao de Clientes \n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			System.out.print("Entre com o Identificador do Cliente: ");
			leitura = new Scanner(System.in);
			identificador = leitura.nextLine();
			
			// retorna dados de pesquisa
			cliente = sistema.getCliente(identificador);
			
			// Verifica se o banco possui agências cadastradas. Neste caso, não permite a exclusão.
			if(cliente.getQtdContas()>0) {
				System.out.println("Este cliente não pode ser excluído, pois possui CONTAS cadastradas.");
			} else {
				System.out.print("Confirma Exclusão <S/N>?");
				leitura = new Scanner(System.in);
				confirmacao = leitura.nextLine().toUpperCase();
				if (confirmacao.equals("S")) {
					sistema.removeCliente(cliente.getIdentificador());
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
	
	@SuppressWarnings("resource")
	public static void atualizaCliente(SistemaBancario sistema) {
	
		String texto;
		String nome="";
		String tecla;
		String confirmacao="S";
		String identificador;
		Scanner leitura;
		Cliente cliente;
		
		while (confirmacao.toUpperCase().equals("S")) {
			// Limpa a tela
			try {
				LimpaConsole.limparTela();
			} catch (IOException | InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
			}		
		
			
			texto ="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tAtualização dos dados do Cliente\n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			System.out.print("Entre com o CPF/CNPJ do Cliente: ");
			leitura = new Scanner(System.in);
			identificador = leitura.nextLine();
			
			// retorna dados de pesquisa
			cliente = sistema.getCliente(identificador);
			
			
			// Apresenta os dados atuais do banco
			System.out.println(cliente);
			
			
			// Entra com os novos dados do banco
			System.out.println("==================================================================================================");
			System.out.println("Novos dados do Cliente");
			System.out.println("==================================================================================================");
			System.out.print("Entre com o novo CPF/CNPJ do cliente: ");
			leitura = new Scanner(System.in);
			identificador = leitura.nextLine();
			System.out.print("Entre com o novo nome do Cliente: ");
			leitura = new Scanner(System.in);
			nome = leitura.nextLine().toUpperCase();
			
			System.out.print("Confirma Alteração <S/N>?");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine().toUpperCase();
			if (confirmacao.equals("S")) {
				cliente.setNome(nome);
				cliente.setIdentificador(identificador);
				System.out.println("Alteração efetuada!");
			}
			
				
			System.out.print("Deseja efetuar outra Alteração <S/N>?");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine().toUpperCase();
		}
		System.out.println("\n==================================================================================================\n");
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		tecla = leitura.nextLine();	
		
	}
	
}
