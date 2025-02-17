package Model;

class Jogador {
	protected static int ordem=1;
	protected int identificador;
	protected int numCartas;
	protected String personagem;
	private String []cartas;
	private String [][]blocoNotas = {{"Corda","0"},{"Cano de Chumbo","0"},{"Faca","0"},{"Chave Inglesa","0"},{"Castiçal","0"},{"Revólver","0"},{"Coronel Mustard","0"},{"Srta. Scarlet","0"},{"Professor Plum","0"},{"Reverendo Green","0"},{"Sra. White","0"},{"Sra. Peacock","0"},{"Entrada","0"},{"Sala de Estar","0"},{"Sala de Jantar","0"},{"Cozinha","0"},{"Sala de Música","0"},{"Jardim de Inverno","0"},{"Salão de Jogos","0"},{"Biblioteca","0"},{"Escritório","0"}};
	protected String ultimoComodo = "0";
	protected boolean block = false;
	protected int x, y;
	
	public Jogador() {
	}
	
	public Jogador(String pngm, int n){
		identificador = ordem;
		ordem++;
		personagem = pngm;
		numCartas = contaCartas(n);
		Cartas c = Cartas.getInstancia();
		recebeCartas(numCartas, c.DistribuiCartas(numCartas));
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
	
	protected void recebeCartas(int numCartas, String[] selecao) {
		cartas = new String[numCartas];
	    cartas = selecao;
	    iniciaBlocoNotas();
	}
	
	private void iniciaBlocoNotas() {	
		for(String c: cartas) {
			for(String[] b:blocoNotas) {
				if(c.equals(b[0])) {
					b[1]="1"; break; } } }
	}
	
	protected void marcaBlocoNotas(String carta) {
		for(String[] b:blocoNotas) {
			if(carta.equals(b[0])) {
				b[1]="1"; break; } }
	}
	
	public String[] getCartasBlocoNotas() {
		String[] auxiliar = new String[21];
		int c=0;
		for(int i=0; i<blocoNotas.length; i++) {
			if(blocoNotas[i][1]!="0") {
				auxiliar[c] = blocoNotas[i][0]; c++;
			}
		}String[] cartasMarcadas = new String[c];
		System.arraycopy(auxiliar, 0, cartasMarcadas, 0, c);
		return cartasMarcadas;
	}
	
	public String[] getCartas() {
		return cartas;
	}
		
	public String[][] getBlocoNotas() {
		return blocoNotas;
	}
	
	public void setBlock(){
		block = true;
	}
	
	/*método criado apenas para testes*/
	public static void reiniciaJogador() {
		ordem=1;
	}
	
	/*método para carregamento de jogo*/
	protected void criaJogador(int id, int ncartas, String persongm, String[] cards, 
			String [][] bn, String ultimoCmd, boolean bloq, int x_, int y_) {
		identificador = id;
		numCartas = ncartas;
		personagem = persongm;
		cartas = cards;
		blocoNotas = bn;
		ultimoComodo = ultimoCmd;
		block = bloq;
		x = x_; y = y_;
	}
}


