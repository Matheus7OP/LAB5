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
}
