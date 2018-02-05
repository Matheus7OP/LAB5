	package lab5;

import java.util.NoSuchElementException;

/**
 * Classe que representa o sistema, em sua ideia
 * mais geral. Tem como atributos a taxa retirada de apostas
 * perdedoras (para ser depositado ao caixa do sistema) e o caixa
 * do sistema.
 * 
 * @author Matheus Oliveira Pereira
 */
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
		if(caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if(taxa < 0.0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		
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
	 * Método utilizado para cadastrar um novo
	 * cenário com bônus no sistema.
	 * 
	 * @param descricao a descricao do cenário
	 * @param bonus o valor dado como bonus no cenário
	 * @return o id do cenário no sistema
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		if( bonus > this.caixa ) {
			throw new IllegalArgumentException("O sistema não tem dinheiro suficiente em caixa para adicionar tal bônus!");
		}
		
		return this.controleCenarios.cadastrarCenario(descricao, bonus);
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
	 * Método utilizado para cadastrar uma nova aposta
	 * com seguro (por valor) ao sistema.
	 * 
	 * @param cenario id do cenario no qual a aposta será adicionada
	 * @param apostador o nome do apostador
	 * @param valor o valor a ser apostado
	 * @param previsao resultado esperado pelo apostador
	 * @param valorAssegurado valor assegurado na criação 
	 * @param custo custo da criação
	 * @return o id da aposta criada
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorAssegurado, int custo) {
		if( custo < 0 ) {
			throw new IllegalArgumentException("O custo para criação da aposta não pode ser negativo!");
		}
		
		this.caixa += custo;
		return this.controleCenarios.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, valorAssegurado);
	}
	
	/**
	 * Método utilizado para cadastrar uma nova aposta
	 * com seguro (por taxa) ao sistema.
	 * 
	 * @param cenario id do cenario no qual a aposta será adicionada
	 * @param apostador o nome do apostador
	 * @param valor o valor a ser apostado
	 * @param previsao resultado esperado pelo apostador
	 * @param valorAssegurado valor assegurado na criação 
	 * @param custo custo da criação
	 * @return o id da aposta criada
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa, int custo) {
		if( custo < 0 ) {
			throw new IllegalArgumentException("O custo para criação da aposta não pode ser negativo!");
		}
		
		this.caixa += custo;
		return this.controleCenarios.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa);
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
		return this.controleCenarios.totalDeApostas(cenario);
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
		
		if( !this.controleCenarios.cenarioEncerrado(cenario) ) {
			throw new NoSuchElementException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		
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
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		
		if(cenario > this.controleCenarios.cenariosCadastrados()) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		
		if( !this.controleCenarios.cenarioEncerrado(cenario) ) {
			throw new NoSuchElementException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		
		int totalArrecadado = this.controleCenarios.getCaixa(cenario);
		return ( totalArrecadado - this.getCaixaCenario(cenario) );
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
		
		this.caixa += this.getCaixaCenario(cenario);
		this.caixa -= this.controleCenarios.pagamentoSeguros(cenario);
	}
}
