package com.mars.smarthouse.datacenter.service;

import com.mars.smarthouse.bean.iocd.Device;
import com.mars.smarthouse.bean.iocd.Machine;
import com.mars.smarthouse.bean.protocol.SmartMachine;
import com.mars.smarthouse.bean.uibean.Environment;
import com.mars.smarthouse.bean.uibean.Room;
import com.mars.smarthouse.constant.Lexicon;
import com.mars.smarthouse.datacenter.service.reasonUnit.*;
import com.mars.smarthouse.utils.ObjectFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/9.
 */
public class ReasonEngine {

	public List<Device> getCurrentDeviceType(String type,List<Device> devices){
		List<Device> result = new ArrayList<>();
		if(devices!=null&&devices.size()>0){
			for (Device d:devices){
				if (d!=null&&d.getType().toString().equals(type)){
					result.add(d);
				}
			}
		}
		return result;
	}
	public void reasoning(Room room) {

		Map<String, Device> deviceMap = room.getMachineList();
		List<Device> devices = new ArrayList<>(deviceMap.values());
		List<Device> tempDevices;
		//tempsensor
		tempDevices = getCurrentDeviceType(Lexicon.temperatureSensor,devices);
		if(tempDevices!=null&&tempDevices.size()>0){
			UnitReasonResult unitReasonResult = getEnvironmentState(Lexicon.temperatureSensor, tempDevices);
			if (unitReasonResult!=null ){
				Environment environment = new Environment();
				environment.setName(Lexicon.temperatureSensor);
				environment.setState(unitReasonResult.getState());
				environment.setWave(unitReasonResult.getWave());
				environment.setComfortableLevel(unitReasonResult.getComfortableLevel());
				environment.setLevel(unitReasonResult.getLevel());
				room.getEnvironmentParameters().put(environment.getName(), environment);
			}
		}
		//humsensor
		tempDevices = getCurrentDeviceType(Lexicon.humiditySensor,devices);
		if(tempDevices!=null&&tempDevices.size()>0){
			UnitReasonResult unitReasonResult = getEnvironmentState(Lexicon.humiditySensor, tempDevices);
			if (unitReasonResult!=null ){
				Environment environment = new Environment();
				environment.setName(Lexicon.humiditySensor);
				environment.setState(unitReasonResult.getState());
				environment.setWave(unitReasonResult.getWave());
				environment.setComfortableLevel(unitReasonResult.getComfortableLevel());
				environment.setLevel(unitReasonResult.getLevel());
				room.getEnvironmentParameters().put(environment.getName(), environment);
			}
		}
		//lightsensor
		tempDevices = getCurrentDeviceType(Lexicon.lightSensor,devices);
		if(tempDevices!=null&&tempDevices.size()>0){
			UnitReasonResult unitReasonResult = getEnvironmentState(Lexicon.lightSensor, tempDevices);
			if (unitReasonResult!=null ){
				Environment environment = new Environment();
				environment.setName(Lexicon.lightSensor);
				environment.setState(unitReasonResult.getState());
				environment.setWave(unitReasonResult.getWave());
				environment.setComfortableLevel(unitReasonResult.getComfortableLevel());
				environment.setLevel(unitReasonResult.getLevel());
				room.getEnvironmentParameters().put(environment.getName(), environment);
			}
		}
		//vocsensor
		tempDevices = getCurrentDeviceType(Lexicon.vocSensor,devices);
		if(tempDevices!=null&&tempDevices.size()>0){
			UnitReasonResult unitReasonResult = getEnvironmentState(Lexicon.vocSensor, tempDevices);
			if (unitReasonResult!=null ){
				Environment environment = new Environment();
				environment.setName(Lexicon.vocSensor);
				environment.setState(unitReasonResult.getState());
				environment.setWave(unitReasonResult.getWave());
				environment.setComfortableLevel(unitReasonResult.getComfortableLevel());
				environment.setLevel(unitReasonResult.getLevel());
				room.getEnvironmentParameters().put(environment.getName(), environment);
			}
		}

		//对房间进行推理
		SmartRoomReasonUnit smartRoomReasonUnit = new SmartRoomReasonUnit();
		smartRoomReasonUnit.activating(room);
	}

	private UnitReasonResult getEnvironmentState(final String type, List<Device> deviceList) {
		ReasonUnit reasonUnit = null;
		if (type.equals(Lexicon.temperatureSensor)) {
			reasonUnit = ObjectFactory.createInstance(TemperatureReasonUnit.class);
		}
		if (type.equals(Lexicon.humiditySensor)) {
			reasonUnit = ObjectFactory.createInstance(HumidityReasonUnit.class);
		}
		if (type.equals(Lexicon.lightSensor)) {
			reasonUnit = ObjectFactory.createInstance(LightReasonUnit.class);
		}
		if (type.equals(Lexicon.vocSensor)) {
			reasonUnit = ObjectFactory.createInstance(VocReasonUnit.class);
		}
		if (type.equals(Lexicon.pm25Sensor)) {
			reasonUnit = ObjectFactory.createInstance(PM25ReasonUnit.class);
		}
		return reasonUnit == null ? null : reasonUnit.activating(deviceList);
	}

}
