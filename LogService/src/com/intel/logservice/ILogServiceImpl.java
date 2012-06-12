package com.intel.logservice;

import android.os.RemoteException;
import com.intel.logcommon.ILogService;
import com.intel.lognative.LogLib;

public class ILogServiceImpl extends ILogService.Stub {

	public void log(int priority, String tag, String message)
			throws RemoteException {
		LogLib.log(priority, tag, message);
	}

}
