package com.mars.smarthouse.bean.uibean;

import com.mars.smarthouse.bean.iocd.Device;
import com.mars.smarthouse.bean.iocd.Machine;
import com.mars.smarthouse.bean.protocol.OneClickComfort;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/8.
 */
public class Room {
	private String roomId;
	private Map<String, Device> machineList;
	public Room() {
		machineList = new HashMap<String,Device>();
	}

	private String level;
	private Map<String, Environment> environmentParameters;
	private double comfortableLevel;
	private String controlSuggestions;

	public Map<String, Device> getMachineList() {
		return machineList;
	}
	private OneClickComfort oneClickComfort = null;

	public void setMachineList(Map<String, Device> machineList) {
		this.machineList = machineList;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public double getComfortableLevel() {
		return comfortableLevel;
	}

	public void setComfortableLevel(double comfortableLevel) {
		this.comfortableLevel = comfortableLevel;
	}

	public String getControlSuggestions() {
		return controlSuggestions;
	}

	public void setControlSuggestions(String controlSuggestions) {
		this.controlSuggestions = controlSuggestions;
	}

	public Map<String, Environment> getEnvironmentParameters() {
		if (environmentParameters==null) environmentParameters = new HashMap<>();
		return environmentParameters;
	}

	public void setEnvironmentParameters(Map<String, Environment> environmentParameters) {
		this.environmentParameters = environmentParameters;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public OneClickComfort getOneClickComfort() {
		return oneClickComfort;
	}

	public void setOneClickComfort(OneClickComfort oneClickComfort) {
		this.oneClickComfort = oneClickComfort;
	}
}
