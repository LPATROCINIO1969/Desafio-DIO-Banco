package bancoGUI;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import bancoDominio.Banco;
import bancoDominio.SistemaBancario;

public class BancoGUI {

	
	
	@SuppressWarnings("resource")
	public static void criarNovo(SistemaBancario sistema) {
		
		String nome="";
		String tecla;
		String confirmacao="";
		int numero=0;
		Scanner leitura;
		Banco banco;
		
		// Limpa a tela
		try {
			LimpaConsole.limparTela();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, e);
		}		
		
		while (!confirmacao.toUpperCase().equals("S")||!confirmacao.toUpperCase().equals("N") ) {	
			String texto ="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tCadastro de Bancos \n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			System.out.print("\nNome do Banco: ");
			leitura = new Scanner(System.in);
			nome = leitura.nextLine().toUpperCase();
			System.out.print("Código do Banco: ");
			leitura = new Scanner(System.in);
			numero = leitura.nextInt();
			System.out.print("Confirma? <S/N> ");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine();
		}
		
		if  (confirmacao.toUpperCase().equals("S")) {
			banco = new Banco(nome, numero);
			sistema.addBanco(banco);
			System.out.println(banco);
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
		int numero=0;
		Scanner leitura;
		Banco banco;
		
		while (confirmacao.toUpperCase().equals("S")) {
			// Limpa a tela
			try {
				LimpaConsole.limparTela();
			} catch (IOException | InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
			}		
		
			
			texto ="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tPesquisa de Bancos \n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			System.out.print("Entre com o Código do Banco: ");
			leitura = new Scanner(System.in);
			numero = leitura.nextInt();
			
			// retorna dados de pesquisa
			banco = sistema.getBanco(numero);
			
			if (banco!=null) {
				// Apresenta os dados relativos ao banco
				System.out.println("==================================================================================================");
				System.out.println(banco.listaAgencias());
				System.out.println("==================================================================================================");
				System.out.print("Deseja fazer outra pesquisa? <S/N> ");
				leitura = new Scanner(System.in);
				confirmacao = leitura.nextLine();
			} else {
				System.out.println("Este banco não está cadastrado.");
			}
				
		}
		
		
		System.out.println("\n==================================================================================================\n");
		System.out.println("Aperte qualquer tecla para continuar...");
		leitura = new Scanner(System.in);
		tecla = leitura.nextLine();	
		
		
	}
	
	
	@SuppressWarnings("resource")
	public static void excluir(SistemaBancario sistema) {
		String texto;
		String tecla;
		String confirmacao="S";
		int numero=0;
		Scanner leitura;
		Banco banco;
		
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
			System.out.print("Entre com o Código do Banco: ");
			leitura = new Scanner(System.in);
			numero = leitura.nextInt();
			
			// retorna dados de pesquisa
			banco = sistema.getBanco(numero);
			
			// Verifica se o banco possui agências cadastradas. Neste caso, não permite a exclusão.
			if(banco.getNumeroAgencias()>0) {
				System.out.println("Este banco não pode ser excluído, pois possui AGÊNCIAS cadastradas.");
			} else {
				System.out.print("Confirma Exclusão <S/N>?");
				leitura = new Scanner(System.in);
				confirmacao = leitura.nextLine().toUpperCase();
				if (confirmacao.equals("S")) {
					sistema.removeBanco(banco.getNumero());
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
	public static void atualizar(SistemaBancario sistema) {
	
		String texto;
		String nome="";
		String tecla;
		String confirmacao="S";
		int numero=0;
		Scanner leitura;
		Banco banco;
		
		while (confirmacao.toUpperCase().equals("S")) {
			// Limpa a tela
			try {
				LimpaConsole.limparTela();
			} catch (IOException | InterruptedException e) {
				JOptionPane.showMessageDialog(null, e);
			}		
		
			
			texto ="";
			texto+= "\n==================================================================================================\n";
			texto+= "\t\t\t\t\tAtualização dos dados do Banco \n";
			texto+= "==================================================================================================";
			System.out.println(texto);
			System.out.print("Entre com o Código Atual do Banco: ");
			leitura = new Scanner(System.in);
			numero = leitura.nextInt();
			
			// retorna dados de pesquisa
			banco = sistema.getBanco(numero);
			
			
			// Apresenta os dados atuais do banco
			System.out.println(banco);
			
			
			// Entra com os novos dados do banco
			System.out.println("==================================================================================================");
			System.out.println("Novos dados do Banco");
			System.out.println("==================================================================================================");
			System.out.print("Entre com o novo Código do Banco: ");
			leitura = new Scanner(System.in);
			numero = leitura.nextInt();
			System.out.print("Entre com o novo nome do Banco: ");
			leitura = new Scanner(System.in);
			nome = leitura.nextLine().toUpperCase();
			
			System.out.print("Confirma Alteração <S/N>?");
			leitura = new Scanner(System.in);
			confirmacao = leitura.nextLine().toUpperCase();
			if (confirmacao.equals("S")) {
				banco.setNumero(numero);
				banco.setNome(nome);
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
