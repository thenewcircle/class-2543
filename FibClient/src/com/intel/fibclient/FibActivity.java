package com.intel.fibclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.intel.fibcommon.IFibService;

public class FibActivity extends Activity {
	private static final Intent INTENT = new Intent(
			"com.intel.fibcommon.IFibService");
	private EditText input;
	private TextView output;
	private IFibService fibService;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Setting up the UI
		input = (EditText) findViewById(R.id.input);
		output = (TextView) findViewById(R.id.output);

		// Bind to the remote service
		boolean bindSuccessful = bindService(INTENT,
				new FibServiceConnection(), Context.BIND_AUTO_CREATE);

		Log.d("FibActivity", "bindSuccessful: " + bindSuccessful);
	}

	/** Handles callbacks from bind to service. */
	class FibServiceConnection implements ServiceConnection {

		public void onServiceConnected(ComponentName name, IBinder binder) {
			fibService = IFibService.Stub.asInterface(binder);
		}

		public void onServiceDisconnected(ComponentName name) {
			fibService = null;
		}

	}

	// Called when button Calculate is clicked on
	public void onClick(View v) throws RemoteException {
		long n = Long.parseLong(input.getText().toString());

		// Java recursive
		long start = System.currentTimeMillis();
		long fibJ = fibService.fibJ(n);
		long timeJ = System.currentTimeMillis() - start;
		output.append(String.format("\nfibJ(%d)=%d (%d ms)", n, fibJ, timeJ));

		// Native recursive
		start = System.currentTimeMillis();
		long fibN = fibService.fibN(n);
		long timeN = System.currentTimeMillis() - start;
		output.append(String.format("\nfibN(%d)=%d (%d ms)", n, fibN, timeN));

		// Java iterative
		start = System.currentTimeMillis();
		long fibJI = fibService.fibJI(n);
		long timeJI = System.currentTimeMillis() - start;
		output.append(String.format("\nfibJI(%d)=%d (%d ms)", n, fibJI, timeJI));

		// Native iterative
		start = System.currentTimeMillis();
		long fibNI = fibService.fibNI(n);
		long timeNI = System.currentTimeMillis() - start;
		output.append(String.format("\nfibNI(%d)=%d (%d ms)", n, fibNI, timeNI));
	}

}