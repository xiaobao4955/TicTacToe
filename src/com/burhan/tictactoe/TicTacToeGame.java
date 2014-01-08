package com.burhan.tictactoe;


public class TicTacToeGame {

	public static final int BOARD_SIZE = 9;
	public static final char HUMAN_PLAYER = 'X';
	public static final char COMPUTER_PLAYER = 'O';
	public static final char OPEN_SPOT = ' ';

	private char board[] = new char[9];
	
	public void clearBoard() {
	}

	public void setMove(char player, int location) {
		if(location >= board.length){
			return;
		}
		if(board[location] == '\u0000'){
			board[location] = player;
		}
	}

	public char[] getBoard() {
		return board;
	}

}
