package com.example.kennedyfinal;

import java.util.ArrayList;
import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class ShowBoard extends ActionBarActivity {

	private Button guessButton;
	static final ArrayList<String> word = new ArrayList<String>();
	static String wordString = "";
	
	static final ArrayList<String> board = new ArrayList<String>();
	static String boardString = "";
	 
	static final String[] letters = new String[] { 
			"A", "B", "C", "D", "E",
			"F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setUpBoard();

		setContentView(R.layout.activity_show_board);

		guessButton = (Button) findViewById(R.id.guessButton);		
		
		TextView boardView = (TextView) findViewById(R.id.showWord);
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, board);
		
		boardView.setText(boardString);
		//boardView.setAdapter(adapter);
 

		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	private void setUpBoard(){
		String[] word_array = getResources().getStringArray(R.array.words);
		Random r = new Random();
		int i1 = r.nextInt(word_array.length);
		String w = word_array[i1];
		Log.v(w, w);
		
		for(int i=0; i<w.length(); i++){
			board.add(""+w.charAt(i));
			boardString += w.charAt(i);
			word.add(""+w.charAt(i));
			wordString += w.charAt(i);
		}
		
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
