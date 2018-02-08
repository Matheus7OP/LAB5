package lab5;

public class ApostaSegura extends Aposta {	
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
		
		if(valorAssegurado < 0) {
			throw new IllegalArgumentException("O valor assegurado não pode ser negativo!");
		}
		
		this.pagamentoSeguro = valorAssegurado;
		this.id = id;
		this.tipoAposta = 1;
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
		
		if(taxa < 0.0) {
			throw new IllegalArgumentException("A taxa não pode ser negativa!");
		}
		
		double pagamento = ( (double)valor ) * taxa;
		
		this.pagamentoSeguro = ( (int)Math.floor(pagamento) );
		this.id = id;
		this.tipoAposta = 2;
	}
	
	@Override
	public String toString() {
		String info = super.toString();
		
		if(this.tipoAposta == 1) {
			info += "- ASSEGURADA (VALOR) - R$ ";
		}
		else {
			info += "- ASSEGURADA (TAXA) - R$ ";
		}
		
		info += this.pagamentoSeguro;
		return info;
	}
}
