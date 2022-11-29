package View;

import Model.ObservadoIF;

public interface ObservadorIF {
	public void notify(ObservadoIF o);
}