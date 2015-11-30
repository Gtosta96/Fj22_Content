package br.com.exercicios.model;

import java.util.Calendar;

public final class Negociacao implements Cloneable, Comparable<Negociacao> { // Cloneable implementado para teste 'dataDaNegociacaoEhImutavel'

	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		if(data == null){
			throw new IllegalArgumentException("Data não pode ser nula");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
		
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getDataMutavel() {
		return data;
	}
	
	public Calendar getData() { // metodo adicionado apenas para facilitar o entendimento usando a interface Cloneable
		return (Calendar) data.clone();
	}
	
	public double getVolume(){
		return preco * quantidade;
	}

	public boolean isMesmoDia(Calendar outroCalendar) {
		
		//return this.data.equals(outroCalendar); // esse return não resolve caso seja no mesmo dia, porém em horas diferentes  
		//return this.data.get(Calendar.DAY_OF_MONTH) == outroCalendar.get(Calendar.DAY_OF_MONTH); // esse return não resolve caso seja no mesmo dia, porém em meses diferentes
		return
				this.data.get(Calendar.DAY_OF_MONTH) == outroCalendar.get(Calendar.DAY_OF_MONTH) &&
				this.data.get(Calendar.MONTH) == outroCalendar.get(Calendar.MONTH) &&
				this.data.get(Calendar.YEAR) == outroCalendar.get(Calendar.YEAR);
	}

	@Override
	public int compareTo(Negociacao outraNegociacao) {
		if(this.data.before(outraNegociacao.getData())){
			return -1;
		}else if(this.data.after(outraNegociacao.getData())){
			return 1;
		}else{
			return -0;
		}
	}
	public Boolean verificaDataOrdemCrescente (Negociacao outraNegociacao) {
		if(this.data.after(outraNegociacao.data)){
			return true;
		}
		return false;
	}
}
