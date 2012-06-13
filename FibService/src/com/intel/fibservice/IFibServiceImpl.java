package com.intel.fibservice;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;

import com.intel.fibcommon.IFibListener;
import com.intel.fibcommon.IFibService;
import com.intel.fibcommon.Request;
import com.intel.fibcommon.Response;
import com.intel.fibnative.FibLib;

public class IFibServiceImpl extends IFibService.Stub {
	private Context context;

	public IFibServiceImpl(Context context) {
		this.context = context;
	}

	public long fibJ(long n) throws RemoteException {
		if (context
				.checkCallingOrSelfPermission("com.intel.fibservice.PREMIUM_ACCESS") != PackageManager.PERMISSION_GRANTED
				&& n > 30) {
			throw new SecurityException(
					"Need com.intel.fibservice.PREMIUM_ACCESS permission");
		}
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
		case Request.JAVA_RECURSIVE:
			response.setResult(FibLib.fibJ(request.getN()));
			break;
		case Request.JAVA_ITERATIVE:
			response.setResult(fibJI(request.getN()));
			break;
		case Request.NATIVE_RECURSIVE:
			response.setResult(fibN(request.getN()));
			break;
		case Request.NATIVE_ITERATIVE:
			response.setResult(fibNI(request.getN()));
			break;
		}

		response.setTime(System.currentTimeMillis() - start);
		return response;
	}

	public void asyncFib(Request request, IFibListener listener)
			throws RemoteException {
		if (context
				.checkCallingOrSelfPermission("com.intel.fibservice.PREMIUM_ACCESS") != PackageManager.PERMISSION_GRANTED
				&& request.getAlgorithm() == Request.JAVA_RECURSIVE
				&& request.getN() > 30) {
			throw new SecurityException(
					"Need com.intel.fibservice.PREMIUM_ACCESS permission");
		}

		Job job = new Job(request, listener);
		job.start();
		// Response response = fib(request); // potentially long task
		// listener.onResponse(response);

	}

	class Job extends Thread {
		Request request;
		IFibListener listener;

		Job(Request request, IFibListener listener) {
			this.request = request;
			this.listener = listener;
		}

		public void run() {
			try {
				Response response = fib(request); // potentially long task
				listener.onResponse(response);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

	}
}
