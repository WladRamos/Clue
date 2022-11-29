package View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import Controller.Controller;
import Model.ModelAPI;

public class Arquivo {
	private static ModelAPI modelAPI = ModelAPI.getInstancia();
	private static Controller ctrl = Controller.getInstancia();
		
	public static boolean gravaArquivo(String nome_arq,String []arrayJog,String []arrayBots) {
		int i,j;
		int []cords;
		String []blocoNotasJogador;
		String []cartasJogador;
		boolean blockJogador;
		String ultimComodoJogador;
		String []envelope = modelAPI.getEnvelope();
				
		try {
			FileWriter arq = new FileWriter(nome_arq);
			PrintWriter gravaArq = new PrintWriter(arq);
			
			gravaArq.println(ctrl.getJogadorDaVezId());
			gravaArq.println(arrayJog.length);
			gravaArq.println(arrayBots.length);
			gravaArq.printf(envelope[0] + "," + envelope[1] + "," + envelope[2] + '\n');
			
			gravaArq.println("Jogadores:");
			for (i = 0;i < arrayJog.length;i++) {
				gravaArq.printf("Jogador " + (i+1) + "\n");
				
				cords = modelAPI.getCordPiao(arrayJog[i]);
				blocoNotasJogador = modelAPI.getBlocoDeNotasJogador(i);
				cartasJogador = modelAPI.getCartasJogador(i);
				blockJogador = modelAPI.jogadorBloqueado(i);
				ultimComodoJogador = modelAPI.getUltimoComodo(i);
				
				gravaArq.printf(arrayJog[i] + "," + cords[0] + "," + cords[1] + "," + blockJogador + "," + ultimComodoJogador + "\n");
				
				gravaArq.println(blocoNotasJogador.length);
				for (j = 0; j < blocoNotasJogador.length;j++) {
					gravaArq.printf(blocoNotasJogador[j]);
					
					if (j != blocoNotasJogador.length - 1)
						gravaArq.printf(",");
				}
				
				gravaArq.println("\n" + cartasJogador.length);
				for (j = 0; j < cartasJogador.length;j++) {
					gravaArq.printf(cartasJogador[j]);
					
					if (j != cartasJogador.length - 1)
						gravaArq.printf(",");
				}
				gravaArq.printf("\n");
			}
			
			if (arrayBots.length > 0) {
				gravaArq.println("Bots:");
				for (i = 0;i < arrayBots.length;i++) {
					gravaArq.printf("Bot " + (i+1) + "\n");
					cords = modelAPI.getCordPiao(arrayBots[i]);
					gravaArq.printf(arrayBots[i] + "," + cords[0] + "," + cords[1] +  "\n");
				}
			}
			gravaArq.close();
			return true;
		}
		catch(Exception e) {
				return false;
			}
		}
				
		public static BufferedReader lerArquivo(String nome_arq) {
			BufferedReader lerArq;
			try {
				FileReader arq = new FileReader(nome_arq);
				lerArq = new BufferedReader(arq);
				return lerArq;
			}catch(Exception e) {
				return null;
			}
		}
}
