package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CartasTest {

	@Test
	public void testgetEnvelope() {
		Cartas cartas = new Cartas();
		cartas.reiniciaCartas();
		String[] envelope = cartas.getEnvelope();
		
		assertEquals("quantidade de cartas no evelope errada",3,envelope.length);
		assertFalse("carta(s) inválida(s) no envelope",envelope[0] == "0" || envelope[1] == "0" || envelope[2] == "0");
	}
	
	@Test
	public void testgetCartasArmas() {
		Cartas cartas = new Cartas();
		cartas.reiniciaCartas();
		String[] armas = cartas.getCartasArmas();
		int envelope=0;
		
		for(int i=0; i<armas.length; i++) {
			if(armas[i]=="0")envelope ++;
		}
		assertEquals("quantidade de armas errada",6,armas.length);  
		assertEquals("quantidade de armas sorteadas diferente de 1",1,envelope);
	}
	
	@Test
	public void testgetCartasSuspeitos() {
		Cartas cartas = new Cartas();
		cartas.reiniciaCartas();
		String[] sus = cartas.getCartasSuspeitos();
		int envelope=0;
		
		for(int i=0; i<sus.length; i++) {
			if(sus[i]=="0")envelope ++;
		}
		assertEquals("quantidade de suspeitos errada",6,sus.length);  
		assertEquals("quantidade de suspeitos sorteados diferente de 1",1,envelope);
	}
	
	@Test
	public void testgetCartasComodos() {
		Cartas cartas = new Cartas();
		cartas.reiniciaCartas();
		String[] comodo = cartas.getCartasComodos();
		int envelope=0;
		
		for(int i=0; i<comodo.length; i++) {
			if(comodo[i]=="0")envelope ++;
		}
		assertEquals("quantidade de cômodos errada",9,comodo.length);
		assertEquals("quantidade de cômodos sorteados diferente de 1",1,envelope);
	}

	@Test
	public void testDistribuiCartasCom3() {
		Cartas cartas = new Cartas();
		cartas.reiniciaCartas();
		String[] maoCom3 = cartas.DistribuiCartas(3);
		
		assertEquals("quantidade de cartas distribuídas errada",3,maoCom3.length);
		assertFalse("carta(s) distribuída(s) inválida(s)",maoCom3[0] == "0" || maoCom3[1] == "0" || maoCom3[2] == "0");
	}
	
	@Test
	public void testDistribuiCartasCom4() {
		Cartas cartas = new Cartas();
		cartas.reiniciaCartas();
		String[] maoCom4 = cartas.DistribuiCartas(4);
		
		assertEquals("quantidade de cartas distribuídas errada",4,maoCom4.length);
		assertFalse("carta(s) distribuída(s) inválida(s)",maoCom4[0] == "0" || maoCom4[1] == "0" || maoCom4[2] == "0" || maoCom4[3] == "0");
	}
	
	@Test
	public void testDistribuiCartasCom5() {
		Cartas cartas = new Cartas();
		cartas.reiniciaCartas();
		String[] maoCom5 = cartas.DistribuiCartas(5);		
		
		assertEquals("quantidade de cartas distribuídas errada",5,maoCom5.length);
		assertFalse("carta(s) distribuída(s) inválida(s)",maoCom5[0] == "0" || maoCom5[1] == "0" || maoCom5[2] == "0" || maoCom5[3] == "0" || maoCom5[4] == "0");
	}
	
	@Test
	public void testDistribuiCartasCom6() {
		Cartas cartas = new Cartas();
		cartas.reiniciaCartas();
		String[] maoCom6 = cartas.DistribuiCartas(6);
		
		assertEquals("quantidade de cartas distribuídas errada",6,maoCom6.length);
		assertFalse("carta(s) distribuída(s) inválida(s)",maoCom6[0] == "0" || maoCom6[1] == "0" || maoCom6[2] == "0" || maoCom6[3] == "0" || maoCom6[4] == "0" || maoCom6[5] == "0");
	}
	
	@Test
	public void testDistribuiCartasSemSobrarBaralho() {
		Cartas cartas = new Cartas();
		cartas.reiniciaCartas();
		cartas.DistribuiCartas(6);
		cartas.DistribuiCartas(6);
		cartas.DistribuiCartas(6);
		
		String[] armas = cartas.getCartasArmas();
		String[] suspeitos = cartas.getCartasSuspeitos();
		String[] comodos = cartas.getCartasComodos();
		int erros=0;
		
		for(int i=0; i<armas.length;i++) {
			if(armas[i]!="0") erros++;
		}
		for(int i=0; i<suspeitos.length;i++) {
			if(suspeitos[i]!="0") erros++;
		}
		for(int i=0; i<comodos.length;i++) {
			if(comodos[i]!="0") erros++;
		}
		assertEquals("baralho não foi zerado após a distribuição",0,erros);
	}
	
	@Test
	public void testDistribuiCartasSemRepeticao() {
		Cartas cartas = new Cartas();
		cartas.reiniciaCartas();
		String[] maoJog1 = cartas.DistribuiCartas(6);
		String[] maoJog2 = cartas.DistribuiCartas(6);
		String[] maoJog3 = cartas.DistribuiCartas(6);
		int erros=0;
		
		for(String c1: maoJog1) {
			for(String c2: maoJog2) {
				if(c1==c2) erros++;
			}
			for(String c3: maoJog3) {
				if(c1==c3) erros++;
			}
		}
		for(String c2: maoJog2) {
			for(String c3: maoJog3) {
				if(c2==c3) erros++;
			}
		}
		assertEquals("há cartas repedidas entre os jogadores",0,erros);
	}

}
