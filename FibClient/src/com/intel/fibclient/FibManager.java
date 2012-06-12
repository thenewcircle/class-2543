package com.intel.fibclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.intel.fibcommon.IFibService;

public class FibManager {
	private static final Intent INTENT = new Intent(
			"com.intel.fibcommon.IFibService");
	private IFibService fibService;
	
	public FibManager(Context context) {
		// Bind to the remote service
		boolean bindSuccessful = context.bindService(INTENT,
				new FibServiceConnection(), Context.BIND_AUTO_CREATE);

		Log.d("FibActivity", "bindSuccessful: " + bindSuccessful);
	}
	
	// Proxy calls
	public long fibJ(long n) {
		try {
			return fibService.fibJ(n);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public long fibJI(long n) {
		try {
			return fibService.fibJI(n);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public long fibN(long n) {
		try {
			return fibService.fibN(n);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public long fibNI(long n) {
		try {
			return fibService.fibNI(n);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return -1;
	}

	
	/** Handles callbacks from bind to service. */
	class FibServiceConnection implements ServiceConnection {

		public void onServiceConnected(ComponentName name, IBinder binder) {
			fibService = IFibService.Stub.asInterface(binder);
		}

		public void onServiceDisconnected(ComponentName name) {
			fibService = null;
		}

	}

}
