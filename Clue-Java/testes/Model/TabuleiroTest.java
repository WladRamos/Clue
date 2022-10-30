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
		assertEquals("posição vazia está preenchida",0,tabuleiro.getTabuleiro()[5][5]);
		tabuleiro.ocupaPosicao(5, 5, 1);
		assertEquals("posição não preenchida com jogador dado",1,tabuleiro.getTabuleiro()[5][5]);
	}
	
	@Test
	public void testLiberaPosicao() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		tabuleiro.ocupaPosicao(5, 5, 1);
		tabuleiro.liberaPosicao(5, 5);
		assertEquals("posição não liberada",0,tabuleiro.getTabuleiro()[5][5]);
	}
	
	@Test
	public void testPosicaoLivre() {
		Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		tabuleiro.ocupaPosicao(5, 5, 1);
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
		int[] coord = tabuleiro.getPortaMaisProxima(xJogador,yJogador,area,1);
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
		int[] coord = tabuleiro.movePiaoPassagemSecreta(2,4,1);
		assertTrue("passagem secreta levou ao cômodo errado", coord[0]==22 && coord[1]==24);
		coord = tabuleiro.movePiaoPassagemSecreta(25,23,1);
		assertTrue("passagem secreta levou ao cômodo errado", coord[0]==4 && coord[1]==4);
		coord = tabuleiro.movePiaoPassagemSecreta(23,4,1);
		assertTrue("passagem secreta levou ao cômodo errado", coord[0]==6 && coord[1]==23);
		coord = tabuleiro.movePiaoPassagemSecreta(3,23,1);
		assertTrue("passagem secreta levou ao cômodo errado", coord[0]==24 && coord[1]==3);
		coord = tabuleiro.movePiaoPassagemSecreta(8,14,1);
		assertTrue("passagem secreta levou ao cômodo errado", coord[0]==0 && coord[1]==0);
	}
	
	@Test
	public void testMovePiao() {
		//testes feitos apenas com a janela gráfica do jogo
		//TODO: depois testar com JUnit
	}
}
