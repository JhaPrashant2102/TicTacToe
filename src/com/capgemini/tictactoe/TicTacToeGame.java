package com.capgemini.tictactoe;

public class TicTacToeGame {

	private char[] board;

	/**
	 * @return array of character
	 */
	private char[] createAndReturnBoardUC1() {
		this.board = new char[10];
		for (int index = 1; index < 10; index++) {
			board[index] = ' ';
		}
		return board;
	}

	public static void main(String args[]) {
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[] ticTacToeBoard = ticTacToeGame.createAndReturnBoardUC1();
	}

}
