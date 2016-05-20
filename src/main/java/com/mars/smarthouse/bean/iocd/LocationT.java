package com.mars.smarthouse.bean.iocd;

/**
 * Created by Administrator on 2016/5/7.
 */
public class LocationT {
	private String locationID;
	private float x;
	private float y;
	private float z;

	public LocationT(String locationID, float x, float y, float z) {
		this.locationID = locationID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public LocationT(){}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
}
