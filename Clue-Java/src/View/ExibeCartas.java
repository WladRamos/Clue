package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ExibeCartas extends JPanel{
	
	private Image[] carta;
	private String[] cartas;
	private int num;
	
	public ExibeCartas(String [] cartasDoJogador) {
		num = cartasDoJogador.length;
		cartas = cartasDoJogador;
		carta = new Image[num];
	}
	
	public void paint(Graphics g) {
	
		int j=0;
		for(int i=0;i<cartas.length;i++) {
			if(cartas[i] == "Corda") {
				ImageIcon ref = new ImageIcon("res\\Armas\\Corda.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Cano de Chumbo") {
				ImageIcon ref = new ImageIcon("res\\Armas\\Cano.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Faca") {
				ImageIcon ref = new ImageIcon("res\\Armas\\Faca.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Chave Inglesa") {
				ImageIcon ref = new ImageIcon("res\\Armas\\ChaveInglesa.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Castiçal") {
				ImageIcon ref = new ImageIcon("res\\Armas\\Castical.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Revólver") {
				ImageIcon ref = new ImageIcon("res\\Armas\\Revolver.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Coronel Mustard") {
				ImageIcon ref = new ImageIcon("res\\Suspeitos\\Mustard.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Srta. Scarlet") {
				ImageIcon ref = new ImageIcon("res\\Suspeitos\\Scarlet.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Professor Plum") {
				ImageIcon ref = new ImageIcon("res\\Suspeitos\\Plum.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Reverendo Green") {
				ImageIcon ref = new ImageIcon("res\\Suspeitos\\Green.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Sra. White") {
				ImageIcon ref = new ImageIcon("res\\Suspeitos\\White.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Sra. Peacock") {
				ImageIcon ref = new ImageIcon("res\\Suspeitos\\Peacock.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Entrada") {
				ImageIcon ref = new ImageIcon("res\\Comodos\\Entrada.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Sala de Estar") {
				ImageIcon ref = new ImageIcon("res\\Comodos\\SalaDeEstar.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Sala de Jantar") {
				ImageIcon ref = new ImageIcon("res\\Comodos\\SalaDeJantar.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Cozinha") {
				ImageIcon ref = new ImageIcon("res\\Comodos\\Cozinha.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Sala de Música") {
				ImageIcon ref = new ImageIcon("res\\Comodos\\SalaDeMusica.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Jardim de Inverno") {
				ImageIcon ref = new ImageIcon("res\\Comodos\\JardimInverno.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Salão de Jogos") {
				ImageIcon ref = new ImageIcon("res\\Comodos\\SalaoDeJogos.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Biblioteca") {
				ImageIcon ref = new ImageIcon("res\\Comodos\\Biblioteca.jpg");
				carta[j] = ref.getImage();
				j++;
			}else if(cartas[i] == "Escritório") {
				ImageIcon ref = new ImageIcon("res\\Comodos\\Escritorio.jpg");
				carta[j] = ref.getImage();
				j++;
			}
		}
		
		
		Graphics2D graficos = (Graphics2D) g;
		
		int width = carta[0].getWidth(this);
	    int height = carta[0].getHeight(this);

	    double scale = 1.5;
	    double w = width / scale;
	    double h = height / scale;
		int x = 200, y = 20,contador = 0;
		for(int i=0;i<num;i++) {
			graficos.drawImage(carta[i], x, y,(int) w, (int) h, null);
			x+=200;
			if(contador ==2) {
				y+=320; x=200;
			}contador++;
		}g.dispose();
	}
}


