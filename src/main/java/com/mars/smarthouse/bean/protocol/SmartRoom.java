package com.mars.smarthouse.bean.protocol;

import com.mars.smarthouse.bean.iocd.Machine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/6.
 */
public class SmartRoom {
	private String roomID;
	private String roomName;
	private Map<String, List<SmartMachine>> machines;
	//…Ë±∏
	private List<Machine> machineList;
	private Map<String,Object> personal;

	public SmartRoom(){
		machines = new HashMap<>();
		personal = new HashMap<>();
	}

	public Map<String, List<SmartMachine>> getMachines() {
		return machines;
	}

	public void setMachines(Map<String, List<SmartMachine>> machines) {
		this.machines = machines;
	}

	public Map<String, Object> getPersonal() {
		return personal;
	}

	public void setPersonal(Map<String, Object> personal) {
		this.personal = personal;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public List<Machine> getMachineList() {
		return machineList;
	}

	public void setMachineList(List<Machine> machineList) {
		this.machineList = machineList;
	}
}
