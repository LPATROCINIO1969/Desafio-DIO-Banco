package bancoDominio;

import java.text.SimpleDateFormat;
import java.util.Date;

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
			
			texto += sd.format(this.data) + "\t" + String.format("%-12s",this.operacao) + "\t" +  String.format("%04d",this.numDoc) + "\t\t" + String.format("%8.2f", valor) + (flagDebito?"D":"C") + "\n"; 
			return texto;

		}
		

		
		
}
