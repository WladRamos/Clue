package Model;

class Suspeita {
	protected String arma, suspeito, comodo;
	
	Suspeita(String armaSus, String suspeitoSus, String comodoSus){
		arma = armaSus;
		suspeito = suspeitoSus;
		comodo = comodoSus;	
	}
	
	boolean DarPalpite(String localAtual) {
		if(localAtual!=comodo) return false;
		return true;
	}
	
	boolean confirmarPalpite(Jogador JogadorDaVez, Jogador [] jogadores) {
		for(Jogador j: jogadores) {
			for(String s: j.getCartas()) {
				if(s==arma) {
					JogadorDaVez.marcaBlocoNotas(arma);
					return false;
				}if(s==suspeito) {
					JogadorDaVez.marcaBlocoNotas(suspeito);
					return false;
				}if(s==comodo) {
					JogadorDaVez.marcaBlocoNotas(comodo);
					return false;
				}
			}
		}return true;
	}
	
	boolean fazerAcusacao(Jogador jogador) {
		Cartas c = Cartas.getInstancia();
		if(arma==c.getEnvelope()[0] && suspeito==c.getEnvelope()[1] && comodo==c.getEnvelope()[2]) {
			return true;
		}
		jogador.setBlock();
		return false;
	}
}
