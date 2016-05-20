package com.mars.smarthouse.datacenter.service.reasonUnit;

import com.mars.smarthouse.bean.iocd.Device;
import com.mars.smarthouse.bean.iocd.StateItem;
import com.mars.smarthouse.bean.protocol.Control;
import com.mars.smarthouse.bean.protocol.OneClickComfort;
import com.mars.smarthouse.bean.uibean.Environment;
import com.mars.smarthouse.bean.uibean.Room;
import com.mars.smarthouse.constant.Lexicon;
import com.mars.smarthouse.constant.Setting;
import com.mars.smarthouse.datacenter.service.Retriever;

import java.util.*;

/**
 * Created by ouweilai on 2016/1/14.
 */
public class SmartRoomReasonUnit {
    public void activating(Room smartRoom) {
        smartRoom.setLevel(this.getRoomLevel(smartRoom.getEnvironmentParameters()));
        smartRoom.setComfortableLevel(this.getComfortableLevel(smartRoom));
        smartRoom.setControlSuggestions(this.getControlSuggestions(smartRoom));
    }

    private double getComfortableLevel(Room smartRoom) {
        Double value = 0.0;
        if (smartRoom.getLevel().equals(Lexicon.warning)) {
            value = Setting.UncomfortableLevel_value;
            value += Setting.Step_length * this.statistics(Lexicon.warning, smartRoom.getEnvironmentParameters());
        }
        if (smartRoom.getLevel().equals(Lexicon.uncomfort)) {
            value = Setting.ComfortableLevel_value;
            value += Setting.Step_length * this.statistics(Lexicon.uncomfort, smartRoom.getEnvironmentParameters());
        }
        if (smartRoom.getLevel().equals(Lexicon.comfort)) {
            value += Setting.Step_length * this.statistics(Lexicon.comfort, smartRoom.getEnvironmentParameters());
        }
        return value;
    }

    private int statistics(final String environmentLevel, Map<String, Environment> environmentMap) {
        int counter = 0;
        Iterator iterator = environmentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Environment environment = (Environment) entry.getValue();
            if (environment.getLevel().equals(environmentLevel)) {
                counter++;
            }
        }
        return counter;
    }

    private String getRoomLevel(Map<String, Environment> environmentMap) {
        Iterator iterator = environmentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Environment environment = (Environment) entry.getValue();
            if (environment.getLevel().trim().equals(Lexicon.warning)) {
                return Lexicon.warning;
            }
        }

        iterator = environmentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Environment environment = (Environment) entry.getValue();
            if (environment.getLevel().trim().equals(Lexicon.uncomfort)) {
                return Lexicon.uncomfort;
            }
        }
        return Lexicon.comfort;
    }

    private String getControlSuggestions(Room smartRoom) {
        String result = "";
        if (smartRoom.getLevel().trim().equals(Lexicon.warning) || smartRoom.getLevel().trim().equals(Lexicon.uncomfort)) {
            Map<String, Environment> environmentMap = smartRoom.getEnvironmentParameters();
            List<Control> controlList = new ArrayList<>();
            Retriever retriever = new Retriever();
            Iterator iterator = environmentMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                Environment environment = (Environment) entry.getValue();
                if (environment.getLevel().equals(Lexicon.uncomfort) || environment.getLevel().equals(Lexicon.warning)) {
                    result += environment.getName() + environment.getState();
                    String openMachineName = environment.getName().equals(Lexicon.temperature) && !retriever.findMachineFromSmartRoom(Lexicon.temperatureControl, smartRoom).isEmpty() ?
                            Lexicon.airCondition : environment.getName().equals(Lexicon.humidity) && !retriever.findMachineFromSmartRoom(Lexicon.humidityControl, smartRoom).isEmpty() ?
                            Lexicon.humidifier : (environment.getName().equals(Lexicon.voc) || environment.getName().equals(Lexicon.pm25)) &&
                            !retriever.findMachineFromSmartRoom(Lexicon.airOptimize, smartRoom).isEmpty() ? Lexicon.airCleaner : null;
                    if (openMachineName == null) {
                        //光照
                        String suggestionBulb = null, suggestionElectricCurtains = null;
                        if (environment.getName().equals(Lexicon.light)) {

                            List<Device> machineList = retriever.findMachineFromSmartRoom(Lexicon.lightControl, smartRoom);
                            if (machineList != null) {
                                for (Device machine : machineList) {
                                    List<StateItem> stateItemList = machine.getOutputData().getStates();
                                    if (stateItemList != null) {
                                        for (StateItem stateItem : stateItemList) {
                                            if (machine.getType().equals(Lexicon.bulb) && stateItem.getName().equals(Lexicon.openOrClose) && stateItem.getDescription().equals(Lexicon.close)) {
                                                suggestionBulb = Lexicon.bulb;
                                            }
                                            if (machine.getType().equals(Lexicon.electricCurtains) && stateItem.getName().equals(Lexicon.openOrClose) && stateItem.getDescription().equals(Lexicon.close)) {
                                                suggestionElectricCurtains = Lexicon.electricCurtains;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        openMachineName = "";
//                        openMachineName += suggestionBulb != null ? suggestionBulb : "";
                        openMachineName += suggestionElectricCurtains != null && suggestionBulb != null ? ", " + Lexicon.open + suggestionBulb + Lexicon.or +
                                suggestionElectricCurtains : suggestionElectricCurtains != null ? ", " + Lexicon.open +
                                suggestionElectricCurtains : suggestionBulb != null ? ", " + Lexicon.open + suggestionBulb : "";
                    } else {
                        result += ", " + Lexicon.open;
                    }
                    result += openMachineName + "; ";
                    List<Device> machineList = this.openMachine(entry.getKey().toString(), smartRoom);
                    if (machineList != null && !machineList.isEmpty()) {
                        for (Device machine : machineList) {
                            Map<String, Object> parameters = new HashMap<String,Object>();
                            parameters.put(Lexicon.openOrClose, Lexicon.open);
                            //暂时未设置其他参数，例如将空调调到多少度。需优化
                            Control control = new Control();
                            control.setMachineID(machine.getId());
                            control.setMachineType(machine.getType().toString());
                            control.setParameters(parameters);
                            controlList.add(control);
                        }
                    }
//                    else {
//                        result += Lexicon.no + entry.getKey().toString() + Lexicon.controlMachine + "; ";
//                    }
                }
            }
            OneClickComfort oneClickComfort = new OneClickComfort();
            oneClickComfort.setControlList(controlList);
            smartRoom.setOneClickComfort(oneClickComfort);
            return result.trim();
        }
        return null;
    }

    private List<Device> openMachine(String environmentName, Room smartRoom) {
        Retriever retriever = new Retriever();
        List<Device> machineList = null;
        machineList = environmentName.equals(Lexicon.temperature) ? retriever.findMachineFromSmartRoom(Lexicon.temperatureControl, smartRoom) :
                environmentName.equals(Lexicon.humidity) ? retriever.findMachineFromSmartRoom(Lexicon.humidityControl, smartRoom) :
                        environmentName.equals(Lexicon.pm25) || environmentName.equals(Lexicon.voc) ? retriever.findMachineFromSmartRoom(Lexicon.airOptimize, smartRoom) : null;
        if (machineList == null) {
            if (environmentName.equals(Lexicon.light)) {
                machineList = new ArrayList<>();
                List<Device> machine1List = retriever.findMachineFromSmartRoom(Lexicon.lightControl, smartRoom);
                if (machine1List != null) {
                    for (Device machine : machine1List) {
                        List<StateItem> stateItemList = machine.getOutputData().getStates();
                        if (stateItemList != null) {
                            for (StateItem stateItem : stateItemList) {
                                if (stateItem.getName().equals(Lexicon.openOrClose) && stateItem.getDescription().equals(Lexicon.close)) {
                                    machineList.add(machine);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            for (Device machine : machineList) {
                List<StateItem> stateItemList = machine.getOutputData().getStates();
                if (stateItemList != null) {
                    for (StateItem stateItem : stateItemList) {
                        if (stateItem.getName().equals(Lexicon.openOrClose) && stateItem.getDescription().equals(Lexicon.close)) {
                            machineList.add(machine);
                        }
                    }
                }
            }
        }
        return machineList;
    }
}

