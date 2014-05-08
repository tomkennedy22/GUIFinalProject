package com.example.kennedyfinal;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class PickLetter extends ActionBarActivity {
	String[] letters;
	GridView grid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.v("TK", "pickcreate");
		Bundle b=this.getIntent().getExtras();
		letters=b.getStringArray("key");
		
		for(String a:letters){
			Log.v("lettersTK", a);
		}
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pick_letter);

		grid = (GridView) findViewById(R.id.gridView);
		 
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, letters);
 
		grid.setAdapter(adapter);
 
		grid.setOnClickListener(new OnClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
			   Toast.makeText(getApplicationContext(),
				((TextView) v).getText(), Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pick_letter, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_pick_letter,
					container, false);
			return rootView;
		}
	}

}
