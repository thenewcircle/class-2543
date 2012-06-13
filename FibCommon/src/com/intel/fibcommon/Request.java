package com.intel.fibcommon;

import android.os.Parcel;
import android.os.Parcelable;

public class Request implements Parcelable {
	private int algorithm;
	private long n;

	public Request(int algorithm, long n) {
		super();
		this.algorithm = algorithm;
		this.n = n;
	}

	// --- Parcelable methods ---
	public Request(Parcel parcel) {
		this(parcel.readInt(), parcel.readLong());
	}

	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeInt(algorithm);
		parcel.writeLong(n);
	}

	public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator<Request>() {
		public Request createFromParcel(Parcel source) {
			return new Request(source);
		}
		public Request[] newArray(int size) {
			return new Request[size];
		}
	};

	// --- Setters & Getters ---
	public int getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(int algorithm) {
		this.algorithm = algorithm;
	}

	public long getN() {
		return n;
	}

	public void setN(long n) {
		this.n = n;
	}

}
