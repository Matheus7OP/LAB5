package lab5;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Classe que representa um cenário (que pode
 * receber apostas) no sistema.
 * 
 * @author Matheus Oliveira Pereira
 */
public class Cenario implements Comparable<Cenario> {
	private String descricao;
	private int id, apostasComSeguro, pagamentoSeguros;
	private ArrayList<Aposta> apostas;
	private boolean encerrado, aconteceu;
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
		this.aconteceu = false;
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
	 * Retorna a descrição do cenário.
	 * 
	 * @return a descricao do cenario
	 */
	public String getDescricao() {
		return this.descricao;
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
	 * @param apostador o nome do apostador
	 * @param valor o valor a ser apostado
	 * @param previsao resultado esperado pelo apostador
	 * @param valorAssegurado valor assegurado na criação 
	 * @return o id da aposta criada
	 */
	public int cadastrarApostaSeguraValor(String apostador, int valor, String previsao, int valorAssegurado) {
		if(apostador.trim().equals("") || apostador == null) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		}
		if(valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		if(previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		}
		if( !previsao.trim().equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER") ) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		}
		
		this.apostasComSeguro += 1;
		
		Aposta apostaSegura = new ApostaSegura(apostador, valor, previsao, valorAssegurado, this.apostasComSeguro);
		this.apostas.add(apostaSegura);
		
		return (this.apostasComSeguro);
	}
	
	/**
	 * Método utilizado para cadastrar uma nova aposta
	 * com seguro (por taxa) ao sistema.
	 * 
	 * @param apostador o nome do apostador
	 * @param valor o valor a ser apostado
	 * @param previsao resultado esperado pelo apostador
	 * @param taxa a taxa do valor a ser assegurada na criação 
	 * @return o id da aposta criada
	 */
	public int cadastrarApostaSeguraTaxa(String apostador, int valor, String previsao, double taxa) {
		if(apostador.trim().equals("") || apostador == null) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		}
		if(valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		if(previsao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		}
		if( !previsao.trim().equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER") ) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		}
		
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
		
		this.aconteceu = ocorreu;
		this.encerrado = true;
	}
	
	@Override
	public int compareTo(Cenario c) {
		return this.getId() - c.getId();
	}
	
	public static Comparator<Cenario> comparadorPorId = new Comparator<Cenario>() {
		@Override
		public int compare(Cenario c1, Cenario c2) {
			return c1.getId() - c2.getId();
		}
	};
	
	public static Comparator<Cenario> comparadorPorNome = new Comparator<Cenario>() {
		@Override
		public int compare(Cenario c1, Cenario c2) {
			int resultado = c1.getDescricao().compareTo( c2.getDescricao() );
			
			if(resultado == 0) {
				resultado = c1.getId() - c2.getId();
			}
			
			return resultado;
		}
	};

	public static Comparator<Cenario> comparadorPorApostas = new Comparator<Cenario>() {
		@Override
		public int compare(Cenario c1, Cenario c2) {
			int resultado = c2.totalDeApostas() - c1.totalDeApostas();
			
			if(resultado == 0) {
				resultado = c1.getId() - c2.getId();
			}
			
			return resultado;
		}
	};
	
	@Override
	public String toString() {
		String representacao = this.id + " - " + this.descricao + " - ";
		
		if( this.encerrado ) {
			representacao += "Finalizado";
			
			if(this.aconteceu) {
				representacao += " (ocorreu)";
			}
			else representacao += " (n ocorreu)";
		}
		else {
			representacao += "Nao finalizado";
		}
		
		return representacao;
	}
}
