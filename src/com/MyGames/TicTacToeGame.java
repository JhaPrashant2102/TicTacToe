package com.MyGames;

public class TicTacToeGame {
	
	private char[] board;
	
	
	
	public TicTacToeGame() {
		super();
		this.board = new char[10];
		for(int i = 1; i<10; i++) {
			board[i] = ' ';
		}
	}



	public static void main(String args[]) {
		
	}
}
