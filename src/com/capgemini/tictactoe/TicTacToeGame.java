package com.capgemini.tictactoe;

import java.util.*;

public class TicTacToeGame {

	private char[] board;
	private char playerChar;
	private char computerChar;

	public static enum Player {
		USER, COMPUTER
	};

	public char getPlayerChar() {
		return playerChar;
	}

	public char getComputerChar() {
		return computerChar;
	}

	public void setComputerChar(char playerChar) {
		if (playerChar == 'O')
			this.computerChar = 'X';
		else
			this.computerChar = 'O';
	}

	public void setPlayerChar(char playerChar) {

		this.playerChar = playerChar;
	}

	/**
	 * UC1
	 * 
	 * @return array of character
	 */
	private char[] createAndReturnBoardUC1() {
		this.board = new char[10];
		for (int index = 1; index < 10; index++) {
			board[index] = ' ';
		}
		return board;
	}

	/**
	 * UC2 set player and computer character
	 */
	private void allowPlayerToChoseFromXandOUC2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice : X or O");
		this.setPlayerChar(sc.next().charAt(0));
		this.setComputerChar(this.playerChar);
	}

	private void displayBoardUC3() {
		for (int row = 0; row < 3; row++) {
			System.out.print("| ");
			for (int col = row * 3 + 1; col < row * 3 + 4; col++) {
				System.out.print(board[col] + " | ");
			}
			System.out.println(" ");
		}
	}

	private int abilityToMakeMoveForPlayerUC4() {
		while (true) {
			System.out.println("Enter the position where you want to add : " + playerChar);
			Scanner sc = new Scanner(System.in);
			int index = sc.nextInt();
			if (index < 1 || index > 10) {
				System.out.println("Invalid position");
				continue;
			}
			if (board[index] == ' ') {
				board[index] = playerChar;
				return index;
			} else {
				System.out.println("This position is already filled");
				continue;
			}
		}
	}

	private Player determineWhoPlaysFirstUC6() {

		if (this.returnHeadOrTail().equalsIgnoreCase("head")) {
			System.out.println("Player plays first");
			return Player.USER;
		} else {
			System.out.println("Computer plays first");
			return Player.COMPUTER;
		}
	}

	private String returnHeadOrTail() {
		String checkForHeadOrTail;
		int toss = new Random().nextInt(2);
		if (toss == 0)
			checkForHeadOrTail = "Head";
		else
			checkForHeadOrTail = "Tail";
		return checkForHeadOrTail;
	}

	private void determineNextMoveUC7(Player player) {
		if (player.USER == player) {
			displayBoardUC3();
			abilityToMakeMoveForPlayerUC4();
			determineNextMoveUC7(player.COMPUTER);
			if (checkifPlayerWon()) {
				System.out.println("Player won");
				return;
			}
		} else {
			abilityToMakeMoveForComputer();
			if (checkifPlayerWon()) {
				System.out.println("Player won");
				return;
			}
			determineNextMoveUC7(player.USER);
		}
	}

	private boolean checkifPlayerWon() {
		for(int i = 1 ;i<=7;i=i+3) {
			if(board[i]==playerChar&&board[i+1]==playerChar&&board[i]==playerChar) {
				return true;
			}
		}
		for(int i = 1; i<=3 ;i++) {
			if(board[i]==playerChar&&board[i+3]==playerChar&&board[i+6]==playerChar) {
				return true;
			}
		}
		return (board[1]==playerChar&&board[5]==playerChar&&board[9]==playerChar)||(board[3]==playerChar&&board[5]==playerChar&&board[7]==playerChar);
	}

	private void abilityToMakeMoveForComputer() {
		while (true) {
			int index = new Random().nextInt(10);
			if (index < 1) {
				continue;
			}
			if (board[index] == ' ') {
				board[index] = computerChar;
				return;
			} else {
				continue;
			}
		}
	}

	public static void main(String args[]) {
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[] ticTacToeBoard = ticTacToeGame.createAndReturnBoardUC1();
		ticTacToeGame.allowPlayerToChoseFromXandOUC2();
		ticTacToeGame.displayBoardUC3();
		// int index = ticTacToeGame.abilityToMakeMoveForPlayerUC4();
		// ticTacToeGame.displayBoardUC3();
		Player player = ticTacToeGame.determineWhoPlaysFirstUC6();
		ticTacToeGame.determineNextMoveUC7(player);
	}

}
