package Model;

class Suspeita {
	protected String arma, suspeito, comodo;
	
	Suspeita(String armaSus, String suspeitoSus, String comodoSus){
		arma = armaSus;
		suspeito = suspeitoSus;
		comodo = comodoSus;	
	}
	
	boolean DarPalpite(String localAtual) {
		//check if the player is in the indicated room, if not ask again for the guess
		if(localAtual!=comodo) return false;
		//if yes
			//bring weapon to the room (graphic)
			//if suspect is not in the room, bring it to the room(graphic)
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
		Cartas c = new Cartas();
		if(arma==c.getEnvelope()[0] && suspeito==c.getEnvelope()[1] && comodo==c.getEnvelope()[2]) {
			return true;
		}
		//show the player the correct answer (graphic)
		jogador.setBlock();
		return false;
	}
}
