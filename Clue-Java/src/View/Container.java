package View;

import Controller.Controller;
import Model.ModelAPI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;

@SuppressWarnings("serial")
class Container extends JFrame implements ActionListener{	
	
	ModelAPI modelAPI = ModelAPI.getInstancia();
	Controller ctrl = Controller.getInstancia();
	
	private static JFrame tabuleiroAtual;
	private static boolean passagemSecretaAtivacao=false, proximoAtivacao=false, palpiteAtivacao=false;
	private static boolean acusarAtivacao=false, jogarDadosAtivacao=false, moverAtivacao=false, salvarJogoAtivacao = true;
	private static boolean jaUseiPassagemSecreta=false, jaPalpitei=false, escolheDado=false;
	private static int contadorSelecaoPersonagens=0, contadorAcusacao=0, contadorPalpite=0;
	private static int d1=1, d2=1;
	
	private int[] personagens = new int[6];
	private String[] personagensSelecionados = new String[6];
	private String[] opcoesPersonagens = {"Reverendo Green", "Coronel Mustard", "Sra. Peacock", "Professor Plum", "Srta. Scarlet", "Sra. White"};
	private String []palpiteConfirmado = new String[3], acusacaoConfirmada = new String[3];
	
	/*criação das telas do jogo*/
	public void CriaInicio() {
		JFrame inicio = new JFrame("Inicio");		
		JButton novo_jogo = new JButton("Novo Jogo");
		JButton continuar = new JButton("Continuar");
		
		novo_jogo.addActionListener(this);
		novo_jogo.addActionListener(e->inicio.dispose());
		novo_jogo.setBounds(260,320,200,40);
		
		continuar.addActionListener(this);
		continuar.addActionListener(e->inicio.dispose());
		continuar.setBounds(260,390,200,40);
				
		inicio.add(novo_jogo);
		inicio.add(continuar);
		
		inicio.add(new DesenhaInicio());
		inicio.setSize(900,700);
		
		inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicio.setLocationRelativeTo(null);
		inicio.setResizable(false);
		inicio.setVisible(true);
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
					contadorSelecaoPersonagens++;
				}else contadorSelecaoPersonagens--;
				if(contadorSelecaoPersonagens>2) jogar.setEnabled(true);
				else jogar.setEnabled(false);
			}
		});
		checkBoxes[1].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				personagens[1]++;
				if(personagens[1] % 2 != 0) {
					contadorSelecaoPersonagens++;
				}else contadorSelecaoPersonagens--;
				if(contadorSelecaoPersonagens>2) jogar.setEnabled(true);
				else jogar.setEnabled(false);
			}
		});
		checkBoxes[2].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				personagens[2]++;
				if(personagens[2] % 2 != 0) {
					contadorSelecaoPersonagens++;
				}else contadorSelecaoPersonagens--;
				if(contadorSelecaoPersonagens>2) jogar.setEnabled(true);
				else jogar.setEnabled(false);
			}
		});
		checkBoxes[3].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				personagens[3]++;
				if(personagens[3] % 2 != 0) {
					contadorSelecaoPersonagens++;
				}else contadorSelecaoPersonagens--;
				if(contadorSelecaoPersonagens>2) jogar.setEnabled(true);
				else jogar.setEnabled(false);
			}
		});
		checkBoxes[4].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				personagens[4]++;
				if(personagens[4] % 2 != 0) {
					contadorSelecaoPersonagens++;
				}else contadorSelecaoPersonagens--;
				if(contadorSelecaoPersonagens>2) jogar.setEnabled(true);
				else jogar.setEnabled(false);
			}
		});
		checkBoxes[5].addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				personagens[5]++;
				if(personagens[5] % 2 != 0) {
					contadorSelecaoPersonagens++;
				}else contadorSelecaoPersonagens--;
				if(contadorSelecaoPersonagens>2) jogar.setEnabled(true);
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
	
	public void CriaTabuleiro(String piao) {
		JFrame tabuleiro = new JFrame("Tabuleiro");
		JButton[] botoes = {new JButton("Passagem Secreta"),new JButton("Próximo"),new JButton("Mostrar Cartas"),
				new JButton("Bloco de Notas"),new JButton("Palpite"),new JButton("Acusar"),
				new JButton("Salvar Jogo"),new JButton("Jogar Dados"),new JButton("Mover")};
		
		int dist = 30;
		for(int i=0;i<botoes.length;i++) {
			botoes[i].setBounds(850, dist, 200, 40);
			dist+=50;
			if(i==8) botoes[i].setBounds(1065,530,80,40);
		}
		for(int i=0;i<botoes.length;i++) {
			tabuleiro.add(botoes[i]);
		}
		
		Color[] color = {Color.WHITE, Color.GREEN, Color.BLUE, Color.YELLOW, Color.RED, Color.MAGENTA};
		String[] pioes = {"Sra. White", "Reverendo Green", "Sra. Peacock", "Coronel Mustard", "Srta. Scarlet", "Professor Plum"};
		
		int cor=0;
		for(String p: pioes) {
			if(p.equals(piao)) break;
			cor++;
		}
		JLabel label = new JLabel(piao); 
		JLabel background = new JLabel("");
		
		label.setOpaque(true);
		label.setBackground(color[cor]);
		label.setBounds(900, 430, 150, 27);
		background.setOpaque(true);
		background.setBackground(color[cor]);
		background.setBounds(850, 430, 50, 27);
		
		tabuleiro.add(label);
		tabuleiro.add(background);
		
		/*requisitando ao observado que notifique os observadores das atualizações*/
		modelAPI.atualizaObservadores();
		
		/*Dados definíveis ************************************* */
		Integer[] range = {1,2,3,4,5,6};
		JComboBox <Integer> dado1 = new JComboBox<>(range);
		JComboBox <Integer> dado2 = new JComboBox<>(range);
		dado1.setBounds(720, 500, 50, 30);
		dado2.setBounds(780, 500, 50, 30);
		tabuleiro.add(dado1);
		tabuleiro.add(dado2);
		
		d1=1; d2=1;
		dado1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				d1 = (int) dado1.getSelectedItem();
			}
		});
		dado2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				d2 = (int) dado2.getSelectedItem();
			}
		});
		JButton escolher = new JButton("Escolher");
		escolher.setBounds(720, 550, 110, 30);
		tabuleiro.add(escolher);
		escolher.setEnabled(escolheDado);
		escolher.addActionListener(this);
		escolher.addActionListener(e->tabuleiro.dispose());
		/* ****************************************************** */

		JLabel passos = new JLabel("passos:" + (DesenhaTabuleiro.d1 + DesenhaTabuleiro.d2));
		passos.setBounds(900, 450, 100, 30);
		tabuleiro.add(passos);
	
		tabuleiro.add(new DesenhaTabuleiro());		
		tabuleiro.getContentPane().addMouseListener(new ClickListener());
		tabuleiro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tabuleiro.setSize(1200,700);
		tabuleiro.setLocationRelativeTo(null);
		tabuleiro.setResizable(false);
		tabuleiro.setVisible(true);
		
		/*botões da tela do jogo*/
		//Passagem Secreta
		passagemSecretaAtivacao = false;
		if(modelAPI.passagemSecreta(ctrl.getJogadorDaVezId())&&jogarDadosAtivacao&&(!jaUseiPassagemSecreta)) 
			passagemSecretaAtivacao = true;
		botoes[0].setEnabled(passagemSecretaAtivacao);
		botoes[0].addActionListener(this);
		botoes[0].addActionListener(e->tabuleiro.dispose());
		
		//Próximo
		proximoAtivacao = false;
		if(!(jogarDadosAtivacao && escolheDado && !jaUseiPassagemSecreta) || jaPalpitei)
			proximoAtivacao = true;
		botoes[1].setEnabled(proximoAtivacao);
		botoes[1].addActionListener(this);
		botoes[1].addActionListener(e->tabuleiro.dispose());
		
		//Mostrar Cartas
		botoes[2].setEnabled(true);
		botoes[2].addActionListener(this);
		
		//Bloco de Notas
		botoes[3].setEnabled(true);
		botoes[3].addActionListener(this);
		
		//Palpite
		palpiteAtivacao = false;
		String area = modelAPI.getAreaDoTabuleiro(ctrl.getJogadorDaVezId());
		if (area != "Casas Comuns" && area != "àrea inválida" && area != "Detetive" && (!jaPalpitei)) {
			String ultimoComodo = modelAPI.getUltimoComodo(ctrl.getJogadorDaVezId());
			if(area!=ultimoComodo)
				palpiteAtivacao = true;
		}
		botoes[4].setEnabled(palpiteAtivacao);
		botoes[4].addActionListener(this);
		
		//Acusar
		botoes[5].setEnabled(acusarAtivacao);
		botoes[5].addActionListener(this);
		
		//Salvar Jogo
		salvarJogoAtivacao = false;
		if(jogarDadosAtivacao && escolheDado && !jaUseiPassagemSecreta)
			salvarJogoAtivacao = true;
		botoes[6].setEnabled(salvarJogoAtivacao);
		botoes[6].addActionListener(this);
		
		//Jogar Dados
		botoes[7].setEnabled(jogarDadosAtivacao);
		botoes[7].addActionListener(this);
		botoes[7].addActionListener(e->tabuleiro.dispose());
		
		//Mover
		botoes[8].setEnabled(moverAtivacao);
		botoes[8].addActionListener(this);
		botoes[8].addActionListener(e->tabuleiro.dispose());
		
		tabuleiroAtual = tabuleiro;
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
		popUp.setSize(900,600);
			
		JCheckBox[] checkBoxes = {new JCheckBox("Rev.Green"), new JCheckBox("Col.Mustard"), new JCheckBox("Mrs.Peacock"), 
					new JCheckBox("Prof.Plum"), new JCheckBox("Miss Scarlet"), new JCheckBox("Mrs.White"),new JCheckBox("Sala de Jantar"),
					new JCheckBox("Entrada"), new JCheckBox("Salão de Jogos"), new JCheckBox("Cozinha"), new JCheckBox("Biblioteca"), 
					new JCheckBox("Sala de Estar"),new JCheckBox("Sala de Música"), new JCheckBox("Escritório"), new JCheckBox("Jardim de Inverno"), 
					new JCheckBox("Castiçal"),new JCheckBox("Revólver"),new JCheckBox("Faca"), new JCheckBox("Cano de Chumbo"),
					new JCheckBox("Corda"), new JCheckBox("Chave Inglesa")};
		String[] opcoes = {"Reverendo Green", "Coronel Mustard", "Sra. Peacock", "Professor Plum", "Srta. Scarlet", "Sra. White", "Sala de Jantar",
					"Entrada", "Salão de Jogos", "Cozinha", "Biblioteca", "Sala de Estar", "Sala de Música", "Escritório", "Jardim de Inverno", "Castiçal", 
					"Revólver", "Faca", "Cano de Chumbo", "Corda", "Chave Inglesa"};
			
		int x = 100, y = 100, contador = 0;
		for(int i=0;i<checkBoxes.length;i++) {
			checkBoxes[i].setBounds(x,y,200,50);
			y+=40; contador++;
			if(contador == 6) {
				x+=275; y=100;
			}else if(contador ==15) {
				x+=275; y=100;
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
				if(opcoes[i].equals(carta)) {
					cb.setSelected(true); break;
				}
			}i++;
		}
			
		popUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		popUp.setLocationRelativeTo(null);
		popUp.setResizable(false);
		popUp.setVisible(true);	
	}
	
	public void popUpAcusacao() {
		JFrame popUp = new JFrame("Acusação");
		popUp.setSize(700,500);
				
		String[] opcoesSuspeitos = {"Escolha um Suspeito","Reverendo Green", "Coronel Mustard", "Sra. Peacock", "Professor Plum", "Srta. Scarlet", "Sra. White"};
		String[] opcoesComodos = {"Escolha um Cômodo","Sala de Jantar","Entrada", "Salão de Jogos", "Cozinha", "Biblioteca", "Sala de Estar", "Sala de Música", "Escritório", "Jardim de Inverno"};
		String[] opcoesArmas = {"Escolha uma Arma","Castiçal", "Revólver", "Faca", "Cano de Chumbo", "Corda", "Chave Inglesa"};
		
		JComboBox <String> suspeitos = new JComboBox<>(opcoesSuspeitos);
		JComboBox <String> comodos = new JComboBox<>(opcoesComodos);
		JComboBox <String> armas = new JComboBox<>(opcoesArmas);
		
		suspeitos.setBounds(75, 200, 150, 30);
		comodos.setBounds(267, 200, 150, 30);
		armas.setBounds(457, 200, 150, 30);
		
		JButton acusar = new JButton("Confirmar Acusação");
		acusar.setBounds(265, 300, 155, 40);
		acusar.setEnabled(false);
		
		popUp.setLayout(null);
		popUp.add(suspeitos);
		popUp.add(comodos);
		popUp.add(armas);
		popUp.add(acusar);
		
		popUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		popUp.setLocationRelativeTo(null);
		popUp.setResizable(false);
		popUp.setVisible(true);
		
		contadorAcusacao = 0;
		suspeitos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				acusacaoConfirmada[1] = (String) suspeitos.getSelectedItem();
				if(acusacaoConfirmada[1]!="Escolha um Suspeito") contadorAcusacao++;
				else contadorAcusacao--;
				if(contadorAcusacao>4) acusar.setEnabled(true);
				else acusar.setEnabled(false);
			}
		});
		armas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				acusacaoConfirmada[0] = (String) armas.getSelectedItem();
				if(acusacaoConfirmada[0]!="Escolha uma Arma") contadorAcusacao++;
				else contadorAcusacao--;
				if(contadorAcusacao>4) acusar.setEnabled(true);
				else acusar.setEnabled(false);
			}
		});comodos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				acusacaoConfirmada[2] = (String) comodos.getSelectedItem();
				if(acusacaoConfirmada[2]!="Escolha um Cômodo") contadorAcusacao++;
				else contadorAcusacao--;
				if(contadorAcusacao>4) acusar.setEnabled(true);
				else acusar.setEnabled(false);
			}
		});
		acusar.addActionListener(this);
		acusar.addActionListener(e->popUp.dispose());			
	}

	public void popUpPalpite(String comodoEsta) {
		JFrame popUp = new JFrame("Palpite");
		popUp.setSize(700,500);
		
		String [] susp = {"Escolha um Suspeito","Reverendo Green", "Coronel Mustard", "Sra. Peacock", "Professor Plum", "Srta. Scarlet", "Sra. White"};		
		String [] armas = {"Escolha uma Arma","Castiçal", "Revólver", "Faca", "Cano de Chumbo", "Corda", "Chave Inglesa"};
		String comodo = modelAPI.getAreaDoTabuleiro(ctrl.getJogadorDaVezId());
		String[] comodos = {comodo};
		
		JComboBox<String> susplist = new JComboBox<>(susp);
		JComboBox<String> comodoslist = new JComboBox<>(comodos);
		JComboBox<String> armaslist = new JComboBox<>(armas);
		
		susplist.setSelectedIndex(0);
		susplist.setBounds(75, 200, 150, 30);
		armaslist.setSelectedIndex(0);
		armaslist.setBounds(457, 200, 150, 30);
		comodoslist.setSelectedIndex(0);
		comodoslist.setBounds(267, 200, 150, 30);
		
		JButton botao = new JButton("Palpitar");
		botao.setBounds(265, 300, 155, 40);
		botao.setEnabled(false);
		botao.addActionListener(this);
		botao.addActionListener(e->popUp.dispose());
		
		popUp.setLayout(null);
		popUp.add(botao);		
		popUp.add(susplist);
		popUp.add(armaslist);
		popUp.add(comodoslist);
		
		contadorPalpite = 0;
		susplist.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				palpiteConfirmado[1] = (String) susplist.getSelectedItem();
				if(palpiteConfirmado[1]!="Escolha um Suspeito") contadorPalpite++;
				else contadorPalpite--;
				if(contadorPalpite>2) botao.setEnabled(true);
				else botao.setEnabled(false);
			}
		});
		armaslist.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				palpiteConfirmado[0] = (String) armaslist.getSelectedItem();
				if(palpiteConfirmado[0]!="Escolha uma Arma") contadorPalpite++;
				else contadorPalpite--;
				if(contadorPalpite>2) botao.setEnabled(true);
				else botao.setEnabled(false);
			}
		});
		
		palpiteConfirmado[2] = comodoEsta;
		popUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		popUp.setLocationRelativeTo(null);
		popUp.setResizable(false);
		popUp.setVisible(true);
	}
	
	public void popUpBloqueado(String jogador) {
		JOptionPane.showMessageDialog(null, jogador, "Errou a acusação e não pode mais jogar!", 0);
		proximoAtivacao = true;
		jogarDadosAtivacao = false;
		acusarAtivacao = false;
		palpiteAtivacao = false;
		moverAtivacao = false;
		escolheDado=false;
		jaPalpitei=true;
		modelAPI.movePiaoAcusacao(ctrl.getJogadorDaVezId());
		tabuleiroAtual.dispose();
		CriaTabuleiro(jogador);
	}
	
	public void popUpPalpiteAviso(boolean correto, int[] posCartaErrada, String[] palpiteConfirmado) {
		if (correto)
			JOptionPane.showMessageDialog(null,"Palpite correto");
		else {
			for (int i=0; i<posCartaErrada.length; i++)
				if (posCartaErrada[i]==1)
					JOptionPane.showMessageDialog(null, palpiteConfirmado[i], "Carta Errada", 0);
		}
	}
	
	public void popUpVencedor(String jogador) {
		Integer resp = JOptionPane.showConfirmDialog(null,jogador + " venceu o jogo! Desejam jogar uma nova partida?","PARABÉNS ! ", JOptionPane.YES_NO_OPTION);
		if(resp == JOptionPane.YES_OPTION) {
			Controller ctrl = Controller.getInstancia();
			modelAPI.reiniciaCartas();
			modelAPI.reiniciaTabuleiro();
			ctrl.reiniciaJogada();
			Container inicio = new Container();
			inicio.CriaEscolhaPersonagens();
		}else {
			System.exit(0);
		}
	}
	
	public void popUpGameOver() {
		Integer resp = JOptionPane.showConfirmDialog(null, "Todos os jogadores foram bloqueados! Desejam jogar uma nova partida?"
				,"GAME OVER !", JOptionPane.YES_NO_OPTION);
		if(resp == JOptionPane.YES_OPTION) {
			Controller ctrl = Controller.getInstancia();
			modelAPI.reiniciaCartas();
			modelAPI.reiniciaTabuleiro();
			ctrl.reiniciaJogada();
			Container inicio = new Container();
			inicio.CriaEscolhaPersonagens();
		}else {
			System.exit(0);
		}
	}
	
	/*funções auxiliares para o salvamento do jogo*/
	public boolean ehJogador(String piao, String[]jogadores) {
		boolean in = false;
		for (int i=0; i<jogadores.length; i++)
			if (piao.equals(jogadores[i]))
				in = true;
		return in;
	}
		
	public String[] colocaCartasJogador(String cartasJog, int tam) {
		String [] cartas = new String[tam];
		int pos=0;
		int virgula=0;
		
		while(virgula != -1) {
			virgula = cartasJog.indexOf(',');
			if (virgula == -1)
				cartas[pos] = cartasJog;
			else
				cartas[pos] = cartasJog.substring(0,virgula);
			cartasJog = cartasJog.substring(virgula+1);
			pos++;
		}return cartas;
	}
		
	public String[][] colocaBlocoNotasJogador(String blocoJog, int tam) {
		String [][] bloco = new String[tam][2];
		int pos=0;
		int virgula=0;
		
		while(virgula != -1) {
			virgula = blocoJog.indexOf(',');
			if (virgula == -1) {
				bloco[pos][0] = blocoJog;
				bloco[pos][1] = "1";
			}
			else {
				bloco[pos][0] = blocoJog.substring(0,virgula);
				bloco[pos][1] = "1";
			}
			blocoJog = blocoJog.substring(virgula+1);
			pos++;
		}return bloco;
	}
	
	/*tratamento dos botões da tela tabuleiro do jogo*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Escolher")) {
			modelAPI.setDados(d1, d2);
			String jogador = ctrl.getJogadorDaVez();
			jogarDadosAtivacao = false; acusarAtivacao = false; moverAtivacao = true;
			escolheDado = false;
			CriaTabuleiro(jogador);
		}
		else if(e.getActionCommand().equals("Novo Jogo")) {
			CriaEscolhaPersonagens();
		}
		else if(e.getActionCommand().equals("Continuar")) {			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Escolha o arquivo salvo");
			int retorno = fileChooser.showOpenDialog(this);
			
			if(retorno == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				
				String s = file.getPath();
				BufferedReader arq = Arquivo.lerArquivo(s);
				
				String nomeTempPersonagem,ultimoComodoTempJog;
				int xTempPersonagem,yTempPersonagem,tamBlocoTemp,tamCartasTemp;
				String blockTempJog;
				String [][]blocoNotasTempJog;
				String []cartasTempJog;
				
				String linha;
				int i, pos;
				int jogVezId, qtdJogadores, qtdBots;
				
				String []envelope = new String[3];
				String []jogadores = null;
				String []ultimoComodoJogadores = null;
				int [][]xyJogadores = null;
				String cartasJogadores[][] = null;
				String blocoNotasJogadores[][][] = null;
				boolean blockJogadores[] = null;
				String []bots = null;
				int [][]xyBots = null;
						
				try {
						linha = arq.readLine();
						jogVezId = Integer.parseInt(linha);
						linha = arq.readLine();
						qtdJogadores = Integer.parseInt(linha);
						linha = arq.readLine();
						qtdBots = Integer.parseInt(linha);
						linha = arq.readLine();
						envelope[0] = linha.split(",")[0];
						envelope[1] = linha.split(",")[1];
						envelope[2] = linha.split(",")[2];
						
						jogadores = new String[qtdJogadores];
						xyJogadores = new int[qtdJogadores][2];
						cartasJogadores = new String[qtdJogadores][2];
						blocoNotasJogadores = new String[qtdJogadores][2][2];
						blockJogadores = new boolean[qtdJogadores];
						ultimoComodoJogadores = new String[qtdJogadores];
						bots = new String[qtdBots];
						xyBots = new int[qtdBots][2];
						
						linha = arq.readLine();
						while(linha != null) {
							if (linha.equals("Jogadores:")) {
								pos=0;
								for (i=0; i<qtdJogadores; i++) {
									linha = arq.readLine(); 	// Jogador x
									linha = arq.readLine(); 	// Personagem, x, y, block
									
									nomeTempPersonagem = linha.split(",")[0].toString();
									xTempPersonagem = Integer.parseInt(linha.split(",")[1]);
									yTempPersonagem = Integer.parseInt(linha.split(",")[2]);
									blockTempJog = linha.split(",")[3];
									ultimoComodoTempJog = linha.split(",")[4];
								 				
									// Leitura Bloco de notas
									linha = arq.readLine(); // Tamanho bloco de notas
									tamBlocoTemp = Integer.parseInt(linha);
									linha = arq.readLine(); // Bloco de Notas
									blocoNotasTempJog = colocaBlocoNotasJogador(linha,tamBlocoTemp);
									
									// Leitura Cartas
									linha = arq.readLine(); // Tamanho cartas
									tamCartasTemp = Integer.parseInt(linha);
									linha = arq.readLine(); // Cartas
									cartasTempJog = colocaCartasJogador(linha,tamCartasTemp);
									
									jogadores[pos] = nomeTempPersonagem;
									xyJogadores[pos][0] = xTempPersonagem;
									xyJogadores[pos][1] = yTempPersonagem;
																	
									blocoNotasJogadores[pos] = new String[tamBlocoTemp][2];
									blocoNotasJogadores[pos] = blocoNotasTempJog;
									
									cartasJogadores[pos] = new String[tamCartasTemp];
									cartasJogadores[pos] = cartasTempJog;
									if(blockTempJog.equals("true"))
										blockJogadores[pos] = true;
									else blockJogadores[pos] = false;
									ultimoComodoJogadores[pos] = ultimoComodoTempJog;
									pos++;
								}
							}else {
								pos = 0;
								for (i = 0; i < qtdBots;i++) {
									linha = arq.readLine(); 	// Bot x
									linha = arq.readLine(); 	// Personagem, x, y
									
									nomeTempPersonagem = linha.split(",")[0].toString();
									xTempPersonagem = Integer.parseInt(linha.split(",")[1]);
									yTempPersonagem = Integer.parseInt(linha.split(",")[2]);
									
									bots[pos] = nomeTempPersonagem;
									xyBots[pos][0] = xTempPersonagem;
									xyBots[pos][1] = yTempPersonagem;
									pos++;
								}
						}
						linha = arq.readLine();
					}
					arq.close();
					
					/*reiniciando jogo*/
					modelAPI.setCartas(envelope);
					modelAPI.zeraDados();
					ctrl.setJogadores(jogadores, jogVezId);
					modelAPI.setTabuleiro(xyJogadores, jogadores, xyBots, bots);
					modelAPI.setJogadores(qtdJogadores, jogadores, ultimoComodoJogadores, xyJogadores, cartasJogadores, blocoNotasJogadores, blockJogadores);
					
					String jogador = ctrl.getJogadorDaVez();
					jogarDadosAtivacao = true; acusarAtivacao = true; proximoAtivacao = false;
					escolheDado=true;
					
					JOptionPane.showMessageDialog(null, "Jogo carregado com sucesso","Aviso", 1);
					CriaTabuleiro(jogador);
				}
				catch(Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, "Erro ao ler arquivo","Aviso", 0);
					CriaInicio();
				}
			}
		}
		else if(e.getActionCommand().equals("Jogar")) {
			int index=0, index2=0;
			for(int p: personagens) {
				if(p%2 != 0) {
					personagensSelecionados[index] = opcoesPersonagens[index2]; index++;
				}index2++;
			}
			ctrl.Jogar(personagensSelecionados, index);
			ctrl.setPrimeiroJogador();
			String jogador = ctrl.getJogadorDaVez(); 
			jogarDadosAtivacao = true; acusarAtivacao = true; proximoAtivacao = false;
			escolheDado=true;
			CriaTabuleiro(jogador);
		}
		else if(e.getActionCommand().equals("Jogar Dados")) {
			modelAPI.jogaDados();
			String jogador = ctrl.getJogadorDaVez();
			jogarDadosAtivacao = false; acusarAtivacao = false; moverAtivacao = true;
			escolheDado=false;
			CriaTabuleiro(jogador);
		}
		else if(e.getActionCommand().equals("Mover")) {
			int x = ClickListener.getClickedX(), y = ClickListener.getClickedY();
			String jogador = ctrl.getJogadorDaVez();
			int jogadorId = ctrl.getJogadorDaVezId();
			boolean moveu = modelAPI.movePiao(jogadorId, jogador, x, y);
			if(moveu) {
				moverAtivacao = false;
				proximoAtivacao = true;
			}
			CriaTabuleiro(jogador);
		}
		else if(e.getActionCommand().equals("Próximo")) {
			String area = modelAPI.getAreaDoTabuleiro(ctrl.getJogadorDaVezId());
			if (area != "Casas Comuns" && area != "àrea inválida")
				modelAPI.setUltimoComodo(ctrl.getJogadorDaVezId(), area);
			
			modelAPI.zeraDados();
			proximoAtivacao = false; jogarDadosAtivacao = true;
			acusarAtivacao = true; jaUseiPassagemSecreta = false;
			jaPalpitei = false; escolheDado = true;
			
			if(ctrl.proximoJogador()==false) {
				tabuleiroAtual.dispose();
				popUpGameOver();
			}else{
				String jogador = ctrl.getJogadorDaVez();
				CriaTabuleiro(jogador);
			}
		}
		else if(e.getActionCommand().equals("Mostrar Cartas")) {
			int jogadorId = ctrl.getJogadorDaVezId();
			String[] cartasDoJogador = modelAPI.getCartasJogador(jogadorId);
			popUpCartas(cartasDoJogador);
		}
		else if(e.getActionCommand().equals("Bloco de Notas")) {
			int jogadorId = ctrl.getJogadorDaVezId();
			String[] cartasMarcadas = modelAPI.getBlocoDeNotasJogador(jogadorId);
			popUpBlocoDeNotas(cartasMarcadas);
		}
		else if(e.getActionCommand().equals("Passagem Secreta")) {
			jogarDadosAtivacao = false; acusarAtivacao = true;
			passagemSecretaAtivacao = false; jaUseiPassagemSecreta = true;
			escolheDado=false;
			
			int jogadorId = ctrl.getJogadorDaVezId();
			String jogador = ctrl.getJogadorDaVez();
			modelAPI.moveJogadorPassagemSecreta(jogadorId, jogador);
			CriaTabuleiro(jogador);
		}
		else if(e.getActionCommand().equals("Acusar")) {
			popUpAcusacao();
		}
		else if(e.getActionCommand().equals("Confirmar Acusação")) {
			boolean resultAcusacao = ctrl.fazerAcusacao(acusacaoConfirmada); 
			if(resultAcusacao == true) {
				tabuleiroAtual.dispose();
				popUpVencedor(ctrl.getJogadorDaVez());
			}else popUpBloqueado(ctrl.getJogadorDaVez());
		}
		else if(e.getActionCommand().equals("Palpite")) {
			String comodo = modelAPI.getAreaDoTabuleiro(ctrl.getJogadorDaVezId());
			popUpPalpite(comodo);		
		}
		else if (e.getActionCommand().equals("Palpitar")) {
			jogarDadosAtivacao = false; acusarAtivacao = true;
			palpiteAtivacao = false; proximoAtivacao = true; jaPalpitei = true;
			escolheDado=false;
				
			String jogador = ctrl.getJogadorDaVez();
			int jogadorId = ctrl.getJogadorDaVezId();
			modelAPI.trazerSuspeito(jogadorId, palpiteConfirmado[1]);
			int[] posCartaErrada = {0,0,0};
			boolean palpiteCerto = modelAPI.fazerPalpite(jogadorId, palpiteConfirmado,posCartaErrada);
			popUpPalpiteAviso(palpiteCerto,posCartaErrada,palpiteConfirmado);
			tabuleiroAtual.dispose();
			CriaTabuleiro(jogador);				
		}
		else if(e.getActionCommand().equals("Salvar Jogo")) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Escolha um local para salvar o jogo");
			int retorno = fileChooser.showOpenDialog(this);
			
			if(retorno == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				String s = file.getPath();
				int i, pos = 0;
								
				String []jog = ctrl.getJogadores();
				String []bots = new String[6 - jog.length];
				
				for (i = 0;i<opcoesPersonagens.length;i++) {
					if(!ehJogador(opcoesPersonagens[i],jog)) {
						bots[pos] = opcoesPersonagens[i];
						pos++;
					}
				}
				boolean gravou = Arquivo.gravaArquivo(s,jog,bots);
				if (gravou) JOptionPane.showMessageDialog(null, "Jogo salvo com sucesso","Aviso", 1);
				else JOptionPane.showMessageDialog(null, "O jogo não foi salvo!","Aviso", 0);
			}
		}		
	}
	
	public static void main(String[]args) {
		/*Registrando DesenhaTabuleiro como Observador*/
		Controller ctrl = Controller.getInstancia();
		new DesenhaTabuleiro(ctrl);
		/*Iniciando o Jogo*/
		Container inicio = new Container();
		inicio.CriaInicio();
	}
}