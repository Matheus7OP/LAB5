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
	public Aposta(String apostador2, int valor, String prev) {
		if( apostador2 == null || prev == null ) {
			throw new NullPointerException("Parâmetro nulo!");
		}
		
		String apostador = apostador2.trim();
		if(apostador.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		
		if(valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		
		String previsao = prev.trim();
		if(previsao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		
		if( !previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER") ) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
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
		String informacao;
		double valorReal = ( (double)this.valor ) / 100.0;
		
		informacao = String.format("%s - R$ %.2f - %s", this.apostador, valorReal, previsao);
		return informacao;
	}
}
