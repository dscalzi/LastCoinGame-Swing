package com.coingame;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.coingame.GUI.MainGUI;
import com.coingame.GUI.SelectorGUI;
import com.coingame.GUI.SimpleGUI;

@SuppressWarnings("unused")
public class Executor {
	
	//Build Version
	public static final String VERSION = "1.1.1";
	
	//Screen Dimensions for auto-scaling
	public static final Dimension DIM = Toolkit.getDefaultToolkit().getScreenSize();
	
	//Collected Data to be passed forward
	public static int dataCoins;
	public static int dataVersion; //0 New | 1 Old
	public static int dataDifficulty; //0 Easy | 1 Medium | 2 Hard
	public static boolean dataGoingFirst;
	
	//Execution Controller
	public static volatile boolean canContinue;
	
	public static void main(String[] args){
		selector();
		while(!canContinue){
			//Pause execution
		}
		CoinGame game = new CoinGame();
		game.setGoingFirst(dataGoingFirst);
		game.setCoins(dataCoins);
		game.setDifficulty(dataDifficulty);
		game.run();
	}
	
	public static void selector(){
		canContinue = false;
		SelectorGUI select = new SelectorGUI();
		select.setVisible(true);
	}
	
}
