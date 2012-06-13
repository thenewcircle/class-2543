package com.intel.fibcommon;

import com.intel.fibcommon.Request;
import com.intel.fibcommon.Response;
import com.intel.fibcommon.IFibListener;

interface IFibService {
	long fibJ(long n);
	long fibJI(long n);
	long fibN(long n);
	long fibNI(long n);
	
	Response fib(in Request request);
	
	oneway void asyncFib(in Request request, IFibListener listener);
}