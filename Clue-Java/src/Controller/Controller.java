package Controller;

import java.util.Arrays;

import Model.*;

public class Controller {
	static protected Jogador[] jogadores;
	static protected int nJog;
	static private  int vez = 0;
	
	public void Jogar(String[] personagens, int numeroJogadores) {

        System.out.println(Arrays.toString(personagens));
        nJog = numeroJogadores;
        Cartas cartas = new Cartas();
        jogadores = new Jogador[numeroJogadores];

        for(int i=0; i<numeroJogadores; i++) {
            jogadores[i] = new Jogador(personagens[i], numeroJogadores);
            int ncartas = jogadores[i].numCartas;
            jogadores[i].recebeCartas(ncartas, cartas.DistribuiCartas(ncartas));
        }
    }
	
	private Jogador setVez() {
        if(vez==nJog-1) vez=-1;
        vez++;
        return jogadores[vez];
    }
	
	public Jogador getProximoJogador() {
		Jogador jogador = setVez();
		int allBlocked=0;
		while(jogador.block) {
			jogador = setVez();
			allBlocked++;
			if(allBlocked==nJog) return null;
		} return jogador;
	}
	
	public Jogador getJogadorDaVez() {
		System.out.println("jogador da vez"+jogadores[vez].personagem);
		return jogadores[vez];
	}
	
	public void setPrimeiroJogador() {
		int scarlet=0;
		for(Jogador j: jogadores) {
			if(j.personagem == "Srta. Scarlet") {
				vez=scarlet;
				break;
			}
			scarlet++;
		}
		System.out.println("vez"+vez);
	}

	public boolean passagemSecreta(int x, int y) {
		return false;
		//TODO
		//Tabuleiro.tabuleiroToMatrix(x,y);
	}
	
	public int getDestinoPassagemSecretaX(Jogador jogador) {
		return 564;
		//TODO
	}
	
	public int getDestinoPassagemSecretaY(Jogador jogador) {
		return 565;
		//TODO
	}
	public void atualizaPosicoes(int[][] coordenadas) {
		/*coordenadas: "Sra. White" (white), "Reverendo Green" (green), "Sra. Peacock" (blue),
		"Coronel Mustard" (yellow), "Srta. Scarlet" (red), "Professor Plum" (pink)*/
		//TODO
	}
	
	public boolean permissaoMover(Jogador j, int x, int y, int passos) {
		return true;
		//Tabuleiro tabuleiro = Tabuleiro.getInstancia();
		//return tabuleiro.movePiao(...);
		
	}
	
	
}

