package lab5;

import java.util.ArrayList;

public class Cenario {
	private String descricao;
	private int id, caixa;
	private ArrayList<Aposta> apostas;
	private boolean encerrado;
	
	/**
	 * Construtor do objeto Cenario.
	 * 
	 * @param descricao a descricao do cenario
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
			}
			if( ocorreu && this.apostas.get(i).getPrevisao().equals("N VAI ACONTECER") ) {
				this.caixa += this.apostas.get(i).getValor();
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
