package com.intel.lognative;

public class LogLib {
	
	public static final int DEBUG = 3;
	public static final int WARN  = 5;
	public static final int ERROR  = 6;
	
	public static native void log(int priority, String tag, String message);
	
	static {
		System.loadLibrary("loglib");
	}
}
