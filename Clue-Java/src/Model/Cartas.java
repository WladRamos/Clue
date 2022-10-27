package Model;

import java.util.Random;
import java.util.Arrays;

public class Cartas{
	private static String[] cartasArmas = {"Corda", "Cano de Chumbo", "Faca", "Chave Inglesa", "Castiçal", "Revólver"};
	private static String[] cartasSuspeitos = {"Coronel Mustard", "Srta. Scarlet", "Professor Plum", "Reverendo Green", "Sra. White", "Sra. Peacock"};
	private static String[] cartasComodos = {"Entrada", "Sala de Estar", "Sala de Jantar", "Cozinha", "Sala de Música", "Jardim de Inverno", "Salão de Jogos", "Biblioteca", "Escritório"};
	private static String[] envelopeConfidencial = new String[3];
	
	static{
		Random r1 = new Random();
		
		int index1 = r1.nextInt(6);
		int index2 = r1.nextInt(6);
		int index3 = r1.nextInt(9);
	  
		envelopeConfidencial[0] = cartasArmas[index1];		//RandomArma
		envelopeConfidencial[1] = cartasSuspeitos[index2];	//RandomSus
		envelopeConfidencial[2] = cartasComodos[index3];	//RandomComodo
		
		cartasArmas[index1] = "0";
	  	cartasSuspeitos[index2] = "0";
	    cartasComodos[index3] = "0";
	}
	
	public String[] getEnvelope() {
		return envelopeConfidencial;
	}
	
	public String[] getCartasArmas() {
		return cartasArmas;
	}
	
	public String[] getCartasComodos() {
		return cartasComodos;
	}
	
	public String[] getCartasSuspeitos() {
		return cartasSuspeitos;
	}
	
	public String[] DistribuiCartas(int numCartas){
		/*try {
			if(numCartas<3 || numCartas>6) { 
				throw new ValorInvalido("número de cartas inválido para jogador");
			}
		}catch(ValorInvalido vi) {
			//System.exit(1);
			System.out.println("número de cartas inválido para jogador");
			return null;
		}*/
		String[] baralho = new String[cartasArmas.length + cartasSuspeitos.length + cartasComodos.length];
		String[] maoJogador = new String[numCartas];
		Random x = new Random();
		int a = 0;
				
		System.arraycopy(cartasArmas, 0, baralho, 0, cartasSuspeitos.length);
		System.arraycopy(cartasSuspeitos, 0, baralho, cartasArmas.length, cartasSuspeitos.length);
		System.arraycopy(cartasComodos, 0, baralho, cartasArmas.length + cartasSuspeitos.length, cartasComodos.length);
		
		//System.out.println("Concatenated Array: " + Arrays.toString(baralho));
			
		for(int i=0;i<numCartas;i++) {
			do {
				a = x.nextInt(baralho.length);
			}while(baralho[a] == "0");
			maoJogador[i] = baralho[a];
			
			for(int j=0;j<cartasArmas.length;j++) {
				if(cartasArmas[j] == baralho[a]) {
					cartasArmas[j] = "0";
					break;
				}
			}
			for(int k=0;k<cartasSuspeitos.length;k++) {
				if(cartasSuspeitos[k] == baralho[a]) {
					cartasSuspeitos[k] = "0";
					break;
				}
			}
			for(int l=0;l<cartasComodos.length;l++) {
				if(cartasComodos[l] == baralho[a]) {
					cartasComodos[l] = "0";
					break;
				}
			}
			baralho[a] = "0";
		}
			
		//System.out.println("Mao jogador: " + Arrays.toString(maoJogador));
		
		return maoJogador;
	}
	
	public void reiniciaCartas() {
		String[] armas = {"Corda", "Cano de Chumbo", "Faca", "Chave Inglesa", "Castiçal", "Revólver"};
		String[] suspeitos = {"Coronel Mustard", "Srta. Scarlet", "Professor Plum", "Reverendo Green", "Sra. White", "Sra. Peacock"};
		String[] comodos = {"Entrada", "Sala de Estar", "Sala de Jantar", "Cozinha", "Sala de Música", "Jardim de Inverno", "Salão de Jogos", "Biblioteca", "Escritório"};
	
		System.arraycopy(armas, 0, cartasArmas, 0, cartasArmas.length);
		System.arraycopy(suspeitos, 0, cartasSuspeitos, 0, cartasSuspeitos.length);
		System.arraycopy(comodos, 0, cartasComodos, 0, cartasComodos.length);
		
		Random r1 = new Random();
		
		int index1 = r1.nextInt(6);
		int index2 = r1.nextInt(6);
		int index3 = r1.nextInt(9);
	  
		envelopeConfidencial[0] = cartasArmas[index1];		//RandomArma
		envelopeConfidencial[1] = cartasSuspeitos[index2];	//RandomSus
		envelopeConfidencial[2] = cartasComodos[index3];	//RandomComodo
		
		cartasArmas[index1] = "0";
	  	cartasSuspeitos[index2] = "0";
	    cartasComodos[index3] = "0";
	}
}
