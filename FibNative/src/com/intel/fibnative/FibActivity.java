package com.intel.fibnative;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FibActivity extends Activity {
	EditText input;
	TextView output;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Setting up the UI
        input = (EditText) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
    }
    
    // Called when button Calculate is clicked on
    public void onClick(View v) {
    		long n = Long.parseLong( input.getText().toString() );
    		
    		// Java recursive
    		long start = System.currentTimeMillis();
    		long fibJ = FibLib.fibJ(n);
    		long timeJ = System.currentTimeMillis() - start;
    		output.append( String.format("\nfibJ(%d)=%d (%d ms)", n, fibJ, timeJ) );

    		// Native recursive
    		start = System.currentTimeMillis();
    		long fibN = FibLib.fibN(n);
    		long timeN = System.currentTimeMillis() - start;
    		output.append( String.format("\nfibN(%d)=%d (%d ms)", n, fibN, timeN) );
    	 	
    		// Java iterative 
    		start = System.currentTimeMillis();
    		long fibJI = FibLib.fibJI(n);
    		long timeJI = System.currentTimeMillis() - start;
    		output.append( String.format("\nfibJI(%d)=%d (%d ms)", n, fibJI, timeJI) );

    		// Native iterative
    		start = System.currentTimeMillis();
    		long fibNI = FibLib.fibNI(n);
    		long timeNI = System.currentTimeMillis() - start;
    		output.append( String.format("\nfibNI(%d)=%d (%d ms)", n, fibNI, timeNI) );
}
}