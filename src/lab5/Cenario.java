package lab5;

import java.util.ArrayList;

public class Cenario {
	private String descricao;
	private boolean finalizado;
	private int id, caixa;
	private ArrayList<Aposta> apostas;
	private boolean encerrado;
	
	public Cenario(String descricao, int id) {
		this.descricao = descricao;
		this.finalizado = false;
		this.id = id;
		this.apostas = new ArrayList<Aposta>();
		this.encerrado = false;
		this.caixa = 0;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getCaixa() {
		return this.caixa;
	}
	
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		this.apostas.add(aposta);
	}
	
	public int totalDeApostas() {
		return this.apostas.size();
	}
	
	public int valorTotalDeApostas() {
		int totalDeApostas = this.totalDeApostas(), somatorio = 0;
		
		for(int i = 0; i < totalDeApostas; i++) {
			somatorio += this.apostas.get(i).getValor();
		}
		
		return somatorio;
	}
	
	public String exibeApostas() {
		String listagem = "";
		int totalDeApostas = this.totalDeApostas();
		
		for(int i = 0; i < totalDeApostas; i++) {
			listagem += this.apostas.get(i).toString() + System.lineSeparator();
		}
		
		return listagem;
	}
	
	public void fecharAposta(boolean ocorreu) {
		if( this.encerrado ) return;
		int totalDeApostas = this.totalDeApostas();
		
		for(int i = 0; i < totalDeApostas; i++) {
			if( !ocorreu && this.apostas.get(i).getPrevisao().equals("VAI ACONTECER") ) {
				this.caixa += this.apostas.get(i).getValor();
			}
			if( ocorreu && this.apostas.get(i).getPrevisao().equals("N VAI ACONTECER") ) {
				this.caixa += this.apostas.get(i).getValor();
			}
		}
	}
	
	@Override
	public String toString() {
		String representacao = this.id + " - " + this.descricao + " - ";
		
		if( this.finalizado ) {
			representacao += "Finalizado (ocorreu)";
		}
		else {
			representacao += "Não finalizado";
		}
		
		return representacao;
	}
}
