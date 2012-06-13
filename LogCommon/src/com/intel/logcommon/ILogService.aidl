package com.intel.logcommon;

import com.intel.logcommon.LogMessage;

interface ILogService {
	void log(int priority, String tag, String message);
	void loggit(in LogMessage message);
}