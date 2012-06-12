package com.intel.logclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.intel.logcommon.ILogService;

public class LogManager {

	// Public Constants
	public static final int DEBUG = 3;
	public static final int WARN = 5;
	public static final int ERROR = 6;


	private static final String TAG = LogManager.class.getSimpleName();
	private static final Intent INTENT = new Intent("com.intel.logcommon.ILogService");
	private ILogService logService;
	
	public LogManager(Context context) {
		context.bindService(INTENT, new ServiceConnection() {

			public void onServiceConnected(ComponentName name, IBinder binder) {
				logService = ILogService.Stub.asInterface(binder);
			}

			public void onServiceDisconnected(ComponentName name) {
				logService = null;
			}
			
		}, Context.BIND_AUTO_CREATE);
	}
	
	/** Proxy call to service. */
	public void log(int priority, String tag, String message) {
		if(logService!=null) {
			try {
				logService.log(priority, tag, message);
			} catch (RemoteException e) {
				Log.e(TAG, "Can't log!", e);
			}
		}
	}
}
