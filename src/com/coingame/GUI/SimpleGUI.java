package com.coingame.GUI;

import javax.swing.JFrame;

import com.coingame.Executor;
import com.coingame.users.Player;
import com.coingame.users.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
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

	private JTextPane console;
	private JProgressBar progressBar;
	private JButton btnSurrender;
	private JButton btnTakeOneCoin;
	private JButton btnTakeTwoCoins;
	
	public SimpleGUI(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(800, 600);
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		initializeComponents();
		
		setVisible(true);
		
	}
	
	public void initializeComponents(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblLastCoinGame = new JLabel("Last Coin Game");
		lblLastCoinGame.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		panel.add(lblLastCoinGame);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblThePlayer = new JLabel("\u00A0\u00A0\u00A0The Player\u00A0\u00A0\u00A0");
		panel_1.add(lblThePlayer, BorderLayout.NORTH);
		lblThePlayer.setForeground(Color.BLACK);
		lblThePlayer.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.SOUTH);
		
		btnSurrender = new JButton("Surrender");
		btnSurrender.addActionListener(this);
		panel_5.add(btnSurrender);
		
		JPanel panel_6 = new JPanel(new GridBagLayout());
		panel_1.add(panel_6, BorderLayout.CENTER);		
		
		JLabel lblOptions = new JLabel("Make a Move");
		lblOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblOptions.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		GridBagConstraints gbc_lblOptions = new GridBagConstraints();
		gbc_lblOptions.anchor = GridBagConstraints.NORTH;
		gbc_lblOptions.insets = new Insets(0, 0, 5, 0);
		gbc_lblOptions.gridx = 0;
		gbc_lblOptions.gridy = 0;
		panel_6.add(lblOptions, gbc_lblOptions);
		
		btnTakeOneCoin = new JButton("Take One");
		btnTakeOneCoin.addActionListener(this);
		GridBagConstraints gbc_btnTakeOneCoin = new GridBagConstraints();
		gbc_btnTakeOneCoin.insets = new Insets(0, 0, 5, 0);
		gbc_btnTakeOneCoin.gridx = 0;
		gbc_btnTakeOneCoin.gridy = 1;
		panel_6.add(btnTakeOneCoin, gbc_btnTakeOneCoin);
		
		btnTakeTwoCoins = new JButton("Take Two");
		btnTakeTwoCoins.addActionListener(this);
		GridBagConstraints gbc_btnTakeTwoCoins = new GridBagConstraints();
		gbc_btnTakeTwoCoins.gridx = 0;
		gbc_btnTakeTwoCoins.gridy = 2;
		panel_6.add(btnTakeTwoCoins, gbc_btnTakeTwoCoins);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAi = new JLabel("\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0AI\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0\u00A0");
		lblAi.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		panel_2.add(lblAi, BorderLayout.NORTH);
		
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.rowWeights = new double[]{0.0, 1.0};
		gbl_panel_7.columnWeights = new double[]{1.0};
		JPanel panel_7 = new JPanel(gbl_panel_7);
		panel_2.add(panel_7, BorderLayout.CENTER);
		
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
		panel_7.add(txtpnAiText, gbc_txtpnAiText);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JLabel lblGameProgress = new JLabel("Game Progress: ");
		lblGameProgress.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		panel_3.add(lblGameProgress);
		
		progressBar = new JProgressBar(0, Executor.dataCoins);
		progressBar.setForeground(new Color(34, 139, 34));
		panel_3.add(progressBar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		getContentPane().add(panel_4, BorderLayout.CENTER);
		
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
		panel_4.add(jsp);
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
		Object[] options = {"Continue",
                "Exit",};
		int n = JOptionPane.showOptionDialog(this,
			    "The " + User.parseUser(u) + " has lost.",
			    "Game Over",
			    JOptionPane.YES_NO_OPTION,
			    JOptionPane.PLAIN_MESSAGE,
			    null,
			    options,  //the titles of buttons
			    options[0]); //default button title
		
		if(n == JOptionPane.NO_OPTION)
			System.exit(1);
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
			Player.takeCoins = 1;
			Executor.canContinue = true;
		}else if(e.getSource() == btnTakeTwoCoins){
			Player.takeCoins = 2;
			Executor.canContinue = true;
		}
		
	}
	
}
