package lab5;

public class Aposta {
	private String apostador;
	private int valor;
	private String previsao;
	
	public Aposta(String apostador, int valor, String previsao) {
		if( apostador == null || previsao == null ) {
			throw new NullPointerException("Parâmetro nulo!");
		}

		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
	}
	
	@Override
	public String toString() {
		String informacao = "";
		double valorReal = ( (double)this.valor ) / 100.0;
		
		informacao += this.apostador + " - " + "R$ " + valorReal + " - " + previsao;
		return informacao;
	}
}
