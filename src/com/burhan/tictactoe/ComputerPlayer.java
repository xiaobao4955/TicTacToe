package com.burhan.tictactoe;

public class ComputerPlayer {

	public int makeMove(char[] board) {
		for (int i = 0; i < 9; i++) {
			if ((board[i] - 0) != 79 && (board[i] - 0) != 88) {
				return i;
			}
		}
		return 0;
	}
}
