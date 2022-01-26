package bancoGUI;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import bancoDominio.*;

public class GestaoMenus {
	
	SistemaBancario sistema;
	
		
	public GestaoMenus(SistemaBancario sistema) {
		this.sistema = sistema;
	}

	public void exibeMenuSistemaBancario() {
		int opcao=0;
		Scanner leitura; 
		String texto;
		
		while (opcao!=3) {
		
		texto = "";
			
		// Limpa a tela
		try {
			LimpaConsole.limparTela();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
						
				
		
		// Definição do layout do menu 
		texto+= "\n== Sistema Bancário ==\n\n";
		texto+= "Bem vindo(a) ao sistema. Escolha a opção desejada\n";
		texto+= "1 - Administrar o sistema\n";
		texto+= "2 - Acessar como cliente\n";
		texto+= "3 - Sair\n";
		texto+= "Sua opção: ";
		
		// Impressão do menu
		System.out.print(texto);
		
		
		// Entrada do valor da opção
		do {
			leitura = new Scanner(System.in);
			opcao = leitura.nextInt();
		} while(opcao>3 || opcao<1);
		
		
		switch (opcao) {
		case 1:
			exibeMenuAdministracaoSistema();
			break;
		case 2:
			if(AcessoClienteGUI.iniciarAcesso(sistema)) exibeMenuAcessoCliente();
			break;
			
		case 3: 
			System.out.println("\n\n >>> Sistema Finalizado!");
			return;		
		
		}
		}
	}
	
	public void exibeMenuAdministracaoSistema() {
		
		int opcao=0;
		Scanner leitura; 
		String texto;
		
		while (opcao!=5) {
			
		texto = "";	
			
		// Limpa a tela
		try {
			LimpaConsole.limparTela();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		// Definição do layout do menu 
		texto+= "\n== Administração do Sistema ==\n\n";
		texto+= "Escolha a opção desejada\n";
		texto+= "1 - Gerenciar Bancos\n";
		texto+= "2 - Gerenciar Clientes\n";
		texto+= "3 - Gerenciar Agencias\n";
		texto+= "4 - Gerenciar Contas\n";
		texto+= "5 - Voltar ao menu anterior\n";
		texto+= "6 - Sair\n";
		texto+= "Sua opção: ";
		
		// Impressão do menu
		System.out.print(texto);
		
		
		// Entrada do valor da opção
		do {
			leitura = new Scanner(System.in);
			opcao = leitura.nextInt();
		} while(opcao>6 || opcao<1);
		
		
		switch (opcao) {
		case 1:
			exibeMenuGerenciarBancos();
			break;
		case 2:
			exibeMenuGerenciarPessoas();
			break;
		case 3: 
			exibeMenuGerenciarAgencias();
			break;
		case 4: 
			exibeMenuGerenciarContas();
			break;
		case 5:
			return;
		case 6:
			System.out.println("\n\n >>> Sistema Finalizado!");
			System.exit(0);
			return;
			
		}		
		}
		
	}
	
	public void exibeMenuGerenciarAgencias() {
		int opcao=0;
		Scanner leitura;
		String texto;
		
		while (opcao!=6) {
			
		texto = "";
			
		// Limpa a tela
		try {
			LimpaConsole.limparTela();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		
		// Definição do layout do menu 
		texto+= "\n== Gerenciar Agências ==\n\n";
		texto+= "Escolha a opção desejada\n";
		texto+= "1 - Nova Agência\n";
		texto+= "2 - Listar Agências\n";
		texto+= "3 - Pesquisar Agências\n";
		texto+= "4 - Excluir Agência\n";
		texto+= "5 - Atualizar Agência\n";
		texto+= "6 - Voltar ao menu anterior\n";
		texto+= "7 - Sair\n";
		texto+= "Sua opção: ";
		
		// Impressão do menu
		System.out.print(texto);
		
		
		// Entrada do valor da opção
		do {
			leitura = new Scanner(System.in);
			opcao = leitura.nextInt();
		} while(opcao>7 || opcao<1);
		
		
		switch (opcao) {
		case 1:
			AgenciaGUI.criarNovo(sistema);
			break;
		case 2:
			AgenciaGUI.listaAgencias(sistema);
			break;
		case 3: 
			AgenciaGUI.pesquisar(sistema);
			break;
		case 4: 
			AgenciaGUI.excluir(sistema);
			break;
		case 5:
			AgenciaGUI.atualizar(sistema);
			break;
		case 6:
			return;
		case 7:
			System.out.println("\n\n >>> Sistema Finalizado!");
			System.exit(0);
			return;
		
		}
		}
		
	}

	public void exibeMenuGerenciarBancos() {
		int opcao=0;
		Scanner leitura;
		String texto;
		
		while (opcao!=6) {
			
		texto = "";
			
		// Limpa a tela
		try {
			LimpaConsole.limparTela();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		
		// Definição do layout do menu 
		texto+= "\n== Gerenciar Bancos ==\n\n";
		texto+= "Escolha a opção desejada\n";
		texto+= "1 - Novo Banco\n";
		texto+= "2 - Listar Bancos\n";
		texto+= "3 - Pesquisar Bancos\n";
		texto+= "4 - Excluir Banco\n";
		texto+= "5 - Atualizar Banco\n";
		texto+= "6 - Voltar ao menu anterior\n";
		texto+= "7 - Sair\n";
		texto+= "Sua opção: ";
		
		// Impressão do menu
		System.out.print(texto);
		
		
		// Entrada do valor da opção
		do {
			leitura = new Scanner(System.in);
			opcao = leitura.nextInt();
		} while(opcao>7 || opcao<1);
		
		
		switch (opcao) {
		case 1:
			BancoGUI.criarNovo(sistema);
			break;
		case 2:
			System.out.println(sistema.listaBancos());
			System.out.println("Aperte qualquer tecla para continuar...");
			leitura = new Scanner(System.in);
			leitura.nextLine();
			break;
		case 3: 
			BancoGUI.pesquisar(sistema);
			break;
		case 4: 
			BancoGUI.excluir(sistema);
			break;
		case 5:
			BancoGUI.atualizar(sistema);
			break;
		case 6:
			return;
		case 7:
			System.out.println("\n\n >>> Sistema Finalizado!");
			System.exit(0);
			return;
		
		}
		}
		
	}
	
	public void exibeMenuGerenciarPessoas() {
		
		int opcao=0;
		Scanner leitura; 
		String texto;

		while (opcao!=6) {
		
		texto = "";
			
		// Limpa a tela
		try {
			LimpaConsole.limparTela();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		
		// Definição do layout do menu 
		texto+= "\n== Gerenciar Clientes ==\n\n";
		texto+= "Escolha a opção desejada\n";
		texto+= "1 - Novo cliente (futuro cliente)\n";
		texto+= "2 - Listar clientes \n";
		texto+= "3 - Pesquisar clientes\n";
		texto+= "4 - Excluir cliente\n";
		texto+= "5 - Atualizar cliente\n";
		texto+= "6 - Voltar ao menu anterior\n";
		texto+= "7 - Sair\n";
		texto+= "Sua opção: ";
		
		
		// Impressão do menu
		System.out.print(texto);
		
		
		// Entrada do valor da opção
		do {
			leitura = new Scanner(System.in);
			opcao = leitura.nextInt();
		} while(opcao>7 || opcao<1);
		
		
		switch (opcao) {
		case 1:
			ClienteGUI.criar(sistema);
			break;
		case 2:
			System.out.println(sistema.listaClientes());
			System.out.println("Aperte qualquer tecla para continuar...");
			leitura = new Scanner(System.in);
			leitura.nextLine();
			break;
		case 3: 
			ClienteGUI.pesquisar(sistema);
			break;
		case 4: 
			ClienteGUI.excluir(sistema);
			break;
		case 5:
			ClienteGUI.atualizar(sistema);
			break;
		case 6:
			return;
		case 7:
			System.out.println("\n\n >>> Sistema Finalizado!");
			System.exit(0);
			return;
		}

		}
		
	}

	
	
	public void exibeMenuGerenciarContas() {
		
		int opcao=0;
		Scanner leitura; 
		String texto;

		while (opcao!=6) {
		
		texto = "";
			
		// Limpa a tela
		try {
			LimpaConsole.limparTela();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		
		// Definição do layout do menu 
		texto+= "\n== Gerenciar Contas ==\n\n";
		texto+= "Escolha a opção desejada\n";
		texto+= "1 - Nova conta\n";
		texto+= "2 - Listar Contas \n";
		texto+= "3 - Pesquisar contas\n";
		texto+= "4 - Excluir conta\n";
		texto+= "5 - Voltar ao menu anterior\n";
		texto+= "6 - Sair\n";
		texto+= "Sua opção: ";
		
		
		// Impressão do menu
		System.out.print(texto);
		
		
		// Entrada do valor da opção
		do {
			leitura = new Scanner(System.in);
			opcao = leitura.nextInt();
		} while(opcao>6 || opcao<1);
		
		
		switch (opcao) {
		case 1:
			ContaGUI.criar(sistema);
			break;
		case 2:
			ContaGUI.listar(sistema);
			break;
		case 3: 
			ContaGUI.pesquisar(sistema);
			break;
		case 4: 
			ContaGUI.excluir(sistema);
			break;

		case 5:
			return;
		case 6:
			System.out.println("\n\n >>> Sistema Finalizado!");
			System.exit(0);
			return;
		}

		}
		
	}
	
	
	public void exibeMenuAcessoCliente() {
		int opcao=0;
		Scanner leitura; 
		String texto;		

		while (opcao!=6) {
		
		texto = "";
			
		// Limpa a tela
		try {
			LimpaConsole.limparTela();
		} catch (IOException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		
		// Definição do layout do menu
		texto+= "\n== Acesso do Cliente: " + AcessoClienteGUI.getUsuario().getNome() + "  ==\n\n";
		texto+= "Escolha a opção desejada\n";
		texto+= "1 - Listar minhas contas bancárias\n";
		texto+= "2 - Efetuar depósito\n";
		texto+= "3 - Efetuar Saque\n";
		texto+= "4 - Efetuar transferência\n";
		texto+= "5 - Obter extrato\n";
		texto+= "6 - Voltar ao menu anterior\n";
		texto+= "7 - Sair\n";
		texto+= "Sua opção: ";
		
		// Impressão do menu
		System.out.print(texto);
		
		
		// Entrada do valor da opção
		do {
			leitura = new Scanner(System.in);
			opcao = leitura.nextInt();
		} while(opcao>7 || opcao<1);
		
		
		switch (opcao) {
		case 1:
			AcessoClienteGUI.listarContas(sistema);
			break;
		case 2:
			AcessoClienteGUI.depositar(sistema);
			break;
		case 3: 
			AcessoClienteGUI.sacar(sistema);
			break;
		case 4: 
			AcessoClienteGUI.transferir(sistema);
			break;
		case 5:
			AcessoClienteGUI.emitirExtrato(sistema);
			break;
		case 6:
			AcessoClienteGUI.encerrarAcesso();
			return;
		case 7:
			AcessoClienteGUI.encerrarAcesso();
			System.out.println("\n\n >>> Sistema Finalizado!");
			System.exit(0);
			return;
		
		}

		}
	}

}
