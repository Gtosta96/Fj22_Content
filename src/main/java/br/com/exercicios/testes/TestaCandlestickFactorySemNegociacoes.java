package br.com.exercicios.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.exercicios.model.Candlestick;
import br.com.exercicios.model.CandlestickFactory;
import br.com.exercicios.model.Negociacao;

public class TestaCandlestickFactorySemNegociacoes {

	public static void main(String[] args) {
		
		Calendar hoje = Calendar.getInstance();
		//Caso fiquemos dias sem ter negociacoes...
		List<Negociacao> negociacoes = Arrays.asList();
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
		
		System.out.println(candle.toString());

	}

}
