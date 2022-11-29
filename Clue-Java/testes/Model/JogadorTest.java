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
	public void testgetCartasBlocoNotas() {
		Cartas.reiniciaCartas();
		Cartas cartas = Cartas.getInstancia();
		Jogador jogador = new Jogador("Sra. White", 6);
		assertEquals("quantidade de cartas incorreta",3,jogador.getCartasBlocoNotas().length);
		jogador.marcaBlocoNotas(cartas.getEnvelope()[0]);
		assertEquals("carta nova não foi marcada no bloco",4,jogador.getCartasBlocoNotas().length);
	}
	
	@Test
	public void testsetBlock() {
		Cartas.reiniciaCartas();
		Jogador jogador = new Jogador("Sra. White", 6);
		jogador.setBlock();
		assertTrue("bloqueio não feito",jogador.block);
	}

	@Test
	public void testcriaJogador() {
		Jogador jogador = new Jogador("Sra. White", 6);
		int id = 1;
		int ncartas = 3;
		String persongm = "Sra. White";
		String[] cards = {"Faca", "Coronel Mustard", "Cozinha"};
		String [][] bn = {{"Corda","0"},{"Cano de Chumbo","0"},{"Faca","1"},{"Chave Inglesa","0"},{"Castiçal","0"},{"Revólver","0"},{"Coronel Mustard","1"},{"Srta. Scarlet","0"},{"Professor Plum","0"},{"Reverendo Green","0"},{"Sra. White","0"},{"Sra. Peacock","0"},{"Entrada","0"},{"Sala de Estar","0"},{"Sala de Jantar","0"},{"Cozinha","1"},{"Sala de Música","0"},{"Jardim de Inverno","0"},{"Salão de Jogos","0"},{"Biblioteca","0"},{"Escritório","0"}};
		String ultimoCmd = "Sala de Música";
		boolean bloq = false;
		int x_ = 10, y_ = 2;
		
		jogador.criaJogador(id, ncartas, persongm, cards, bn, ultimoCmd, bloq, x_, y_);
		
		assertEquals(jogador.identificador, id);
		assertEquals(jogador.numCartas, ncartas);
		assertEquals(jogador.personagem, persongm);
		assertArrayEquals(jogador.getCartas(), cards);
		assertArrayEquals(jogador.getBlocoNotas(), bn);
		assertEquals(jogador.ultimoComodo, ultimoCmd);
		assertEquals(jogador.block, bloq);
		assertEquals(jogador.x, x_);
		assertEquals(jogador.y, y_);
	}
}
