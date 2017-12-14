package lab5;

public class Aposta {
	private String apostador;
	private int valor;
	private String previsao;
	
	/**
	 * Construtor do objeto Aposta.
	 * 
	 * @param apostador o nome do apostador
	 * @param valor o valor da aposta
	 * @param previsao a previsao feita pelo apostador
	 */
	public Aposta(String apostador, int valor, String previsao) {
		if( apostador == null || previsao == null ) {
			throw new NullPointerException("Parâmetro nulo!");
		}

		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
	}
	
	/**
	 * Retorna o valor da aposta, em centavos.
	 * 
	 * @return valor da aposta
	 */
	public int getValor() {
		return this.valor;
	}
	
	/**
	 * Retorna a previsão que o apostador
	 * fez ao cadastrar sua aposta.
	 * 
	 * @return previsao do apostador
	 */
	public String getPrevisao() {
		return this.previsao;
	}
	
	@Override
	public String toString() {
		String informacao = "";
		double valorReal = ( (double)this.valor ) / 100.0;
		
		informacao += this.apostador + " - " + "R$ " + valorReal + " - " + previsao;
		return informacao;
	}
}
