package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab5.Cenario;
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
		
		assertEquals(this.controleSimples.exibirCenario(1), "1 - A equipe de Cláudio ficou no Top 15 da Maratona da SBC - Nao finalizado");
		assertEquals(this.controleSimples.exibirCenarios(), "1 - A equipe de Cláudio ficou no Top 15 da Maratona da SBC - Nao finalizado" + System.lineSeparator());
	}
	
	@Test
	public void exibirCenarioTest() {
		this.controleSimples.cadastrarCenario("A equipe de Cláudio ficou no Top 15 da Maratona da SBC");
		assertEquals(this.controleSimples.exibirCenario(1), "1 - A equipe de Cláudio ficou no Top 15 da Maratona da SBC - Nao finalizado");
	}
	
	@Test
	public void cenariosCadastradosTest() {
		assertEquals(this.controleSimples.cenariosCadastrados(), 0);
		
		this.controleSimples.cadastrarCenario("Clodovaldo irá para a escola");
		assertEquals(this.controleSimples.cenariosCadastrados(), 1);
		
		this.controleSimples.cadastrarCenario("Hoje comerei pastel");
		assertEquals(this.controleSimples.cenariosCadastrados(), 2);
		
		this.controleSimples.cadastrarCenario("Hoje não comerei pastel");
		assertEquals(this.controleSimples.cenariosCadastrados(), 3);
	}
	
	@Test
	public void cadastrarApostaTest() {
		this.controleSimples.cadastrarCenario("A equipe de Cláudio ficou no Top 15 da Maratona da SBC");
		this.controleSimples.cadastrarAposta(1, "Matheus", 42, "VAI ACONTECER");
		
		assertEquals(this.controleSimples.exibeApostas(1), "Matheus - R$ 0,42 - VAI ACONTECER" + System.lineSeparator());
	}
	
	@Test
	public void valorTotalDeApostas() {
		this.controleSimples.cadastrarCenario("A equipe de Cláudio ficou no Top 15 da Maratona da SBC");
		this.controleSimples.cadastrarAposta(1, "Matheus", 42, "VAI ACONTECER");
		
		assertEquals(this.controleSimples.valorTotalDeApostas(1), 42);
	}
	
	@Test
	public void totalDeApostasTest() {
		this.controleSimples.cadastrarCenario("A equipe de Cláudio ficou no Top 15 da Maratona da SBC");
		this.controleSimples.cadastrarAposta(1, "Matheus", 42, "VAI ACONTECER");
		this.controleSimples.cadastrarAposta(1, "João", 642, "N VAI ACONTECER");
		
		assertEquals(this.controleSimples.totalDeApostas(1), 2);
	}
	
	@Test
	public void exibeApostas() {
		this.controleSimples.cadastrarCenario("A equipe de Cláudio ficou no Top 15 da Maratona da SBC");
		this.controleSimples.cadastrarAposta(1, "Matheus", 42, "VAI ACONTECER");
		
		assertEquals(this.controleSimples.exibeApostas(1), "Matheus - R$ 0,42 - VAI ACONTECER" + System.lineSeparator());
	}
	
	@Test
	public void fecharApostaTest() {
		this.controleSimples.cadastrarCenario("A equipe de Cláudio ficou no Top 15 da Maratona da SBC");
		this.controleSimples.cadastrarAposta(1, "Matheus", 642, "N VAI ACONTECER");
		this.controleSimples.fecharAposta(1, true);
		
		assertEquals(this.controleSimples.getCaixa(1), 642);
	}
	
	@Test
	public void cenarioEncerradoTest() {
		this.controleSimples.cadastrarCenario("A equipe de Cláudio ficou no Top 15 da Maratona da SBC");
		assertFalse(this.controleSimples.cenarioEncerrado(1));
		
		this.controleSimples.fecharAposta(1, true);
		assertTrue(this.controleSimples.cenarioEncerrado(1));
	}
	
	@Test
	public void exibirCenariosTest() {
		this.controleSimples.cadastrarCenario("A equipe de Cláudio ficou no Top 15 da Maratona da SBC");
		assertEquals(this.controleSimples.exibirCenarios(), "1 - A equipe de Cláudio ficou no Top 15 da Maratona da SBC - Nao finalizado" + System.lineSeparator());
	}
}
