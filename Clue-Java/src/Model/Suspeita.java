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
	
	boolean confirmarPalpite(Jogador JogadorDaVez, Jogador[] jogadores, int[] palpiteCartaErrada) {
		for(Jogador j: jogadores) {
			for(String s: j.getCartas()) {
				if(s.equals(arma)) {
					JogadorDaVez.marcaBlocoNotas(arma);
					palpiteCartaErrada[0] = 1;
					return false;
				}if(s.equals(suspeito)) {
					JogadorDaVez.marcaBlocoNotas(suspeito);
					palpiteCartaErrada[1] = 1;
					return false;
				}if(s.equals(comodo)) {
					JogadorDaVez.marcaBlocoNotas(comodo);
					palpiteCartaErrada[2] = 1;
					return false;
				}
			}
		}return true;
	}
	
	boolean fazerAcusacao(Jogador jogador) {
		Cartas c = Cartas.getInstancia();
		if(arma.equals(c.getEnvelope()[0]) && suspeito.equals(c.getEnvelope()[1]) && comodo.equals(c.getEnvelope()[2])) {
			return true;
		}
		jogador.setBlock();
		return false;
	}
}
