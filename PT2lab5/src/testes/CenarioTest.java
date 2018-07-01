package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Cenarios.Cenario;
import lab5.Aposta;

public class CenarioTest {
	
	Cenario cen;
	@Before
	public void inicia() {
		cen = new Cenario("EU VOU PAGAR CÁLCULO II COM NOTA BOA", 0.1, 1);
	}
	
	@Test(expected=NullPointerException.class)
	public void nullDescr() {
		Cenario erro = new Cenario(null, 0.2, 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalidTax() {
		Cenario erro = new Cenario("rafa vai pagar aa sem chorar", -1, 2);
	}

	@Test(expected=NullPointerException.class)
	public void testCadastraApostaNull() {
		cen.cadastrarAposta(null, 10, "sd");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void illegalvalue() {
		cen.cadastrarAposta("nome eu", -54, "nsei");
	}
	
	@Test(expected=NullPointerException.class)
	public void testPrevNull() {
		cen.cadastrarAposta("rafaaaahahaha", 10, null);
	}
	
	@Test
	public void testCadastraAposta() {
		cen.cadastrarAposta("rafa", 250, "VAI ACONTECER");
		cen.cadastrarAposta("minha mae", 25, "VAI ACONTECER");
	}
	
	@Test
	public void testExibeApostas() {
		cen.cadastrarAposta("rafa", 250, "VAI ACONTECER");
		cen.cadastrarAposta("minha mae", 25, "VAI ACONTECER");
		
		assertEquals("rafa - R$2,50 - VAI ACONTECER\n" +
					 "minha mae - R$0,25 - VAI ACONTECER", cen.exibeApostas());
		
	}

	@Test
	public void testFecharAposta() {
		cen.cadastrarAposta("rodrigo professor", 1000, "N VAI ACONTECER");
		cen.cadastrarAposta("rafa", 250, "VAI ACONTECER");
		cen.cadastrarAposta("minha mae", 25, "VAI ACONTECER");
		
		cen.fecharAposta(true);
	}

	@Test
	public void testTotalDeApostas() {
		cen.cadastrarAposta("rodrigo professor", 1000, "N VAI ACONTECER");
		cen.cadastrarAposta("rafa", 250, "VAI ACONTECER");
		cen.cadastrarAposta("minha mae", 25, "VAI ACONTECER");
		
		assertEquals(3, cen.totalDeApostas());
	}

	@Test
	public void testGetCaixaCenario() {
		cen.cadastrarAposta("rodrigo professor", 1000, "N VAI ACONTECER");
		cen.cadastrarAposta("rafa", 250, "VAI ACONTECER");
		cen.cadastrarAposta("minha mae", 25, "VAI ACONTECER");
		
		cen.fecharAposta(true);

		assertEquals(100, cen.getCaixaCenario());
	}

	@Test
	public void testValorTotalDeAposta() {
		cen.cadastrarAposta("rodrigo professor", 1000, "N VAI ACONTECER");
		cen.cadastrarAposta("rafa", 250, "VAI ACONTECER");
		cen.cadastrarAposta("minha mae", 25, "VAI ACONTECER");
		
		assertEquals(1275, cen.valorTotalDeAposta());
	}

	@Test
	public void testGetDescricao() {
		assertEquals("EU VOU PAGAR CÁLCULO II COM NOTA BOA", cen.getDescricao());
	}

	@Test
	public void testGetEstadoNfinali() {
		assertEquals("Não finalizado", cen.getEstado());
	}
	
	@Test
	public void testGetEstadoOcorreu() {
		cen.fecharAposta(true);
		assertEquals("Finalizado (ocorreu)", cen.getEstado());
	}
	
	@Test
	public void testGetEstado_N_ocorreu() {
		Cenario novo = new Cenario("RAFAELA VAI COMER MUITOO", 0.3, 2);
		//novo.fecharAposta(false);
		System.out.println(novo.getEstado());
		//assertEquals("Finalizado (n ocorreu)", novo.getEstado());
	}
	
	@Test
	public void testGetRateio() {
		cen.cadastrarAposta("rodrigo professor", 1000, "N VAI ACONTECER");
		cen.cadastrarAposta("rafa", 250, "VAI ACONTECER");
		cen.cadastrarAposta("minha mae", 25, "VAI ACONTECER");
		
		cen.fecharAposta(true);
		
		assertEquals(900, cen.calculaRateio());
	}

	@Test
	public void testToString() {
		assertEquals("EU VOU PAGAR CÁLCULO II COM NOTA BOA - Não finalizado", cen.toString());
	}

}