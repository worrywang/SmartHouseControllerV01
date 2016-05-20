package com.mars.smarthouse.bean.protocol;

import com.mars.smarthouse.bean.uibean.Building;
import com.mars.smarthouse.bean.uibean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/9.
 */
public class CommunicationRequest {
	private Building building;
	private List<Person> personList;

	public CommunicationRequest(){
		personList = new ArrayList<>();
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
}
