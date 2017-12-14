package lab5;

import java.util.ArrayList;

public class ControleCenarios {
	private ArrayList<Cenario> conjuntoCenarios;
	
	public ControleCenarios() {
		this.conjuntoCenarios = new ArrayList<Cenario>();
	}
	
	public int cadastrarCenario(String descricao) {
		Cenario cenario = new Cenario(descricao, this.conjuntoCenarios.size() + 1);
		this.conjuntoCenarios.add(cenario);
		return cenario.getId();
	}
	
	public String exibirCenario(int cenario) {
		return this.conjuntoCenarios.get(cenario - 1).toString();
	}
	
	public int cenariosCadastrados() {
		return this.conjuntoCenarios.size();
	}
	
	/**
	 * Método utilizado para cadastrar uma nova aposta ao
	 * sistema.
	 * 
	 * @param cenario id do cenário no qual a aposta será colocada
	 * @param apostador nome do apostador
	 * @param valor o valor que será apostado
	 * @param previsao resultado esperado pelo apostador
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.conjuntoCenarios.get(cenario - 1).cadastrarAposta(apostador, valor, previsao);
	}
	
	public int valorTotalDeApostas(int cenario) {
		return this.conjuntoCenarios.get(cenario - 1).valorTotalDeApostas();
	}
	
	public int totalDeApostas(int cenario) {
		return this.conjuntoCenarios.get(cenario - 1).totalDeApostas();
	}
	
	/**
	 * Retorna uma listagem de todas as apostas feitas
	 * em um cenário.
	 * 
	 * @param cenario o id do cenário a ser verificado
	 * @return a listagem das apostas do cenário
	 */
	public String exibeApostas(int cenario) {
		return this.conjuntoCenarios.get(cenario - 1).exibeApostas();
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.conjuntoCenarios.get(cenario - 1).fecharAposta(ocorreu);
	}
	
	public int getCaixa(int cenario) {
		return this.conjuntoCenarios.get(cenario - 1).getCaixa();
	}
	
	public String exibirCenarios() {
		int cenariosCadastrados = this.cenariosCadastrados();
		String listagem = "";
		
		for(int i = 0; i < cenariosCadastrados; i++) {
			listagem += this.exibirCenario(i+1) + System.lineSeparator();
		}
		
		return listagem;
	}
}
