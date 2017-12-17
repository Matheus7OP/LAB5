package Testes;

import org.junit.Before;
import org.junit.Test;

import lab5.Aposta;

public class ApostaTest {
	private Aposta apostaSimples;
	
	@Before
	public void inicializar() {
		this.apostaSimples = new Aposta("Matheus Oliveira", 777, "VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void nomeNullTest() {
		Aposta aposta = new Aposta(null, 123, "N VAI ACONTECER");
	}
	
	@Test(expected=NullPointerException.class)
	public void previsaoNullTest() {
		Aposta aposta = new Aposta("Matheus", 123, null);
	}
}
