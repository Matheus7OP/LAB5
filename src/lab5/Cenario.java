package lab5;

import java.util.ArrayList;

public class Cenario {
	private String descricao;
	private boolean finalizado;
	private int id;
	private ArrayList<Aposta> apostas;
	
	public Cenario(String descricao, int id) {
		this.descricao = descricao;
		this.finalizado = false;
		this.id = id;
		this.apostas = new ArrayList<Aposta>();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		this.apostas.add(aposta);
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
