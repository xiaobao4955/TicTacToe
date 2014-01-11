package com.burhan.tictactoe;

import com.burhan.tictactoe.TicTacToeGame.DifficultyLevel;


public class ComputerPlayer {

	private DifficultyLevel difficultyLevel = DifficultyLevel.EASY;
	

	
	public ComputerPlayer() {
		setDifficultyLevel(DifficultyLevel.EASY);
	}

	public ComputerPlayer(DifficultyLevel difficultyLevel) {
		this.setDifficultyLevel(difficultyLevel);

	}
	public int makeMove(char[] board) {
		for (int i = 0; i < 9; i++) {
			if ((board[i] - 0) != 79 && (board[i] - 0) != 88) {
				return i;
			}
		}
		return 0;
	}

	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	private void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	

}
