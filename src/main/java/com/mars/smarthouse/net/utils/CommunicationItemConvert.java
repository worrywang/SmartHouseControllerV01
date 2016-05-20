package com.mars.smarthouse.net.utils;

import com.mars.smarthouse.bean.iocd.*;
import com.mars.smarthouse.net.decoder.CommInfoProtocol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/7.
 */
public class CommunicationItemConvert {

	public static Machine ProtoDeviceToMachine(CommInfoProtocol.Device device){
		Machine machine = null;
		if(device!=null){
			machine = new Machine();
			if(device.hasMachineID()) machine.setId(device.getMachineID());
			if(device.hasName()) machine.setName(device.getName());
			if(device.hasType()) machine.setType(device.getType());
			///device
			if(device.hasDeployment()){
				if(device.getDeployment().hasLocation()) {
					Deployment deployment = new Deployment();
					LocationT locationT = new LocationT();
					CommInfoProtocol.Location pLocation = device.getDeployment().getLocation();
					locationT.setLocationID(pLocation.getLocationID());
					locationT.setX(pLocation.getX());
					locationT.setY(pLocation.getY());
					locationT.setZ(pLocation.getZ());
					deployment.setLocation(locationT);
					machine.setDeployment(deployment);
				}
			}

			///output
			if(device.hasOutput()){
				CommInfoProtocol.Output protoOutput = device.getOutput();
				Output output = new Output();
				machine.setOutput(output);
				List<CommInfoProtocol.StateItem> protoStates = protoOutput.getStatesList();
				List<CommInfoProtocol.ObservationItem> protoObservations = protoOutput.getObservationsList();
				List<CommInfoProtocol.CommandItem> protoCommands = protoOutput.getCommandsList();
				List<StateItem> states = new ArrayList<>();
				List<ObservationItem> observations = new ArrayList<>();
				List<CommandItem> commands = new ArrayList<>();
				for(CommInfoProtocol.StateItem e:protoStates){
					if (e!=null){
						StateItem item = new StateItem();
						item.setName(e.getName());
						item.setDescription(e.getDescription());
						item.setTime(e.getTime());
						states.add(item);
					}
				}
				output.setStates(states);
				for(CommInfoProtocol.ObservationItem e:protoObservations){
					if (e!=null){
						ObservationItem item = new ObservationItem();
						item.setName(e.getName());
						item.setValue(e.getValue());
						item.setUnit(e.getUnit());
						item.setTime(e.getTime());
						observations.add(item);
					}
				}
				output.setObservations(observations);
				for (CommInfoProtocol.CommandItem e:protoCommands){
					if (e!=null){
						CommandItem item = new CommandItem();
						item.setName(e.getName());
						item.setMethod(e.getMethod());
						item.setUrl(e.getUrl());
						item.setParameters(ProtoParameterToParameters(e.getParametersList()));
						commands.add(item);
					}
				}
				output.setCommands(commands);
			}

			///input
			if(device.hasInput()){
				List<CommInfoProtocol.InputItem> protoInputs = device.getInput().getInputItemListList();
				List<InputItem> inputItems = new ArrayList<>();
				for (CommInfoProtocol.InputItem e:protoInputs){
					InputItem item = ProtoInputItemToInputItem(e);
					if (item!=null) inputItems.add(item);
				}
				machine.setInput(new Input());
				machine.getInput().setInputItemList(inputItems);
			}

			///capability
			if(device.hasCapability()){
//				CommInfoProtocol.ControlCapability controlCapability = device.getCapability().getControlCapabilityList();
			}
		}
		return machine;
	}


//	public static SmartMachine ProtoSmartDeviceToSmartMachine(){
//
//	}
//
//	public static CommInfoProtocol.SmartDevice SmartMachineToProtoSmartDevice(){
//
//	}

	public static Map<String,Object> ProtoParameterToParameters(List<CommInfoProtocol.Parameter> parameter){
		Map<String,Object> result = null;
		if(parameter!=null&&parameter.size()>0){
			result = new HashMap<>();
			for (CommInfoProtocol.Parameter e:parameter){
				if(e!=null) {
					result.put(e.getName(), e.getValue());
				}
			}

		}
		return result;
	}

	public static List<CommInfoProtocol.Parameter> ParameterToProtoParameter(Map<String,Object> parameter){
		List<CommInfoProtocol.Parameter> result = null;
		if(parameter!=null&&parameter.size()>0){
			result = new ArrayList<>();
			for (String key:parameter.keySet()){
				CommInfoProtocol.Parameter.Builder builder = CommInfoProtocol.Parameter.newBuilder();
				builder.setName(key);
				builder.setValue(parameter.get(key).toString());
				result.add(builder.build());
			}
		}
		return  result;
	}

	public static InputItem ProtoInputItemToInputItem(CommInfoProtocol.InputItem item){
		InputItem result  = null;
		if(item!=null){
			result = new InputItem();
			result.setName(item.getName());
			result.setCommandItem(ProtoCommandItemToCommandItem(item.getCommandItem()));
		}
		return result;
	}

	public static CommInfoProtocol.InputItem InputItemToProtoInputItem(InputItem item){
		CommInfoProtocol.InputItem.Builder builder = CommInfoProtocol.InputItem.newBuilder();
		if(item!=null){
			builder.setName(item.getName());
			builder.setCommandItem(CommandItemToProtoCommandItem(item.getCommandItem()));
		}
		return builder.build();
	}

	public static StateItem ProtoStateItemToStateItem(CommInfoProtocol.StateItem item){
		StateItem result  =null;
		if (item!=null){
			result = new StateItem();
			result.setName(item.getName());
			result.setDescription(item.getDescription());
			result.setTime(item.getTime());
		}
		return  result;
	}

	public static CommInfoProtocol.StateItem StateItemToProtoStateItem(StateItem item){
		CommInfoProtocol.StateItem.Builder builder = CommInfoProtocol.StateItem.newBuilder();
		if(item!=null){
			builder.setName(item.getName());
			builder.setDescription(item.getDescription());
			builder.setTime(item.getTime());
		}
		return builder.build();
	}

	public static CommandItem ProtoCommandItemToCommandItem(CommInfoProtocol.CommandItem item){
		CommandItem result = null;
		if (item!=null){
			result = new CommandItem();
			result.setName(item.getName());
			result.setMethod(item.getMethod());
			result.setUrl(item.getUrl());
			result.setParameters(ProtoParameterToParameters(item.getParametersList()));
		}

		return result;
	}

	public static CommInfoProtocol.CommandItem CommandItemToProtoCommandItem(CommandItem item){
		CommInfoProtocol.CommandItem.Builder builder = CommInfoProtocol.CommandItem.newBuilder();
		if(item!=null){
			builder.setName(item.getName());
			builder.setMethod(item.getMethod());
			builder.setUrl(item.getUrl());
			List<CommInfoProtocol.Parameter> parameters = ParameterToProtoParameter(item.getParameters());
			for(CommInfoProtocol.Parameter p:parameters){
				builder.addParameters(p);
			}
		}
		return builder.build();
	}
}


