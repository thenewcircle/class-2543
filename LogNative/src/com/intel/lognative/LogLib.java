package com.intel.lognative;

public class LogLib {
	public static native void log(int priority, String tag, String message);
	/* You'll need to load your library here */
}
