package View;

import Controller.Controller;
import Model.ModelAPI;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@SuppressWarnings("serial")
public class Container extends JFrame implements ActionListener{
	ModelAPI modelAPI = ModelAPI.getInstancia();
	Controller c = new Controller();
	int[] personagens = new int[6];
	String[] personagensSelecionados = new String[6];
	String[] opcoesPersonagens = {"Reverendo Green", "Coronel Mustard", "Sra. Peacock", "Professor Plum", "Srta. Scarlet", "Sra. White"};
	int contador=0;
	static int d1=0, d2=0;
	static boolean passagemSecretaAtivacao=false, proximoAtivacao=false, palpiteAtivacao=false, acusarAtivacao=false, jogarDadosAtivacao=false, moverAtivacao=false;

	public void CriaInicio() {
		JFrame inicio = new JFrame("Inicio");		
		JButton novo_jogo = new JButton("Novo Jogo");
		JButton continuar = new JButton("Continuar");
		
		novo_jogo.addActionListener(this);
		novo_jogo.addActionListener(e->inicio.dispose());
		novo_jogo.setBounds(260,320,200,40);
		continuar.setBounds(260,390,200,40);
		
		inicio.add(novo_jogo);
		inicio.add(continuar);
		
		inicio.add(new Inicio());
		inicio.setSize(900,700);
		
		inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicio.setLocationRelativeTo(null);
		inicio.setResizable(false);
		inicio.setVisible(true);
	}
	
	public void CriaTabuleiro(String piao, int a, int b, int x, int y) {
		JFrame tabuleiro = new JFrame("Tabuleiro");
		JButton[] botoes = {new JButton("Passagem Secreta"),new JButton("Próximo"),new JButton("Mostrar Cartas"),
				new JButton("Bloco de Notas"),new JButton("Palpite"),new JButton("Acusar"),
				new JButton("Salvar Jogo"),new JButton("Jogar Dados"),new JButton("Mover")};
		
		int dist = 30;
		for(int i=0;i<botoes.length;i++) {
			botoes[i].setBounds(850, dist, 200, 40);
			dist+=50;
			if(i==8) {
				botoes[i].setBounds(1065,530,80,40);
			}
		}
		for(int i=0;i<botoes.length;i++) {
			tabuleiro.add(botoes[i]);
		}
		
		Color[] color = {Color.WHITE, Color.GREEN, Color.BLUE, Color.YELLOW, Color.RED, Color.MAGENTA};
		//String[] cores = {"branco", "verde", "azul", "amarelo", "vermelho", "rosa"};
		String[] pioes = {"Sra. White", "Reverendo Green", "Sra. Peacock", "Coronel Mustard", "Srta. Scarlet", "Professor Plum"};
		
		int cor=0;
		for(String p: pioes) {
			if(p==piao) break;
			cor++;
		}
		JLabel label = new JLabel(piao); 
		JLabel background = new JLabel(""); 
		label.setOpaque(true);
		background.setOpaque(true);
		label.setBackground(color[cor]);
		background.setBackground(color[cor]);
		label.setBounds(900, 430, 150, 27);
		background.setBounds(850, 430, 50, 27);
		tabuleiro.add(label);
		tabuleiro.add(background);
		
		JLabel passos = new JLabel("passos:" + (a+b));
		passos.setBounds(900, 450, 100, 30);
		tabuleiro.add(passos);
				
		tabuleiro.add(new Tabuleiro(piao, a, b, x, y));
		tabuleiro.getContentPane().addMouseListener(new ClickListener());
		tabuleiro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tabuleiro.setSize(1200,700);
		tabuleiro.setLocationRelativeTo(null);
		tabuleiro.setResizable(false);
		tabuleiro.setVisible(true);
		
		if(modelAPI.passagemSecreta(c.getJogadorDaVezId())&&jogarDadosAtivacao) 
			passagemSecretaAtivacao = true;
		
		botoes[0].setEnabled(passagemSecretaAtivacao);
		botoes[1].setEnabled(proximoAtivacao);
		botoes[1].setEnabled(true);
		botoes[2].setEnabled(true);
		botoes[3].setEnabled(true);
		botoes[4].setEnabled(palpiteAtivacao);
		botoes[5].setEnabled(acusarAtivacao);
		botoes[6].setEnabled(false);
		botoes[7].setEnabled(jogarDadosAtivacao);
		botoes[8].setEnabled(moverAtivacao);
		
		botoes[0].addActionListener(this);
		botoes[0].addActionListener(e->tabuleiro.dispose());
		botoes[1].addActionListener(this);
		botoes[1].addActionListener(e->tabuleiro.dispose());
		
		botoes[2].addActionListener(this);
		botoes[3].addActionListener(this);
		
		//palpite e acusação na próxima interação 
		
		botoes[7].addActionListener(this);
		botoes[7].addActionListener(e->tabuleiro.dispose());
		botoes[8].addActionListener(this);
		botoes[8].addActionListener(e->tabuleiro.dispose());	
		
	}
	
	public void CriaEscolhaPersonagens() {
		JFrame tela = new JFrame("Escolha de Personagens");
		JCheckBox[] checkBoxes = {new JCheckBox("Green"),new JCheckBox("Mustard"),new JCheckBox("Peacock"),
				new JCheckBox("Plum"),new JCheckBox("Scarlet"),new JCheckBox("White"),};
		
		JButton jogar = new JButton("Jogar");
		jogar.addActionListener(this);
		jogar.addActionListener(e->tela.dispose());
		
		tela.setSize(900,700);
		
		checkBoxes[0].setBackground(Color.GREEN);
		checkBoxes[1].setBackground(Color.YELLOW);
		checkBoxes[2].setBackground(Color.BLUE);
		checkBoxes[3].setBackground(Color.MAGENTA);
		checkBoxes[4].setBackground(Color.RED);
		checkBoxes[5].setBackground(Color.WHITE);
		
		int dist = 140;
		
		for(int i=0;i<checkBoxes.length;i++) {
			checkBoxes[i].setBounds(630, dist, 200, 50);
			dist+=40;
		}
		jogar.setBounds(630,410,200,40);
		jogar.setEnabled(false);	
		
		for(int i=0; i<checkBoxes.length;i++) {
			tela.add(checkBoxes[i]);
		}
				
		checkBoxes[0].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				personagens[0]++;
				if(personagens[0] % 2 != 0) {
					contador++;
				}else contador--;
				if(contador>2) jogar.setEnabled(true);
				else jogar.setEnabled(false);
			}
		});
		checkBoxes[1].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				personagens[1]++;
				if(personagens[1] % 2 != 0) {
					contador++;
				}else contador--;
				if(contador>2) jogar.setEnabled(true);
				else jogar.setEnabled(false);
			}
		});
		checkBoxes[2].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				personagens[2]++;
				if(personagens[2] % 2 != 0) {
					contador++;
				}else contador--;
				if(contador>2) jogar.setEnabled(true);
				else jogar.setEnabled(false);
			}
		});
		checkBoxes[3].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				personagens[3]++;
				if(personagens[3] % 2 != 0) {
					contador++;
				}else contador--;
				if(contador>2) jogar.setEnabled(true);
				else jogar.setEnabled(false);
			}
		});
		checkBoxes[4].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				personagens[4]++;
				if(personagens[4] % 2 != 0) {
					contador++;
				}else contador--;
				if(contador>2) jogar.setEnabled(true);
				else jogar.setEnabled(false);
			}
		});
		checkBoxes[5].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				personagens[5]++;
				if(personagens[5] % 2 != 0) {
					contador++;
				}else contador--;
				if(contador>2) jogar.setEnabled(true);
				else jogar.setEnabled(false);
			}
		});
		
		tela.add(jogar);
		tela.add(new EscolhaPersonagens());
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setVisible(true);		
	}
	
	public void popUpCartas(String[] cartasDoJogador) {
		JFrame popUp = new JFrame("cartas");		
		
		popUp.add(new ExibeCartas(cartasDoJogador));
		popUp.setSize(900,700);
		popUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		popUp.setLocationRelativeTo(null);
		popUp.setResizable(false);
		popUp.setVisible(true);
	}
	
	public void popUpBlocoDeNotas(String [] cartasMarcadas) {
		JFrame popUp = new JFrame("Bloco de notas");
		popUp.setSize(900,700);
			
		JCheckBox[] checkBoxes = {new JCheckBox("Rev.Green"), new JCheckBox("Col.Mustard"), new JCheckBox("Mrs.Peacock"), 
					new JCheckBox("Prof.Plum"), new JCheckBox("Miss Scarlet"), new JCheckBox("Mrs.White"),new JCheckBox("Sala de Jantar"),
					new JCheckBox("Entrada"), new JCheckBox("Sala de Jantar"), new JCheckBox("Cozinha"), new JCheckBox("Biblioteca"), 
					new JCheckBox("Sala de Estar"),new JCheckBox("Sala de Música"), new JCheckBox("Escritório"), new JCheckBox("Jardim de Inverno"), 
					new JCheckBox("Castiçal"),new JCheckBox("Revólver"),new JCheckBox("Faca"), new JCheckBox("Cano"),
					new JCheckBox("Corda"), new JCheckBox("Chave Inglesa")};
		String[] opcoes = {"Reverendo Green", "Coronel Mustard", "Sra. Peacock", "Professor Plum", "Srta. Scarlet", "Sra. White", "Sala de Jantar",
					"Entrada", "Sala de Jantar", "Cozinha", "Biblioteca", "Sala de Estar", "Sala de Música", "Escritório", "Jardim de Inverno", "Castiçal", 
					"Revólver", "Faca", "Cano", "Corda", "Chave Inglesa"};
			
		int x = 100, y = 100, contador = 0;
			
		for(int i=0;i<checkBoxes.length;i++) {
			checkBoxes[i].setBounds(x,y,200,50);
			y+=40;
			contador++;
			if(contador == 6) {
				x+=275;
				y=100;
			}else if(contador ==15) {
				x+=275;
				y=100;
			}
		}
			
		JLabel suspeitos = new JLabel("Suspeitos");
		JLabel comodos = new JLabel("Cômodos");
		JLabel armas = new JLabel("Armas");
		
		suspeitos.setBounds(100, 60, 150, 30);
		comodos.setBounds(375, 60, 150, 30);
		armas.setBounds(650, 60, 150, 30);
			
		popUp.setLayout(null);
		popUp.add(suspeitos);
		popUp.add(comodos);
		popUp.add(armas);
			
		for(int i=0;i<checkBoxes.length;i++) {
			popUp.add(checkBoxes[i]);
		}
			
		for(JCheckBox cb: checkBoxes) cb.setSelected(false);
				
		int i=0;
		for(JCheckBox cb: checkBoxes) {
			for(String carta: cartasMarcadas) {
				if(opcoes[i]==carta) {
					cb.setSelected(true);
					break;
				}
			}i++;
		}
			
		popUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		popUp.setLocationRelativeTo(null);
		popUp.setResizable(false);
		popUp.setVisible(true);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Novo Jogo")) {
			Container inicio = new Container();
			inicio.CriaEscolhaPersonagens();
		}
		else if(e.getActionCommand().equals("Jogar")) {
			int index = 0;
			int index2 = 0;
			for(int p:personagens) {
				if(p%2 != 0) {
					personagensSelecionados[index] = opcoesPersonagens[index2];
					index++;
				}index2++;
			}
			
			c.Jogar(personagensSelecionados, index);
			c.setPrimeiroJogador();
			String jogador = c.getJogadorDaVez(); 
			jogarDadosAtivacao = true;
			acusarAtivacao = true;
			proximoAtivacao = false;
			Container inicio = new Container();
			inicio.CriaTabuleiro(jogador, d1, d2, 0, 0);	
		}
		else if(e.getActionCommand().equals("Jogar Dados")) {
			int[] dados = ModelAPI.getDados();
			d1 = dados[0]; d2 = dados[1];
			System.out.println("dados do botao: "+(d1+d2));
			String jogador = c.getJogadorDaVez();
			jogarDadosAtivacao = false;
			acusarAtivacao = false;
			moverAtivacao = true;
			Container inicio = new Container();
			inicio.CriaTabuleiro(jogador, d1, d2, 0, 0);
		}
		else if(e.getActionCommand().equals("Mover")) {
			int x = ClickListener.getClickedX();
			int y = ClickListener.getClickedY();
			String jogador = c.getJogadorDaVez();
			int jogadorId = c.getJogadorDaVezId();
			System.out.println("jogador id: "+jogadorId);
			System.out.println("destino: "+x/25+", "+y/25);
			System.out.println("dados: "+(d1+d2));
			boolean moveu = modelAPI.movePiao(jogadorId, x, y, d1+d2);
			if(moveu) {
				moverAtivacao = false;
				proximoAtivacao = true;
				Container inicio = new Container();
				inicio.CriaTabuleiro(jogador, d1, d2, x, y);
			}else {
				Container inicio = new Container();
				inicio.CriaTabuleiro(jogador, d1, d2, 0, 0);
			}
		}
		else if(e.getActionCommand().equals("Próximo")) {
			proximoAtivacao = false;
			jogarDadosAtivacao = true;
			acusarAtivacao = true;
			if(c.proximoJogador()==false) System.out.print("game over");
			String jogador = c.getJogadorDaVez();
			Container inicio = new Container();
			inicio.CriaTabuleiro(jogador, 0, 0, 0, 0);
		}
		else if(e.getActionCommand().equals("Mostrar Cartas")) {
			Container popUp = new Container();
			int jogadorId = c.getJogadorDaVezId();
			String[] cartasDoJogador = modelAPI.getCartasJogador(jogadorId);
			popUp.popUpCartas(cartasDoJogador);
		}
		else if(e.getActionCommand().equals("Bloco de Notas")) {
			Container popUp = new Container();
			int jogadorId = c.getJogadorDaVezId();
			String[] cartasMarcadas = modelAPI.getBlocoDeNotasJogador(jogadorId);
			popUp.popUpBlocoDeNotas(cartasMarcadas);
		}
		else if(e.getActionCommand().equals("Passagem Secreta")) {
			jogarDadosAtivacao = false;
			acusarAtivacao = false;
			passagemSecretaAtivacao = false;
			int jogadorId = c.getJogadorDaVezId();
			String jogador = c.getJogadorDaVez();
			int[] coord = modelAPI.getDestinoPassagemSecreta(jogadorId);
			Container inicio = new Container();
			inicio.CriaTabuleiro(jogador, 0, 0, coord[0], coord[1]);
		}else if(e.getActionCommand().equals("Acusar")) {
			//TODO
		}else if(e.getActionCommand().equals("Palpite")) {
			//TODO
		}else if(e.getActionCommand().equals("Salvar Jogo")) {
			//TODO
		}
		
	}
	
	public static void main(String[]args) {
		/*Starts Game*/
		Container inicio = new Container();
		inicio.CriaInicio();
	}
	
}