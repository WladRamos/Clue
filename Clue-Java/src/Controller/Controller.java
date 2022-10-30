package Controller;

import Model.ModelAPI;

public class Controller {
	static protected String[] jogadores;
	static private int jogada = 0;
	ModelAPI modelAPI = ModelAPI.getInstancia();
	
	public void Jogar(String[] personagens, int numeroJogadores) {
		jogadores = new String[numeroJogadores];
		System.arraycopy(personagens,0,jogadores,0,numeroJogadores); 
		modelAPI.criaJogadores(personagens, numeroJogadores);
		
    }
	
	private void setJogada() {
        if(jogada==jogadores.length-1) jogada=-1;
        jogada++;
    }
	
	public void setPrimeiroJogador() {
		for(String jogador: jogadores) {
			if(jogador == "Srta. Scarlet") break;
			setJogada();
		}
	}
	
	public String getJogadorDaVez() {
		return jogadores[jogada];
	}
	
	public int getJogadorDaVezId() {
		return jogada;
	}
	
	public boolean proximoJogador() {
		int blocked=0;
		setJogada();
		while(modelAPI.jogadorBloqueado(jogada)) {
			setJogada(); blocked++;
			if(blocked==jogadores.length) return false;
		}return true;
	}
		
}

