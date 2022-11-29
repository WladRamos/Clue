package Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class DadosTest {
	
	@Test
	public void testDados() {
		Dados dados = new Dados();
		dados.jogaDados();
		assertTrue("valor do 1o dado inválido",dados.dado1 >0 && dados.dado1 <=6);
		assertTrue("valor do 2o dado inválido",dados.dado2 >0 && dados.dado2 <=6);
	}
	
	@Test
	public void testJogaDados() {
		Dados dados = new Dados();
		int jogada = dados.jogaDados();
		assertEquals("soma dos dados errada",dados.dado1+dados.dado2,jogada);
		assertTrue("soma dos dados inválida",jogada >0 && jogada <=12);
	}

}
