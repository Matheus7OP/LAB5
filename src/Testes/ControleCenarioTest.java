package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab5.ControleCenarios;

public class ControleCenarioTest {
	private ControleCenarios controleSimples;
	
	@Before
	public void inicializar() {
		this.controleSimples = new ControleCenarios();
	}
	
	@Test
	public void cadastrarCenarioTest() {
		assertEquals(this.controleSimples.exibirCenarios(), "");
		
		this.controleSimples.cadastrarCenario("A equipe de Cláudio ficou no Top 15 da Maratona da SBC");
		this.controleSimples.exibirCenarios();
		
		assertEquals(this.controleSimples.exibirCenarios(), "A equipe de Cláudio ficou no Top 15 da Maratona da SBC" + System.lineSeparator());
	}
}
