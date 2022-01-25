package bancoDominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Transacao {
		private static int NUMERO = 1;
		private int numDoc;
		private String operacao;
		private double valor;
		private boolean flagDebito;
		private Date data;

		public Transacao(String operacao, double valor, boolean flagDebito, Date data) {
			this.operacao = operacao;
			this.valor = valor;
			this.flagDebito = flagDebito;
			this.data = data;
			this.numDoc = NUMERO++;
		}

		@Override
		public String toString() {
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			String texto ="";
			
			texto += sd.format(this.data) + "\t" + this.operacao + "\t" +  String.format("%04d",this.numDoc) + "\t" + String.format("%6.2f", valor) + (flagDebito?"D":"C") + "\n"; 
			return texto;

		}
		

		
		
}
