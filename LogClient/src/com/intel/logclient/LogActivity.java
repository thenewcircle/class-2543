package com.intel.logclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class LogActivity extends Activity {
	EditText tag, message;
	RadioGroup priority;
	LogManager logManager;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tag = (EditText) findViewById(R.id.tag);
        message = (EditText) findViewById(R.id.message);
        priority = (RadioGroup) findViewById(R.id.priority);
        
        logManager = new LogManager(this);
    }
    
    /** Called when button Log! is clicked. */
    public void onClickLog(View v) {
    		String tagString = tag.getText().toString();
    		String messageString = message.getText().toString();
    		int priorityInt = -1;
    		
    		switch( priority.getCheckedRadioButtonId() ) {
    		case R.id.radio_debug:
    			priorityInt = LogManager.DEBUG; break;
    		case R.id.radio_warn:
    			priorityInt = LogManager.WARN; break;
    		case R.id.radio_error:
    			priorityInt = LogManager.ERROR; break;
    		}
    		
    		logManager.log(priorityInt, tagString, messageString);
    }
}