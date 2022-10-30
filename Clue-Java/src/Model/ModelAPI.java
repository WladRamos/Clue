package Model;

public class ModelAPI {
	static ModelAPI modelInstancia = null;
	
	static private Tabuleiro tabuleiro = Tabuleiro.getInstancia(); 
	static private Jogador[] jogadores;
	
	/*singleton class*/
	private ModelAPI() {
	}
	
	public static ModelAPI getInstancia() {
		if(modelInstancia == null) modelInstancia = new ModelAPI();
		return modelInstancia; 
	}
	
	public void criaJogadores(String[] personagens, int numeroJogadores) {
		jogadores = new Jogador[numeroJogadores];
		for(int i=0; i<numeroJogadores; i++) {
			jogadores[i] = new Jogador(personagens[i], numeroJogadores); 
		}
	}
	
	public boolean jogadorBloqueado(int jogador) {
		return jogadores[jogador].block;
	}
	
	public boolean passagemSecreta(int jogador) {
		int x = jogadores[jogador].x;
		int y = jogadores[jogador].y;
		return tabuleiro.permissaoPassagemSecreta(x, y);
	}
	
	public int[] getDestinoPassagemSecreta(int jogador) {
		int x = jogadores[jogador].x;
		int y = jogadores[jogador].y;
		int[] coord = tabuleiro.movePiaoPassagemSecreta(x, y, jogador+1);
		coord[0]*=25; coord[1]*=25;
		return coord;
	}
	
	
	public void atualizaPosicoes(int [][] coordenadas) {
		String [] personagens = {"Sra. White", "Reverendo Green", "Sra. Peacock", "Coronel Mustard", "Srta. Scarlet", "Professor Plum"};
		for(int i=0; i<jogadores.length; i++) {
			for(int j=0; j<personagens.length; j++) {
				if(jogadores[i].personagem == personagens[j]) {
					jogadores[i].x = coordenadas[j][0]/25;
					jogadores[i].y = coordenadas[j][1]/25;
				}
			}
		}
	}
	
	public boolean movePiao(int jogador, int x, int y, int passos) {
		int x0 = jogadores[jogador].x;
		int y0 = jogadores[jogador].y;
		System.out.printf("origem: %d, %d  -  destino: %d, %d\n",x0,y0,x/25,y/25);
		return tabuleiro.movePiao(x0, y0, x/25, y/25, passos, jogador+1);
	}
	
	public static int[] getDados() {
		Dados d = new Dados();
		d.jogaDados();
		int[] dados = {d.dado1, d.dado2};
		return dados;
	}
	

	public String[] getCartasJogador(int jogador) {
		return jogadores[jogador].getCartas();
	}
	
	public String[] getBlocoDeNotasJogador(int jogador) {
		String[] auxiliar = new String[21];
		String[][] blocoDeNotas = jogadores[jogador].getBlocoNotas();
		int contador=0;
		for(int i=0; i<blocoDeNotas.length; i++) {
			if(blocoDeNotas[i][1]!="0") {
				auxiliar[contador] = blocoDeNotas[i][0];
				contador++;
			}
		}
		String[] cartasMarcadas = new String[contador];
		System.arraycopy(auxiliar, 0, cartasMarcadas, 0, contador);
		return cartasMarcadas;
	}

}
