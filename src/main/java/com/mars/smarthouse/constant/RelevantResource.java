package com.mars.smarthouse.constant;

import com.mars.smarthouse.ui.subpanel.unit.RoomIcon;

/**
 * Created by Administrator on 2016/5/4.
 */
public class RelevantResource {
	public static RoomIcon[] floor_1_room={
			new RoomIcon("livingroom", 512/851.0, 22/694.0, (834-512)/851.0, (262-22)/694.0),
			new RoomIcon("kitchen",  38/851.0, 134/694.0, (204-38)/851.0, (380-134)/694.0),
			new RoomIcon("diningroom",204/851.0, 108/694.0, (510-204)/851.0, (374-108)/694.0),
			new RoomIcon("garage",520/851.0, 268/694.0, (834-520)/851.0, (686-268)/694.0)
	};

	public static RoomIcon[] floor_2_room={
			new RoomIcon("bedroom00",510/851.0, 305/694.0, (822-510)/851.0, (664-305)/694.0),
			new RoomIcon("bedroom01",50/851.0, 384/694.0, (248-50)/851.0, (620-384)/694.0),
			new RoomIcon("bathroom00", 560/851.0, 80/694.0, (820-560)/851.0, (298-80)/694.0),
			new RoomIcon("bathroom01",252/851.0, 380/694.0, (346-252)/851.0, (610-380)/694.0),
			new RoomIcon("studyroom",258/851.0, 158/694.0, (548-258)/851.0, (298-158)/694.0),
			new RoomIcon("hovel",45/851.0, 158/694.0, (252-45)/851.0, (298-158)/694.0)
	};

	public static String living_room = "livingroom";
	public static String kitchen = "kitchen";
	public static String dining_room = "diningroom";
	public static String garage  = "garage";
	public static String study_room="studyroom";
	public static String bathroom00="bathroom00";
	public static String bathroom01="bathroom01";
	public static String bedroom00="bedroom00";
	public static String bedroom01="bedroom01";
	public static String hovel="hovel";
	public static String corridor00 = "corridor00";
	public static String corridor01 = "corridor01";
	public static String entertainment_room = "warehouse";
	public static String information_box_id = "information_show_vbox";

	public static String corridor_tag = "corridor";
	public static String garage_tag = "garage";

	public static String ROOM_SECURITY = "Security";
	public static String ROOM_WARNING = "Warning";
	public static String ROOM_UNSECURITY = "Unsecurity";
	public static String ROOM_OTHER = "NoInformation";

	public static String level_0="labelGreen";
	public static String level_1="labelOrange";
	public static String level_2="labelBlue";
	public static String level_3="labelRed";
	public static String level_temp= "label4";

	public static String floor01_name = "Floor-1";
	public static String floor02_name = "Floor-2";



	public enum DeviceType{    //监控设备
		Temp, Humidity, Light, Voc, MonitorRFID,MonitorCar,
		//控制设备
		AC, Curtain, Bulb, Fridge, Display,Door,}

	public static String convertName(String roomName){
		String result = null;
		if(roomName.equals(RelevantResource.living_room)){
			result = "客厅";
		}else if(roomName.equals(RelevantResource.kitchen)){
			result = "厨房";
		}else if (roomName.equals(RelevantResource.dining_room)){
			result = "餐厅";
		}else if (roomName.equals(RelevantResource.garage)){
			result = "车库";
		}else if(roomName.equals(RelevantResource.study_room)){
			result = "书房";
		}else if (roomName.equals(RelevantResource.bathroom00)){
			result = "洗手间00";
		}else if (roomName.equals(RelevantResource.bathroom01)){
			result = "洗手间01";
		}else if (roomName.equals(RelevantResource.bedroom00)){
			result = "卧室00";
		}else if (roomName.equals(RelevantResource.bedroom01)){
			result = "卧室01";
		}else if (roomName.equals(RelevantResource.hovel)){
			result = "储物室";
		}
		return result;
	}
}
