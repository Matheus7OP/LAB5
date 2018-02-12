package Testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab5.CenarioBonus;

public class CenarioBonusTest {
	private CenarioBonus cenarioSimples;
	
	@Before
	public void inicializar() {
		this.cenarioSimples = new CenarioBonus("Pigmeu ganhará medalha de ouro na OBI 2018", 1, 200);
	}
	
	@Test
	public void toStringTest() {
		assertEquals( this.cenarioSimples.toString(), "1 - Pigmeu ganhará medalha de ouro na OBI 2018 - Nao finalizado - R$ 2,00" );
	}
}
