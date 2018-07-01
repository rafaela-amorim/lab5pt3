package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab5pt2.Aposta;

public class ApostaTest {
	
	Aposta ap;
	
	@Before
	public void inicia() {
		ap = new Aposta("rafa", 250, "VAI ACONTECER");
	}

	@Test (expected=NullPointerException.class)
	public void nullAposta() {
		Aposta erro = new Aposta(null, 20, "nsei");
	}
	
	@Test (expected=NullPointerException.class)
	public void nullprevi() {
		Aposta erro = new Aposta("nome eu", 20, null);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void illegalName() {
		Aposta erro = new Aposta("     ", 54, "nsei");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void illegalPrev() {
		Aposta erro = new Aposta("nome eu", 54, "   ");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nullvalor() {
		Aposta erro = new Aposta("nome eu", -54, "nsei");
	}
	
	
	@Test
	public void testGetNomeApostador() {
		assertEquals("rafa", ap.getNomeApostador());
	}
	
	@Test
	public void testGetValor() {
		assertEquals(250, ap.getValor());
	}
	
	@Test
	public void testGetPrevisao() {
		assertEquals("VAI ACONTECER", ap.getPrevisao());
	}
	
	@Test
	public void testToString() {
		assertEquals("rafa - R$2,50 - VAI ACONTECER", ap.toString());
	}

}
