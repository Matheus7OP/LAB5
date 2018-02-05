package lab5;

public class ApostaSegura extends Aposta {
	private int id;
	
	/**
	 * Construtor do objeto ApostaSegura, quando
	 * a mesma é por valor.
	 * 
	 * @param apostador o nome do apostador
	 * @param valor o valor a ser apostado
	 * @param previsao previsao feita pelo apostador
	 * @param valorAssegurado valor a ser devolvido caso o apostador perca
	 * @param id o id da aposta
	 */
	public ApostaSegura(String apostador, int valor, String previsao, int valorAssegurado, int id) {
		super(apostador, valor, previsao);
		
		this.pagamentoSeguro = valorAssegurado;
		this.id = id;
	}
	
	/**
	 * Construtor do objeto ApostaSegura, quando
	 * a mesma é por taxa.
	 * 
	 * @param apostador o nome do apostador
	 * @param valor o valor a ser apostado
	 * @param previsao previsao feita pelo apostador
	 * @param valorAssegurado valor a ser devolvido caso o apostador perca
	 * @param id o id da aposta
	 */
	public ApostaSegura(String apostador, int valor, String previsao, double taxa, int id) {
		super(apostador, valor, previsao);
		
		double pagamento = ( (double)valor ) * taxa;
		
		this.pagamentoSeguro = ( (int)Math.floor(pagamento) );
		this.id = id;
	}
	
	/**
	 * Retorna o id da ApostaSegura.
	 * 
	 * @return o id da aposta assegurada
	 */
	public int getId() {
		return this.id;
	}
}
