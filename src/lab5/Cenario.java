package lab5;

import java.util.ArrayList;

/**
 * Classe que representa um cenário (que pode
 * receber apostas) no sistema.
 * 
 * @author Matheus Oliveira Pereira
 */
public class Cenario {
	private String descricao;
	private int id, apostasComSeguro, pagamentoSeguros;
	private ArrayList<Aposta> apostas;
	private boolean encerrado;
	protected int caixa, bonus;
	
	/**
	 * Construtor do objeto Cenario.
	 * 
	 * @param desc a descricao do cenario
	 * @param id o id do cenario
	 */
	public Cenario(String desc, int id) {
		if(desc == null) {
			throw new NullPointerException("Parâmetro nulo!");
		}
		
		String descricao = desc.trim();
		if(descricao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		
		this.descricao = descricao;
		this.id = id;
		this.apostas = new ArrayList<Aposta>();
		this.encerrado = false;
		this.caixa = 0;
		this.apostasComSeguro = 0;
		this.pagamentoSeguros = 0;
		this.bonus = 0;
	}
	
	/**
	 * Retorna o ID do cenario.
	 * 
	 * @return o id do cenario
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Retorna o valor que o sistema está
	 * devendo aos seguros feitos em determinadas
	 * apostas desse cenário.
	 * 
	 * @return valor que o sistema deve pagar
	 */
	public int getPagamentoSeguros() {
		return this.pagamentoSeguros;
	}
	
	/**
	 * Retorna se o cenario está encerrado.
	 * 
	 * @return true, caso o cenario esteja encerrado
	 */
	public boolean estaEncerrado() {
		return this.encerrado;
	}
	
	/**
	 * Retorna a quantidade de dinheiro no 
	 * caixa do cenario (em centavos).
	 * 
	 * @return a quantidade de dinheiro em caixa.
	 */
	public int getCaixa() {		
		return this.caixa;
	}
	
	/**
	 * Retorna o bônus do cenário.
	 * 
	 * @return o bonus do cenário
	 */
	public int getBonus() {
		return this.bonus;
	}
	
	/**
	 * Método utilizado para cadastrar uma nova aposta ao
	 * sistema.
	 * 
	 * @param apostador nome do apostador
	 * @param valor o valor que será apostado
	 * @param previsao resultado esperado pelo apostador
	 */
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		this.apostas.add(aposta);
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
	public int cadastrarApostaSeguraValor(String apostador, int valor, String previsao, int valorAssegurado) {
		this.apostasComSeguro += 1;
		
		Aposta apostaSegura = new ApostaSegura(apostador, valor, previsao, valorAssegurado, this.apostasComSeguro);
		this.apostas.add(apostaSegura);
		
		return (this.apostasComSeguro);
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
	public int cadastrarApostaSeguraTaxa(String apostador, int valor, String previsao, double taxa) {
		this.apostasComSeguro += 1;
		
		Aposta apostaSegura = new ApostaSegura(apostador, valor, previsao, taxa, this.apostasComSeguro);
		this.apostas.add(apostaSegura);
		
		return (this.apostasComSeguro);
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
	public int alterarSeguroValor(int apostaAssegurada, int valor) {
		int totalDeApostas = this.totalDeApostas();
		
		for(int i = 0; i < totalDeApostas; i++) {
			if( this.apostas.get(i).getId() == apostaAssegurada ) {
				if( this.apostas.get(i).getTipoAposta() == 2 ) {
					return this.apostas.get(i).alterarParaSeguroValor(valor);
				}
			}
		}
		
		throw new IllegalArgumentException("O id indicado não existe.");
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
	public int alterarSeguroTaxa(int apostaAssegurada, double taxa) {
		int totalDeApostas = this.totalDeApostas();
		
		for(int i = 0; i < totalDeApostas; i++) {
			if( this.apostas.get(i).getId() == apostaAssegurada ) {
				if( this.apostas.get(i).getTipoAposta() == 1 ) {
					return this.apostas.get(i).alterarParaSeguroTaxa(taxa);
				}
			}
		}
		
		throw new IllegalArgumentException("O id indicado não existe.");
	}
	
	/**
	 * Retorna a quantidade de apostas feitas
	 * no cenario.
	 * 
	 * @return a quantidade de apostas feitas nesse cenario
	 */
	public int totalDeApostas() {
		return this.apostas.size();
	}
	
	/**
	 * Retorna o valor total das apostas que
	 * foram feitas no cenario.
	 * 
	 * @return valor total das apostas no cenario
	 */
	public int valorTotalDeApostas() {
		int totalDeApostas = this.totalDeApostas(), somatorio = 0;
		
		for(int i = 0; i < totalDeApostas; i++) {
			somatorio += this.apostas.get(i).getValor();
		}
		
		return somatorio;
	}
	
	/**
	 * Retorna uma listagem de todas as apostas feitas
	 * no cenário.
	 * 
	 * @return a listagem das apostas do cenário
	 */
	public String exibeApostas() {
		String listagem = "";
		int totalDeApostas = this.totalDeApostas();
		
		for(int i = 0; i < totalDeApostas; i++) {
			listagem += this.apostas.get(i).toString() + System.lineSeparator();
		}
		
		return listagem;
	}
	
	/**
	 * Método utilizado para fechar as apostas do
	 * cenário (o cenário é encerrado).
	 * 
	 * @param ocorreu status final do cenário (se o mesmo ocorreu ou não)
	 */
	public void fecharAposta(boolean ocorreu) {
		if( this.encerrado ) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		int totalDeApostas = this.totalDeApostas();
		
		for(int i = 0; i < totalDeApostas; i++) {
			if( !ocorreu && this.apostas.get(i).getPrevisao().equals("VAI ACONTECER") ) {
				this.caixa += this.apostas.get(i).getValor();
				this.pagamentoSeguros += this.apostas.get(i).getPagamentoSeguro();
			}
			if( ocorreu && this.apostas.get(i).getPrevisao().equals("N VAI ACONTECER") ) {
				this.caixa += this.apostas.get(i).getValor();
				this.pagamentoSeguros += this.apostas.get(i).getPagamentoSeguro();
			}
		}
		
		this.encerrado = true;
	}
	
	@Override
	public String toString() {
		String representacao = this.id + " - " + this.descricao + " - ";
		
		if( this.encerrado ) {
			representacao += "Finalizado (ocorreu)";
		}
		else {
			representacao += "Nao finalizado";
		}
		
		return representacao;
	}
}
