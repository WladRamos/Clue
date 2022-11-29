package Model;

class Tabuleiro{
	static Tabuleiro tabuleiroInstancia;
	private static int tabuleiro [][] = new int[27][26];
	private static String [] personagens = {"Sra. White", "Reverendo Green", "Sra. Peacock", "Coronel Mustard", "Srta. Scarlet", "Professor Plum"};
	
	/*dicionário das áreas da matriz tabuleiro*/
	private int coordCasas[][] = {						  {9, 2},  {10, 2}, {11, 2}, 								           {16, 2},  {17, 2},  {18, 2},
								  					 {8, 3},  {9, 3}, 																		           {18, 3},  {19, 3},
								  					 {8, 4},  {9, 4},																		           {18, 4},  {19, 4},
								  					 {8, 5},  {9, 5},																		           {18, 5},  {19, 5}, 
								  					 {8, 6},  {9, 6}, 																		           {18, 6},  {19, 6}, {20, 6}, 
								  					 {8, 7},  {9, 7}, 																		           {18, 7},  {19, 7}, {20, 7}, {21, 7}, {22, 7}, {23, 7}, {24, 7}, 
	{2, 8}, {3, 8}, {4, 8}, {5, 8}, {6, 8}, {7, 8},  {8, 8},  {9, 8}, 																		           {18, 8},  {19, 8}, {20, 8}, {21, 8}, {22, 8}, {23, 8}, {24, 8}, 
			{3, 9}, {4, 9}, {5, 9}, {6, 9}, {7, 9},  {8, 9},  {9, 9},  {10, 9},  {11, 9},  {12, 9},  {13, 9},  {14, 9},  {15, 9},  {16, 9},  {17, 9},  {18, 9},  {19, 9},
											{7, 10}, {8, 10}, {9, 10}, {10, 10}, {11, 10}, {12, 10}, {13, 10}, {14, 10}, {15, 10}, {16, 10}, {17, 10}, {18, 10}, {19, 10},
																	   {10, 11}, {11, 11},                                                   {17, 11}, {18, 11}, {19, 11}, 
																	   {10, 12}, {11, 12},												     {17, 12}, {18, 12}, {19, 12}, 
																	   {10, 13}, {11, 13}, 													 {17, 13}, {18, 13}, {19, 13},
																	   {10, 14}, {11, 14}, 													 {17, 14}, {18, 14}, {19, 14}, {20, 14}, {21, 14}, {22, 14}, {23, 14}, {24, 14}, 
																	   {10, 15}, {11, 15}, 													 {17, 15}, {18, 15}, {19, 15}, 
																	   {10, 16}, {11, 16}, 													 {17, 16}, {18, 16},
			{3, 17},{4, 17},{5, 17},{6, 17}, {7, 17}, {8, 17},{9, 17}, {10, 17}, {11, 17}, 													 {17, 17}, {18, 17}, 
			{3, 18},{4, 18},{5, 18},{6, 18}, {7, 18}, {8, 18},{9, 18}, {10, 18}, {11, 18}, {12, 18}, {13, 18}, {14, 18}, {15, 18}, {16, 18}, {17, 18}, {18, 18}, 
			{3, 19},{4, 19},{5, 19},{6, 19}, {7, 19}, {8, 19},{9, 19}, {10, 19}, 															 {17, 19}, {18, 19}, {19, 19},
															  {9, 20}, {10, 20}, 															 {17, 20}, {18, 20}, {19, 20}, {20, 20}, {21, 20}, {22, 20}, {23, 20}, {24, 20}, 
															  {9, 21}, {10, 21}, 															 {17, 21}, {18, 21}, {19, 21}, {20, 21}, {21, 21}, {22, 21}, {23, 21}, {24, 21}, 
															  {9, 22}, {10, 22}, 															 {17, 22}, {18, 22}, 
															  {9, 23}, {10, 23}, 															 {17, 23}, {18, 23}, 
															  {9, 24}, {10, 24}, 															 {17, 24}, {18, 24}, 
															  																						   {18, 25}};
 	private int coordCozinha[][] = {{2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {7, 1}, 
									{2, 2}, {3, 2}, {4, 2}, {5, 2}, {6, 2}, {7, 2}, 
									{2, 3}, {3, 3}, {4, 3}, {5, 3}, {6, 3}, {7, 3}, 
									{2, 4}, {3, 4}, {4, 4}, {5, 4}, {6, 4}, {7, 4}, 
									{2, 5}, {3, 5}, {4, 5}, {5, 5}, {6, 5}, {7, 5}, 
									{2, 6}, {3, 6}, {4, 6}, {5, 6}, {6, 6}, {7, 6}, 
											{3, 7}, {4, 7}, {5, 7}, {6, 7}, {7, 7}};
	private int portasCozinha[][] = {{6, 8}};
	private int coordSalaDeJantar[][] = {{2, 10}, {3, 10}, {4, 10}, {5, 10}, {6, 10}, 
										 {2, 11}, {3, 11}, {4, 11}, {5, 11}, {6, 11}, {7, 11}, {8, 11}, {9, 11}, 
										 {2, 12}, {3, 12}, {4, 12}, {5, 12}, {6, 12}, {7, 12}, {8, 12}, {9, 12}, 
										 {2, 13}, {3, 13}, {4, 13}, {5, 13}, {6, 13}, {7, 13}, {8, 13}, {9, 13}, 
										 {2, 14}, {3, 14}, {4, 14}, {5, 14}, {6, 14}, {7, 14}, {8, 14}, {9, 14}, 
										 {2, 15}, {3, 15}, {4, 15}, {5, 15}, {6, 15}, {7, 15}, {8, 15}, {9, 15}, 
										 {2, 16}, {3, 16}, {4, 16}, {5, 16}, {6, 16}, {7, 16}, {8, 16}, {9, 16}};
	private int portasSalaDeJantar[][] = {{10, 13}, {8, 17}};
	private int coordSalaDeEstar[][] = {{2, 20}, {3, 20}, {4, 20}, {5, 20}, {6, 20}, {7, 20}, {8, 20}, 
										{2, 21}, {3, 21}, {4, 21}, {5, 21}, {6, 21}, {7, 21}, {8, 21}, 
										{2, 22}, {3, 22}, {4, 22}, {5, 22}, {6, 22}, {7, 22}, {8, 22}, 
										{2, 23}, {3, 23}, {4, 23}, {5, 23}, {6, 23}, {7, 23}, {8, 23}, 
										{2, 24}, {3, 24}, {4, 24}, {5, 24}, {6, 24}, {7, 24}, {8, 24}, 
										{2, 25}, {3, 25}, {4, 25}, {5, 25}, {6, 25}, {7, 25}};
	private int portasSalaDeEstar[][] = {{8, 19}};
	private int coordSalaDeMusica[][] = {{12, 2}, {13, 2}, {14, 2}, {15, 2}, 
					   {10, 3}, {11, 3}, {12, 3}, {13, 3}, {14, 3}, {15, 3}, {16, 3}, {17, 3}, 
					   {10, 4}, {11, 4}, {12, 4}, {13, 4}, {14, 4}, {15, 4}, {16, 4}, {17, 4}, 
					   {10, 5}, {11, 5}, {12, 5}, {13, 5}, {14, 5}, {15, 5}, {16, 5}, {17, 5}, 
					   {10, 6}, {11, 6}, {12, 6}, {13, 6}, {14, 6}, {15, 6}, {16, 6}, {17, 6}, 
					   {10, 7}, {11, 7}, {12, 7}, {13, 7}, {14, 7}, {15, 7}, {16, 7}, {17, 7}, 
					   {10, 8}, {11, 8}, {12, 8}, {13, 8}, {14, 8}, {15, 8}, {16, 8}, {17, 8}};
	private int portasSalaDeMusica[][] = {{9, 6}, {11, 9}, {16, 9}, {18, 6}};
	private int coordEntrada[][] = {{11, 19}, {12, 19}, {13, 19}, {14, 19}, {15, 19}, {16, 19}, 
									{11, 20}, {12, 20}, {13, 20}, {14, 20}, {15, 20}, {16, 20}, 
									{11, 21}, {12, 21}, {13, 21}, {14, 21}, {15, 21}, {16, 21}, 
									{11, 22}, {12, 22}, {13, 22}, {14, 22}, {15, 22}, {16, 22}, 
									{11, 23}, {12, 23}, {13, 23}, {14, 23}, {15, 23}, {16, 23}, 
									{11, 24}, {12, 24}, {13, 24}, {14, 24}, {15, 24}, {16, 24}, 
											  {12, 25}, {13, 25}, {14, 25}, {15, 25}};
	private int portasEntrada[][] = {{13, 18}, {14, 18}, {17, 21}};
	private int coordJardimDeInverno[][] = {{20, 2}, {21, 2}, {22, 2}, {23, 2}, {24, 2}, {25, 2}, 
											{20, 3}, {21, 3}, {22, 3}, {23, 3}, {24, 3}, {25, 3}, 
											{20, 4}, {21, 4}, {22, 4}, {23, 4}, {24, 4}, {25, 4}, 
											{20, 5}, {21, 5}, {22, 5}, {23, 5}, {24, 5}, {25, 5}, 
													 {21, 6}, {22, 6}, {23, 6}, {24, 6}};
	private int portasJardimDeInverno[][] = {{20, 6}};
	private int coordSalaoDeJogos[][] = {{20, 9},  {21, 9},  {22, 9},  {23, 9},  {24, 9},  {25, 9}, 
										 {20, 10}, {21, 10}, {22, 10}, {23, 10}, {24, 10}, {25, 10}, 
										 {20, 11}, {21, 11}, {22, 11}, {23, 11}, {24, 11}, {25, 11}, 
										 {20, 12}, {21, 12}, {22, 12}, {23, 12}, {24, 12}, {25, 12}, 
										 {20, 13}, {21, 13}, {22, 13}, {23, 13}, {24, 13}, {25, 13}};
	private int portasSalaoDeJogos[][] = {{19, 10}, {24, 14}};
	private int coordBiblioteca[][] = {{20, 15}, {21, 15}, {22, 15}, {23, 15}, {24, 15}, 
							 {19, 16}, {20, 16}, {21, 16}, {22, 16}, {23, 16}, {24, 16}, {25, 16}, 
							 {19, 17}, {20, 17}, {21, 17}, {22, 17}, {23, 17}, {24, 17}, {25, 17}, 
							 {19, 18}, {20, 18}, {21, 18}, {22, 18}, {23, 18}, {24, 18}, {25, 18}, 
							 		   {20, 19}, {21, 19}, {22, 19}, {23, 19}, {24, 19}};
	private int portasBiblioteca[][] = {{22, 14}, {18, 17}};
	private int coordEscritorio[][] = {{19, 22}, {20, 22}, {21, 22}, {22, 22}, {23, 22}, {24, 22}, {25, 22}, 
										{19, 23}, {20, 23}, {21, 23}, {22, 23}, {23, 23}, {24, 23}, {25, 23}, 
										{19, 24}, {20, 24}, {21, 24}, {22, 24}, {23, 24}, {24, 24}, {25, 24}, 
												  {20, 25}, {21, 25}, {22, 25}, {23, 25}, {24, 25}, {25, 25}};
	private int portasEscritorio[][] = {{19, 21}};
	private int coordDetetive[][] = {{12,11}, {13,11}, {14,11}, {15,11},{16,11}, 
									{12,12}, {13,12}, {14,12}, {15,12},{16,12}, 
									{12,13}, {13,13}, {14,13}, {15,13},{16,13}, 
									{12,14}, {13,14}, {14,14}, {15,14},{16,14}, 
									{12,15}, {13,15}, {14,15}, {15,15},{16,15}, 
									{12,16}, {13,16}, {14,16}, {15,16},{16,16}, 
									{12,17}, {13,17}, {14,17}, {15,17},{16,17}};
	private String[] areas = {"Casas Comuns", "Cozinha", "Sala de Jantar", "Sala de Estar", "Sala de Música", "Entrada", "Jardim de Inverno", "Salão de Jogos", "Escritório", "Biblioteca"};
	
	/*inicializando tabuleiro vazio*/
	static{	
		for(int x=0;x<27;x++) {
			for(int y=0;y<26;y++) tabuleiro[x][y]=-1;
		}
		/*colocando os pioes em suas posicoes iniciais*/ 
		tabuleiro[11][1] = 0;
		tabuleiro[16][1] = 1;
		tabuleiro[25][7] = 2;
		tabuleiro[2][18] = 3;
		tabuleiro[9][25] = 4;
		tabuleiro[25][20] = 5;
	}
	
	/*singleton class*/
	private Tabuleiro() {
	}
	
	public static Tabuleiro getInstancia() {
		if(tabuleiroInstancia == null) tabuleiroInstancia = new Tabuleiro();
		return tabuleiroInstancia; 
	}
	
	public int[][] getTabuleiro(){
		return tabuleiro;
	}
	
	/*méotodos de identificação no tabuleiro*/
	protected boolean posicaoLivre(int x, int y) {
		if(tabuleiro[x][y]==-1) return true;
		return false;
	}
		
	private boolean pertence(int x, int y, int[][] area) {
		for(int[] coord: area) {
			if(coord[0]==x && coord[1]==y) return true;
		}return false;
	}
	
	protected String getAreaDoTabuleiro(int x, int y) {
		if(pertence(x, y, coordCasas)) return areas[0];
		if(pertence(x, y, coordCozinha)) return areas[1];
		if(pertence(x, y, coordSalaDeJantar)) return areas[2];
		if(pertence(x, y, coordSalaDeEstar)) return areas[3];
		if(pertence(x, y, coordSalaDeMusica)) return areas[4];
		if(pertence(x, y, coordEntrada)) return areas[5];
		if(pertence(x, y, coordJardimDeInverno)) return areas[6];
		if(pertence(x, y, coordSalaoDeJogos)) return areas[7];
		if(pertence(x, y, coordEscritorio)) return areas[8];
		if(pertence(x, y, coordBiblioteca)) return areas[9];
		if(pertence(x, y, coordDetetive)) return "Detetive";
		return "àrea inválida";
	}
	
	protected String getPorta(int x, int y) {
		if(pertence(x,y,portasCozinha)) return areas[1];
		if(pertence(x, y, portasSalaDeJantar)) return areas[2];
		if(pertence(x, y, portasSalaDeEstar)) return areas[3];
		if(pertence(x, y, portasSalaDeMusica)) return areas[4];
		if(pertence(x, y, portasEntrada)) return areas[5];
		if(pertence(x, y, portasJardimDeInverno)) return areas[6];
		if(pertence(x, y, portasSalaoDeJogos)) return areas[7];
		if(pertence(x, y, portasEscritorio)) return areas[8];
		if(pertence(x, y, portasBiblioteca)) return areas[9];
		return "não é porta";
	}
	
	protected int[] getCoordenadaDoPiao(String jogador) {
		int piao = nomeToId(jogador);
		int x=0, y=0, stop=0;
		for(x=0, stop=0;x<27;x++) {
			for(y=0;y<26;y++) {
				if(tabuleiro[x][y]==piao) { stop=1; break; }
			}if(stop==1) break;
		}
		int[] coord = {x,y};
		return coord;			
	}
	
	protected int[] getCoordenadaArea(String area) {
		if(area .equals( areas[1])) {
			for(int[] coord: coordCozinha) 
				if(posicaoLivre(coord[0], coord[1])) return coord;
		}if(area .equals( areas[2])){
			for(int[] coord: coordSalaDeJantar)
				if(posicaoLivre(coord[0], coord[1])) return coord;
		}if(area .equals( areas[3])) {
			for(int[] coord: coordSalaDeEstar) 
				if(posicaoLivre(coord[0], coord[1])) return coord;
		}if(area .equals( areas[4])){
			for(int[] coord: coordSalaDeMusica) 
				if(posicaoLivre(coord[0], coord[1])) return coord;
		}if(area .equals( areas[5])){
			for(int[] coord: coordEntrada) 
				if(posicaoLivre(coord[0], coord[1])) return coord;
		}if(area .equals( areas[6])){
			for(int[] coord: coordJardimDeInverno) 
				if(posicaoLivre(coord[0], coord[1])) return coord;
		}if(area .equals( areas[7])){
			for(int[] coord: coordSalaoDeJogos) 
				if(posicaoLivre(coord[0], coord[1])) return coord;
		}if(area .equals( areas[8])) {
			for(int[] coord: coordEscritorio) 
				if(posicaoLivre(coord[0], coord[1])) return coord;
		}if(area .equals( areas[9])) {
			for(int[] coord: coordBiblioteca) 
				if(posicaoLivre(coord[0], coord[1])) return coord;
		}
		int[] fail = {0,0};
		return fail; 
	}
		
	/*método de movimentação de piões*/
	protected boolean movePiao(int x0, int y0, int x1, int y1, int passos, String jogador) {
		System.out.println("tentando mover "+jogador+" com "+passos+" passos");
		String origem = getAreaDoTabuleiro(x0, y0);
		String destino = getAreaDoTabuleiro(x1, y1);
		System.out.printf("origem: %s - destino: %s\n", origem, destino);
		if(destino=="àrea inválida" || destino=="Detetive") return false;
		if(!posicaoLivre(x1, y1)) return false;
		
		int distancia; int distanciaDesvios=0;
		if(origem=="Casas Comuns" || origem=="àrea inválida") {
			if(destino=="Casas Comuns") {
				distancia = Math.abs(x0-x1) + Math.abs(y0-y1);
				distanciaDesvios = getDistancia(x0, y0, x1, y1);
			}
			else {	/*destino é um dos comodos*/
				int[] porta = getPortaMaisProxima(x0, y0, destino, jogador);
				if(porta==null) return false;
				distancia = Math.abs(x0-porta[0]) + Math.abs(y0-porta[1]) +1;
				distanciaDesvios = getDistancia(x0, y0, porta[0], porta[1]) +1;
			}
			System.out.println();
			System.out.println("distancia: "+distancia+"    distancia com desvios: "+distanciaDesvios);
			if(distanciaDesvios>distancia) distancia = distanciaDesvios;
			if(distancia<=passos) {
				ocupaPosicao(x1, y1, jogador);
				liberaPosicao(x0,y0);
				return true;
			}else return false;
		}else {	/*origem é um dos comodos*/
			if(destino=="Casas Comuns"){
				int[] porta = getPortaMaisProxima(x1, y1, origem, jogador);
				if(porta==null) return false;
				distancia = Math.abs(x1-porta[0]) + Math.abs(y1-porta[1])+1;
				distanciaDesvios = getDistancia(porta[0], porta[1], x1, y1) +1;
			}else {	/*destino é um dos comodos*/
				/*passagens secretas*/
				if((origem=="Cozinha" && destino=="Escritório")||(destino=="Cozinha" && origem=="Escritório")
					||(origem=="Jardim de Inverno" && destino=="Sala de Estar")||(destino=="Jardim de Inverno" && origem=="Sala de Estar")) {
					ocupaPosicao(x1, y1, jogador);
					liberaPosicao(x0,y0);
					return true;
				}else {	/*comodo para comodo sem passagens secretas*/
					int[] porta1 = getPortaMaisProxima(x0, y0, destino, jogador);
					int[] porta2 = getPortaMaisProxima(x1, y1, origem, jogador);
					if(porta1==null || porta2==null) return false;
					distancia = Math.abs(porta1[0]-porta2[0]) + Math.abs(porta1[1]-porta2[1]) +2;
					distanciaDesvios = getDistancia(porta1[0], porta1[1], porta2[0], porta2[1]) +2;
				}
			}
			System.out.println();
			System.out.println("distancia: "+distancia+"    distancia com desvios: "+distanciaDesvios);
			if(distanciaDesvios>distancia) distancia = distanciaDesvios;
			if(distancia<=passos) {
				ocupaPosicao(x1, y1, jogador);
				liberaPosicao(x0,y0);
				return true;
			}else return false;
		}
	}
	
	/*métodos auxiliares a movimentação*/
	protected void ocupaPosicao(int x, int y, String jogador) {
		tabuleiro[x][y] = nomeToId(jogador);
	}
	
	protected void liberaPosicao(int x, int y) {
		tabuleiro[x][y] = -1;
	}
	
	private int nomeToId(String nome) {
		int Id=0;
		for(String s: personagens) {
			if(nome.equals(s)) break;
			Id++;
		}return Id;
	}
		
	protected int[] getPortaMaisProxima(int x, int y, String destino, String jogador) {
		int j = nomeToId(jogador);
		int[][] portas;
		if(destino.equals(areas[1])) portas = portasCozinha;
		else if(destino.equals(areas[2])) portas = portasSalaDeJantar;
		else if(destino.equals(areas[3])) portas = portasSalaDeEstar;
		else if(destino.equals(areas[4])) portas = portasSalaDeMusica;
		else if(destino.equals(areas[5])) portas = portasEntrada;
		else if(destino.equals(areas[6])) portas = portasJardimDeInverno;
		else if(destino.equals(areas[7])) portas = portasSalaoDeJogos;
		else if(destino.equals(areas[8])) portas = portasEscritorio;
		else portas = portasBiblioteca;

		if(portas.length==1) {
			if(posicaoLivre(portas[0][0], portas[0][1]) || tabuleiro[portas[0][0]][portas[0][1]]==j)
				return portas[0];
			else return null;
		}
		int menorDistancia=1000;
		int portaMaisProxima[] = null;
		for(int[] porta: portas) { 
			if(posicaoLivre(porta[0], porta[1]) || tabuleiro[porta[0]][porta[1]]==j) {
				int distancia = Math.abs(porta[0]-x) + Math.abs(porta[1]-y);
				if(distancia<menorDistancia) {
					menorDistancia = distancia;
					portaMaisProxima = porta;
				}
			}
		}return portaMaisProxima;
	}
	
	private int atualizaPassos(int[][] vetor, int passos, int x, int y) {
		int i=0;
		while(i<passos) {
			if(!(vetor[i][0]==x && vetor[i][1]==y))  i++;
			else break;
		}return i;
	}
	
	private String getContornoPiao(String direcao, String dx, String dy, int x0, int y0, int x1, int y1) {
		if(direcao=="x") {
			if(dy=="norte") {
				for(int i=0; i<3 && y0-i>=y1; i++) {
					if(!(getAreaDoTabuleiro(x0-1,y0-i)=="Casas Comuns") || !posicaoLivre(x0-1,y0-i))
						return "leste";
					if(!(getAreaDoTabuleiro(x0+1,y0-i)=="Casas Comuns") || !posicaoLivre(x0+1,y0-i)) 
						return "oeste";		
				} 
				if(dx=="0") return "leste";
				else return dx;	
			}
			if(dy=="sul") {
				for(int i=0; i<3 && y0+i<=y1; i++) {
					if(!(getAreaDoTabuleiro(x0-1,y0+i)=="Casas Comuns") || !posicaoLivre(x0-1,y0+i))
						return "leste";
					if(!(getAreaDoTabuleiro(x0+1,y0+i)=="Casas Comuns") || !posicaoLivre(x0+1,y0+i)) 
						return "oeste";		
				}
				if(dx=="0") return "leste";
				else return dx;
			}
		}
		if(direcao=="y") {	
			if(dx=="oeste") {
				for(int i=0; i<3 && x0-i>=x1; i++) {
					if(!(getAreaDoTabuleiro(x0-i,y0+1)=="Casas Comuns") || !posicaoLivre(x0-i,y0+1))
						return "norte";
					if(!(getAreaDoTabuleiro(x0-i,y0-1)=="Casas Comuns") || !posicaoLivre(x0-i,y0-1)) 
						return "sul";		
				} 
				if(dy=="0") return "norte";
				else return dy;
			}
			if(dx=="leste") {
				for(int i=0; i<3 && x0+i<=x1; i++) {
					if(!(getAreaDoTabuleiro(x0+i,y0+1)=="Casas Comuns") || !posicaoLivre(x0+i,y0+1))
						return "norte";
					if(!(getAreaDoTabuleiro(x0+i,y0+1)=="Casas Comuns") || !posicaoLivre(x0+i,y0+1)) 
						return "sul";		
				} 
				if(dy=="0") return "norte";
				else return dy;
			}
		}return "erro";
	}

	private String getContorno(String direcao, int x0, int x1, int y0, int y1, int x, int y, String area) {
		if(direcao=="x") {
			if(x<=2) return "leste";
			if(x>=25) return "oeste";
			if(area=="Cozinha" || area=="Sala de Jantar" || area=="Sala de Estar") return "leste";
			if(area=="Jardim de Inverno" || area=="Salão de Jogos" || area=="Biblioteca" || area=="Escritório") return "oeste";
			if(area=="Sala de Música") {
				if(y0==2) {
					if(x0<14) return "oeste";
					else return "leste";
				}
				if(y0==9) {
					if(x1<14) return "oeste";
					else return "leste";
				}
			}
			if(area=="Entrada") {
				if(x1<14) return "oeste";
				else return "leste";
			}
			if(area=="Detetive") {
				if(y0==10) {
					int distOeste = (x0-11) + (y1-10) + (x1-11);
					int distLeste = (17-x0) + (y1-10) + (17-x1);
					if(distOeste<distLeste) return "oeste";
					else return "leste";
				}
				if(y0==18) {
					int distOeste = (x0-11) + (18-y1) + (x1-11);
					int distLeste = (17-x0) + (18-y1) + (17-x1);
					if(distOeste<distLeste) return "oeste";
					else return "leste";
				}
				
			}
		}
		if(direcao=="y") {
			if(y<=2) return "sul";
			if(y>=25) return "norte";
			if(area=="Cozinha" || area=="Sala de Música" || area=="Jardim de Inverno") return "sul";
			if(area=="Sala de Estar" || area=="Entrada" ||  area=="Escritório") return "norte";
			if(area=="Sala de Jantar" || area=="Salão de Jogos" || area=="Biblioteca") {
				if(y0<y1) return "sul";
				else return "norte";
			}
			if(area=="Detetive") {
				if(x0==17) {
					int distNorte = (y0-10) + (17-x1) + (y1-10);
					int distSul = (18-y0) + (17-x1) + (18-y1);
					if(distNorte<distSul) return "norte";
					else return "sul";
				}
				if(x0==11) {
					int distNorte = (y0-10) + (x1-11) + (y1-10);
					int distSul = (18-y0) + (x1-11) + (18-y1);
					if(distNorte<distSul) return "norte";
					else return "sul";
				}
			}
		}return "erro";
	}
	
	private int getDistancia(int x0, int y0, int x1, int y1) {
		int caminho[][] = new int[51][2];
		int x=x0, y=y0, passos=0, rounds=0;
		String direcaoEmX="0", direcaoEmY="0", area;
		boolean desvioPorX = false;
		boolean desvioPorY = false;
		
		if(x<x1) direcaoEmX = "leste";
		else if(x==x1) direcaoEmX = "0";
		else if(x>x1) direcaoEmX = "oeste";
		
		if(y<y1) direcaoEmY = "sul";
		else if(y==y1) direcaoEmY = "0";
		else if(y>y1) direcaoEmY = "norte";
				
		while(!(x==x1 && y==y1)) {
			while(true) {
				if(x==x1 && y==y1) break;
				//buscando em que direção de x andar
				if(!desvioPorX) {
					if(x<x1) direcaoEmX = "leste";
					else if(x==x1) direcaoEmX = "0";
					else if(x>x1) direcaoEmX = "oeste";
				}
				//tentando andar de acordo com a direção definida
				if(direcaoEmX!="0" || desvioPorX) {
					if(direcaoEmX=="leste") {
						x++;
						if((area = getAreaDoTabuleiro(x, y))=="Casas Comuns") {
							if(posicaoLivre(x,y)) {
								passos = atualizaPassos(caminho, passos, x, y);
								caminho[passos][0]=x; caminho[passos][1]=y;
								passos++;
								System.out.printf("(p: %d) [%d, %d] >> ",passos, x,y); 
								desvioPorY=false;
							}else {
								x--;
								desvioPorY=true;
								direcaoEmY = getContornoPiao("y", direcaoEmX, direcaoEmY, x, y, x1, y1);
								System.out.printf("bateu em piao\ndesvio: %s\n",direcaoEmY);
								if(direcaoEmY=="erro") return -1;
							}
						}
						else {
							x--;
							desvioPorY=true;
							direcaoEmY = getContorno("y", x, x1, y, y1, x+1, y, area);
							System.out.printf("(%d, %d) bateu em: %s\ndesvio: %s\n",x+1,y,area, direcaoEmY);
							if(direcaoEmY=="erro") return -1;
						}
					}else if(direcaoEmX=="oeste") {
						x--;
						if((area = getAreaDoTabuleiro(x, y))=="Casas Comuns") {
							if(posicaoLivre(x,y)) {
								passos = atualizaPassos(caminho, passos, x, y);
								caminho[passos][0]=x; caminho[passos][1]=y; 
								passos++; 
								System.out.printf("(p: %d) [%d, %d] >> ",passos, x,y);
								desvioPorY=false;
							}
							else {
								x++;
								desvioPorY=true;
								direcaoEmY = getContornoPiao("y", direcaoEmX, direcaoEmY, x, y, x1, y1);
								System.out.printf("bateu em piao\ndesvio: %s\n",direcaoEmY);
								if(direcaoEmY=="erro") return -1;
							}
						}
						else {
							x++;
							desvioPorY=true;
							direcaoEmY = getContorno("y", x, x1, y, y1, x-1, y, area);
							System.out.printf("(%d, %d) bateu em: %s\ndesvio: %s\n",x-1,y,area, direcaoEmY);
							if(direcaoEmY=="erro") return -1;
						}
					}
				}
				//buscando em que direção de y andar
				if(!desvioPorY) {
					if(y<y1) direcaoEmY = "sul";
					else if(y==y1) direcaoEmY = "0";
					else if(y>y1) direcaoEmY = "norte";
				}
				//tentando andar de acordo com a direção definida
				if(direcaoEmY!="0" || desvioPorY) {
					if(direcaoEmY=="sul") {
						y++;
						if((area = getAreaDoTabuleiro(x, y))=="Casas Comuns") {
							if(posicaoLivre(x,y)) {
								passos = atualizaPassos(caminho, passos, x, y);
								caminho[passos][0]=x; caminho[passos][1]=y; 
								passos++; 
								System.out.printf("(p: %d) [%d, %d] >> ",passos, x,y);
								desvioPorX=false;
							}
							else {
								y--;
								desvioPorX=true;
								direcaoEmX = getContornoPiao("x", direcaoEmX, direcaoEmY, x, y, x1, y1);
								System.out.printf("bateu em piao\ndesvio: %s\n",direcaoEmX);
								if(direcaoEmX=="erro") return -1;
							}
						}
						else {
							y--;
							desvioPorX=true;
							direcaoEmX = getContorno("x", x, x1, y, y1, x, y+1, area);
							System.out.printf("(%d, %d) bateu em: %s\ndesvio: %s\n",x,y+1,area,direcaoEmX);
							if(direcaoEmX=="erro") return -1;
						}
					}else if(direcaoEmY=="norte") {
						y--;
						if((area = getAreaDoTabuleiro(x, y))=="Casas Comuns") {
							if(posicaoLivre(x,y)) {
								passos = atualizaPassos(caminho, passos, x, y);
								caminho[passos][0]=x; caminho[passos][1]=y;
								passos++; 
								System.out.printf("(p: %d) [%d, %d] >> ",passos, x,y);
								desvioPorX=false; 
							}
							else {
								y++;
								desvioPorX=true;
								direcaoEmX = getContornoPiao("x", direcaoEmX, direcaoEmY, x, y, x1, y1);
								System.out.printf("bateu em piao\ndesvio: %s\n",direcaoEmX);
								if(direcaoEmX=="erro") return -1;
							}
						}
						else {
							y++;
							desvioPorX=true;
							direcaoEmX = getContorno("x", x, x1, y, y1, x, y-1, area);
							System.out.printf("(%d, %d) bateu em: %s\ndesvio: %s\n",x,y-1,area,direcaoEmX);
							if(direcaoEmX=="erro") return -1;
						}
					}
				}
				if(passos>20) return 20;	/*já andou 20 passos e não conseguiu chegar, retorna distância inatingível*/
				break;
			}
			rounds++;
			if(rounds>50) break;
		}
		if(!(x==x1 && y==y1)) return 20;	/*já tentou mover 50 vezes e não conseguiu chegar, retorna distância inatingível*/
		return passos;
	}	
	
	/*métodos de movimentação especial*/
	protected void movePiaoIncondicional(int x0, int y0, int x1, int y1, String jogador) {
		ocupaPosicao(x1, y1, jogador);
		liberaPosicao(x0,y0);
	}

	protected boolean permissaoPassagemSecreta(int x, int y) {
		String comodo = getAreaDoTabuleiro(x, y);
		if(comodo=="Cozinha"||comodo=="Escritório"||comodo=="Jardim de Inverno"||comodo=="Sala de Estar") 
			return true;
		return false;
	}
	
	protected int[] movePiaoPassagemSecreta(int x, int y, String jogador) {
		String comodo = getAreaDoTabuleiro(x, y);
		int[][] coordsDestino = null;
		int x1=0, y1=0;
		if(comodo=="Cozinha") { coordsDestino = coordEscritorio; }
		else if(comodo=="Escritório") { coordsDestino = coordCozinha; }
		else if(comodo=="Jardim de Inverno") { coordsDestino = coordSalaDeEstar; }
		else if(comodo=="Sala de Estar") { coordsDestino = coordJardimDeInverno; }
		
		if(coordsDestino==null) return null;
		for(int i=0; i<coordsDestino.length; i++) {
			x1 = coordsDestino[i][0];
			y1 = coordsDestino[i][1];
			if(posicaoLivre(x1,y1)) break;
		}
		String destino = getAreaDoTabuleiro(x1, y1);
		if(destino=="Cozinha" || destino=="Escritório" || 
				destino=="Jardim de Inverno" || destino=="Sala de Estar") {
			ocupaPosicao(x1, y1, jogador);
			liberaPosicao(x,y);
		}
		int[] coordenadas = {x1,y1};
		return coordenadas;
	}
	
	/*método para reinicio de jogo*/
	protected void reiniciaTabuleiro() {
		for(int x=0;x<27;x++) {
			for(int y=0;y<26;y++) tabuleiro[x][y]=-1;
		} 
		tabuleiro[11][1] = 0;
		tabuleiro[16][1] = 1;
		tabuleiro[25][7] = 2;
		tabuleiro[2][18] = 3;
		tabuleiro[9][25] = 4;
		tabuleiro[25][20] = 5;
	}
	
	/*métodos para carregamento de jogo*/
	protected void zeraTabuleiro() {
		for(int x=0;x<27;x++) {
			for(int y=0;y<26;y++) tabuleiro[x][y]=-1;
		} 
	}
	
	protected void setTabuleiro(int[][] coordJogadores, String[] jogadores, int[][] coordBots, String[] bots) {
		int i=0;
		for(int[] coord: coordJogadores) {
			tabuleiro[coord[0]][coord[1]] = nomeToId(jogadores[i]); i++; }
		i=0;
		for(int[] coord: coordBots) {
			tabuleiro[coord[0]][coord[1]] = nomeToId(bots[i]); i++; }
	}
}
