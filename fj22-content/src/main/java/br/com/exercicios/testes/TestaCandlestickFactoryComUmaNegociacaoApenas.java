package br.com.exercicios.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.exercicios.model.Candlestick;
import br.com.exercicios.model.CandlestickFactory;
import br.com.exercicios.model.Negociacao;

public class TestaCandlestickFactoryComUmaNegociacaoApenas {

	public static void main(String[] args) {

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		List<Negociacao> negociacoes = Arrays.asList(negociacao1);
		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		System.out.println(candle.toString());
	}

}
