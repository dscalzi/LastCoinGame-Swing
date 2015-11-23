package com.coingame.GUI;

import javax.swing.JFrame;

import com.coingame.users.User;

@SuppressWarnings("serial")
public abstract class GameGUI extends JFrame{
	
	public abstract void printMove(User u, int coinsTaken, boolean isTurnEnd);
	
	public static String parseAmount(int coins, int type){
		if(type == 0){
			if(coins == 1)
				return " is ";
			return " are ";
		}
		if(type == 1){
			if(coins == 1)
				return " coin";
			return " coins";
		}
		return "Invalid";
	}
}
