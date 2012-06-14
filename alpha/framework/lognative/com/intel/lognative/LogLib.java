package com.intel.lognative;

public class LogLib {

	// API
	public static native void log(int priority, String tag, String message);

	// Load the native library
	static {
		System.loadLibrary("loglib");
	}
}
