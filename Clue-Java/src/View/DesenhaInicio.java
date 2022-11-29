package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class DesenhaInicio extends JPanel{
	private Image inicio;
	
	public DesenhaInicio() {
		ImageIcon ref = new ImageIcon("res\\Tabuleiros\\Clue1.jpg");
		inicio = ref.getImage();
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(inicio, 0, 0, null);
		g.dispose();
	}
}
