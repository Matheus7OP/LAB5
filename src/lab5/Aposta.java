package lab5;

/**
 * Classe que representa as apostas no sistema.
 * Tem como parâmetros o nome do apostador, o valor apostado
 * e a previsão feita na hora de apostar.
 * 
 * @author Matheus Oliveira Pereira
 */
public class Aposta {
	private String apostador;
	private int valor;
	private String previsao;
	protected int id, tipoAposta, pagamentoSeguro;
	
	/**
	 * Construtor do objeto Aposta.
	 * 
	 * @param apostador2 o nome do apostador
	 * @param valor o valor da aposta
	 * @param prev a previsao feita pelo apostador
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
		this.pagamentoSeguro = 0;
		this.id = 0;
		this.tipoAposta = 0;
	}
	
	/**
	 * Método utilizado para alterar o tipo
	 * de uma aposta, caso ela seja do tipo por
	 * taxa.
	 * 
	 * @param valor o novo valor a ser assegurado
	 */
	public int alterarParaSeguroValor(int valor) {
		if(this.tipoAposta == 1) {
			throw new IllegalArgumentException("A aposta atual já é do tipo por valor.");
		}
		
		this.tipoAposta = 1;
		this.pagamentoSeguro = valor;
		
		return (this.pagamentoSeguro);
	}
	
	/**
	 * Método utilizado para alterar o tipo
	 * de uma aposta, caso ela seja do tipo por
	 * valor.
	 * 
	 * @param taxa a taxa a ser assegurada
	 */
	public int alterarParaSeguroTaxa(double taxa) {
		if(this.tipoAposta == 2) {
			throw new IllegalArgumentException("A aposta atual já é do tipo por taxa.");
		}
		
		this.tipoAposta = 2;
		
		double novoValor = ((double) this.pagamentoSeguro) * taxa;
		this.pagamentoSeguro = ((int) novoValor);
		
		return (this.pagamentoSeguro);
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
	 * Retorna o id da Aposta.
	 * 
	 * @return o id da aposta
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Retorna o tipo da aposta:
	 * - 0, caso seja uma aposta comum;
	 * - 1, caso seja uma aposta com seguro por valor;
	 * - 2, caso seja uma aposta com seguro por taxa.
	 * 
	 * @return o tipo da aposta
	 */
	public int getTipoAposta() {
		return this.tipoAposta;
	}
	
	/**
	 * Retorna o valor necessário para o
	 * sistema pagar o seguro da aposta
	 * 
	 * @return valor devido pelo sistema
	 */
	public double getPagamentoSeguro() {
		return this.pagamentoSeguro;
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
