package com.intel.fibcommon;

import android.os.Parcel;
import android.os.Parcelable;

public class Response implements Parcelable {
	private long result; // 1
	private long time;	// 2
	
	public Response(long result, long time) {
		super();
		this.result = result;
		this.time = time;
	}
	
	// --- Parcelable methods ---
	public Response(Parcel parcel) {
		this( parcel.readLong(), parcel.readLong() );
	}
	
	public int describeContents() {
		return 0;
	}
	
	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeLong(result);
		parcel.writeLong(time);
	}
	
	public static final Parcelable.Creator<Response> CREATOR = new Parcelable.Creator<Response>() {
		public Response createFromParcel(Parcel parcel) {
			return new Response(parcel);
		}
		public Response[] newArray(int size) {
			return new Response[size];
		}
	};
	
	// --- Setters & Getters ---
	public long getResult() {
		return result;
	}
	public void setResult(long result) {
		this.result = result;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}

	
	
}
