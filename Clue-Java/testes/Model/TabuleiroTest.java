package Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class TabuleiroTest {

	@Test
	public void testGetTabuleiro() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		assertEquals("quantidade de linhas erradas",27,tabuleiro.getTabuleiro().length);
		assertEquals("quantidade de colunas erradas",26,tabuleiro.getTabuleiro()[0].length);
	}
	
	@Test
	public void testOcupaPosicao() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		assertEquals("posição vazia está preenchida",-1,tabuleiro.getTabuleiro()[5][5]);
		tabuleiro.ocupaPosicao(5, 5, "Reverendo Green");
		assertEquals("posição não preenchida com jogador dado",1,tabuleiro.getTabuleiro()[5][5]);
	}
	
	@Test
	public void testLiberaPosicao() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		tabuleiro.ocupaPosicao(5, 5, "Reverendo Green");
		tabuleiro.liberaPosicao(5, 5);
		assertEquals("posição não liberada",-1,tabuleiro.getTabuleiro()[5][5]);
	}
	
	@Test
	public void testPosicaoLivre() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		tabuleiro.ocupaPosicao(5, 5, "Reverendo Green");
		assertFalse("posição ocupada dada como livre",tabuleiro.posicaoLivre(5,5));
		tabuleiro.liberaPosicao(5, 5);
		assertTrue("posição livre dada como ocupada",tabuleiro.posicaoLivre(5,5));
	}
	
	@Test
	public void testGetAreaDoTabuleiro() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		assertEquals("area errada","àrea inválida",tabuleiro.getAreaDoTabuleiro(0,0));
		assertEquals("area errada","Cozinha",tabuleiro.getAreaDoTabuleiro(5,4));
		assertEquals("area errada","Sala de Música",tabuleiro.getAreaDoTabuleiro(16,5));
		assertEquals("area errada","Jardim de Inverno",tabuleiro.getAreaDoTabuleiro(23,5));
		assertEquals("area errada","Sala de Jantar",tabuleiro.getAreaDoTabuleiro(6,13));
		assertEquals("area errada","Salão de Jogos",tabuleiro.getAreaDoTabuleiro(25,10));
		assertEquals("area errada","Biblioteca",tabuleiro.getAreaDoTabuleiro(23,16));
		assertEquals("area errada","Sala de Estar",tabuleiro.getAreaDoTabuleiro(5,23));
		assertEquals("area errada","Entrada",tabuleiro.getAreaDoTabuleiro(14,19));
		assertEquals("area errada","Escritório",tabuleiro.getAreaDoTabuleiro(24,24));
		assertEquals("area errada","Casas Comuns",tabuleiro.getAreaDoTabuleiro(2,8));
		assertEquals("area errada","Casas Comuns",tabuleiro.getAreaDoTabuleiro(18,12));
		assertEquals("area errada","Casas Comuns",tabuleiro.getAreaDoTabuleiro(9,23));
	}
	
	@Test
	public void testGetPortaMaisProxima() {
		getPortaMaisProximaHelper(0,0,6,8,"Cozinha");
		getPortaMaisProximaHelper(0,0,20,6,"Jardim de Inverno");
		getPortaMaisProximaHelper(0,0,8,19,"Sala de Estar");
		getPortaMaisProximaHelper(0,0,19,21,"Escritório");
		getPortaMaisProximaHelper(11,18,13,18,"Entrada");
		getPortaMaisProximaHelper(16,18,14,18,"Entrada");
		getPortaMaisProximaHelper(19,20,17,21,"Entrada");
		getPortaMaisProximaHelper(18,4,18,6,"Sala de Música");
		getPortaMaisProximaHelper(18,12,16,9,"Sala de Música");
		getPortaMaisProximaHelper(6,4,9,6,"Sala de Música");
		getPortaMaisProximaHelper(11,13,11,9,"Sala de Música");
	}
	private void getPortaMaisProximaHelper(int xJogador, int yJogador, int xPorta, int yPorta, String area) {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		int[] coord = tabuleiro.getPortaMaisProxima(xJogador,yJogador,area,"Reverendo Green");
		assertTrue("porta errada", coord[0]==xPorta && coord[1]==yPorta);
	}
	
	@Test
	public void testPermissaoPassagemSecreta() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		assertTrue("passagem secreta não identificada", tabuleiro.permissaoPassagemSecreta(5,3));
		assertTrue("passagem secreta não identificada", tabuleiro.permissaoPassagemSecreta(22,5));
		assertTrue("passagem secreta não identificada", tabuleiro.permissaoPassagemSecreta(6,20));
		assertTrue("passagem secreta não identificada", tabuleiro.permissaoPassagemSecreta(25,24));
		assertFalse("passagem secreta não identificada", tabuleiro.permissaoPassagemSecreta(15,5));
		assertFalse("passagem secreta não identificada", tabuleiro.permissaoPassagemSecreta(20,6));
	}
	
	@Test
	public void testMovePiaoPassagemSecreta() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		int[] coord = tabuleiro.movePiaoPassagemSecreta(2,4,"Reverendo Green");
		String area = tabuleiro.getAreaDoTabuleiro(coord[0], coord[1]);
		assertEquals("passagem secreta levou ao cômodo errado", "Escritório", area);
		
		coord = tabuleiro.movePiaoPassagemSecreta(25,23,"Reverendo Green");
		area = tabuleiro.getAreaDoTabuleiro(coord[0], coord[1]);
		assertEquals("passagem secreta levou ao cômodo errado", "Cozinha", area);
		
		coord = tabuleiro.movePiaoPassagemSecreta(23,4,"Reverendo Green");
		area = tabuleiro.getAreaDoTabuleiro(coord[0], coord[1]);
		assertEquals("passagem secreta levou ao cômodo errado", "Sala de Estar", area);
		
		coord = tabuleiro.movePiaoPassagemSecreta(3,23,"Reverendo Green");
		area = tabuleiro.getAreaDoTabuleiro(coord[0], coord[1]);
		assertEquals("passagem secreta levou ao cômodo errado", "Jardim de Inverno", area);
		
		coord = tabuleiro.movePiaoPassagemSecreta(8,14,"Reverendo Green");
		assertEquals("passagem secreta levou ao cômodo errado", coord, null);
	}
	
	@Test
	public void testMovePiao() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		tabuleiro.zeraTabuleiro();
		assertTrue("Andou um número de casas equivalente aos passos disponiveis" , tabuleiro.movePiao(18, 2, 18, 6, 4, "Reverendo Green"));
		assertFalse("Tentou andar um número de casas maior que os passos disponiveis" , tabuleiro.movePiao(18, 2, 18, 25, 4, "Reverendo Green"));
		assertFalse("Tentou andar para uma casa inválida" , tabuleiro.movePiao(23, 7, 25, 7, 6, "Reverendo Green"));
		assertFalse("Tentou andar para dentro do quadro detetive" , tabuleiro.movePiao(14, 10, 14, 11, 6, "Reverendo Green"));
		assertFalse("Tentou andar para uma posição ocupada" , tabuleiro.movePiao(11, 2, 11, 1, 6, "Reverendo Green"));
		assertTrue("Contornou um desvio" , tabuleiro.movePiao(11, 11, 17, 11, 8, "Reverendo Green"));
		assertFalse("Não conseguiu contornar  um desvio" , tabuleiro.movePiao(11, 11, 17, 11, 6, "Reverendo Green"));
		tabuleiro.zeraTabuleiro();
		assertTrue("Entrou pela porta" , tabuleiro.movePiao(16, 1, 16, 3, 8, "Reverendo Green"));
		assertFalse("Não conseguiu entrar pela porta" , tabuleiro.movePiao(16, 1, 16, 3, 4, "Reverendo Green"));
		assertTrue("Saiu da biblioteca para casas comuns" , tabuleiro.movePiao(22, 15, 22, 13, 8, "Reverendo Green"));
		assertFalse("Não conseguiu sair de um comodo" , tabuleiro.movePiao(7, 3, 8, 3, 1, "Reverendo Green"));
		assertTrue("Indo da cozinha para o escritorio com passagem secreta" , tabuleiro.movePiao(3, 2, 23, 24, 9, "Reverendo Green"));		
	}
	
	@Test
	public void testReiniciaTabuleiro() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		
		tabuleiro.movePiao(11, 1, 11, 2, 4, "Sra. White");
		tabuleiro.movePiao(16, 1, 16, 2, 4, "Reverendo Green");
		tabuleiro.movePiao(25, 7, 24, 7, 4, "Sra. Peacock");
		tabuleiro.movePiao(2, 18, 3, 18, 4, "Coronel Mustard");
		tabuleiro.movePiao(9, 25, 9, 24, 4, "Srta. Scarlet");
		tabuleiro.movePiao(25, 20, 24, 20, 4, "Professor Plum");
		
		int[] coord = tabuleiro.getCoordenadaDoPiao("Sra. White");
		assertFalse("Sra. White fora de posição", coord[0] == 11 && coord[1] == 1);
		coord = tabuleiro.getCoordenadaDoPiao("Reverendo Green");
		assertFalse("Reverendo Green fora de posição", coord[0] == 16 && coord[1] == 1);
		coord = tabuleiro.getCoordenadaDoPiao("Sra. Peacock");
		assertFalse("Sra. Peacock fora de posição", coord[0] == 25 && coord[1] == 7);
		coord = tabuleiro.getCoordenadaDoPiao("Coronel Mustard");
		assertFalse("Coronel Mustard fora de posição", coord[0] == 2 && coord[1] == 18);
		coord = tabuleiro.getCoordenadaDoPiao("Srta. Scarlet");
		assertFalse("Srta. Scarlet fora de posição", coord[0] == 9 && coord[1] == 25);
		coord = tabuleiro.getCoordenadaDoPiao("Professor Plum");
		assertFalse("Professor Plum fora de posição", coord[0] == 25 && coord[1] == 20);
		
		tabuleiro.reiniciaTabuleiro();
		
		coord = tabuleiro.getCoordenadaDoPiao("Sra. White");
		assertTrue("Sra. White não retornou para o inicio", coord[0] == 11 && coord[1] == 1);
		coord = tabuleiro.getCoordenadaDoPiao("Reverendo Green");
		assertTrue("Reverendo Green não retornou para o inicio", coord[0] == 16 && coord[1] == 1);
		coord = tabuleiro.getCoordenadaDoPiao("Sra. Peacock");
		assertTrue("Sra. Peacock não retornou para o inicio", coord[0] == 25 && coord[1] == 7);
		coord = tabuleiro.getCoordenadaDoPiao("Coronel Mustard");
		assertTrue("Coronel Mustard não retornou para o inicio", coord[0] == 2 && coord[1] == 18);
		coord = tabuleiro.getCoordenadaDoPiao("Srta. Scarlet");
		assertTrue("Srta. Scarlet não retornou para o inicio", coord[0] == 9 && coord[1] == 25);
		coord = tabuleiro.getCoordenadaDoPiao("Professor Plum");
		assertTrue("Professor Plum não retornou para o inicio", coord[0] == 25 && coord[1] == 20);
	}
	
	@Test
	public void testSetTabuleiro() {
		int [][] coordJogadores = {{11,2},{16,2},{24,7}};
		String[] jogadores = {"Sra. White","Reverendo Green","Sra. Peacock"};
		int[][] coordBots = {{3,18},{9,24},{24,20}};
		String[] bots = {"Coronel Mustard","Srta. Scarlet","Professor Plum"};
		
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		tabuleiro.zeraTabuleiro();
		tabuleiro.setTabuleiro(coordJogadores, jogadores, coordBots, bots);
		
		int[] coord = tabuleiro.getCoordenadaDoPiao("Sra. White");
		assertTrue("Sra. White fora de posição", coord[0] == 11 && coord[1] == 2);
		coord = tabuleiro.getCoordenadaDoPiao("Reverendo Green");
		assertTrue("Reverendo Green fora de posição", coord[0] == 16 && coord[1] == 2);
		coord = tabuleiro.getCoordenadaDoPiao("Sra. Peacock");
		assertTrue("Sra. Peacock fora de posição", coord[0] == 24 && coord[1] == 7);
		coord = tabuleiro.getCoordenadaDoPiao("Coronel Mustard");
		assertTrue("Coronel Mustard fora de posição", coord[0] == 3 && coord[1] == 18);
		coord = tabuleiro.getCoordenadaDoPiao("Srta. Scarlet");
		assertTrue("Srta. Scarlet fora de posição", coord[0] == 9 && coord[1] == 24);
		coord = tabuleiro.getCoordenadaDoPiao("Professor Plum");
		assertTrue("Professor Plum fora de posição", coord[0] == 24 && coord[1] == 20);
	}
	
	@Test
	public void testmovePiaoIncondicional() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		tabuleiro.zeraTabuleiro();
		tabuleiro.movePiaoIncondicional(11,1, 20,25, "Sra. White" );
		
		int[] coord = tabuleiro.getCoordenadaDoPiao("Sra. White");
		assertTrue(coord[0] == 20 && coord[1] == 25);
	}
	
	@Test
	public void testzeraTabuleiro() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		int [][]tab = tabuleiro.getTabuleiro();
		tabuleiro.movePiaoIncondicional(11,1, 20,25, "Sra. White" );
		tabuleiro.zeraTabuleiro();
		for(int x=0;x<27;x++) {
			for(int y=0;y<26;y++) assertTrue(tab[x][y] == -1);
		}
	}
	
	@Test
	public void testCoordenadaArea() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		tabuleiro.zeraTabuleiro();
		
		int[] coord = tabuleiro.getCoordenadaArea("Cozinha");
		int[] aux = {2,1};
		assertArrayEquals(coord,aux);
		
		coord = tabuleiro.getCoordenadaArea("Sala de Jantar");
		aux[0] = 2;
		aux[1] = 10;
		assertArrayEquals(coord,aux);
		
		coord = tabuleiro.getCoordenadaArea("Sala de Estar");
		aux[0] = 2;
		aux[1] = 20;
		assertArrayEquals(coord,aux);
		
		coord = tabuleiro.getCoordenadaArea("Sala de Música");
		aux[0] = 12;
		aux[1] = 2;
		assertArrayEquals(coord,aux);
		
		coord = tabuleiro.getCoordenadaArea("Entrada");
		aux[0] = 11;
		aux[1] = 19;
		assertArrayEquals(coord,aux);
		
		coord = tabuleiro.getCoordenadaArea("Jardim de Inverno");
		aux[0] = 20;
		aux[1] = 2;
		assertArrayEquals(coord,aux);
		
		coord = tabuleiro.getCoordenadaArea("Salão de Jogos");
		aux[0] = 20;
		aux[1] = 9;
		assertArrayEquals(coord,aux);
		
		coord = tabuleiro.getCoordenadaArea("Escritório");
		aux[0] = 19;
		aux[1] = 22;
		assertArrayEquals(coord,aux);
		
		coord = tabuleiro.getCoordenadaArea("Biblioteca");
		aux[0] = 20;
		aux[1] = 15;
		assertArrayEquals(coord,aux);
		
		coord = tabuleiro.getCoordenadaArea("a");
		aux[0] = 0;
		aux[1] = 0;
		assertArrayEquals(coord,aux);
	}
	
	@Test
	public void testgetPorta() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		
		//{"Cozinha", "Sala de Jantar", "Sala de Estar", "Sala de Música", "Entrada", "Jardim de Inverno", "Salão de Jogos", "Escritório", "Biblioteca"};
		String area = tabuleiro.getPorta(6, 8);
		assertEquals(area, "Cozinha");
		area = tabuleiro.getPorta(10, 13);
		assertEquals(area, "Sala de Jantar");
		area = tabuleiro.getPorta(8, 19);
		assertEquals(area, "Sala de Estar");
		area = tabuleiro.getPorta(9, 6);
		assertEquals(area, "Sala de Música");
		area = tabuleiro.getPorta(13, 18);
		assertEquals(area, "Entrada");
		area = tabuleiro.getPorta(20, 6);
		assertEquals(area, "Jardim de Inverno");
		area = tabuleiro.getPorta(19,10);
		assertEquals(area, "Salão de Jogos");
		area = tabuleiro.getPorta(22, 14);
		assertEquals(area, "Biblioteca");
		area = tabuleiro.getPorta(19, 21);
		assertEquals(area, "Escritório");
		area = tabuleiro.getPorta(21, 5);
		assertEquals(area, "não é porta");	
	}
}

