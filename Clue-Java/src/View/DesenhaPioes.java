package View;

import javax.swing.*;
import java.awt.*;

public class DesenhaPioes extends JFrame {
	int x, y; 
	Color cor;
	
	public void movePiao(int x, int y, Color cor) {
		this.x = x;
		this.y = y;
		this.cor = cor;
	}
	
	
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(cor);
        g2d.drawOval(x, y, 100, 100);
    }

}
