package bancoGUI;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import bancoDominio.Agencia;
import bancoDominio.Banco;
import bancoDominio.SistemaBancario;

public class AgenciaGUI {

	
	@SuppressWarnings("resource")
	private static Banco listaAgenciaBanco(SistemaBancario sistema) {
		String texto ="";
		Scanner leitura;
		int numero;
		Banco banco;
		
		texto+= "\n==================================================================================================\n";
		texto+= "\t\t\t\t\tCadastro de Agencias \n";
		texto+= "==================================================================================================";
		System.out.println(texto);
		System.out.print("\nCódigo do Banco a qual pertence a nova Agencia: ");
		leitura = new Scanner(System.in);
		numero = leitura.nextInt();
		
		// busca o banco na lista de bancos
		banco = sistema.getBanco(numero);
		
		// Imprime lista de Agencias atuais
		System.out.println("==================================================================================================");
		System.out.println("Lista de agencias atuais");
		System.out.println(banco.listaAgencias());
		System.out.println("==================================================================================================");
		return banco;
	}
	
	
	@SuppressWarnings("resource")
	public static void criarNovo(SistemaBancario sistema) {
		
		String nome="";
		String confirmacao="";
		int numeroAgencia=0;
		Scanner leitura;
		Agencia agencia;
		Banco banco;
		
		// Limpa a tela
		try {
			LimpaConsole.limparTela();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, e);
		}		
		
		while (!confirmacao.toUpperCase().equals("S") && !confirmacao.toUpperCase().equals("N")  ) {	

			
			banco=listaAgenciaBanco(sistema);
			
			// Entrada de dados da nova agência
						
			System.out.print("\nNome da nova Agência: ");
			leitura = new Scanner(System.in);
			nome = leitura.nextLine().toUpperCase();
			
			System.out.print("Código da nova Agência: ");
			leitura = new Scanner(System.in);
			numeroAgencia = leitura.nextInt();
			System.out.print("Confirma? <S/N> ");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine();
			
			// armazena a agencia na lista do banco
			if  (confirmacao.toUpperCase().equals("S")) {
				agencia = new Agencia(nome, numeroAgencia,banco);
				banco.addAgencia(agencia);
				
				System.out.println(agencia);
			}
			
		}
		
		System.out.println("\n==================================================================================================\n");
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		leitura.nextLine();
		
	}
	
	
	@SuppressWarnings("resource")
	public static void listaAgencias(SistemaBancario sistema) {
		
		Scanner leitura;
				
		
		// Limpa a tela
		try {
				LimpaConsole.limparTela();
			} catch (IOException | InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
		}		
			
				
		listaAgenciaBanco(sistema);
		
		
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		
		leitura.nextLine();
	}
	
	 
	
	
	@SuppressWarnings("resource")
	public static void pesquisar(SistemaBancario sistema) {
		String texto;
		String confirmacao="S";
		int numero=0;
		Scanner leitura;
		Agencia agencia;
		
		
		
		while (confirmacao.toUpperCase().equals("S")) {

			// Limpa a tela
			try {
				LimpaConsole.limparTela();
			} catch (IOException | InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
			}		
		
			
			texto ="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tPesquisa de Agências\n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			System.out.print("Código da Agencia: ");
			leitura = new Scanner(System.in);
			numero = leitura.nextInt();
			System.out.println("==================================================================================================");
			
			// retorna os dados da agência pesquisada
			agencia = sistema.encontraAgencia(numero);
			
			if (agencia==null) {
				System.out.println(">>> Agência não cadastrada no Sistema Bancário.");
			}
			else {
				System.out.println("Banco: " + agencia.getBanco().getNumero()+ " - " + agencia.getBanco().getNome().toUpperCase() );
				System.out.println("Codigo da agencia: " + agencia.getNumero());
				System.out.println("Nome da agencia: " + agencia.getNome());
				System.out.println("Número de contas: " + agencia.getQtdContas());
			}
				

			System.out.println("==================================================================================================");
			System.out.print("Deseja fazer outra pesquisa? <S/N> ");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine();
				
		}
		
		
		System.out.println("==================================================================================================\n");
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		leitura.nextLine();	
		
		
	}
	
	
	@SuppressWarnings("resource")
	public static void excluir(SistemaBancario sistema) {
		String texto;
		String confirmacao="S";
		int numero=0;
		Scanner leitura;
		Agencia agencia;
		
		while (confirmacao.toUpperCase().equals("S")) {
			// Limpa a tela
			try {
				LimpaConsole.limparTela();
			} catch (IOException | InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
			}		
		
			
			texto ="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tExclusao de Bancos \n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			System.out.print("Entre com o Código da Agencia: ");
			leitura = new Scanner(System.in);
			numero = leitura.nextInt();
			
			// retorna dados de pesquisa
			agencia = sistema.encontraAgencia(numero);
			
			
			// verifica se a agência existe
			if (agencia==null) {
				System.out.println(">>> Agência não cadastrada no Sistema Bancário.");
			}
			else {
				System.out.println(agencia);	
				if(agencia.getQtdContas()>0) {
					System.out.println(">>\t Esta Agência não pode ser excluída, pois possui contas cadastradas.");
				} else {
					System.out.print("Confirma Exclusão <S/N>?");
					leitura = new Scanner(System.in);
					confirmacao = leitura.nextLine().toUpperCase();
					if (confirmacao.equals("S")) {
						agencia.getBanco().removeAgencia(numero);
						System.out.println("Exclusão efetuada!");
					}
				}
				
			}
			
							
			System.out.print("Deseja efetuar outra Exclusão <S/N>?");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine().toUpperCase();
		}
		System.out.println("\n==================================================================================================\n");
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		leitura.nextLine();	
			
	}
	
	@SuppressWarnings("resource")
	public static void atualizar(SistemaBancario sistema) {
	
		String texto;
		String nome="";
		String confirmacao="S";
		int numero=0;
		Scanner leitura;
		Agencia agencia;
		
		while (confirmacao.toUpperCase().equals("S")) {
			// Limpa a tela
			try {
				LimpaConsole.limparTela();
			} catch (IOException | InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
			}		
		
			
			texto ="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tAtualização dos dados da Agência \n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			System.out.print("Entre com o Código Atual da Agência: ");
			leitura = new Scanner(System.in);
			numero = leitura.nextInt();
			
			// retorna dados de pesquisa
			agencia = sistema.encontraAgencia(numero);
			
			if (agencia!=null) {
			
				// Apresenta os dados atuais da agencia
				System.out.println(agencia);
			
			
				// Entra com os novos dados do banco
				System.out.println("==================================================================================================");
				System.out.println("Novos dados da agencia");
				System.out.println("==================================================================================================");
				System.out.print("Entre com o novo Código da Agencia: ");
				leitura = new Scanner(System.in);
				numero = leitura.nextInt();
				System.out.print("Entre com o novo nome do Agencia: ");
				leitura = new Scanner(System.in);
				nome = leitura.nextLine().toUpperCase();
			
				System.out.print("Confirma Alteração <S/N>?");
				leitura = new Scanner(System.in);
				confirmacao = leitura.nextLine().toUpperCase();
				if (confirmacao.equals("S")) {
					agencia.setNumero(numero);
					agencia.setNome(nome);
					System.out.println("Alteração efetuada!");
				}
			} else {
				System.out.println(">>> Agência não cadastrada no Sistema Bancário.");
			}
			System.out.print("Deseja efetuar outra Alteração <S/N>?");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine().toUpperCase();
		}
		System.out.println("\n==================================================================================================\n");
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		leitura.nextLine();	
		
	}
	
	
}
