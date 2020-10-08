package com.capgemini.tictactoe;
import java.util.*;
public class TicTacToeGame {

	private char[] board;
	private char playerChar;
	private char computerChar;
	
	public char getPlayerChar() {
		return playerChar;
	}

	public char getComputerChar() {
		return computerChar;
	}

	public void setComputerChar(char playerChar) {
		if(playerChar == 'O')
			this.computerChar = 'X';
		else
			this.computerChar = 'O';
	}

	public void setPlayerChar(char playerChar) {

		this.playerChar = playerChar;
	}

	/**
	 * UC1
	 * @return array of character
	 */
	private char[] createAndReturnBoardUC1() {
		this.board = new char[10];
		for (int index = 1; index < 10; index++) {
			board[index] = 'X';
		}
		return board;
	}
	
	/**
	 * UC2
	 * set player and computer character
	 */
	private void allowPlayerToChoseFromXandOUC2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice : X or O");
		this.setPlayerChar(sc.next().charAt(0));
		this.setComputerChar(this.playerChar);
	}
	
	private void diplayBoardUC3() {
		for(int row = 0;row<3;row++) {
			for(int col = row*3+1;col<row*3+4;col++) {
				System.out.print(board[col]);
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String args[]) {
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[] ticTacToeBoard = ticTacToeGame.createAndReturnBoardUC1();
		ticTacToeGame.allowPlayerToChoseFromXandOUC2();
		ticTacToeGame.diplayBoardUC3();
	}



}
