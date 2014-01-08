package com.burhan.tictactoe;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button mBoardButtons[];
	private TicTacToeGame mGame;
	private TextView mInfoTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initUI();
		startNewGame();
		updateView();
		
		//test
		setMove(TicTacToeGame.COMPUTER_PLAYER, 1);
		setMove(TicTacToeGame.COMPUTER_PLAYER, 3);
		setMove(TicTacToeGame.COMPUTER_PLAYER, 7);
		
	}

	private void initUI() {
		mBoardButtons = new Button[TicTacToeGame.BOARD_SIZE];
		mBoardButtons[0] = (Button) findViewById(R.id.button1);
		mBoardButtons[1] = (Button) findViewById(R.id.button2);
		mBoardButtons[2] = (Button) findViewById(R.id.button3);
		mBoardButtons[3] = (Button) findViewById(R.id.button4);
		mBoardButtons[4] = (Button) findViewById(R.id.button5);
		mBoardButtons[5] = (Button) findViewById(R.id.button6);
		mBoardButtons[6] = (Button) findViewById(R.id.button7);
		mBoardButtons[7] = (Button) findViewById(R.id.button8);
		mBoardButtons[8] = (Button) findViewById(R.id.button9);
		mInfoTextView = (TextView) findViewById(R.id.information);
		mGame = new TicTacToeGame();
	}

	private void startNewGame() {
		mGame.clearBoard();
		
		/**/
		for(int i=0;i<mBoardButtons.length;i++){
			mBoardButtons[i].setText("");
			mBoardButtons[i].setEnabled(true);
			mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));
		}
	}


	private void setMove(char player, int location){
		if (mBoardButtons[location].isEnabled()) {
			mBoardButtons[location].setEnabled(false);
			mGame.setMove(player, location);
			updateView();
		}
	}
	private void updateView() {
		char board[] = mGame.getBoard();
		for(int i=0; i<board.length;i++){
			mBoardButtons[i].setText(String.valueOf(board[i]));
			if(board[i] == TicTacToeGame.HUMAN_PLAYER){
				mBoardButtons[i].setTextColor(Color.rgb(0, 200, 0));
			}else{
				mBoardButtons[i].setTextColor(Color.rgb(200, 0, 0));
			}
			
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class ButtonClickListener implements OnClickListener{

		private int location;

		public ButtonClickListener(int location) {
			this.location = location;
		}


		@Override
		public void onClick(View v) {
			if(mBoardButtons[location].isEnabled()){
				setMove(TicTacToeGame.HUMAN_PLAYER, location);
			}
		}
		
	}
}
