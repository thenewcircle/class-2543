package com.intel.fibcommon;

import com.intel.fibcommon.Response;

oneway interface IFibListener {
	void onResponse(in Response response);
}