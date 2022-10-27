package View;

import Controller.*;
import Model.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Container extends JFrame implements ActionListener{
	Controller c = new Controller();
	int[] personagens = new int[6];
	String[] personagensSelecionados = new String[6];
	String[] opcoesPersonagens = {"Reverendo Green", "Coronel Mustard", "Sra. Peacock", "Professor Plum", "Srta. Scarlet", "Sra. White"};
	int contador=0, d1=0, d2=0;
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
	
	public void CriaTabuleiro(Jogador jogador, int a, int b, int x, int y) {
		
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
		

		JLabel label = new JLabel(jogador.personagem);
		label.setBounds(900, 430, 150, 30);
		tabuleiro.add(label);
		
		JLabel passos = new JLabel("passos:" + (a+b));
		passos.setBounds(900, 450, 100, 30);
		tabuleiro.add(passos);
				
		tabuleiro.add(new Tabuleiro(jogador, a, b, x, y, c));
		tabuleiro.getContentPane().addMouseListener(new ClickListener());
		tabuleiro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tabuleiro.setSize(1200,700);
		tabuleiro.setLocationRelativeTo(null);
		tabuleiro.setResizable(false);
		tabuleiro.setVisible(true);
		
		if(c.passagemSecreta(jogador.x, jogador.y)) passagemSecretaAtivacao = true;
		
		botoes[0].setEnabled(passagemSecretaAtivacao);
		botoes[1].setEnabled(proximoAtivacao);
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
		
		Color red = new Color(136, 8, 8);
		Color yellow = new Color(239,255,45);
		Color white = new Color(255,255,255);
		Color blue = new Color(39, 39, 255);
		Color green = new Color(17, 254, 13);
		Color purple = new Color(128, 0, 128);
		
		checkBoxes[0].setBackground(green);
		checkBoxes[1].setBackground(yellow);
		checkBoxes[2].setBackground(blue);
		checkBoxes[3].setBackground(purple);
		checkBoxes[4].setBackground(red);
		checkBoxes[5].setBackground(white);
		
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
	public void popUpCartas(Jogador jogador) {
		JFrame popUp = new JFrame("cartas");		
		
		
		popUp.add(new ExibeCartas(jogador));
		popUp.setSize(900,700);
		
		popUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		popUp.setLocationRelativeTo(null);
		popUp.setResizable(false);
		popUp.setVisible(true);
	}
	
	public void popUpBloco(Jogador jogador) {
		JFrame popUp = new JFrame("Bloco de notas");
			popUp.setSize(900,700);
			
			
			JCheckBox[] checkBoxes = {new JCheckBox("Rev.Green"), new JCheckBox("Col.Mustard"), new JCheckBox("Mrs.Peacock"), 
					new JCheckBox("Prof.Plum"), new JCheckBox("Miss Scarlet"), new JCheckBox("Mrs.White"),new JCheckBox("Sala de Jantar"),
					new JCheckBox("Entrada"), new JCheckBox("Salão de Jantar"), new JCheckBox("Cozinha"), new JCheckBox("Biblioteca"), 
					new JCheckBox("Sala de Estar"),new JCheckBox("Sala de Música"), new JCheckBox("Escritório"), new JCheckBox("Jardim de Invérno"), 
					new JCheckBox("Castiçal"),new JCheckBox("Revólver"),new JCheckBox("Faca"), new JCheckBox("Cano"),
					new JCheckBox("Corda"), new JCheckBox("Chave Inglesa")};
			
			int x = 100, y = 100, contador = 0;
			
			for(int i=0;i<checkBoxes.length;i++) {
				checkBoxes[i].setBounds(x,y,200,50);
				y+=40;
				contador++;
				if(contador == 5) {
					x+=275;
					y=100;
				}else if(contador ==14) {
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
			
			
			/*//funcao de marcar as checkboxes de acordo com vetor de string recebido
			String [] cartas;
			for(String carta: cartas) {
				if(carta == "Reverendo Green") Green.setSelected(true);
				
			}*/
			for(JCheckBox cb: checkBoxes) {
				
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
			System.out.println(index);
			c.Jogar(personagensSelecionados, index);
			c.setPrimeiroJogador();
			Jogador jogador = c.getJogadorDaVez(); 
			jogarDadosAtivacao = true;
			acusarAtivacao = true;
			Container inicio = new Container();
			inicio.CriaTabuleiro(jogador, d1, d2, 0, 0);
		}
		else if(e.getActionCommand().equals("Jogar Dados")) {
			Dados d = new Dados();
			d.jogaDados();
			d1 = d.dado1;
			d2 = d.dado2;
			System.out.println(d1+d2);
			Jogador jogador = c.getJogadorDaVez();
			jogarDadosAtivacao = false;
			acusarAtivacao = false;
			moverAtivacao = true;
			Container inicio = new Container();
			inicio.CriaTabuleiro(jogador, d1, d2, 0, 0);
		}
		else if(e.getActionCommand().equals("Mover")) {
			int x = ClickListener.getClickedX();
			int y = ClickListener.getClickedY();
			Jogador jogador = c.getJogadorDaVez();
			boolean movePiao = c.permissaoMover(jogador, x, y, d1+d2);
			
			if(movePiao) {
				moverAtivacao = false;
				proximoAtivacao = true;
				Container inicio = new Container();
				inicio.CriaTabuleiro(jogador, d1, d2, x, y);
			}
		}
		else if(e.getActionCommand().equals("Próximo")) {
			proximoAtivacao = false;
			jogarDadosAtivacao = true;
			acusarAtivacao = true;
			Jogador jogador = c.getProximoJogador();
			Container inicio = new Container();
			inicio.CriaTabuleiro(jogador, 0, 0, 0, 0);
		}
		else if(e.getActionCommand().equals("Mostrar Cartas")) {
			Container popUp = new Container();
			Jogador jogador = c.getJogadorDaVez();
			popUp.popUpCartas(jogador);
		}
		else if(e.getActionCommand().equals("Bloco de Notas")) {
			Container popUp = new Container();
			Jogador jogador = c.getJogadorDaVez();
			popUp.popUpBloco(jogador);
		}
		else if(e.getActionCommand().equals("Passagem Secreta")) {
			jogarDadosAtivacao = false;
			acusarAtivacao = false;
			Jogador jogador = c.getJogadorDaVez();
			int x = c.getDestinoPassagemSecretaX(jogador);
			int y = c.getDestinoPassagemSecretaY(jogador);
			Container inicio = new Container();
			inicio.CriaTabuleiro(jogador, 0, 0, x, y);
			passagemSecretaAtivacao = false;
		}
		
	}
	
	public static void main(String[]args) {
		/*Starts Game*/
		Container inicio = new Container();
		inicio.CriaInicio();
	}
	
}