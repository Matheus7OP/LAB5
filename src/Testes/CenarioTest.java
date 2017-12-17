package Testes;

import org.junit.Before;

import lab5.Cenario;

public class CenarioTest {
	private Cenario cenarioSimples;
	
	@Before
	public void inicializar() {
		this.cenarioSimples = new Cenario("Joãozinho ganhará medalha na OBI 2018", 1);
	}
}
