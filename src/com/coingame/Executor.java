package com.coingame;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.coingame.GUI.MainGUI;
import com.coingame.GUI.SelectorGUI;
import com.coingame.GUI.SimpleGUI;

@SuppressWarnings("unused")
public class Executor {
	
	//Build Version
	public static final String VERSION = "1.1.5";
	
	//Screen Dimensions for auto-scaling
	public static final Dimension DIM = Toolkit.getDefaultToolkit().getScreenSize();
	
	//Execution Controller
	public static volatile boolean canContinue;
	
	public static void main(String[] args){
		CoinGame game = new CoinGame();
		selector(game);
		while(!canContinue){
			//Pause execution
		}
		game.run();
	}
	
	public static void selector(CoinGame game){
		canContinue = false;
		SelectorGUI select = new SelectorGUI(game);
		select.setVisible(true);
	}
	
}
