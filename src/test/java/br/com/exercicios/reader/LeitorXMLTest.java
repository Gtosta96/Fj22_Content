package br.com.exercicios.reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.exercicios.model.Negociacao;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria(){
		String trechoXML = "<list>" +
								" <negociacao>" +
									" <preco>43.5</preco>" +
									" <quantidade>1000</quantidade>" +
									/*" <data>" +
										" <time>1322233344455</time>" +
									" </data>" +*/
								" </negociacao>" +
							"</list>";
		
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(trechoXML.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		Assert.assertEquals(1, negociacoes.size());
		Assert.assertEquals(43.5, negociacoes.get(0).getPreco(), 0);
		Assert.assertEquals(1000, negociacoes.get(0).getQuantidade());
		Assert.assertEquals(null, negociacoes.get(0).getData()); // Atributos não existentes, são nulos no objeto
	}
}