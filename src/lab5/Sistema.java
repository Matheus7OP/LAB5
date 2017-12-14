package lab5;

public class Sistema {
	private int caixa;
	private double taxa;
	private ControleCenarios controleCenarios;
	
	/**
	 * Construtor do objeto Sistema.
	 * 
	 * @param caixa quantidade de dinheiro inicial em caixa (em centavos)
	 * @param taxa a taxa que o sistema irá utilizar para retirar sua parte nas apostas
	 */
	public Sistema(int caixa, double taxa) {
		this.caixa = caixa;
		this.taxa = taxa;
		this.controleCenarios = new ControleCenarios();
	}
	
	/**
	 * Retorna a quantidade de dinheiro em caixa, em
	 * centavos.
	 * 
	 * @return dinheiro em caixa (em centavos)
	 */
	public int getCaixa() {
		return this.caixa;
	}
	
	/**
	 * Método utilizado para cadastrar um novo cenário
	 * ao sistema.
	 * 
	 * @param descricao a descricao do cenario
	 * @return o id do cenário no sistema
	 */
	public int cadastrarCenario(String descricao) {
		return this.controleCenarios.cadastrarCenario(descricao);
	}
	
	/**
	 * Retorna uma string que representa o cenário
	 * com o id passado no parâmetro da função.
	 * 
	 * @param cenario id do cenário a ser exibido
	 * @return representação do cenário com o id especificado 
	 */
	public String exibirCenario(int cenario) {
		return this.controleCenarios.exibirCenario(cenario);
	}
	
	/**
	 * Retorna a listagem de todos os
	 * cenários cadastrados no sistema.
	 * 
	 * @return a listagem dos cenários, em forma de String.
	 */
	public String exibirCenarios() {
		return this.controleCenarios.exibirCenarios();
	}
	
	/**
	 * Método utilizado para cadastrar uma nova aposta ao
	 * sistema.
	 * 
	 * @param cenario id do cenário no qual a aposta será colocada
	 * @param apostador nome do apostador
	 * @param valor o valor que será apostado
	 * @param previsao resultado esperado pelo apostador
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.controleCenarios.cadastrarAposta(cenario, apostador, valor, previsao);
	}
	
	/**
	 * Retorna o valor total das apostas feitas em
	 * um cenário.
	 * 
	 * @param cenario id do cenário a ser verificado
	 * @return valor total das apostas no cenário
	 */
	public int valorTotalDeApostas(int cenario) {
		return this.controleCenarios.valorTotalDeApostas(cenario);
	}
	
	/**
	 * Retorna a quantidade de apostas feitas em
	 * um cenário.
	 * 
	 * @param cenario o id do cenário a ser verificado
	 * @return quantidade de apostas feitas no cenário
	 */
	public int totalDeApostas(int cenario) {
		return this.controleCenarios.valorTotalDeApostas(cenario);
	}
	
	/**
	 * Retorna uma listagem de todas as apostas feitas
	 * em um cenário.
	 * 
	 * @param cenario o id do cenário a ser verificado
	 * @return a listagem das apostas do cenário
	 */
	public String exibeApostas(int cenario) {
		return this.controleCenarios.exibeApostas(cenario);
	}
	
	/**
	 * Retorna a quantidade de dinheiro (que pertence ao sistema)
	 * no caixa do cenário.
	 * 
	 * @param cenario id do cenário a ser verificado
	 * @return a quantidade de dinheiro no caixa do cenário
	 */
	public int getCaixaCenario(int cenario) {
		int caixa = this.controleCenarios.getCaixa(cenario);
		
		double valorReal = ( (double)caixa ) * this.taxa;
		valorReal = Math.floor(valorReal);
		
		return ( (int)valorReal );
	}
	
	/**
	 * Retorna a quantidade de dinheiro (que pertence aos vencedores)
	 * presente no caixa do cenário.
	 * 
	 * @param cenario id do cenário a ser verificado
	 * @return a quantidade de dinheiro pertencente aos vencedores do cenário
	 */
	public int getTotalRateioCenario(int cenario) {
		int caixa = this.controleCenarios.getCaixa(cenario);
		return ( caixa - this.getCaixaCenario(cenario) );
	}
	
	/**
	 * Método utilizado para fechar as apostas de determinado
	 * cenário (o cenário é encerrado).
	 * 
	 * @param cenario id do cenário a ser verificado
	 * @param ocorreu status final do cenário (se o mesmo ocorreu ou não)
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.controleCenarios.fecharAposta(cenario, ocorreu);
	}
}
