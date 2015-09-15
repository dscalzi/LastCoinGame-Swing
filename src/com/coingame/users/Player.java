package com.coingame.users;

public class Player extends User {

	public static int takeCoins;
	
	public Player(){
		
	}

	@Override
	public int makeMove(int coinsLeft) {
		return takeCoins;
	}
	
}
