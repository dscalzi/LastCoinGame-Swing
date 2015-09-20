package com.coingame.GUI;

import javax.swing.JDialog;
import javax.swing.JPanel;

import com.coingame.users.Player;
import com.coingame.Executor;
import com.coingame.users.AI;
import com.coingame.users.User;

import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class WinGUI extends JDialog implements ActionListener{
	
	private static final String AI_WIN = "/resource/asset_AIWin.jpg";
	private static final String PLAYER_WIN = "/resource/asset_PlayerWin.jpg";
	
	private User winner;
	private JButton btnExit;
	private JButton btnContinue;
	private JPanel imgPanel;
	private JLabel lblTitle;
	private JLabel labelPicture;
	
	public WinGUI() {
		setAlwaysOnTop(true);
		setSize(450, 350);
        setLocation(Executor.DIM.width/2-getSize().width/2, Executor.DIM.height/2-getSize().height/2);
		setBackground(Color.WHITE);
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		initializeComponents();
		setVisible(true);
	}
	
	public WinGUI(User loser){
		this();
		if(loser instanceof AI)
			this.winner = new Player();
		if(loser instanceof Player)
			this.winner = new AI(-1);
		try {
			printData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initializeComponents(){
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.WHITE);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		btnContinue = new JButton("Continue\r\n");
		btnContinue.addActionListener(this);
		bottomPanel.add(btnContinue);
		
		btnExit = new JButton("\u00A0\u00A0\u00A0\u00A0Exit\u00A0\u00A0\u00A0\u00A0");
		btnExit.addActionListener(this);
		bottomPanel.add(btnExit);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.WHITE);
		getContentPane().add(topPanel, BorderLayout.NORTH);
		
		lblTitle = new JLabel();
		topPanel.add(lblTitle);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		
		JPanel emptyPanel1 = new JPanel();
		emptyPanel1.setBackground(Color.WHITE);
		getContentPane().add(emptyPanel1, BorderLayout.WEST);
		
		JPanel emptyPanel2 = new JPanel();
		emptyPanel2.setBackground(Color.WHITE);
		getContentPane().add(emptyPanel2, BorderLayout.EAST);
		
		imgPanel = new JPanel();
		imgPanel.setBackground(SystemColor.inactiveCaptionBorder);
		getContentPane().add(imgPanel, BorderLayout.CENTER);
		
		labelPicture = new JLabel();
		imgPanel.add(labelPicture);
	}
	
	public void printData() throws IOException{
		if(this.winner instanceof AI){
			getRootPane().setBorder(BorderFactory.createLineBorder(Color.RED));
			lblTitle.setText("The AI has won, as predicted..");
			labelPicture.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream(AI_WIN))));
		}
		else if(this.winner instanceof Player){
			getRootPane().setBorder(BorderFactory.createLineBorder(Color.GREEN));
			lblTitle.setText("The Player has won..");
			labelPicture.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream(PLAYER_WIN))));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnContinue)
			this.dispose();
		if(e.getSource() == btnExit)
			System.exit(1);
	}

}
