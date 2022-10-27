package Model;

public class Jogador {
	static int ordem=1;
	protected int identificador;
	public int numCartas;
	public String personagem;
	private String []cartas;
	private String [][]blocoNotas = {{"Corda","0"},{"Cano de Chumbo","0"},{"Faca","0"},{"Chave Inglesa","0"},{"Castiçal","0"},{"Revólver","0"},{"Coronel Mustard","0"},{"Srta. Scarlet","0"},{"Professor Plum","0"},{"Reverendo Green","0"},{"Sra. White","0"},{"Sra. Peacock","0"},{"Entrada","0"},{"Sala de Estar","0"},{"Sala de Jantar","0"},{"Cozinha","0"},{"Sala de Música","0"},{"Jardim de Inverno","0"},{"Salão de Jogos","0"},{"Biblioteca","0"},{"Escritório","0"}};
	protected boolean turn = false;
	public boolean block = false;
	public int x, y;
	
	public Jogador(String pngm, int numJogadores){
		identificador = ordem;
		ordem++;
		personagem = pngm;
		numCartas = contaCartas(numJogadores);
		
	}

	private int contaCartas(int numJogadores){ 
		if(numJogadores==3) return 6;
		if(numJogadores==6) return 3;
		if(numJogadores==4) {
			if(identificador<3) return 4;
			else return 5;
		}
		if(numJogadores==5) {
			if(identificador<4) return 4;
			else return 3;
		}
		return -1;
	}
	
	public void recebeCartas(int numCartas, String[] selecao) {
		cartas = new String[numCartas];
	    cartas = selecao;
	    iniciaBlocoNotas();
	}
	
	private void iniciaBlocoNotas() {	
		for(String c: cartas) {
			for(String[] b:blocoNotas) {
				if(c==b[0]) {
					b[1]="1";
					break;
				}
			}
		}
	}
	
	protected void marcaBlocoNotas(String carta) {
		for(String[] b:blocoNotas) {
			if(carta==b[0]) {
				b[1]="1";
				break;
			}
		}
	}
	
	public String[] getCartas() {
		return cartas;
	}
	
	protected String[][] getBlocoNotas() {
		return blocoNotas;
	}

	public void setTurn(){
		turn = true;
	}
	
	public void setBlock(){
		block = true;
	}
	
	public static void reiniciaJogador() {
		ordem=1;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}


