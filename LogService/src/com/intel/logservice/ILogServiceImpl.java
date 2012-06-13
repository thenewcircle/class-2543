package com.intel.logservice;

import android.os.RemoteException;
import com.intel.logcommon.ILogService;
import com.intel.logcommon.LogMessage;
import com.intel.lognative.LogLib;

public class ILogServiceImpl extends ILogService.Stub {

	public void log(int priority, String tag, String message)
			throws RemoteException {
		LogLib.log(priority, tag, message);
	}

	public void loggit(LogMessage message) throws RemoteException {
		LogLib.log(message.getPriority(), message.getTag(),
				message.getMessage());
	}
}
