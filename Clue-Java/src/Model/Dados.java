package Model;

import java.util.Random;

public class Dados {
	public int dado1;
	public int dado2;
	
	public int jogaDados() {
		Random r = new Random();
		dado1 = r.nextInt(6)+1;
		dado2 = r.nextInt(6)+1;
			
		return dado1 + dado2;
	}
}
