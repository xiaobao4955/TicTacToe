package com.burhan.tictactoe;

import android.util.Log;


public class TicTacToeGame {

	public static final int BOARD_SIZE = 9;
	public static final char HUMAN_PLAYER = 'X';
	public static final char COMPUTER_PLAYER = 'O';
	public static final char OPEN_SPOT = ' ';
	
	private char lastTurn;

	private char board[] = {OPEN_SPOT,OPEN_SPOT,OPEN_SPOT,OPEN_SPOT,OPEN_SPOT,OPEN_SPOT,OPEN_SPOT,OPEN_SPOT,OPEN_SPOT};
	
	public enum GameStatus{ GAME_GOES_ON, ITS_A_TIE, COMPUTER_WINS, HUMAN_PLAYER_WINS};
	private GameStatus gameStatus;
	
	public TicTacToeGame() {
		gameStatus = GameStatus.GAME_GOES_ON;
	}
	
	public void clearBoard() {
		board = new char[9];
	}

	public boolean setMove(char player, int location) {
		System.out.println("location is "+ location);
		Log.v("Burhan","board location is "+ board[location]);
		
		if(location >= board.length || isOver() ){
			return false;
		}
		
		if(board[location] != HUMAN_PLAYER && board[location] != COMPUTER_PLAYER){
			board[location] = player;
			lastTurn = player;
			checkForWin();
			return true;
		}
		return false;
		
	}

	private void checkForWin() {
		// Check horizontal wins
				for (int i = 0; i <= 6; i += 3)	{
					if (board[i] == HUMAN_PLAYER && 
						board[i+1] == HUMAN_PLAYER &&
						board[i+2]== HUMAN_PLAYER)
						gameStatus = GameStatus.HUMAN_PLAYER_WINS;
					
					if (board[i] == COMPUTER_PLAYER && 
						board[i+1]== COMPUTER_PLAYER && 
						board[i+2] == COMPUTER_PLAYER)
						gameStatus = GameStatus.COMPUTER_WINS;
				}
			
				// Check vertical wins
				for (int i = 0; i <= 2; i++) {
					if (board[i] == HUMAN_PLAYER && 
						board[i+3] == HUMAN_PLAYER && 
						board[i+6]== HUMAN_PLAYER)
						gameStatus = GameStatus.HUMAN_PLAYER_WINS;
					
					if (board[i] == COMPUTER_PLAYER && 
						board[i+3] == COMPUTER_PLAYER && 
						board[i+6]== COMPUTER_PLAYER)
						gameStatus = GameStatus.COMPUTER_WINS;
				}
			
				// Check for diagonal wins
				if ((board[0] == HUMAN_PLAYER &&
					 board[4] == HUMAN_PLAYER && 
					 board[8] == HUMAN_PLAYER) ||
					(board[2] == HUMAN_PLAYER && 
					 board[4] == HUMAN_PLAYER &&
					 board[6] == HUMAN_PLAYER))
					gameStatus = GameStatus.HUMAN_PLAYER_WINS;
				
				if ((board[0] == COMPUTER_PLAYER &&
					 board[4] == COMPUTER_PLAYER && 
					 board[8] == COMPUTER_PLAYER) ||
					(board[2] == COMPUTER_PLAYER && 
					 board[4] == COMPUTER_PLAYER &&
					 board[6] == COMPUTER_PLAYER))
					gameStatus = GameStatus.COMPUTER_WINS;
			
				// Check for tie
				for (int i = 0; i < BOARD_SIZE; i++) {
					// If we find a number, then no one has won yet
					if (board[i] != HUMAN_PLAYER && board[i] != COMPUTER_PLAYER)
						gameStatus = GameStatus.GAME_GOES_ON;
				}
			
	}

	public char[] getBoard() {
		return immutable(board);
	}

	private char[] immutable(char[] array2Copy) {
		char returnArray[] = new char[array2Copy.length];
		for(int i=0;i<array2Copy.length;i++){
			returnArray[i] = array2Copy[i];
		}
		return returnArray;
	}

	public boolean isOver(){
		if(gameStatus == GameStatus.GAME_GOES_ON){
			return false;
		}
		return true;
	}
	
	public GameStatus getGameStatus(){
		return gameStatus;
	}
}
