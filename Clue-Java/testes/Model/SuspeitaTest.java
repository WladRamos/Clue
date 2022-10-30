package Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class SuspeitaTest {

	@Test
	public void testCriacaoSuspeita() {
		Suspeita suspeita = new Suspeita("Faca", "Srta. Scarlet", "Cozinha");
		boolean suspeitaCorreta = (suspeita.arma=="Faca" && suspeita.suspeito=="Srta. Scarlet" && suspeita.comodo=="Cozinha");
		assertTrue("suspeita gravada incorretamente", suspeitaCorreta);
	}
	
	@Test
	public void testDarPalpiteForaDoLugar() {
		Suspeita suspeita = new Suspeita("Faca", "Srta. Scarlet", "Cozinha");
		assertFalse("jogador não está no local do palpite", suspeita.DarPalpite("Sala de Estar"));
	}
	
	@Test
	public void testDarPalpiteNoLugar() {
		Suspeita suspeita = new Suspeita("Faca", "Srta. Scarlet", "Cozinha");
		assertTrue("jogador não está no local do palpite", suspeita.DarPalpite("Cozinha"));
	}
	
	@Test
	public void testConfirmarPalpiteVerdadeiro() {
		Cartas cartas = Cartas.getInstancia();
		Cartas.reiniciaCartas();
		Jogador j1 = new Jogador("Srta. Scarlet", 3), j2 = new Jogador("Coronel Mustard",3), 
				j3 = new Jogador("Professor Plum",3); 
		Jogador[] jogadores = {j2,j3};
		
		Suspeita suspeita = new Suspeita(cartas.getEnvelope()[0], cartas.getEnvelope()[1], cartas.getEnvelope()[2]);
		assertTrue("palpite verdadeiro retornou falso", suspeita.confirmarPalpite(j1, jogadores));
	}
	
	@Test
	public void testConfirmarPalpiteFalso() {
		Cartas cartas = Cartas.getInstancia();
		Cartas.reiniciaCartas();
		Jogador j1 = new Jogador("Srta. Scarlet", 3), j2 = new Jogador("Coronel Mustard",3), 
				j3 = new Jogador("Professor Plum",3); 
		Jogador[] jogadores = {j2,j3};
		
		String[] Armas = {"Corda", "Cano de Chumbo", "Faca", "Chave Inglesa", "Castiçal", "Revólver"};
		String[] Suspeitos = {"Coronel Mustard", "Srta. Scarlet", "Professor Plum", "Reverendo Green", "Sra. White", "Sra. Peacock"};
		String[] Comodos = {"Entrada", "Sala de Estar", "Sala de Jantar", "Cozinha", "Sala de Música", "Jardim de Inverno", "Salão de Jogos", "Biblioteca", "Escritório"};
		
		String carta = j2.getCartas()[3];
		Suspeita suspeita = new Suspeita("0","0","0");
		for(String a: Armas) {
			if(a==carta) suspeita = new Suspeita(carta, cartas.getEnvelope()[1], cartas.getEnvelope()[2]);
		}
		for(String s: Suspeitos) {
			if(s==carta) suspeita = new Suspeita(cartas.getEnvelope()[0], carta, cartas.getEnvelope()[2]);
		}
		for(String c: Comodos) {
			if(c==carta) suspeita = new Suspeita(cartas.getEnvelope()[0], cartas.getEnvelope()[1], carta);
		}
		
		assertFalse("palpite falso retornou verdadeiro", suspeita.confirmarPalpite(j1, jogadores));
	}
	
	@Test
	public void testFazerAcusacaoVerdadeira() {
		Cartas cartas = Cartas.getInstancia();
		Cartas.reiniciaCartas();
		Jogador j = new Jogador("Srta. Scarlet", 3); 
		
		Suspeita suspeita = new Suspeita(cartas.getEnvelope()[0], cartas.getEnvelope()[1], cartas.getEnvelope()[2]);
		assertTrue("acusação verdadeira retornou falsa", suspeita.fazerAcusacao(j));
		assertFalse("jogador foi bloqueado", j.block);
	}
	
	@Test
	public void testFazerAcusacaoFalsa() {
		Cartas cartas = Cartas.getInstancia();
		Cartas.reiniciaCartas();
		Jogador j = new Jogador("Srta. Scarlet", 3); 
		
		Suspeita suspeita = new Suspeita(cartas.getEnvelope()[0], cartas.getEnvelope()[1], "errado");
		assertFalse("acusação falsa retornou verdadeira", suspeita.fazerAcusacao(j));
		assertTrue("jogador não foi bloqueado", j.block);
	}
	
}
