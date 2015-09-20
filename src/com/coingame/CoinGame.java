package com.coingame;

import com.coingame.GUI.GameGUI;
import com.coingame.GUI.MainGUI;
import com.coingame.GUI.SimpleGUI;
import com.coingame.users.AI;
import com.coingame.users.Player;

public class CoinGame {

	//Data
	private GameGUI gameScreen;
	private int totalCoins;
	private int coinsLeft;
	private boolean goingFirst;
	private int difficulty; //0 Easy | 1 Medium | 2 Hard
	
	//Users
	private AI ai;
	private Player player;
	
	public CoinGame(){
		this.coinsLeft = Executor.dataCoins;
		this.ai = new AI(Executor.dataDifficulty);
		this.player = new Player();
		if(Executor.dataVersion == 0){
			gameScreen = new MainGUI();
			((MainGUI)gameScreen).setVisible(true);
		} else {
			gameScreen = new SimpleGUI();
			((SimpleGUI)gameScreen).setVisible(true);
		}
	}
	
	public void run(){
		while(!isOver()){
			int coinsTaken;
			if(goingFirst){
				Executor.canContinue = false;
				while(!Executor.canContinue){
					//Pause Execution
				}
				coinsTaken = player.makeMove(coinsLeft);
				this.coinsLeft = this.coinsLeft - coinsTaken;
				gameScreen.printMove(player, coinsLeft, coinsTaken, false);
				
				if(isOver())
					break;
					
				coinsTaken = ai.makeMove(coinsLeft);
				this.coinsLeft = this.coinsLeft - coinsTaken;
				gameScreen.printMove(ai, coinsLeft, coinsTaken, true);
			} else {
				coinsTaken = ai.makeMove(coinsLeft);
				this.coinsLeft = this.coinsLeft - coinsTaken; 
				gameScreen.printMove(ai, coinsLeft, coinsTaken, false);
				
				Executor.canContinue = false;
				while(!Executor.canContinue){
					//Pause Execution
				}
				coinsTaken = player.makeMove(coinsLeft);
				this.coinsLeft = this.coinsLeft - coinsTaken; 
				gameScreen.printMove(player, coinsLeft, coinsTaken, true);
			}
		}
	}
	
	public boolean isOver(){
		if(coinsLeft <= 0)
			return true;
		else
			return false;
	}
	
	public void setCoins(int coins){
		this.totalCoins = coins;
	}
	
	public int getCoins(){
		return this.totalCoins;
	}
	
	public void setCoinsLeft(int coinsLeft){
		this.coinsLeft = coinsLeft;
	}
	
	public int getCoinsLeft(){
		return this.coinsLeft;
	}
	
	public void setDifficulty(int difficulty){
		this.difficulty = difficulty;
	}
	
	public int getDifficulty(){
		return this.difficulty;
	}
	
	public boolean isGoingFirst(){
		return this.goingFirst;
	}
	
	public void setGoingFirst(boolean goingFirst){
		this.goingFirst = goingFirst;
	}
}
