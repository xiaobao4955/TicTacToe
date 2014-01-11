package com.burhan.tictactoe;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	private Button mBoardButtons[];
	private TicTacToeGame mGame;
	private TextView mInfoTextView;
	private ComputerPlayer computerPlayer = new ComputerPlayer();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initUI();
		startNewGame();
		updateView();

		
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
		mGame.newGame();
		Log.v(TAG, "startNewGame()");
		Log.d(TAG, "startNewGame()");
		/**/
		for(int i=0;i<mBoardButtons.length;i++){
			mBoardButtons[i].setText("");
			mBoardButtons[i].setEnabled(true);
			mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));
		}
		updateView();
	}


	private void setMove(char player, int location){

		if (mBoardButtons[location].isEnabled()) {
			boolean result =mGame.setMove(player, location);
			updateView();
		}
	}
	
	private void updateView() {
		char board[] = mGame.getBoard();
		
		for(int i=0; i<board.length;i++){
			mBoardButtons[i].setText(String.valueOf(board[i]));
			if(board[i] == TicTacToeGame.HUMAN_PLAYER){
				mBoardButtons[i].setTextColor(Color.rgb(0, 200, 0));
				mBoardButtons[i].setEnabled(false);
			}else if (board[i] == TicTacToeGame.COMPUTER_PLAYER){
				mBoardButtons[i].setTextColor(Color.rgb(200, 0, 0));
				mBoardButtons[i].setEnabled(false);
			}
			
		}
		mInfoTextView.setText(mGame.getMessage());
		if(mGame.isOver()){
			disableAllTheBoardButtons();
		}
	}
	
	private void disableAllTheBoardButtons() {
		for(Button button : mBoardButtons){
			button.setEnabled(false);
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add("New Game");
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		startNewGame();
		return super.onOptionsItemSelected(item);
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
			/*computers move*/
			if(!mGame.isOver()){	
				setMove(TicTacToeGame.COMPUTER_PLAYER, computerPlayer.makeMove(mGame.getBoard()));	
			}
		}
		
	}
}
