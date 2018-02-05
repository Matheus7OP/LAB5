package lab5;

import java.util.ArrayList;

/**
 * Classe Controller do conjunto de cenários
 * que o sistema pode vir a armazenar.
 * 
 * @author Matheus Oliveira Pereira
 */
public class ControleCenarios {
	private ArrayList<Cenario> conjuntoCenarios;
	
	/**
	 * Construtor do objeto ControleCenarios.
	 */
	public ControleCenarios() {
		this.conjuntoCenarios = new ArrayList<Cenario>();
	}
	
	/**
	 * Método utilizado para cadastrar um novo cenário
	 * ao sistema.
	 * 
	 * @param descricao a descricao do cenario
	 * @return o id do cenário no sistema
	 */
	public int cadastrarCenario(String descricao) {
		Cenario cenario = new Cenario(descricao, this.conjuntoCenarios.size() + 1);
		this.conjuntoCenarios.add(cenario);
		return cenario.getId();
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
		CenarioBonus cenario = new CenarioBonus(descricao, this.conjuntoCenarios.size() + 1, bonus);
		this.conjuntoCenarios.add(cenario);
		return cenario.getId();
	}
	
	/**
	 * Retorna uma string que representa o cenário
	 * com o id passado no parâmetro da função.
	 * 
	 * @param cenario id do cenário a ser exibido
	 * @return representação do cenário com o id especificado 
	 */
	public String exibirCenario(int cenario) {
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		
		if(cenario > this.conjuntoCenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		
		return this.conjuntoCenarios.get(cenario - 1).toString();
	}
	
	/**
	 * Retorna a quantidade de cenários cadastrados.
	 * 
	 * @return a quantidade de cenarios cadastrados
	 */
	public int cenariosCadastrados() {
		return this.conjuntoCenarios.size();
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
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		
		if(cenario > this.conjuntoCenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		
		this.conjuntoCenarios.get(cenario - 1).cadastrarAposta(apostador, valor, previsao);
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
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorAssegurado) {
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		
		if(cenario > this.conjuntoCenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		
		return this.conjuntoCenarios.get(cenario - 1).cadastrarApostaSeguraValor(apostador, valor, previsao, valorAssegurado);
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
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa) {
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		
		if(cenario > this.conjuntoCenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		return this.conjuntoCenarios.get(cenario - 1).cadastrarApostaSeguraTaxa(apostador, valor, previsao, taxa);
	}
	
	/**
	 * Retorna o valor total das apostas feitas em
	 * um cenário.
	 * 
	 * @param cenario id do cenário a ser verificado
	 * @return valor total das apostas no cenário
	 */
	public int valorTotalDeApostas(int cenario) {
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		
		if(cenario > this.conjuntoCenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		
		return this.conjuntoCenarios.get(cenario - 1).valorTotalDeApostas();
	}
	
	/**
	 * Retorna a quantidade de apostas feitas em
	 * um cenário.
	 * 
	 * @param cenario o id do cenário a ser verificado
	 * @return quantidade de apostas feitas no cenário
	 */
	public int totalDeApostas(int cenario) {
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		
		if(cenario > this.conjuntoCenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		
		return this.conjuntoCenarios.get(cenario - 1).totalDeApostas();
	}
	
	/**
	 * Retorna uma listagem de todas as apostas feitas
	 * em um cenário.
	 * 
	 * @param cenario o id do cenário a ser verificado
	 * @return a listagem das apostas do cenário
	 */
	public String exibeApostas(int cenario) {
		return this.conjuntoCenarios.get(cenario - 1).exibeApostas();
	}
	
	/**
	 * Método utilizado para fechar as apostas de determinado
	 * cenário (o cenário é encerrado).
	 * 
	 * @param cenario id do cenário a ser verificado
	 * @param ocorreu status final do cenário (se o mesmo ocorreu ou não)
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		
		if(cenario > this.conjuntoCenarios.size()) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		
		this.conjuntoCenarios.get(cenario - 1).fecharAposta(ocorreu);
	}
	
	/**
	 * Método utilizado para checar se determinado
	 * cenário está encerrado ou não.
	 * 
	 * @param cenario o id do cenario
	 * @return true, caso o cenario esteja encerrado
	 */
	public boolean cenarioEncerrado(int cenario) {
		return this.conjuntoCenarios.get(cenario - 1).estaEncerrado();
	}
	
	/**
	 * Retorna a quantidade de dinheiro (em centavos)
	 * presente no caixa do cenario.
	 * 
	 * @param cenario o id do cenario a ser verificado
	 * @return quantidade de dinheiro no caixa do cenario
	 */
	public int getCaixa(int cenario) {
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		
		if(cenario > this.conjuntoCenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		
		return this.conjuntoCenarios.get(cenario - 1).getCaixa();
	}
	
	/**
	 * Retorna o valor que o sistema está
	 * devendo aos seguros feitos em determinadas
	 * apostas desse cenário.
	 * 
	 * @return valor que o sistema deve pagar
	 */
	public int pagamentoSeguros(int cenario) {
		return this.conjuntoCenarios.get(cenario - 1).getPagamentoSeguros();
	}
	
	/**
	 * Retorna a listagem de todos os
	 * cenários cadastrados no sistema.
	 * 
	 * @return a listagem dos cenários, em forma de String.
	 */
	public String exibirCenarios() {
		int cenariosCadastrados = this.cenariosCadastrados();
		String listagem = "";
		
		for(int i = 0; i < cenariosCadastrados; i++) {
			listagem += this.exibirCenario(i+1) + System.lineSeparator();
		}
		
		return listagem;
	}
}
