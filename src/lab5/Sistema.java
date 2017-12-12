package lab5;

public class Sistema {
	private int caixa;
	private double taxa;
	private ControleCenarios controleCenarios;
	
	public Sistema(int caixa, double taxa) {
		this.caixa = caixa;
		this.taxa = taxa;
		this.controleCenarios = new ControleCenarios();
	}
	
	public int getCaixa() {
		return this.caixa;
	}
	
	public int cadastrarCenario(String descricao) {
		return this.controleCenarios.cadastrarCenario(descricao);
	}
	
	public String exibirCenario(int cenario) {
		return this.controleCenarios.exibirCenario(cenario);
	}
	
	public String exibirCenarios() {
		return this.controleCenarios.exibirCenarios();
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.controleCenarios.cadastrarAposta(cenario, apostador, valor, previsao);
	}
	
	public int valorTotalDeApostas(int cenario) {
		return this.controleCenarios.valorTotalDeApostas(cenario);
	}
	
	public int totalDeApostas(int cenario) {
		return this.controleCenarios.valorTotalDeApostas(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return this.controleCenarios.exibeApostas(cenario);
	}
	
	public int getCaixaCenario(int cenario) {
		int caixa = this.controleCenarios.getCaixa(cenario);
		
		double valorReal = ( (double)caixa ) * this.taxa;
		valorReal = Math.floor(valorReal);
		
		return ( (int)valorReal );
	}
	
	public int getTotalRateioCenario(int cenario) {
		int caixa = this.controleCenarios.getCaixa(cenario);
		return ( caixa - this.getCaixaCenario(cenario) );
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.controleCenarios.fecharAposta(cenario, ocorreu);
	}
}
