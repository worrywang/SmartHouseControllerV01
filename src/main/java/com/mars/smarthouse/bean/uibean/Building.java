package com.mars.smarthouse.bean.uibean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/8.
 */
public class Building {
	private String buildingId;
	private Map<String,Floor> floor_list;

	public Building(){
		floor_list = new HashMap<String, Floor>();
	}

	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public Map<String, Floor> getFloor_list() {
		return floor_list;
	}
	public void setFloor_list(Map<String, Floor> floor_list) {
		this.floor_list = floor_list;
	}

	public Floor getFloorByID(String id){
		if(floor_list!=null&&floor_list.size()>0){
			for (String key : floor_list.keySet()){
				if(key.equals(id)){
					return floor_list.get(key);
				}
			}
		}
		return null;
	}
}
