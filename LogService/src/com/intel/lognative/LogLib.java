package com.intel.lognative;

public class LogLib {

	// Public Constants
	public static final int DEBUG = 3;
	public static final int WARN = 5;
	public static final int ERROR = 6;

	// API
	public static native void log(int priority, String tag, String message);

	// Load the native library
	static {
		System.loadLibrary("loglib");
	}
}
