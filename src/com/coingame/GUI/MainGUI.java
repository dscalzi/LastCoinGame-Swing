package com.coingame.GUI;

import com.coingame.CoinGame;
import com.coingame.users.User;

@SuppressWarnings("serial")
public class MainGUI extends GameGUI{

	@SuppressWarnings("unused")
	private CoinGame game;
	
	public MainGUI(CoinGame game){
		this.game = game;
	}

	@Override
	public void printMove(User u, int coinsTaken, boolean isTurnEnd) {
		// TODO Auto-generated method stub
		
	}
	
}
