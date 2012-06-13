package com.intel.fibclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.intel.fibcommon.Request;

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

		output.append("\nJava recursive: "
				+ (CharSequence) fibManager.fib(new Request(
						Request.JAVA_RECURSIVE, n)).toString() );

		output.append("\nJava iterative: "
				+ (CharSequence) fibManager.fib(new Request(
						Request.JAVA_ITERATIVE, n)).toString() );

		output.append("\nNative recursive: "
				+ (CharSequence) fibManager.fib(new Request(
						Request.NATIVE_RECURSIVE, n)).toString() );

		output.append("\nNative iterative: "
				+ (CharSequence) fibManager.fib(new Request(
						Request.NATIVE_ITERATIVE, n)).toString() );

	}

}