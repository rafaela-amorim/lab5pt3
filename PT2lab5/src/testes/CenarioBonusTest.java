package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Cenarios.CenarioBonus;

public class CenarioBonusTest {

	CenarioBonus cb;
	@Before
	public void inicia() {
		cb = new CenarioBonus("Meus dedos vão cair antes de terminar o semestre", 0.1, 2000);
	}
	
	@Test(expected=IllegalAccessError.class)
	public void testCalculaRateio() {
		cb.calculaRateio();
	}

	@Test
	public void testCalculaRateioCenFechado() {
		cb.cadastrarAposta("rafa", 300, "VAI ACONTECER");
		cb.fecharAposta(false);
		assertEquals(2270, cb.calculaRateio());	// 300 - 300 * 0.1 = 270 -> 270 + 2000
	}

	@Test
	public void testToString() {
		assertEquals("Meus dedos vão cair antes de terminar o semestre - Não finalizado - R$20,00",
					  cb.toString());
	}

	@Test(expected=NullPointerException.class)
	public void testCenarioBonusDescr() {
		CenarioBonus erro = new CenarioBonus(null, 0, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCenarioBonBonus() {
		CenarioBonus erro = new CenarioBonus("descricao generica sono", 0, -89);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCenarioBonusDescrInvalid() {
		CenarioBonus erro = new CenarioBonus("    ", 0, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCenarioBonusPorcInvalid() {
		CenarioBonus erro; 
		erro = new CenarioBonus("nunca mais eu me matriculo em aa dnovo meus dedinhos lindos vão cair", -1455862, 6);
	}
	
	@Test
	public void testGetBonus() {
		assertEquals(2000, cb.getBonus());
	}

}
