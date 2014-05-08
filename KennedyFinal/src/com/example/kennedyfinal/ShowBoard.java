package com.example.kennedyfinal;

import java.util.ArrayList;
import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class ShowBoard extends ActionBarActivity {

	private TextView guessButton;
	static final ArrayList<String> word = new ArrayList<String>();
	static String wordString = "";
	
	static final ArrayList<String> board = new ArrayList<String>();
	static String boardString = "";
	
	private TextView boardView;
	 
	static final String[] letters = new String[] { 
			"A", "B", "C", "D", "E",
			"F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v("TK","shoawboard oncreate");
		setUpBoard();
		Log.v("TK","TK1");
		setContentView(R.layout.activity_show_board);

		guessButton = (Button) findViewById(R.id.guessButton);		
		Log.v("TK","TK2");
		boardView = (TextView) findViewById(R.id.showWord);
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, board);
		
		updateBoard();
		//boardView.setAdapter(adapter);
		Log.v("TK","TK3");
		
		guessButton = (TextView) findViewById(R.id.welcomeGo);
		 
		guessButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.v("TK", "onclick");
				pickLetter();
			}
		});
		
		Log.v("TK", "TK4");
	}
	
	private void setUpBoard(){
		String[] word_array = getResources().getStringArray(R.array.words);
		Random r = new Random();
		int i1 = r.nextInt(word_array.length);
		String w = word_array[i1];
		Log.v("TKsub", w);
		
		for(int i=0; i<w.length(); i++){
			board.add(""+w.charAt(i));
			if(w.charAt(i)==' ')
				boardString += " ";
			else{
				boardString += w.charAt(i);
			}
			word.add(""+w.charAt(i));
			wordString += w.charAt(i);
		}
		
	}

	private void pickLetter(){
		Bundle j=new Bundle();
		j.putStringArray("key", letters);
    	Intent i = new Intent(this, PickLetter.class);
    	ShowBoard.this.startActivity(i);
		i.putExtras(j);
	}
	
	private void updateBoard(){
		boardView.setText(boardString);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_board, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_show_board,
					container, false);
			return rootView;
		}
	}

}
