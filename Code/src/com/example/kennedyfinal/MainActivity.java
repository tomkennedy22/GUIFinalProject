package com.example.kennedyfinal;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	
	GridView grid;
	private Button b;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		setContentView(R.layout.activity_main);
		b = (Button) findViewById(R.id.welcomeGo);
		 
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startRun();
			}
		});
    }
    
    private void startRun(){
    	Intent intent = new Intent(MainActivity.this, ShowBoard.class);
    	MainActivity.this.startActivity(intent);
    }

    

}
