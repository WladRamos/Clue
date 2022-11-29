package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import View.ObservadorIF;

public class ModelAPI implements ObservadoIF{
	static ModelAPI modelInstancia = null;
	
	private List<ObservadorIF> list = new ArrayList<ObservadorIF>();
	static private Tabuleiro tabuleiro = Tabuleiro.getInstancia(); 
	static private Jogador[] jogadores;
	static private int d1=0, d2=0;
		
	/*singleton class*/
	private ModelAPI() {
	}
	
	public static ModelAPI getInstancia() {
		if(modelInstancia == null) modelInstancia = new ModelAPI();
		return modelInstancia; 
	}
	
	/*acesso às cartas*/
	public String[] getEnvelope() {
        return Cartas.getInstancia().getEnvelope();
    }
	
	public void reiniciaCartas() {
		Cartas.reiniciaCartas();
	}
	
	public void setCartas(String[] envelope) {
		Cartas.setCartas(envelope);
	}
	
	
	/*acesso aos jogadores*/		
	public String[] getCartasJogador(int jogador) {
		return jogadores[jogador].getCartas();
	}
	
	public String[] getBlocoDeNotasJogador(int jogador) {
		return jogadores[jogador].getCartasBlocoNotas();
	}
	
	public boolean jogadorBloqueado(int jogador) {
		return jogadores[jogador].block;
	}
	
	public String getUltimoComodo(int jogador) {
		return jogadores[jogador].ultimoComodo;
	}
	
	public void setUltimoComodo(int jogador, String comodo) {
		jogadores[jogador].ultimoComodo = comodo;
	}
	
	public void criaJogadores(String[] personagens, int numeroJogadores) {
		jogadores = new Jogador[numeroJogadores];
		for(int i=0; i<numeroJogadores; i++) 
			jogadores[i] = new Jogador(personagens[i], numeroJogadores); 
	}
	
	public void setJogadores(int nJog, String []jog, String []ultCmd, int [][]xyJog, String cartasJog[][], String bnJog[][][], boolean blockJog[]) {
		Jogador.reiniciaJogador();
		Jogador jogadoresArray[] = new Jogador[nJog];
		for(int i=0; i<nJog; i++) {
			jogadoresArray[i] = new Jogador();
			jogadoresArray[i].criaJogador(i+1, cartasJog[i].length, jog[i], cartasJog[i], bnJog[i], ultCmd[i], blockJog[i], xyJog[i][0], xyJog[i][1]); 
		}
		jogadores = new Jogador[nJog];
		jogadores = jogadoresArray;
	}
	
	public void atualizaPosicoes(int [][] coordenadas) {
		String [] personagens = {"Sra. White", "Reverendo Green", "Sra. Peacock", "Coronel Mustard", "Srta. Scarlet", "Professor Plum"};
		for(int i=0; i<jogadores.length; i++) {
			for(int j=0; j<personagens.length; j++) {
				if(jogadores[i].personagem.equals(personagens[j])) {
					jogadores[i].x = coordenadas[j][0]/25;
					jogadores[i].y = coordenadas[j][1]/25;	  }	} }
	}
	
	
	/*acesso aos dados*/
	public void jogaDados() {
		Dados d = new Dados();
		d.jogaDados();
		d1 = d.dado1; d2 = d.dado2;
	}
	
	public void zeraDados() {
		d1=0; d2=0;
	}
	
	public void setDados(int dado1, int dado2) {
		d1=dado1; d2=dado2;
	}
	
	
	/*acesso ao tabuleiro e à movimentação dos piões*/
	public int[] getCordPiao(String piao) {
		return tabuleiro.getCoordenadaDoPiao(piao);
	}
	
	public void reiniciaTabuleiro() {
		tabuleiro.reiniciaTabuleiro();
	}
	
	public void setTabuleiro(int[][] coordJogadores, String[] jogadores, int[][] coordBots, String[] bots) {
		tabuleiro.zeraTabuleiro();
		tabuleiro.setTabuleiro(coordJogadores, jogadores, coordBots, bots);
	}
	
	public boolean passagemSecreta(int jogador) {
		int x = jogadores[jogador].x, y = jogadores[jogador].y;
		return tabuleiro.permissaoPassagemSecreta(x, y);
	}
	
	public void moveJogadorPassagemSecreta(int jogador, String piao) {
		int x = jogadores[jogador].x, y = jogadores[jogador].y;
		tabuleiro.movePiaoPassagemSecreta(x, y, piao);
	}
	
	public String getAreaDoTabuleiro(int jogador) {
		int x = jogadores[jogador].x, y = jogadores[jogador].y;
		return tabuleiro.getAreaDoTabuleiro(x, y);
	}
	
	public boolean movePiao(int jogador, String piao, int x, int y) {
		int x0 = jogadores[jogador].x, y0 = jogadores[jogador].y;
		System.out.printf("origem: %d, %d  -  destino: %d, %d\n",x0,y0,x/25,y/25);
		return tabuleiro.movePiao(x0, y0, x/25, y/25, d1+d2, piao);
	}
	
	public void trazerSuspeito(int jogador, String suspeito) {
		String area = tabuleiro.getAreaDoTabuleiro(jogadores[jogador].x, jogadores[jogador].y);
		int x = tabuleiro.getCoordenadaArea(area)[0], y = tabuleiro.getCoordenadaArea(area)[1];
		int x0 = tabuleiro.getCoordenadaDoPiao(suspeito)[0], y0 = tabuleiro.getCoordenadaDoPiao(suspeito)[1];
		if(x!=0 && y!=0) tabuleiro.movePiaoIncondicional(x0, y0, x, y, suspeito);
		else System.out.print("nenhuma posição livre no comôdo de destino");
	}
	
	public void movePiaoAcusacao(int jogador) {
		String area = tabuleiro.getPorta(jogadores[jogador].x, jogadores[jogador].y);
		if(!(area.equals("não é porta"))) {
			int x = tabuleiro.getCoordenadaArea(area)[0], y = tabuleiro.getCoordenadaArea(area)[1];
			tabuleiro.movePiaoIncondicional(jogadores[jogador].x, jogadores[jogador].y, x, y, jogadores[jogador].personagem);
		}
	}

	
	/*acesso às suspeitas*/	
	public boolean fazerPalpite(int jogador, String[] palpite, int[] palpiteCartaErrada) {
		Suspeita susp = new Suspeita(palpite[0], palpite[1], palpite[2]);
		Jogador[] outrosJogadores = new Jogador[jogadores.length -1];
		int i=0;
		for(Jogador j: jogadores) {
			System.out.println("jogador: "+jogadores[jogador].personagem+" != "+j.personagem+" i:"+i);
			if(j!=jogadores[jogador]) { outrosJogadores[i] = j; i++; }
		}return susp.confirmarPalpite(jogadores[jogador], outrosJogadores, palpiteCartaErrada);
	}

	public boolean fazerAcusacao(String[] acusacao, int jogador) {
		Suspeita s = new Suspeita(acusacao[0], acusacao[1], acusacao[2]); 
		return s.fazerAcusacao(jogadores[jogador]);
	}

		
	/*métodos do observado (movimentação dos piões sobre o tabuleiro e lançamento dos dados)*/
	public void add(ObservadorIF o) {
		list.add(o);
	}

	public void remove(ObservadorIF o) {
		list.remove(o);
	}
	
	public int[] getDados() {
		int[] dados = {d1, d2};
		return dados;
	}

	public int[][] getTabuleiro() {
		return tabuleiro.getTabuleiro();
	}
	
	public void atualizaObservadores() {		
		ListIterator<ObservadorIF> observadores=list.listIterator();
		while(observadores.hasNext())
			observadores.next().notify(this);
	}
	
}