package br.com.exercicios.reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.exercicios.model.Negociacao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class LeitorXML {
	
	public List<Negociacao> carrega(InputStream inputStream){
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);
		
		//GARANTINDO QUE MINHA LISTA SERÁ DE NEGOCIACOES.
		
		List<?> listaDeObjetos = (List<?>) stream.fromXML(inputStream);
		List<Negociacao> negociacoes = new ArrayList<Negociacao>();
		
		for (Object object : listaDeObjetos) {
			if (object instanceof Negociacao){
				negociacoes.add((Negociacao) (object));
			}
		}

		return negociacoes;
		//return (List<Negociacao>) stream.fromXML(inputStream);
		
	}

}
