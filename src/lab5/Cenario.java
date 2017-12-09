package lab5;

public class Cenario {
	private String descricao;
	private boolean finalizado;
	private int id;
	
	public Cenario(String descricao, int id) {
		this.descricao = descricao;
		this.finalizado = false;
		this.id = id;
	}
	
	public int getId() {
		return this.id;
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
