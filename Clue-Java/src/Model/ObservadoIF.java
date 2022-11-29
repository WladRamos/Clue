package Model;

import View.ObservadorIF;

public interface ObservadoIF {
	public void add(ObservadorIF o);
	public void remove(ObservadorIF o);
	public int[] getDados();
	public int[][] getTabuleiro();
}
