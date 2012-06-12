package com.intel.fibservice;

import android.os.RemoteException;
import com.intel.fibcommon.IFibService;
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

}
