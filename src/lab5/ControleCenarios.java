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
}
