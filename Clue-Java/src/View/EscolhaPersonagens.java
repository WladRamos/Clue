package View;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EscolhaPersonagens extends JPanel {
	private Image green;
	private Image mustard;
	private Image peacock;
	private Image plum;
	private Image scarlet;
	private Image white;
	
	public EscolhaPersonagens() {
		ImageIcon ref1 = new ImageIcon("res\\Suspeitos\\Green.jpg");
		green = ref1.getImage();
		
		ImageIcon ref2 = new ImageIcon("res\\Suspeitos\\Mustard.jpg");
		mustard = ref2.getImage();
		
		ImageIcon ref3 = new ImageIcon("res\\Suspeitos\\Peacock.jpg");
		peacock = ref3.getImage();
		
		ImageIcon ref4 = new ImageIcon("res\\Suspeitos\\Plum.jpg");
		plum = ref4.getImage();
		
		ImageIcon ref5 = new ImageIcon("res\\Suspeitos\\Scarlet.jpg");
		scarlet = ref5.getImage();
		
		ImageIcon ref6 = new ImageIcon("res\\Suspeitos\\White.jpg");
		white = ref6.getImage();
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		int width = green.getWidth(this);
	    int height = green.getHeight(this);

	    double scale = 1.5;
	    double w = width / scale;
	    double h = height / scale;
	    
		graficos.drawImage(green, 0, 0,(int) w, (int) h, null);
		graficos.drawImage(mustard, 195, 0,(int) w, (int) h, null);
		graficos.drawImage(peacock, 390, 0,(int) w, (int) h, null);
		graficos.drawImage(plum, 0, 310,(int) w, (int) h, null);
		graficos.drawImage(scarlet, 195, 310,(int) w, (int) h, null);
		graficos.drawImage(white, 390, 310,(int) w, (int) h, null);
		g.dispose();
	}
}