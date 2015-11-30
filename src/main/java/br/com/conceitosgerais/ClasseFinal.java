package br.com.conceitosgerais;

/*FINAL significa que a classe nunca poderá ter filhas, isso é, não pode ser herdada;
 * Classes FINAL automaticamente transforma todos seus métodos em final também, isto é, não podem ser reescritos*/
public final class ClasseFinal {

	//private final int valor1 = 10; atributos com modificador final não podem ser alterados!, atribuindo aqui, e setando no construtor irá dar erro
	
	static final String CONSTANTE_DA_CLASSE = "CONSTANTE DA CLASSE";
	public static final String CONSTANTE_GLOBAL = "CONSTANTE GLOBAL";
	
	private final int valor1; // OK, quando a variavel for criada, ela já tera um valor!
	private int valor2;

	public ClasseFinal(int valor1){
		this.valor1 = valor1;
	}
	public int soma() {
		return this.valor1 + this.valor2;
	}

	public int getValor1() {
		return valor1;
	}

	//não existe set para valor 1
	
	public int getValor2() {
		return valor2;
	}

	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}
}