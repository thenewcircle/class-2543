package com.intel.fibservice;

import android.os.RemoteException;
import com.intel.fibcommon.IFibService;
import com.intel.fibcommon.Request;
import com.intel.fibcommon.Response;
import com.intel.fibnative.FibLib;

public class IFibServiceImpl extends IFibService.Stub {

	public long fibJ(long n) throws RemoteException {
		return FibLib.fibJ(n);
	}

	public long fibJI(long n) throws RemoteException {
		return FibLib.fibJI(n);
	}

	public long fibN(long n) throws RemoteException {
		return FibLib.fibN(n);
	}

	public long fibNI(long n) throws RemoteException {
		return FibLib.fibNI(n);
	}

	public Response fib(Request request) throws RemoteException {
		Response response = new Response();
		long start = System.currentTimeMillis();

		switch (request.getAlgorithm()) {
		case Request.JAVA_ITERATIVE:
			response.setResult(fibJ(request.getN()));
			break;
		case Request.JAVA_RECURSIVE:
			response.setResult(fibJI(request.getN()));
			break;
		case Request.NATIVE_ITERATIVE:
			response.setResult(fibN(request.getN()));
			break;
		case Request.NATIVE_RECURSIVE:
			response.setResult(fibNI(request.getN()));
			break;
		}

		response.setTime(System.currentTimeMillis() - start);
		return response;
	}

}
