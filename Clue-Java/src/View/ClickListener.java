package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickListener extends MouseAdapter {
	private static int x, y;
	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		System.out.println(x/25+", "+y/25);
	}
	
	public static int getClickedX() {
		return x;
	}
	
	public static int getClickedY() {
		return y;
	}

}
