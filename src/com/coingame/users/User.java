package com.coingame.users;

public abstract class User {

	public abstract int makeMove(int coinsLeft);
	
	public static String parseUser(User u){
		if(u instanceof Player)
			return "Player";
		if(u instanceof AI)
			return "AI";
		return "User";
	}
	
}
