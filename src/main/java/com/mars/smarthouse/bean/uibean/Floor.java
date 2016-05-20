package com.mars.smarthouse.bean.uibean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/8.
 */
public class Floor {
	private String floorId;
	private Map<String,Room> roomList;

	public Floor(){
		roomList = new HashMap<String, Room>();
	}

	public String getFloorId() {
		return floorId;
	}
	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}
	public Map<String, Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(Map<String, Room> roomList) {
		this.roomList = roomList;
	}
}
