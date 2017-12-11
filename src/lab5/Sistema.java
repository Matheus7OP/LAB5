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
		int cenariosCadastrados = this.controleCenarios.cenariosCadastrados();
		String listagem = "";
		
		for(int i = 0; i < cenariosCadastrados; i++) {
			listagem += this.controleCenarios.exibirCenario(i+1) + System.lineSeparator();
		}
		
		return listagem;
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.controleCenarios.cadastrarAposta(cenario, apostador, valor, previsao);
	}
}
