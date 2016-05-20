package com.mars.smarthouse.datacenter;

import com.mars.smarthouse.bean.uibean.Building;
import com.mars.smarthouse.bean.uibean.Floor;
import com.mars.smarthouse.bean.uibean.Room;
import com.mars.smarthouse.datacenter.service.ReasonEngine;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.*;

/**
 * Created by Administrator on 2016/5/4.
 */
public class MainPad {
	//界面监听
	private BooleanProperty streetRootMonitor = new SimpleBooleanProperty();
	private BooleanProperty logMsgMonitor = new SimpleBooleanProperty();
	private BooleanProperty floorChangeMonitor = new SimpleBooleanProperty();
	private BooleanProperty roomChangeMonitor = new SimpleBooleanProperty();
	private BooleanProperty autoControlMonitor = new SimpleBooleanProperty();
	//后台数据
	private Building building;
	private static Map<String,Room> dataBuffer = new HashMap<>();



	public void setBuilding(Building building) {
		this.building = building;
	}

	public void startReasoning(){
		ReasonEngine reasonEngine = new ReasonEngine();
		Iterator iterator = dataBuffer.entrySet().iterator();
		while (iterator.hasNext()){
			Map.Entry entry = (Map.Entry) iterator.next();
			Room room = (Room) entry.getValue();
			reasonEngine.reasoning(room);
		}
	}

	///更新房间列表
	public void UpdateDataBuffer(){
		if (building!=null&&building.getFloor_list()!=null&&building.getFloor_list().size()>0){
			dataBuffer.clear();
			for(String id : building.getFloor_list().keySet()){
				Floor floor = building.getFloor_list().get(id);
				if(floor!=null&&floor.getRoomList()!=null&&floor.getRoomList().size()>0){
					for (String roomID: floor.getRoomList().keySet()){
						Room room = floor.getRoomList().get(roomID);
						dataBuffer.put(roomID,room);
					}
				}
			}
		}
	}


	public final boolean getStreetRootMonitor() {
		return streetRootMonitor.get();
	}

	public final void setStreetRootMonitor(boolean value) {
		streetRootMonitor.set(value);
	}

	public BooleanProperty streetRootMonitorProperty() {
		return streetRootMonitor;
	}

	public final boolean getLogMsgMonitor(){
		return logMsgMonitor.get();
	}
	public final void setLogMsgMonitor(boolean value){
		logMsgMonitor.set(value);
	}
	public BooleanProperty logMsgMonitorProperty(){
		return logMsgMonitor;
	}

	public final boolean getFloorChangeMonitor(){
		return floorChangeMonitor.get();
	}
	public final void setFloorChangeMonitor(boolean value){
		floorChangeMonitor.set(value);
	}
	public BooleanProperty floorChangeMonitorProperty(){
		return floorChangeMonitor;
	}

	public final boolean getRoomChangeMonitor(){
		return roomChangeMonitor.get();
	}
	public final void setRoomChangeMonitor(boolean value){
		roomChangeMonitor.set(value);
	}
	public BooleanProperty roomChangeMonitorProperty(){
		return roomChangeMonitor;
	}

	public final boolean getAutoControlMonitor(){
		return autoControlMonitor.get();
	}
	public final void setAutoControlMonitor(boolean value){
		autoControlMonitor.set(value);
	}
	public BooleanProperty autoControlMonitorProperty(){
		return autoControlMonitor;
	}

	public Building getBuilding() {
		return building;
	}


}
