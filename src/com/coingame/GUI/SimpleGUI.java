package com.coingame.GUI;

import javax.swing.JFrame;

import com.coingame.Executor;
import com.coingame.users.AI;
import com.coingame.users.Player;
import com.coingame.users.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class SimpleGUI extends GameGUI implements ActionListener{

	private Player player;
	@SuppressWarnings("unused")
	private AI ai;
	
	private JTextPane console;
	private JProgressBar progressBar;
	private JButton btnSurrender;
	private JButton btnTakeOneCoin;
	private JButton btnTakeTwoCoins;
	
	public SimpleGUI(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
        setLocation(Executor.DIM.width/2-getSize().width/2, Executor.DIM.height/2-getSize().height/2);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		initializeComponents();
		
		setVisible(true);
		
	}
	
	public SimpleGUI(Player p, AI ai){
		this();
		this.player = p;
		this.ai = ai;
	}
	
	public void initializeComponents(){
		JPanel panelTop = new JPanel();
		panelTop.setBackground(Color.WHITE);
		getContentPane().add(panelTop, BorderLayout.NORTH);
		
		JLabel lblLastCoinGame = new JLabel("Last Coin Game");
		lblLastCoinGame.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		panelTop.add(lblLastCoinGame);
		
		JPanel panelPlayer = new JPanel();
		getContentPane().add(panelPlayer, BorderLayout.WEST);
		panelPlayer.setLayout(new BorderLayout(0, 0));
		
		JLabel lblThePlayer = new JLabel("\u00A0\u00A0\u00A0The Player\u00A0\u00A0\u00A0");
		panelPlayer.add(lblThePlayer, BorderLayout.NORTH);
		lblThePlayer.setForeground(Color.BLACK);
		lblThePlayer.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		
		JPanel panelPlayerSurrender = new JPanel();
		panelPlayer.add(panelPlayerSurrender, BorderLayout.SOUTH);
		
		btnSurrender = new JButton("Surrender");
		btnSurrender.addActionListener(this);
		panelPlayerSurrender.add(btnSurrender);
		
		JPanel panelPlayerOptions = new JPanel(new GridBagLayout());
		panelPlayer.add(panelPlayerOptions, BorderLayout.CENTER);		
		
		JLabel lblOptions = new JLabel("Make a Move");
		lblOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblOptions.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		GridBagConstraints gbc_lblOptions = new GridBagConstraints();
		gbc_lblOptions.anchor = GridBagConstraints.NORTH;
		gbc_lblOptions.insets = new Insets(0, 0, 5, 0);
		gbc_lblOptions.gridx = 0;
		gbc_lblOptions.gridy = 0;
		panelPlayerOptions.add(lblOptions, gbc_lblOptions);
		
		btnTakeOneCoin = new JButton("Take One");
		btnTakeOneCoin.addActionListener(this);
		GridBagConstraints gbc_btnTakeOneCoin = new GridBagConstraints();
		gbc_btnTakeOneCoin.insets = new Insets(0, 0, 5, 0);
		gbc_btnTakeOneCoin.gridx = 0;
		gbc_btnTakeOneCoin.gridy = 1;
		panelPlayerOptions.add(btnTakeOneCoin, gbc_btnTakeOneCoin);
		
		btnTakeTwoCoins = new JButton("Take Two");
		btnTakeTwoCoins.addActionListener(this);
		GridBagConstraints gbc_btnTakeTwoCoins = new GridBagConstraints();
		gbc_btnTakeTwoCoins.gridx = 0;
		gbc_btnTakeTwoCoins.gridy = 2;
		panelPlayerOptions.add(btnTakeTwoCoins, gbc_btnTakeTwoCoins);
		
		JPanel panelAI = new JPanel();
		getContentPane().add(panelAI, BorderLayout.EAST);
		panelAI.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAi = new JLabel("\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0AI\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0");
		lblAi.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		panelAI.add(lblAi, BorderLayout.NORTH);
		
		GridBagLayout gbl_panelAIText = new GridBagLayout();
		gbl_panelAIText.rowWeights = new double[]{0.0, 1.0};
		gbl_panelAIText.columnWeights = new double[]{1.0};
		JPanel panelAIText = new JPanel(gbl_panelAIText);
		panelAI.add(panelAIText, BorderLayout.CENTER);
		
		JTextPane txtpnAiText = new JTextPane();
		txtpnAiText.setBackground(SystemColor.control);
		txtpnAiText.setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 11));
		txtpnAiText.setText("\r\n\r\n\r\n\r\nSo you think \r\nyou can win?\r\n\r\nDue to my\r\nclear superior\r\nintellect, I'll\r\noffer you a\r\nfew pieces\r\nof knowledge:\r\n\r\n- Take one\r\nor two coins\r\nper round.\r\n\r\n- Try to force\r\nme to take the\r\nlast coin to win\r\n(doubtful you\r\ncan haha).\r\n");
		txtpnAiText.setEditable(false);
		GridBagConstraints gbc_txtpnAiText = new GridBagConstraints();
		gbc_txtpnAiText.anchor = GridBagConstraints.EAST;
		gbc_txtpnAiText.fill = GridBagConstraints.VERTICAL;
		gbc_txtpnAiText.gridx = 0;
		gbc_txtpnAiText.gridy = 1;
		panelAIText.add(txtpnAiText, gbc_txtpnAiText);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.WHITE);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		JLabel lblGameProgress = new JLabel("Game Progress: ");
		lblGameProgress.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		bottomPanel.add(lblGameProgress);
		
		progressBar = new JProgressBar(0, Executor.dataCoins);
		progressBar.setForeground(new Color(34, 139, 34));
		bottomPanel.add(progressBar);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		getContentPane().add(panelMain, BorderLayout.CENTER);
		
		console = new JTextPane();
		JScrollPane jsp = new JScrollPane(console);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		new SmartScroller(jsp, SmartScroller.VERTICAL, SmartScroller.END);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setViewportBorder(null);
		console.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		console.setContentType("text/html");
		console.setEditable(false);
		console.setPreferredSize(new Dimension(550, 496));
		console.setBackground(new Color(248, 248, 255));
		SimpleAttributeSet attribs = new SimpleAttributeSet();  
		StyleConstants.setFontFamily(attribs, "Microsoft YHei UI");
		StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_CENTER);  
		console.setParagraphAttributes(attribs, true);
		console.setText("<center>Welcome to the Last Coin Game.\r<br>Can you beat the AI? We'll soon see.");
		try {
			appendString("\n\nThere are " + Executor.dataCoins + " coins.", false);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		console.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true); //Amazing fix for the font
		panelMain.add(jsp);
	}

	@Override
	public void printMove(User u, int coinsLeft, int coinsTaken, boolean isTurnEnd) {
			progressBar.setValue(Executor.dataCoins - coinsLeft);
			if(coinsLeft == 0){
				try {
					appendString("\n• The " + User.parseUser(u) +" has taken " +coinsTaken + parseAmount(coinsTaken, 1) + ". There" + GameGUI.parseAmount(coinsLeft, 0) + coinsLeft + " remaining.", true);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			} else {
				try {
					appendString("\n• The " + User.parseUser(u) +" has taken " +coinsTaken + parseAmount(coinsTaken, 1) + ". There" + GameGUI.parseAmount(coinsLeft, 0) + coinsLeft + " remaining.", false);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		if(isTurnEnd)
			try {
				appendString("\n", false);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		if(coinsLeft == 1)
			btnTakeTwoCoins.setEnabled(false);
		if(coinsLeft == 0){
			btnTakeOneCoin.setEnabled(false);
			btnTakeTwoCoins.setEnabled(false);
			btnSurrender.setEnabled(false);
			printWin(u);
		}
	}
	
	public void printWin(User u){
		@SuppressWarnings("unused")
		WinGUI win = new WinGUI(u);
	}
	
	public void appendString(String str, boolean lose) throws BadLocationException {
	     StyledDocument document = (StyledDocument) console.getDocument();
	     Style style = console.addStyle("Color", null);
	     StyleConstants.setForeground(style, Color.red);
	     
	     if(!lose){
	    	 document.insertString(document.getLength(), str, null);
	    	 return;
	     } else
	    	 document.insertString(document.getLength(), str, style);
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSurrender){
			System.exit(1);
		}
		if(e.getSource() == btnTakeOneCoin){
			this.player.setMove(1);
			Executor.canContinue = true;
		}else if(e.getSource() == btnTakeTwoCoins){
			this.player.setMove(2);
			Executor.canContinue = true;
		}
		
	}
	
}
