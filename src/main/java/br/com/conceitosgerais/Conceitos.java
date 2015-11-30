package br.com.conceitosgerais;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*CONCEITOS/TIPS DA APOSTILA*/
public class Conceitos {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// pesquisar sobre BigDecimal
		BigDecimal bd1 = new BigDecimal(100.00);
		BigDecimal bd2 = new BigDecimal(5.50);
		

		System.out.println(bd1);
		System.out.println(bd2);

		try {
			// aqui temos 100 / 5.5;
			System.out.println(bd1.divide(bd2)); // EXCEPTION quando resultado com numero de casas inconclusivas
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

		// OBJETOS IMUTAVEIS (ex: String / Classes wrappers) - VERIFICAR Design Pattern Flyweight.
		String palavra = "supercalifragilisticexpialidocious";
		String inicio = palavra.substring(0, 5);
		String proximas = palavra.substring(5, 10);
		String outras = palavra.substring(10, 15);
		String resto = palavra.substring(15);

		/*
		 * Se você tem uma String muito longa e cria várias outras com trechos
		 * da original, você não terá que armazenaros caracteres de novo para
		 * cada trecho: eles utilizarão o array de chars da String original!
		 */

		// CALENDAR
		Calendar c = Calendar.getInstance();
		System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
		System.out.println("Dia da Semana: " + c.get(Calendar.DAY_OF_WEEK));
		
		c.set(2011, Calendar.DECEMBER, 25, 10, 30);
		
		Calendar c1 = new GregorianCalendar(2005, Calendar.OCTOBER, 12);
		Calendar c2 = new GregorianCalendar(2005, Calendar.DECEMBER, 25);
		System.out.println(c1.after(c2)); // retorna true, pois dia 12 de outubro vem antes de 25 de dezembro
		
		//retorna diferença em dias
		long m1 = c1.getTimeInMillis();
		long m2 = c2.getTimeInMillis() + 232498291;
		System.out.println((int) ((m2 - m1) / (24*60*60*1000)));;

		/*
		 * ANOTAÇOES
		 * 
		 * @Override é o exemplo de anotação apenas para legibilidade. Caso você
		 * use essa anotação em um método que não foi reescrito, vai haver um
		 * erro de compilação!
		 * 
		 * @Deprecated indica que ummétodo não deve sermais utilizado por
		 * algummotivo e decidiramnão retirá-lo da API para não quebrar
		 * programas que já funcionavam anteriormente.
		 * 
		 * @SurpressWarnings indica para o compilador que ele não deve dar
		 * warnings a respeito de determinadoproblema, indicando que o
		 * programador sabe o que está fazendo.
		 */
	}

}