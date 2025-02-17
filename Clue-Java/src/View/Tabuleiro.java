package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Model.ModelAPI;

@SuppressWarnings("serial")
public class Tabuleiro extends JPanel {
	private Image tabuleiro;
	private Image dado1;
	private Image dado2;
	/*coordenadas: "Sra. White" (white), "Reverendo Green" (green), "Sra. Peacock" (blue),
	"Coronel Mustard" (yellow), "Srta. Scarlet" (red), "Professor Plum" (pink)*/
	private static int[][] coordenadas = {{286, 29}, {411, 31}, {640, 185}, {61, 458}, {238, 630}, {639, 508}};
	ImageIcon refd1;
	ImageIcon refd2;
	
	public Tabuleiro() { }
	
	public Tabuleiro(String piao, int d1, int d2, int x , int y) {
		/*tabuleiro*/
		ImageIcon ref = new ImageIcon("res\\Tabuleiros\\Tabuleiro-Clue-A.jpg");
		tabuleiro = ref.getImage();
		
		/*dados*/
		if(d1 == 0) {
			refd1 = new ImageIcon("res\\Tabuleiros\\dado1.jpg");
		}else if(d1 == 1) {
			refd1 = new ImageIcon("res\\Tabuleiros\\dado1.jpg");
		}else if(d1 == 2) {
			refd1 = new ImageIcon("res\\Tabuleiros\\dado2.jpg");
		}else if(d1 == 3) {
			refd1 = new ImageIcon("res\\Tabuleiros\\dado3.jpg");
		}else if(d1 == 4) {
			refd1 = new ImageIcon("res\\Tabuleiros\\dado4.jpg");
		}else if(d1 == 5) {
			refd1 = new ImageIcon("res\\Tabuleiros\\dado5.jpg");
		}else if(d1 == 6) {
			refd1 = new ImageIcon("res\\Tabuleiros\\dado6.jpg");
		}
		dado1 = refd1.getImage();
		
		if(d2 == 0) {
			refd2 = new ImageIcon("res\\Tabuleiros\\dado1.jpg");
		}else if(d2 == 1) {
			refd2 = new ImageIcon("res\\Tabuleiros\\dado1.jpg");
		}else if(d2 == 2) {
			refd2 = new ImageIcon("res\\Tabuleiros\\dado2.jpg");
		}else if(d2 == 3) {
			refd2 = new ImageIcon("res\\Tabuleiros\\dado3.jpg");
		}else if(d2 == 4) {
			refd2 = new ImageIcon("res\\Tabuleiros\\dado4.jpg");
		}else if(d2 == 5) {
			refd2 = new ImageIcon("res\\Tabuleiros\\dado5.jpg");
		}else if(d2 == 6) {
			refd2 = new ImageIcon("res\\Tabuleiros\\dado6.jpg");
		}
		dado2 = refd2.getImage();
		
		/*piões*/
		if(x!=0 && y!=0) {
			if(piao == "Sra. White") {
				coordenadas[0][0] = x; coordenadas[0][1] = y;
			}else if(piao == "Reverendo Green") {
				coordenadas[1][0] = x; coordenadas[1][1] = y;
			}else if(piao == "Sra. Peacock") {
				coordenadas[2][0] = x; coordenadas[2][1] = y;
			}else if(piao == "Coronel Mustard") {
				coordenadas[3][0] = x; coordenadas[3][1] = y;
			}else if(piao == "Srta. Scarlet") {
				coordenadas[4][0] = x; coordenadas[4][1] = y;
			}else if(piao == "Professor Plum") {
				coordenadas[5][0] = x; coordenadas[5][1] = y;
			}
		}
		ModelAPI modelAPI = ModelAPI.getInstancia();
		modelAPI.atualizaPosicoes(coordenadas);
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(tabuleiro, 0, -30, null);
		graficos.drawImage(dado1, 850, 500, null);
		graficos.drawImage(dado2, 940, 500, null);
		
		graficos.setColor(Color.WHITE);
		graficos.fillOval(coordenadas[0][0]-3, coordenadas[0][1]-3, 10, 10);
		
		graficos.setColor(Color.GREEN);
		graficos.fillOval(coordenadas[1][0]-3, coordenadas[1][1]-3, 10, 10);
		
		graficos.setColor(Color.BLUE);
		graficos.fillOval(coordenadas[2][0]-3, coordenadas[2][1]-3, 10, 10);
		
		graficos.setColor(Color.YELLOW);
		graficos.fillOval(coordenadas[3][0]-3, coordenadas[3][1]-3, 10, 10);
		
		graficos.setColor(Color.RED);
		graficos.fillOval(coordenadas[4][0]-3, coordenadas[4][1]-3, 10, 10);
		
		graficos.setColor(Color.MAGENTA);
		graficos.fillOval(coordenadas[5][0]-3, coordenadas[5][1]-3, 10, 10);
		g.dispose();
	}
}
