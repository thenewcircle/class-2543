package com.intel.fibclient;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.intel.fibcommon.IFibListener;
import com.intel.fibcommon.Request;
import com.intel.fibcommon.Response;

public class FibActivity extends Activity {
	private EditText input;
	private TextView output;
	private FibManager fibManager;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Setting up the UI
		input = (EditText) findViewById(R.id.input);
		output = (TextView) findViewById(R.id.output);

		fibManager = new FibManager(this);
	}

	// Called when button Calculate is clicked on
	public void onClick(View v) {
		long n = Long.parseLong(input.getText().toString());

		fibManager.asyncFib(new Request(Request.JAVA_RECURSIVE, n), listener);
		fibManager.asyncFib(new Request(Request.JAVA_ITERATIVE, n), listener);
		fibManager.asyncFib(new Request(Request.NATIVE_RECURSIVE, n), listener);
		fibManager.asyncFib(new Request(Request.NATIVE_ITERATIVE, n), listener);
	}
	
	/** Async listener called when asyncFib is done, runs on Binder thread. */
	private IFibListener listener = new IFibListener.Stub() {
		
		public void onResponse(Response response) throws RemoteException {
			Message msg = handler.obtainMessage();
			msg.what = UPDATE_UI_MSG;
			msg.obj = response;
			handler.sendMessage(msg);
		}
	}; 
	
	private static final int UPDATE_UI_MSG = 47;
	private Handler handler = new Handler() {

		// Runs on UI thread
		@Override
		public void handleMessage(Message msg) {
			if(msg.what == UPDATE_UI_MSG) {
				output.append("\n" + (Response)msg.obj);
			}
		}
		
	};
}