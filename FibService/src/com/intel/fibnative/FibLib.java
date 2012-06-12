package com.intel.fibnative;

public class FibLib {

	// Java recursive version
	public static long fibJ(long n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return fibJ(n-1)+fibJ(n-2);
	}
	
	// Java iterative
	public static long fibJI(long n) {
        long previous = -1;
        long result = 1;
        for (long i = 0; i <= n; i++) {
            long sum = result + previous;
            previous = result;
            result = sum;
        }
        return result;
    }
	
	// Native recursive version
	public static native long fibN(long n);
	
	// Native iterative
	public static native long fibNI(long n);
	
	static {
		System.loadLibrary("fib");
	}
}
