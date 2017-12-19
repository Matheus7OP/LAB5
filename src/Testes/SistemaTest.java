package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab5.Sistema;

public class SistemaTest {
	private Sistema sistema;
	
	@Before
	public void inicializar() {
		this.sistema = new Sistema(10000, 0.1);
	}
	
	@Test
	public void getCaixa() {
		assertEquals(this.sistema.getCaixa(), 10000);
	}
	
	@Test
	public void getCaixaCenario() {
		this.sistema.cadastrarCenario("Irá chover hoje.");
		this.sistema.cadastrarAposta(1, "Matheus", 1500, "VAI ACONTECER");
		this.sistema.fecharAposta(1, false);
		
		assertEquals(this.sistema.getCaixaCenario(1), 150);
	}
	
	@Test
	public void getTotalRateioTest() {
		this.sistema.cadastrarCenario("Irá chover hoje.");
		
		this.sistema.cadastrarAposta(1, "Matheus", 1500, "VAI ACONTECER");
		this.sistema.cadastrarAposta(1, "Victor", 250000, "N VAI ACONTECER");
		
		this.sistema.fecharAposta(1, true);
		
		assertEquals(this.sistema.getTotalRateioCenario(1), (250000 - 25000));
	}
}
