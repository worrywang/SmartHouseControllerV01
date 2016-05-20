package com.mars.smarthouse.constant;

import io.netty.channel.Channel;

/**
 * Created by Administrator on 2016/5/2.
 */
public class Setting {
	public static String ApplicationName = "智能家居系统";
	public static String IndividuationButtonName = "个性化";
	public static String AutoControlButtonName = "智能控制";
	public static String OneButtonForComfortName = "一键舒适";
	public static String FloorInfo_Prefix = "房间信息——";
	public static TimeState currentTimeState = TimeState.DAY;
	public static Channel CHANNEL;


	//img path
	public static String livingroom_img_path ="imgs/livingRoom.png";
	public static String diningroom_img_path = "imgs/diningRoom.png";
	public static String kitchen_img_path = "imgs/kitchen.png";
	public static String bedroom00_img_path = "imgs/bedroom00.png";
	public static String bedroom01_img_path = "imgs/bedroom01.png";
	public static String bathroom00_img_path ="imgs/bathroom00.png";
	public static String bathroom01_img_path = "imgs/bathroom01.png";
	public static String studyroom_img_path = "imgs/studyroom.png";
	public static String hovel_img_path = "imgs/hovel.png";
	public static String garage_img_path = "imgs/garage.png";

	public enum DeviceState {
		ON,OFF,SLEEP,NO,
	}

	public enum TimeState
	{
		DAY, NIGHT,
	}

	public enum InfoLevel{
		TooHigh,High,Moderation,Low,TooLow,
	}

	public enum ComLevel{
		Warning,UnComfort,Comfort,
	}

	//todo : just for test
	public static int count = 1;
	public static int length = 4;
	//netty 相关
	public static int corePoolSize = 5;
	public static int maximumPoolSize = 80;
	public static long keepAliveSecond = 300;
	public static long sleepTime = 100;
	public static int HEAD_LENGTH = 4;

	public static InitConfig.Protocol currentProtocol = InitConfig.Protocol.ALL;
	public static InitConfig.FrameType currentFrameType = InitConfig.FrameType.UserDefine;
	//	public static InitConfig.MsgType currentMsgType = InitConfig.MsgType.Byte;
	public static InitConfig.SerializationType currentSerializationType = InitConfig.SerializationType.PROTOBUF;

	public final static double ComfortableLevel_value = 40.0;
	public final static double UncomfortableLevel_value = 70.0;
	public final static double Step_length = 6.0;
}
