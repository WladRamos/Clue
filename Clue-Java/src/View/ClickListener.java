package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickListener extends MouseAdapter {
	private static int x, y;
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + ", " + e.getY());
		System.out.println((e.getX() / 25) + ", " + (e.getY() / 25));
		
		x = e.getX();
		y = e.getY();
	}
	
	public static int getClickedX() {
		return x;
	}
	
	public static int getClickedY() {
		return y;
	}

}
