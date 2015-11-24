package br.com.exercicios.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class NegociacaoTest {

	@Test
	public void dataDaNegociacaoImutavelErro(){
		
		//Criando uma negociacao no dia 15;
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao negociacao = new Negociacao(10, 5, c);
		
		//Tentativa de recuperar a data de negociacao e setar para dia 10;
		
		//Teoricamente, essa linha não deverá funcionar, pois negociação é imutavel
		Calendar c2 = Calendar.getInstance();
		c2 = negociacao.getDataMutavel();
		
		//Tentativa de Alterar data
		c2.set(Calendar.DAY_OF_MONTH, 10);
		
		/*Negociacao é imutavel, ele não deve ter valores alterados depois da criação do objeto... Teoricamente o resultado esperado da data é 15 MAS,
		 * vamos testar conforme o dia que setamos, ou seja, 10   
		 */
		Assert.assertEquals(10, negociacao.getDataMutavel().get(Calendar.DAY_OF_MONTH));
		
		/*What happens? O teste aceita o dia 10... pois devolvemos um objeto mutavel através de um getter (getData) então,
		 * temos que implementar CLONEABLE para Negociacao, que assim, garantirá que o objeto original permanecerá intacto.
		 * 
		 *  VEJA dataDaNegociacaoImutavel, é onde o teste é feito de forma correta, utilizando a interface Cloneable 
		 * */
	}
	
	@Test
	public void dataDaNegociacaoImutavel(){
		
		//Criando uma negociacao no dia 15;
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao negociacao = new Negociacao(10, 5, c);
			
		
		negociacao.getData().set(Calendar.DAY_OF_MONTH, 10);
		Assert.assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	//Esse teste deve retornar um illegalArgumentException
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula(){
		
		new Negociacao(10, 5, null);
	}
	
	@Test
	public void mesmoMilissegundoMesmoDia(){
		
		Calendar calendarAgora = Calendar.getInstance();
		Calendar cloneCalendarAgora = (Calendar)calendarAgora.clone();
		
		Negociacao negociacao = new Negociacao(40.0, 100, calendarAgora);
		Assert.assertTrue(negociacao.isMesmoDia(cloneCalendarAgora));
	}
	
	@Test
	public void horariosDiferentesMesmoDia(){
		Calendar manha = new GregorianCalendar(2015, 10, 28, 9, 00); //28/10/2015 08:30AM
		Calendar tarde = new GregorianCalendar(2015, 10, 28, 16, 00); //28/10/2015 16:00AM
		
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		Assert.assertTrue(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaMesesDiferentes(){
		Calendar umDeMarco = new GregorianCalendar(2015, 03, 01);
		Calendar umDeAbril = new GregorianCalendar(2015, 04, 01);
		
		Negociacao negociacao = new Negociacao(40.0, 100, umDeMarco);
		Assert.assertFalse(negociacao.isMesmoDia(umDeAbril));
	}
	
	@Test
	public void mesmoDiaMesmoMesAnosDiferentes(){
		Calendar umDeMarcoDe2015 = new GregorianCalendar(2015, 03, 01);
		Calendar umDeMarcoDe2016 = new GregorianCalendar(2016, 03, 01);
		
		Negociacao negociacao = new Negociacao(40.0, 100, umDeMarcoDe2015);
		Assert.assertFalse(negociacao.isMesmoDia(umDeMarcoDe2016));
	}
}
