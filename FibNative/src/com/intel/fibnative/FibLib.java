package com.intel.fibnative;

public class FibLib {

	// Java recursive version
	public long fibJ(long n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return fibJ(n-1)+fibJ(n-2);
	}
	
	// Native recursive version
	public native long fibN(long n);
}
