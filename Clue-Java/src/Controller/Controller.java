package Controller;

import Model.ModelAPI;
import Model.ObservadoIF;
import View.ObservadorIF;

public class Controller {
static Controller controllerInstancia = null;
	
	static protected String[] jogadores;
	static private int jogada = 0;
	ModelAPI modelAPI = ModelAPI.getInstancia();
	
	/*singleton class*/
	private Controller() {
	}
	
	public static Controller getInstancia() {
		if(controllerInstancia == null) controllerInstancia = new Controller();
		return controllerInstancia; 
	}
		
	/*controle de rodadas*/
	public void Jogar(String[] personagens, int numeroJogadores) {
		jogadores = new String[numeroJogadores];
		System.arraycopy(personagens,0,jogadores,0,numeroJogadores); 
		modelAPI.criaJogadores(personagens, numeroJogadores);
		
    }
	
	public String[] getJogadores() {
        return jogadores;
    }
	
	private void setJogada() {
        if(jogada==jogadores.length-1) jogada=-1;
        jogada++;
    }
	
	public void setJogadores(String []jogadores_, int jogVezId) {
		jogadores = jogadores_;
		jogada = jogVezId; 
	}
	
	public void setPrimeiroJogador() {
		for(String jogador: jogadores) {
			if(jogador.equals("Srta. Scarlet")) break;
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
		System.out.println(jogadores[jogada]+" bloqueada: "+modelAPI.jogadorBloqueado(jogada));
		while(modelAPI.jogadorBloqueado(jogada)) {
			setJogada(); blocked++;
			if(blocked==jogadores.length) return false;
		}return true;
	}
	
	public void reiniciaJogada() {
		jogada=0;
	}
	
	/*controle de palpites e acusações*/
	public boolean palpite(String []palpiteConfirmado,int []palpiteCartaErrada) {
		return modelAPI.fazerPalpite(getJogadorDaVezId(), palpiteConfirmado,palpiteCartaErrada);
	}
	
	public boolean fazerAcusacao(String[] acusacao) {
		return modelAPI.fazerAcusacao(acusacao, this.getJogadorDaVezId());
	}
	
	/*controle de registro entre o observador e o observado*/
	public ObservadoIF registra(ObservadorIF o) {
		ObservadoIF observado = (ObservadoIF) modelAPI;
		observado.add(o);
		return observado;
	}
		
}

