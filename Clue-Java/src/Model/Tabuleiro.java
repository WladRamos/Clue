package Model;

public class Tabuleiro {
	static Tabuleiro tabuleiroInstancia;
	private int tabuleiro [][] = new int[561][2];
		
	/*dictionary of matrix areas*/
	private int coordCasas[][] = {{9, 2}, {10, 2}, {11, 2}, {16, 2}, {17, 2}, {18, 2}, {8, 3}, {9, 3}, {18, 3}, {19, 3}, {8, 4}, {9, 4}, {18, 4}, {19, 4}, {8, 5}, {9, 5}, {18, 5}, {19, 5}, {8, 6}, {9, 6}, {18, 6}, {19, 6}, {20, 6}, {8, 7}, {9, 7}, {18, 7}, {19, 7}, {20, 7}, {21, 7}, {22, 7}, {23, 7}, {24, 7}, {2, 8}, {3, 8}, {4, 8}, {5, 8}, {6, 8}, {7, 8}, {8, 8}, {9, 8}, {18, 8}, {19, 8}, {20, 8}, {21, 8}, {22, 8},{23, 8}, {24, 8}, {3, 9}, {4, 9}, {5, 9}, {6, 9}, {7, 9}, {8, 9}, {9, 9}, {10, 9}, {11, 9}, {12, 9}, {13, 9}, {14, 9}, {15, 9}, {16, 9}, {17, 9}, {18, 9}, {19, 9}, {7, 10}, {8, 10}, {9, 10}, {10, 10}, {11, 10}, {12, 10}, {13, 10}, {14, 10}, {15, 10}, {16, 10}, {17, 10}, {18, 10}, {19, 10}, {10, 11}, {11, 11}, {17, 11}, {18, 11}, {19, 11}, {10, 12}, {11, 12}, {17, 12}, {18, 12}, {19, 12}, {10, 13}, {11, 13}, {17, 13}, {18, 13}, {19, 13}, {10, 14}, {11, 14}, {17, 14}, {18, 14}, {19, 14}, {20, 14}, {21, 14}, {22, 14}, {23, 14}, {24, 14}, {10, 15}, {11, 15}, {17, 15}, {18, 15}, {19, 15}, {10, 16}, {11, 16}, {18, 16}, {3, 17}, {4, 17}, {5, 17}, {7, 17}, {8, 17}, {10, 17}, {11, 17}, {17, 17}, {18, 17}, {3, 18}, {9, 18}, {10, 18}, {13, 18}, {15, 18}, {16, 18}, {17, 18}, {18, 18}, {3, 19}, {4, 19}, {7, 19}, {8, 19}, {9, 19}, {10, 19}, {19, 19}, {9, 20}, {10, 20}, {19, 20}, {22, 20}, {23, 20}, {24, 20}, {9, 21}, {10, 21}, {17, 21}, {18, 21}, {20, 21}, {21, 21}, {22, 21}, {23, 21}, {24, 21}, {9, 22}, {10, 22}, {17, 22}, {18, 22}, {9, 23}, {10, 23}, {17, 23}, {18, 23}, {9, 24}, {10, 24}, {17, 24}, {18, 24}, {18, 25},};
	private int coordCozinha[][] = {{2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {7, 1}, {2, 2}, {3, 2}, {4, 2}, {5, 2}, {6, 2}, {7, 2}, {2, 3}, {3, 3}, {4, 3}, {5, 3}, {6, 3}, {7, 3}, {2, 4}, {3, 4}, {4, 4}, {5, 4}, {6, 4}, {7, 4}, {2, 5}, {3, 5}, {4, 5}, {5, 5}, {6, 5}, {7, 5}, {2, 6}, {3, 6}, {4, 6}, {5, 6}, {6, 6}, {7, 6}, {3, 7}, {4, 7}, {5, 7}, {6, 7}, {7, 7}};
	private int portasCozinha[][] = {{6, 8}};
	private int coordSalaDeJantar[][] = {{2, 9}, {3, 9}, {4, 9}, {5, 9}, {6, 9}, {7, 9}, {8, 9}, {9, 9}, {2, 10}, {3, 10}, {4, 10}, {5, 10}, {6, 10}, {2, 11}, {3, 11}, {4, 11}, {5, 11}, {6, 11}, {7, 11}, {8, 11}, {9, 11}, {2, 12}, {3, 12}, {4, 12}, {5, 12}, {6, 12}, {7, 12}, {8, 12}, {9, 12}, {2, 13}, {3, 13}, {4, 13}, {5, 13}, {6, 13}, {7, 13}, {8, 13}, {9, 13}, {2, 14}, {3, 14}, {4, 14}, {5, 14}, {6, 14}, {7, 14}, {8, 14}, {9, 14}, {2, 15}, {3, 15}, {4, 15}, {5, 15}, {6, 15}, {7, 15}, {8, 15}, {9, 15}, {2, 16}, {3, 16}, {4, 16}, {5, 16}, {6, 16}, {7, 16}, {8, 16}, {9, 16}};
	private int portasSalaDeJantar[][] = {{10, 13}, {8, 17}};
	private int coordSalaDeEstar[][] = {{2, 20}, {3, 20}, {4, 20}, {5, 20}, {6, 20}, {7, 20}, {8, 20}, {2, 21}, {3, 21}, {4, 21}, {5, 21}, {6, 21}, {7, 21}, {8, 21}, {2, 22}, {3, 22}, {4, 22}, {5, 22}, {6, 22}, {7, 22}, {8, 22}, {2, 23}, {3, 23}, {4, 23}, {5, 23}, {6, 23}, {7, 23}, {8, 23}, {2, 24}, {3, 24}, {4, 24}, {5, 24}, {6, 24}, {7, 24}, {8, 24}, {2, 25}, {3, 25}, {4, 25}, {5, 25}, {6, 25}, {7, 25}};
	private int portasSalaDeEstar[][] = {{8, 19}};
	private int coordSalaDeMusica[][] = {{12, 2}, {13, 2}, {14, 2}, {15, 2}, {10, 3}, {11, 3}, {12, 3}, {13, 3}, {14, 3}, {15, 3}, {16, 3}, {17, 3}, {10, 4}, {11, 4}, {12, 4}, {13, 4}, {14, 4}, {15, 4}, {16, 4}, {17, 4}, {10, 5}, {11, 5}, {12, 5}, {13, 5}, {14, 5}, {15, 5}, {16, 5}, {17, 5}, {10, 6}, {11, 6}, {12, 6}, {13, 6}, {14, 6}, {15, 6}, {16, 6}, {17, 6}, {10, 7}, {11, 7}, {12, 7}, {13, 7}, {14, 7}, {15, 7}, {16, 7}, {17, 7}, {10, 8}, {11, 8}, {12, 8}, {13, 8}, {14, 8}, {15, 8}, {16, 8}, {17, 8}};
	private int portasSalaDeMusica[][] = {{9, 6}, {11, 9}, {16, 9}, {18, 6}};
	private int coordEntrada[][] = {{11, 19}, {12, 19}, {13, 19}, {14, 19}, {15, 19}, {16, 19}, {11, 20}, {12, 20}, {13, 20}, {14, 20}, {15, 20}, {16, 20}, {11, 21}, {12, 21}, {13, 21}, {14, 21}, {15, 21}, {16, 21}, {11, 22}, {12, 22}, {13, 22}, {14, 22}, {15, 22}, {16, 22}, {11, 23}, {12, 23}, {13, 23}, {14, 23}, {15, 23}, {16, 23}, {11, 24}, {12, 24}, {13, 24}, {14, 24}, {15, 24}, {16, 24}, {12, 25}, {13, 25}, {14, 25}, {15, 25}};
	private int portasEntrada[][] = {{13, 18}, {14, 18}, {17, 21}};
	private int coordJardimDeInverno[][] = {{20, 2}, {21, 2}, {22, 2}, {23, 2}, {24, 2}, {25, 2}, {20, 3}, {21, 3}, {22, 3}, {23, 3}, {24, 3}, {25, 3}, {20, 4}, {21, 4}, {22, 4}, {23, 4}, {24, 4}, {25, 4}, {20, 5}, {21, 5}, {22, 5}, {23, 5}, {24, 5}, {25, 5}, {21, 6}, {22, 6}, {23, 6}, {24, 6}};
	private int portasJardimDeInverno[][] = {{20, 6}};
	private int coordSalaoDeJogos[][] = {{20, 9}, {21, 9}, {22, 9}, {23, 9}, {24, 9}, {25, 9}, {20, 10}, {21, 10}, {22, 10}, {23, 10}, {24, 10}, {25, 10}, {20, 11}, {21, 11}, {22, 11}, {23, 11}, {24, 11}, {25, 11}, {20, 12}, {21, 12}, {22, 12}, {23, 12}, {24, 12}, {25, 12}, {20, 13}, {21, 13}, {22, 13}, {23, 13}, {24, 13}, {25, 13}};
	private int portasSalaoDeJogos[][] = {{19, 10}, {24, 14}};
	private int coordBiblioteca[][] = {{20, 15}, {21, 15}, {22, 15}, {23, 15}, {24, 15}, {19, 16}, {20, 16}, {21, 16}, {22, 16}, {23, 16}, {24, 16}, {25, 16}, {19, 17}, {20, 17}, {21, 17}, {22, 17}, {23, 17}, {24, 17}, {25, 17}, {19, 18}, {20, 18}, {21, 18}, {22, 18}, {23, 18}, {24, 18}, {25, 18}, {20, 19}, {21, 19}, {22, 19}, {23, 19}, {24, 19}};
	private int portasBiblioteca[][] = {{22, 14}, {18, 17}};
	private int coordEscritorio[][] = {{19, 22}, {20, 22}, {21, 22}, {22, 22}, {23, 22}, {24, 22}, {25, 22}, {19, 23}, {20, 23}, {21, 23}, {22, 23}, {23, 23}, {24, 23}, {25, 23}, {19, 24}, {20, 24}, {21, 24}, {22, 24}, {23, 24}, {24, 24}, {25, 24}, {20, 25}, {21, 25}, {22, 25}, {23, 25}, {24, 25}, {25, 25}};
	private int portasEscritorio[][] = {{19, 21}};
	private String[] areas = {"Casas Comuns", "Cozinha", "Sala de Jantar", "Sala de Estar", "Sala de Música", "Entrada", "Jardim de Inverno", "Salão de Jogos", "Escritório", "Biblioteca"};
	
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
	
	public void ocupaPosicao(int x, int y, int jogador) {
		tabuleiro[x][y] = jogador;
	}
	
	public void liberaPosicao(int x, int y) {
		tabuleiro[x][y] = 0;
	}
	
	public boolean posicaoLivre(int x, int y) {
		if(tabuleiro[x][y]==0) return true;
		return false;
	}
	
	public int MouseCoordToMatrixCoord(int coord) {
		return coord/25;
	}
	
	private boolean pertence(int x, int y, int[][] area) {
		for(int[] coord: area) {
			if(coord[0]==x && coord[1]==y) return true;
		}return false;
	}
	
	public String getAreaDoTabuleiro(int x, int y) {
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
		return "àrea inválida";
	}
	
	private int[] getPortaMaisProxima(int x, int y, String destino) {
		int[][] portas;
		if(destino==areas[1]) portas = portasCozinha;
		if(destino==areas[2]) portas = portasSalaDeJantar;
		if(destino==areas[3]) portas = portasSalaDeEstar;
		if(destino==areas[4]) portas = portasSalaDeMusica;
		if(destino==areas[5]) portas = portasEntrada;
		if(destino==areas[6]) portas = portasJardimDeInverno;
		if(destino==areas[7]) portas = portasSalaoDeJogos;
		if(destino==areas[8]) portas = portasEscritorio;
		else portas = portasBiblioteca;
		
		if(portas.length==1) return portas[0];
		int menorDistancia=-1;
		int portaMaisProxima[] = null;
		for(int[] porta: portas) { 
			if(posicaoLivre(porta[0], porta[1])) {
				int distancia = Math.abs(porta[0]-x) + Math.abs(porta[1]-y);
				if(distancia<menorDistancia) {
					menorDistancia = distancia;
					portaMaisProxima = porta;
				}
			}
		}return portaMaisProxima;
	}
	
	public boolean movePiao(int x0, int y0, int x1, int y1, int passos, int jogador) {
		String origem = getAreaDoTabuleiro(x0, y0);
		String destino = getAreaDoTabuleiro(x1, y1);
		
		if(destino=="àrea inválida") return false;
		if(!posicaoLivre(x1, y1)) return false;
		
		int distancia;
		if(origem=="Casas Comuns") {
			if(destino=="Casas Comuns") distancia = Math.abs(x0-x1) + Math.abs(y0-y1);
			else {	/*destino é um dos comodos*/
				int[] porta = getPortaMaisProxima(x0, y0, destino);
				if(porta==null) return false;
				distancia = Math.abs(x0-porta[0]) + Math.abs(y0-porta[1]);
			}
			if(distancia<=passos) {
				ocupaPosicao(x1, y1, jogador);
				liberaPosicao(x0,y0);
				return true;
			}else return false;
		}else {	/*origem é um dos comodos*/
			if(destino=="Casas Comuns"){
				int[] porta = getPortaMaisProxima(x1, y1, origem);
				if(porta==null) return false;
				distancia = Math.abs(x1-porta[0]) + Math.abs(y1-porta[1]);
			}else {	/*destino é um dos comodos*/
				/*passagens secretas*/
				if((origem=="Cozinha" && destino=="Escritório")||(destino=="Cozinha" && origem=="Escritório")
					||(origem=="Jardim de Inverno" && destino=="Sala de Estar")||(destino=="Jardim de Inverno" && origem=="Sala de Estar")) {
					ocupaPosicao(x1, y1, jogador);
					liberaPosicao(x0,y0);
					return true;
				}else {	/*comodo para comodo sem passagens secretas*/
					int[] porta1 = getPortaMaisProxima(x0, y0, destino);
					int[] porta2 = getPortaMaisProxima(x1, y1, origem);
					if(porta1==null || porta2==null) return false;
					distancia = Math.abs(porta1[0]-porta2[0]) + Math.abs(porta1[1]-porta2[1]);
					if(distancia<=passos) {
						ocupaPosicao(x1, y1, jogador);
						liberaPosicao(x0,y0);
						return true;
					}else return false;
				}
			}
		}return false;
	}
	
	public boolean permissaoPassagemSecreta(int x, int y) {
		String comodo = getAreaDoTabuleiro(x, y);
		if(comodo=="Cozinha"||comodo=="Escritório"||comodo=="Jardim de Inverno"||comodo=="Sala de Estar") 
			return true;
		return false;
	}
	
	public void movePiaoPassagemSecreta(int x, int y, int jogador) {
		String comodo = getAreaDoTabuleiro(x, y);
		int x1=0, y1=0;
		if(comodo=="Cozinha") { x1 = 22; y1 = 24; }
		else if(comodo=="Escritório") { x1 = 4; y1 = 4; }
		else if(comodo=="Jardim de Inverno") { x1 = 6; y1 = 23; }
		else if(comodo=="Sala de Estar") { x1 = 23; y1 = 25; }
		ocupaPosicao(x1, y1, jogador);
		liberaPosicao(x,y);
	}
	
}
