package com.mars.smarthouse.datacenter.service;

import com.mars.smarthouse.bean.iocd.CommunicationCapability;
import com.mars.smarthouse.bean.iocd.ControlCapability;
import com.mars.smarthouse.bean.iocd.Device;
import com.mars.smarthouse.bean.iocd.MeasurementCapability;
import com.mars.smarthouse.bean.uibean.Room;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/9.
 */
public class Retriever {
	public List<Device> findMachineFromSmartRoom(final String capability, Room smartRoom) {
		List<Device> resultMachineList = new ArrayList<Device>();
		Map<String,Device> machineMap = smartRoom.getMachineList();
		resultMachineList = new ArrayList<>(machineMap.values());
//		Iterator iterator = machineMap.entrySet().iterator();
//		while (iterator.hasNext()) {
//			Map.Entry entry = (Map.Entry) iterator.next();
//			List<Device> smartMachineList = (List<Device>) entry.getValue();
//			List<Device> machineList = findMachineFromSmartMachineList(capability, smartMachineList);
//			if (machineList != null) {
//				resultMachineList.addAll(machineList);
//			}
//		}
		return resultMachineList;
	}

	public List<Device> findMachineFromSmartMachineList(final String capability, List<Device> smartMachineList) {
		List<Device> machineList = new ArrayList<Device>();
		if (smartMachineList != null) {
			for (Device device : smartMachineList) {
				if (device.getCapability()!=null) {
					List<ControlCapability> controlCapabilityList = device.getCapability().getControlCapability();
					List<MeasurementCapability> measurementCapabilityList = device.getCapability().getMeasurementCapability();
					List<CommunicationCapability> communicationCapabilityList = device.getCapability().getCommunicationCapability();
					if (this.hasThisCapability(capability, controlCapabilityList, measurementCapabilityList, communicationCapabilityList)) {
						machineList.add(device);
					}
				}
			}
			return machineList;
		}
		return null;
	}

	public boolean hasThisCapability(final String capability, List<ControlCapability> controlCapabilityList, List<MeasurementCapability> measurementCapabilityList, List<CommunicationCapability> communicationCapabilityList) {

		if (controlCapabilityList != null) {
			for (ControlCapability controlCapability : controlCapabilityList) {
				if (controlCapability.getName().equals(capability)) {
					return true;
				}
			}
		}
		if (measurementCapabilityList != null) {
			for (MeasurementCapability measurementCapability : measurementCapabilityList) {
				if (measurementCapability.getName().equals(capability)) {
					return true;
				}
			}
		}
		if (communicationCapabilityList != null) {
			for (CommunicationCapability communicationCapability : communicationCapabilityList) {
				if (communicationCapability.getName().equals(capability)) {
					return true;
				}
			}
		}
		return false;
	}

	public Device findMachineByIDFromSmartRoom(final String machineID, Room smartRoom) {
		List<Device> deviceList = new ArrayList<Device>(smartRoom.getMachineList().values());
		if (deviceList != null) {
				for (Device device : deviceList) {
					if (device.getId().equals(machineID)) {
						return device;
					}
				}

		}
		return null;
	}

//	public List<Device> findRelativeMachineByIDFromSmartRoom(final String machineID, List<Room> smartRoomList) {
//		for (Room smartRoom : smartRoomList) {
//			List<List<SmartMachine>> smartMachineList = new ArrayList<List<SmartMachine>>(smartRoom.getMachines().values());
//			if (smartMachineList != null) {
//				for (List<SmartMachine> childSmartMachineList : smartMachineList) {
//					for (SmartMachine smartMachine : childSmartMachineList) {
//						String id=smartMachine.getMachine().getMachineID();
//						if (smartMachine.getMachine().getMachineID().equals(machineID)) {
//							return smartMachine.getMachineList();
//						}
//					}
//				}
//			}
//		}
//		return null;
//	}
}
