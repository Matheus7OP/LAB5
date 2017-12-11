package lab5;

public class Facade {
	private Sistema sistema;
	
	public void inicializa(int caixa, double taxa) {
		this.sistema = new Sistema(caixa, taxa);
	}
	
	public int getCaixa() {
		return this.sistema.getCaixa();
	}
	
	public int cadastrarCenario(String descricao) {
		return this.sistema.cadastrarCenario(descricao);
	}
	
	public String exibirCenario(int cenario) {
		return this.sistema.exibirCenario(cenario);
	}
	
	public String exibirCenarios() {
		return this.sistema.exibirCenarios();
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.sistema.cadastrarAposta(cenario, apostador, valor, previsao);
	}
	/*
	public int valorTotalDeApostas(int cenario)
	public int totalDeApostas(int cenario)
	public String exibeApostas(int cenario)
	public void fecharAposta(int cenario, boolean ocorreu) 
	public int getCaixaCenario(int cenario)
	public int getTotalRateioCenario(int cenario)
	*/
}
