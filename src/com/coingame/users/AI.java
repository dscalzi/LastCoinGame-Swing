package com.coingame.users;

public class AI extends User {

	private int difficulty; //0 Easy | 1 Medium | 2 Hard
	
	public AI(int difficulty){
		this.difficulty = difficulty;
	}

	@Override
	public int makeMove(int coinsLeft) {
		int amt;
		
		if(this.difficulty == 0)
			amt = moveEasy(coinsLeft);
		else if(this.difficulty == 1)
			amt = moveMedium(coinsLeft);
		else
			amt = moveHard(coinsLeft);
		
		return amt;	
	}
	
	public int moveEasy(int coinsLeft){
		if(coinsLeft == 1)
			return 1;
		
		int amt = (int)((Math.random()*3));
		while(amt == 0){
			amt = (int)((Math.random()*3));
		}
		
		return amt;
	}
	
	public int moveMedium(int coinsLeft){
		int det = (int)(Math.random()*2);
		int amt = 0;
		
		if(det == 0)
			amt = moveEasy(coinsLeft);
		if(det == 1)
			amt = moveHard(coinsLeft);
		
		return amt;
	}
	
	public int moveHard(int coinsLeft){
		int amt = 0;
		
		if((coinsLeft-2)%3 == 0)
			amt = 1;
		
		if((coinsLeft-3)%3 == 0)
			amt = 2;
		
		if((coinsLeft-1)%3 == 0){
			amt = moveEasy(coinsLeft);
		}
		
		return amt;
	}
	
}
