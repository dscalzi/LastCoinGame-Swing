package com.coingame.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import com.coingame.Executor;

@SuppressWarnings("unused")
public class SelectorGUI extends JFrame implements ChangeListener, PropertyChangeListener, ActionListener{
	
	private static final long serialVersionUID = -8408726492384595034L;
	public static final int MAXFORNEW = 500;
	private JSlider slider;
	private JButton btnPlayButton;
	private JFormattedTextField formattedTextField;
	private ButtonGroup grpVersion;
	private JRadioButton rdbtnNewVersion;
	private JRadioButton rdbtnOldVersion;
	private ButtonGroup grpDifficulty;
	private JRadioButton rdbtnEasy;
	private JRadioButton rdbtnMedium;
	private JRadioButton rdbtnHard;
	private JCheckBox chckbxGoFirst;
	private JPanel contentPane;
	private final JPanel panel_6 = new JPanel();
	private Border border;
	private boolean canContinue = true;
	
	public SelectorGUI(){
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 310);
        setLocation(Executor.DIM.width/2-getSize().width/2, Executor.DIM.height/2-getSize().height/2);
		initializeComponents();
	}
	
	
	private void initializeComponents(){
		/*Instantiate Variables*/
		//Main
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Last Coin Game!");
		lblWelcomeToThe.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 17));
		panel.add(lblWelcomeToThe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnPlayButton = new JButton("Play");
		btnPlayButton.addActionListener(this);
		panel_1.add(btnPlayButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))));
		panel_2.add(panel_3);
		
		JTextPane txtpnToPlayThis = new JTextPane();
		txtpnToPlayThis.setText("You start of with a selected amount of coins and take either one or two per turn \r\nuntil there is one coin left. The player who has to take the last coin is the loser!");
		panel_3.add(txtpnToPlayThis);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_2.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))));
		panel_4.add(panel_5);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		textPane.setText("You start of with a selected amount of coins and take either one or two per turn \r\nuntil there is one coin left. The player who has to take the last coin is the loser!");
		panel_5.add(textPane);
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(5, 0, 0, 0));
		
		JLabel lblGameSettings = new JLabel("Game Settings");
		lblGameSettings.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblGameSettings);
		lblGameSettings.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		
		JLabel lblNumberOfCoins = new JLabel("Number of Coins: ");
		panel_8.add(lblNumberOfCoins);
		lblNumberOfCoins.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		
		formattedTextField = new JFormattedTextField(NumberFormat.getNumberInstance());
		formattedTextField.setToolTipText("Limit: 10,000");
		panel_8.add(formattedTextField);
		formattedTextField.setColumns(5);
		formattedTextField.setText("23");
		formattedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		this.border = formattedTextField.getBorder();
		formattedTextField.addPropertyChangeListener("value", this);
		
		slider = new JSlider();
		slider.setMinimum(3);
		panel_8.add(slider);
		slider.setValue(23);
		slider.addChangeListener(this);
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9);
		
		JLabel lblDifficulty = new JLabel("Difficulty: ");
		lblDifficulty.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		panel_9.add(lblDifficulty);
		
		grpDifficulty = new ButtonGroup();
		
		rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setToolTipText("Plays just like someone who does not know how to win.");
		panel_9.add(rdbtnEasy);
		grpDifficulty.add(rdbtnEasy);
		
		rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setToolTipText("Knows how to win, but makes a few mistakes.");
		panel_9.add(rdbtnMedium);
		grpDifficulty.add(rdbtnMedium);
		
		rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setToolTipText("Plays flawlessly, but is beatable.");
		rdbtnHard.setSelected(true);
		panel_9.add(rdbtnHard);
		grpDifficulty.add(rdbtnHard);
		
		chckbxGoFirst = new JCheckBox("Go First", true);
		panel_9.add(chckbxGoFirst);
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		
		JLabel lblVersion = new JLabel("Version: ");
		lblVersion.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		panel_7.add(lblVersion);
		
		grpVersion = new ButtonGroup();
		
		rdbtnNewVersion = new JRadioButton("New Version");
		panel_7.add(rdbtnNewVersion);
		rdbtnNewVersion.setSelected(true);
		
		rdbtnOldVersion = new JRadioButton("Old Version");
		panel_7.add(rdbtnOldVersion);
		
		grpVersion.add(rdbtnNewVersion);
		grpVersion.add(rdbtnOldVersion);
		
		forceVersion(); //Until new gui is done
	}
	
	public void forceVersion(){
		rdbtnNewVersion.setSelected(false);
		rdbtnOldVersion.setSelected(true);
		rdbtnNewVersion.setEnabled(false);
		rdbtnOldVersion.setEnabled(false);
	}
	
	public void unforceVersion(){
		rdbtnNewVersion.setEnabled(true);
		rdbtnOldVersion.setEnabled(true);
	}
	
	public int getVersion(){
		if(rdbtnNewVersion.isSelected())
			return 0;
		else
			return 1;
	}
	
	public int getDifficulty(){
		if(rdbtnEasy.isSelected())
			return 0;
		else if(rdbtnMedium.isSelected())
			return 1;
		else
			return 2;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
        if ( e.getSource() == slider &&((JSlider) e.getSource()).getValueIsAdjusting()) {
        	JSlider source = (JSlider) e.getSource();
            formattedTextField.setText("" + source.getValue());
            formattedTextField.setBorder(border);
            canContinue = true;
            btnPlayButton.setEnabled(true);
            //unforceVersion();
        }    
    }

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if(e.getSource() == formattedTextField){
			int val;
			try{
				val = (NumberFormat.getNumberInstance(java.util.Locale.US).parse(formattedTextField.getText())).intValue();
			}catch(Exception ex){
				return;
			}
			
			if(val > 10000 || val < 3){
				formattedTextField.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 0, 0), null, Color.RED, null));
				canContinue = false;
				btnPlayButton.setEnabled(false);
			} else {
				formattedTextField.setBorder(border);
				canContinue = true;
				btnPlayButton.setEnabled(true);
			}
			
			if(val > MAXFORNEW)
				forceVersion();
			//else
				//unforceVersion();					
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnPlayButton && canContinue){
			try {
				Executor.dataCoins = (NumberFormat.getNumberInstance(java.util.Locale.US).parse(formattedTextField.getText())).intValue();
			} catch (ParseException e1) {
				System.exit(0);
			}
			Executor.dataDifficulty = getDifficulty();
			Executor.dataVersion = getVersion();
			Executor.dataGoingFirst = chckbxGoFirst.isSelected();
			Executor.canContinue = true;
			this.dispose();
		}
	}
	
}
