package com.mars.smarthouse.bean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Administrator on 2016/5/2.
 */
public class DeviceInfoItem {
	private StringProperty deviceId;
	private StringProperty devicePosition;
	private StringProperty deviceCapability;
	private StringProperty deviceName;
	private StringProperty deviceValue;
	private StringProperty deviceState;
	private StringProperty devicePeriod;

	public DeviceInfoItem(String deviceId,String devicePosition,String deviceCapability,String deviceName,String deviceValue,String deviceState,String devicePeriod){
		this.deviceId = new SimpleStringProperty(deviceId);
		this.devicePosition = new SimpleStringProperty(devicePosition);
		this.deviceCapability = new SimpleStringProperty(deviceCapability);
		this.deviceName = new SimpleStringProperty(deviceName);
		this.deviceValue = new SimpleStringProperty(deviceValue);
		this.deviceState = new SimpleStringProperty(deviceState);
		this.devicePeriod = new SimpleStringProperty(devicePeriod);
	}

	public String getDeviceCapability() {
		return deviceCapability.get();
	}

	public StringProperty deviceCapabilityProperty() {
		return deviceCapability;
	}

	public String getDeviceId() {
		return deviceId.get();
	}

	public StringProperty deviceIdProperty() {
		return deviceId;
	}

	public String getDeviceName() {
		return deviceName.get();
	}

	public StringProperty deviceNameProperty() {
		return deviceName;
	}

	public String getDevicePeriod() {
		return devicePeriod.get();
	}

	public StringProperty devicePeriodProperty() {
		return devicePeriod;
	}

	public String getDevicePosition() {
		return devicePosition.get();
	}

	public StringProperty devicePositionProperty() {
		return devicePosition;
	}

	public String getDeviceState() {
		return deviceState.get();
	}

	public StringProperty deviceStateProperty() {
		return deviceState;
	}

	public String getDeviceValue() {
		return deviceValue.get();
	}

	public StringProperty deviceValueProperty() {
		return deviceValue;
	}
}
