package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ClickListener extends MouseAdapter {
	private static int x, y;
	
	public static int getClickedX() {
		return x;
	}
	public static int getClickedY() {
		return y;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX(); y = e.getY();
		System.out.printf("{"+x/25+", "+y/25+"}"+"\n");
	}
}
