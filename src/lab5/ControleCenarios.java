package lab5;

import java.util.ArrayList;

/**
 * Classe Controller do conjunto de cenários
 * que o sistema pode vir a armazenar.
 * 
 * @author Matheus Oliveira Pereira
 */
public class ControleCenarios {
	private ArrayList<Cenario> conjuntoCenarios, exibicao;
	private String ordemAtual;
	
	/**
	 * Construtor do objeto ControleCenarios.
	 */
	public ControleCenarios() {
		this.conjuntoCenarios = new ArrayList<Cenario>();
		this.exibicao = new ArrayList<Cenario>();
		this.ordemAtual = "cadastro";
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
	 * @return o id da aposta criada
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorAssegurado) {
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		}
		
		if(cenario > this.conjuntoCenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
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
	 * @param taxa a taxa do valor a ser assegurada na criação 
	 * @return o id da aposta criada
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa) {
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		}
		
		if(cenario > this.conjuntoCenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
		}
		return this.conjuntoCenarios.get(cenario - 1).cadastrarApostaSeguraTaxa(apostador, valor, previsao, taxa);
	}
	
	/**
	 * Altera o tipo do seguro feito, de seguro por valor
	 * para seguro por taxa, caso o cenário
	 * ainda não tenha sido encerrado.
	 * 
	 * @param cenario o id do cenario no sistema
	 * @param apostaAssegurada o id da aposta no cenario
	 * @param valor o valor a ser assegurado
	 * @return o novo valor a ser assegurado
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return this.conjuntoCenarios.get(cenario - 1).alterarSeguroValor(apostaAssegurada, valor);
	}
	
	/**
	 * Altera o tipo do seguro feito, de seguro por taxa
	 * para seguro por valor, caso o cenário
	 * ainda não tenha sido encerrado.
	 * 
	 * @param cenario o id do cenario no sistema
	 * @param apostaAssegurada o id da aposta no cenario
	 * @param taxa a nova taxa a ser assegurada
	 * @return o novo valor a ser assegurado
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return this.conjuntoCenarios.get(cenario - 1).alterarSeguroTaxa(apostaAssegurada, taxa);
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
	
	public int getBonus(int cenario) {
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		
		if(cenario > this.conjuntoCenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		
		return this.conjuntoCenarios.get(cenario - 1).getBonus();
	}
	
	/**
	 * Retorna o valor que o sistema está
	 * devendo aos seguros feitos em determinadas
	 * apostas desse cenário.
	 * 
	 * @param cenario o id do cenario a ser verificado o pagamento de seguros
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
	
	/**
	 * Altera a ordem em que os cenários são
	 * exibidos.
	 * 
	 * @param ordem o critério de ordenação que deve ser utilizado
	 */
	public void alterarOrdem(String ordem) {
		if( ordem.trim().equals("") || ordem == null ) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		}
		
		if( !ordem.equals("cadastro") && !ordem.equals("nome") && !ordem.equals("apostas") ) {
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
		}
		
		this.ordemAtual = ordem;
	}
	
	/**
	 * Retornar a representação textual de um cenário,
	 * com a ordenação definida atualmente.
	 * 
	 * @param cenario o id do cenario a ser exibido
	 * @return representacao do cenario segundo critério de ordenação
	 */
	public String exibirCenarioOrdenado(int cenario) {
		if(cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario invalido");
		}
		
		if(cenario > this.conjuntoCenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario ordenado: Cenario nao cadastrado");
		}
		
		int cenariosCadastrados = this.cenariosCadastrados();		
		this.exibicao.clear();
		
		for(int i = 0; i < cenariosCadastrados; i++) {
			this.exibicao.add( this.conjuntoCenarios.get(i) );
		}
		
		if( this.ordemAtual.equals("cadastro") ) {
			this.exibicao.sort(Cenario.comparadorPorId);
		}
		else {
			if( this.ordemAtual.equals("apostas") ) {
				this.exibicao.sort(Cenario.comparadorPorApostas);
			}
			else {
				this.exibicao.sort(Cenario.comparadorPorNome);
			}
		}
		
		String info = "";
		info = this.exibicao.get(cenario-1).toString();
		return info;
	}
}
