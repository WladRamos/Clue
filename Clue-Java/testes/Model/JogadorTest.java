package Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class JogadorTest {

	@Test
	public void testCriacaoJogador() {
		Cartas.reiniciaCartas();
		CriacaoJogadorHelper("Reverendo Green",4,1,4);
		CriacaoJogadorHelper("Coronel Mustard",4,2,4);
		CriacaoJogadorHelper("Srta. Scarlet",4,3,5);
		CriacaoJogadorHelper("Professor Plum",4,4,5);
	}
	private void CriacaoJogadorHelper(String pngm, int numJog, int id, int cartas) {
		if(id==1) Jogador.reiniciaJogador();
		Jogador jog = new Jogador(pngm, numJog);
		CriacaoJogadorIdHelper(jog, id);
		CriacaoJogadorNumCartasHelper(jog, cartas);
		CriacaoJogadorPersonagemHelper(jog,pngm);
	}
	private void CriacaoJogadorIdHelper(Jogador jog, int id) {
		assertEquals("identificador incorreto",id, jog.identificador);
	}
	private void CriacaoJogadorNumCartasHelper(Jogador jog, int cartas) {
		assertEquals("número de cartas incorreto",cartas, jog.numCartas);
	}
	private void CriacaoJogadorPersonagemHelper(Jogador jog,String pngm) {
		assertEquals("personagem incorreto",pngm, jog.personagem);
	}
	
	@Test
	public void testRecebeCartasQuantidadeCorreta() {
		Cartas.reiniciaCartas();
		Jogador jogador = new Jogador("Sra. White", 6);
		int n = jogador.numCartas;
		assertEquals("quantidade de cartas errada para esse jogador",n,jogador.getCartas().length);
	}
	
	@Test
	public void testRecebeCartasValidas() {
		Cartas.reiniciaCartas();
		Jogador jogador = new Jogador("Sra. White", 6);
		
		int erro=0;
		for(int i=0;i<jogador.numCartas;i++) {
			if(jogador.getCartas()[i]=="0") erro++;
		}
		assertEquals("jogador recebeu cartas inválidas",0,erro);
	}
	
	@Test
	public void testIniciaBlocoNotas() {
		Cartas.reiniciaCartas();
		Jogador jogador = new Jogador("Sra. White", 3);
		
		int erro=0;
		for(String c: jogador.getCartas()) {
			for(String[] b: jogador.getBlocoNotas()) {
				if(c==b[0]) {
					if(b[1]!="1") erro++;
				}
			}
		}assertEquals("não foram marcadas todas as cartas recebidas no bloco de notas",0,erro);
	}
	
	@Test
	public void testMarcaBlocoNotas() {
		Cartas cartas = Cartas.getInstancia();
		Cartas.reiniciaCartas();
		Jogador jogador = new Jogador("Sra. White", 3);
		String[] envelope = cartas.getEnvelope();
		int contador=0;
		for(String[] c: jogador.getBlocoNotas()) {
			if(c[0]==envelope[1]) break;
			contador++;
		}
		assertEquals("carta já estava marcada no bloco de notas","0",jogador.getBlocoNotas()[contador][1]);
		jogador.marcaBlocoNotas("Faca");
		assertEquals("carta não foi marcada no bloco de notas","1",jogador.getBlocoNotas()[2][1]);
	}
	
	@Test
	public void testgetCartas() {
		Cartas.reiniciaCartas();
		Jogador jogador = new Jogador("Sra. White", 6);
		String[] selecao = {"Faca", "Coronel Mustard", "Cozinha"};
		jogador.recebeCartas(3, selecao);
		
		assertEquals("quantidade de cartas incorreta",3,jogador.getCartas().length);
		assertEquals("cartas incorreta","Faca",jogador.getCartas()[0]);
		assertEquals("cartas incorreta","Coronel Mustard",jogador.getCartas()[1]);
		assertEquals("cartas incorreta","Cozinha",jogador.getCartas()[2]);
	}
	
	@Test
	public void testgetBlocoNotas() {
		Cartas.reiniciaCartas();
		Jogador jogador = new Jogador("Sra. White", 6);
		assertEquals("quantidade de cartas incorreta",21,jogador.getBlocoNotas().length);
		assertEquals("quantidade de cartas incorreta",2,jogador.getBlocoNotas()[9].length);
		assertEquals("cartas incorreta","Faca",jogador.getBlocoNotas()[2][0]);
	}
	
	@Test
	public void testsetBlock() {
		Cartas.reiniciaCartas();
		Jogador jogador = new Jogador("Sra. White", 6);
		jogador.setBlock();
		assertTrue("bloqueio não feito",jogador.block);
	}

}
