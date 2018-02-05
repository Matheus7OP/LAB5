package lab5;

import easyaccept.EasyAccept;

/**
 * Classe que abstrai o sistema para facilitar
 * o uso das classes abstraídas.
 * 
 * @author Matheus Oliveira Pereira
 */
public class Facade {
	private Sistema sistema;
	
	/**
	 * Função adicionada para fazer uso do EasyAccept,
	 * visando rodar testes de aceitação no código.
	 * 
	 * @param args argumentos para inicialização do EasyAccept
	 */
	public static void main(String[] args) {
		args = new String[] {"lab5.Facade", "acceptanceTest/us1_test.txt", "acceptanceTest/us2_test.txt", 
		"acceptanceTest/us3_test.txt", "acceptanceTest/us4_test.txt"};
		EasyAccept.main(args);
	}
	
	/**
	 * Método utilizado para inicializar o sistema.
	 * 
	 * @param caixa quantidade inicial de dinheiro em caixa
	 * @param taxa taxa a ser retirada para o sistema
	 */
	public void inicializa(int caixa, double taxa) {
		this.sistema = new Sistema(caixa, taxa);
	}
	
	/**
	 * Retorna a quantidade de dinheiro no caixa do
	 * sistema (em centavos)
	 * 
	 * @return dinheiro em caixa
	 */
	public int getCaixa() {
		return this.sistema.getCaixa();
	}
	
	/**
	 * Método utilizado para cadastrar um novo cenário
	 * ao sistema.
	 * 
	 * @param descricao a descricao do cenario
	 * @return o id do cenário no sistema
	 */
	public int cadastrarCenario(String descricao) {
		return this.sistema.cadastrarCenario(descricao);
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
		return this.sistema.cadastrarCenario(descricao, bonus);
	}
	
	/**
	 * Retorna uma string que representa o cenário
	 * com o id passado no parâmetro da função.
	 * 
	 * @param cenario id do cenário a ser exibido
	 * @return representação do cenário com o id especificado 
	 */
	public String exibirCenario(int cenario) {
		return this.sistema.exibirCenario(cenario);
	}
	
	/**
	 * Retorna a listagem de todos os
	 * cenários cadastrados no sistema.
	 * 
	 * @return a listagem dos cenários, em forma de String.
	 */
	public String exibirCenarios() {
		return this.sistema.exibirCenarios();
	}
	
	/**
	 * Método utilizado para cadastrar uma nova aposta ao
	 * sistema.
	 * 
	 * @param cenario id do cenário no qual a aposta será colocada
	 * @param apostador nome do apostador
	 * @param valor valor que será apostado
	 * @param previsao resultado esperado pelo apostador
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.sistema.cadastrarAposta(cenario, apostador, valor, previsao);
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
		return this.sistema.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, valorAssegurado, custo);
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
		return this.sistema.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);
	}
	
	/**
	 * Retorna o valor total das apostas feitas em
	 * um cenário.
	 * 
	 * @param cenario id do cenário a ser verificado
	 * @return valor total das apostas no cenário
	 */
	public int valorTotalDeApostas(int cenario) {
		return this.sistema.valorTotalDeApostas(cenario);
	}
	
	/**
	 * Retorna a quantidade de apostas feitas em
	 * um cenário.
	 * 
	 * @param cenario o id do cenário a ser verificado
	 * @return quantidade de apostas feitas no cenário
	 */
	public int totalDeApostas(int cenario) {
		return this.sistema.totalDeApostas(cenario);
	}
	
	/**
	 * Retorna uma listagem de todas as apostas feitas
	 * em um cenário.
	 * 
	 * @param cenario o id do cenário a ser verificado
	 * @return a listagem das apostas do cenário
	 */
	public String exibeApostas(int cenario) {
		return this.sistema.exibeApostas(cenario);
	}
	
	/**
	 * Método utilizado para fechar as apostas de determinado
	 * cenário (o cenário é encerrado).
	 * 
	 * @param cenario id do cenário a ser verificado
	 * @param ocorreu status final do cenário (se o mesmo ocorreu ou não)
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.sistema.fecharAposta(cenario, ocorreu);
	}
	
	/**
	 * Retorna a quantidade de dinheiro (que pertence ao sistema)
	 * presente no caixa do cenário.
	 * 
	 * @param cenario id do cenário a ser verificado
	 * @return a quantidade de dinheiro no caixa do cenário
	 */
	public int getCaixaCenario(int cenario) {
		return this.sistema.getCaixaCenario(cenario);
	}
	
	/**
	 * Retorna a quantidade de dinheiro (que pertence aos vencedores)
	 * presente no caixa do cenário.
	 * 
	 * @param cenario id do cenário a ser verificado
	 * @return a quantidade de dinheiro pertencente aos vencedores do cenário
	 */
	public int getTotalRateioCenario(int cenario) {
		return this.sistema.getTotalRateioCenario(cenario);
	}

	//int alterarSeguroValor(int cenario, int apostaAssegurada, int valor)
	//int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa)
}
