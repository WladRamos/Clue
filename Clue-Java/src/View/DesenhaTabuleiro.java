package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Model.ModelAPI;
import Model.ObservadoIF;
import Controller.Controller;

@SuppressWarnings("serial")
class DesenhaTabuleiro extends JPanel implements ObservadorIF{
	private Image tabuleiro;
	private Image dado1;
	private Image dado2;
	private ImageIcon refd1;
	private ImageIcon refd2;
	private static int[][] matriz;
	protected static int d1=0, d2=0;
	/*coordenadas: "Sra. White" (white), "Reverendo Green" (green), "Sra. Peacock" (blue),
	"Coronel Mustard" (yellow), "Srta. Scarlet" (red), "Professor Plum" (pink)*/
	private static int[][] coordenadas = {{286, 29}, {411, 31}, {640, 185}, {61, 458}, {238, 630}, {639, 508}};
	
	
	/*métodos do observador*/
	public void notify(ObservadoIF o) {
		int[] dados = o.getDados();
		d1 = dados[0]; d2 = dados[1];
		matriz = o.getTabuleiro();
	}
	
	/*registro do observador*/
	public DesenhaTabuleiro(Controller ctrl) { 
		ctrl.registra(this);
	}
	
	public DesenhaTabuleiro() {
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
		int x=0, y=0, stop=0, piao=0;
		for(piao=0; piao<6; piao++) {
			for(x=0, stop=0;x<27;x++) {
				for(y=0;y<26;y++) {
					if(matriz[x][y]==piao) { stop=1; break; }
				}
				if(stop==1) break;
			}
			x*=25; y*=25;
			coordenadas[piao][0]=x;
			coordenadas[piao][1]=y;
		}

		ModelAPI.getInstancia().atualizaPosicoes(coordenadas);
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(tabuleiro, 0, -30, null);
		graficos.drawImage(dado1, 850, 500, null);
		graficos.drawImage(dado2, 940, 500, null);
		
		graficos.setColor(Color.WHITE);
		graficos.fillOval(coordenadas[0][0]+3, coordenadas[0][1], 10, 10);
		
		graficos.setColor(Color.GREEN);
		graficos.fillOval(coordenadas[1][0]+3, coordenadas[1][1], 10, 10);
		
		graficos.setColor(Color.BLUE);
		graficos.fillOval(coordenadas[2][0]+3, coordenadas[2][1], 10, 10);
		
		graficos.setColor(Color.YELLOW);
		graficos.fillOval(coordenadas[3][0]+3, coordenadas[3][1], 10, 10);
		
		graficos.setColor(Color.RED);
		graficos.fillOval(coordenadas[4][0]+3, coordenadas[4][1], 10, 10);
		
		graficos.setColor(Color.MAGENTA);
		graficos.fillOval(coordenadas[5][0]+3, coordenadas[5][1], 10, 10);
		g.dispose();
	}
}
