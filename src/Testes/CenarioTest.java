package Testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import lab5.Cenario;

public class CenarioTest {
	private Cenario cenarioSimples;
	
	@Before
	public void inicializar() {
		this.cenarioSimples = new Cenario("Joãozinho ganhará medalha de Ouro na OBI 2018", 1);
	}
	
	@Test(expected=NullPointerException.class)
	public void descricaoNullTest() {
		Cenario cenario = new Cenario(null, 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void descricaoVaziaTest() {
		Cenario cenario = new Cenario("", 2);
	}
	
	@Test
	public void estaEncerradoTest() {
		assertFalse(this.cenarioSimples.estaEncerrado());
		this.cenarioSimples.fecharAposta(true);
		assertTrue(this.cenarioSimples.estaEncerrado());
	}
	
	@Test
	public void cadastrarApostaTest() {
		this.cenarioSimples.cadastrarAposta("Matheus", 123, "N VAI ACONTECER");
		
		assertEquals(this.cenarioSimples.totalDeApostas(), 1);
		assertEquals(this.cenarioSimples.valorTotalDeApostas(), 123);
		assertEquals(this.cenarioSimples.exibeApostas(), "Matheus - R$ 1,23 - N VAI ACONTECER" + System.lineSeparator());
	}
	
	@Test
	public void valorTotalDeApostasTest() {
		this.cenarioSimples.cadastrarAposta("Matheus", 123, "N VAI ACONTECER");
		this.cenarioSimples.cadastrarAposta("Gabriel", 427, "VAI ACONTECER");
		this.cenarioSimples.cadastrarAposta("Victor", 200, "N VAI ACONTECER");
		
		assertEquals(this.cenarioSimples.valorTotalDeApostas(), 750);
		
		this.cenarioSimples.cadastrarAposta("Victor", 250, "N VAI ACONTECER");
		assertEquals(this.cenarioSimples.valorTotalDeApostas(), 1000);
	}
	
	@Test
	public void totalDeApostasTest() {
		this.cenarioSimples.cadastrarAposta("Matheus", 123, "N VAI ACONTECER");
		assertEquals(this.cenarioSimples.totalDeApostas(), 1);
		
		this.cenarioSimples.cadastrarAposta("Gabriel", 427, "VAI ACONTECER");
		assertEquals(this.cenarioSimples.totalDeApostas(), 2);
		
		this.cenarioSimples.cadastrarAposta("Victor", 200, "N VAI ACONTECER");
		assertEquals(this.cenarioSimples.totalDeApostas(), 3);
		
		this.cenarioSimples.cadastrarAposta("Victor", 250, "N VAI ACONTECER");
		assertEquals(this.cenarioSimples.totalDeApostas(), 4);
	}
	
	@Test
	public void exibeApostasTest() {
		this.cenarioSimples.cadastrarAposta("Matheus", 123, "N VAI ACONTECER");
		assertEquals(this.cenarioSimples.exibeApostas(), "Matheus - R$ 1,23 - N VAI ACONTECER" + System.lineSeparator());
		
		this.cenarioSimples.cadastrarAposta("Victor", 250, "N VAI ACONTECER");
		assertEquals(this.cenarioSimples.exibeApostas(), "Matheus - R$ 1,23 - N VAI ACONTECER" + System.lineSeparator() +
		"Victor - R$ 2,50 - N VAI ACONTECER" + System.lineSeparator());
	}
	
	@Test
	public void fecharApostaTest() {
		this.cenarioSimples.cadastrarAposta("Matheus", 123, "N VAI ACONTECER");
		this.cenarioSimples.cadastrarAposta("Gabriel", 427, "VAI ACONTECER");
		this.cenarioSimples.cadastrarAposta("Victor", 200, "N VAI ACONTECER");
		
		assertEquals(this.cenarioSimples.getCaixa(), 0);
		assertEquals(this.cenarioSimples.estaEncerrado(), false);
		
		this.cenarioSimples.fecharAposta(false);
		
		assertEquals(this.cenarioSimples.getCaixa(), 427);
		assertEquals(this.cenarioSimples.estaEncerrado(), true);
	}
	
	@Test
	public void toStringTest() {
		assertEquals(this.cenarioSimples.toString(), "1 - Joãozinho ganhará medalha de Ouro na OBI 2018 - Nao finalizado");
		this.cenarioSimples.fecharAposta(true);
		assertEquals(this.cenarioSimples.toString(), "1 - Joãozinho ganhará medalha de Ouro na OBI 2018 - Finalizado (ocorreu)");
	}
}
