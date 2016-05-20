package com.mars.smarthouse.bean.protocol;

import java.util.Map;

/**
 * Created by Administrator on 2016/5/9.
 */
public class Control {
	private String machineID = null;
	private String machineType = null;
	private Map<String, Object> parameters = null;

	public String getMachineID() {
		return machineID;
	}

	public void setMachineID(String machineID) {
		this.machineID = machineID;
	}

	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
}
