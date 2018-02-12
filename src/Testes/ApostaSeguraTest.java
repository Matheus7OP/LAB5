package Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lab5.ApostaSegura;

public class ApostaSeguraTest {
	private ApostaSegura aposta;
	
	@Test(expected=IllegalArgumentException.class)
	public void valorAsseguradoErradoTest() {
		this.aposta = new ApostaSegura("Matheus", 450, "VAI ACONTECER", -32, 1);
	}
	
	@Test
	public void toStringTest() {
		this.aposta = new ApostaSegura("Matheus", 450, "VAI ACONTECER", 200, 1);
		assertEquals(this.aposta.toString(), "Matheus - R$ 4,50 - VAI ACONTECER - ASSEGURADA (VALOR) - R$ 2,00");
	}
}
