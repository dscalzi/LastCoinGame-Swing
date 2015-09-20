package com.coingame.users;

public class Player extends User {

	private int takeCoins;
	
	public Player(){
		
	}

	@Override
	public int makeMove(int coinsLeft) {
		return takeCoins;
	}
	
	public void setMove(int takeCoins){
		this.takeCoins = takeCoins;
	}
	
}
