package com.mars.smarthouse.constant;

import com.mars.smarthouse.bean.Language;
/**
 * Created by Administrator on 2016/5/9.
 */
public class Lexicon {
	//floor id
	public final static String floor = "/floor";
	//room id
	public final static String living_room_id = new Language(floor + "/living_room", "客厅").get();
	public final static String bedroom_id = new Language(floor + "/bedroom", "卧室").get();
	public final static String toilet_id = new Language(floor + "/toilet", "卫生间").get();
	public final static String kitchen_id = new Language(floor + "/kitchen", "厨房").get();
	//room name
	public final static String living_room_name = new Language("living room", "客厅").get();
	public final static String bedroom_name = new Language("bedroom", "卧室").get();
	public final static String toilet_name = new Language("toilet", "卫生间").get();
	public final static String kitchen_name = new Language("kitchen", "厨房").get();
	//device
	public final static String temperatureSensor = new Language("Temp", "温度传感器").get();
	public final static String humiditySensor = new Language("Humidity", "湿度传感器").get();
	public final static String lightSensor = new Language("Light", "光照传感器").get();
	public final static String vocSensor = new Language("Voc", "Voc探测器").get();
	public final static String pm25Sensor = new Language("Pm2.5 sensor", "pm2.5探测器").get();
	public final static String bulb = new Language("Bulb", "灯").get();
	public final static String airCleaner = new Language("air cleaner", "空气净化器").get();
	public final static String humidifier = new Language("humidifier", "加湿器").get();
	public final static String electricCurtains = new Language("Curtain", "电动窗帘").get();
	public final static String airCondition = new Language("AC", "空调").get();

	//device id
	public final static String temperatureSensorIdPrefix = new Language("TS", "TS").get();
	public final static String humiditySensorIdPrefix = new Language("HS", "HS").get();
	public final static String lightSensorIdPrefix = new Language("LS", "LS").get();
	public final static String vocSensorIdPrefix = new Language("VS", "VS").get();
	public final static String pm25SensorIdPrefix = new Language("PS", "PS").get();
	public final static String bulbIdPrefix = new Language("B", "B").get();
	public final static String airCleanerIdPrefix = new Language("CL", "CL").get();
	public final static String humidifierIdPrefix = new Language("H", "H").get();
	public final static String electricCurtainsIdPrefix = new Language("EC", "EC").get();
	public final static String airConditionIdPrefix = new Language("AC", "AC").get();

	public final static String temperature = new Language("Temp", "温度").get();
	public final static String humidity = new Language("Humidity", "湿度").get();
	public final static String light = new Language("Light", "光照").get();
	public final static String voc = new Language("Voc", "voc").get();
	public final static String pm25 = new Language("Pm2.5", "pm2.5").get();

	//sensor measure level
	public final static String veryLow = new Language("very low", "很低").get();
	public final static String low = new Language("low", "低").get();
	public final static String moderation = new Language("moderation", "适中").get();
	//    public final static String littleHigh = new Language("little high", "偏高").get();
	public final static String high = new Language("high", "偏高").get();
	public final static String veryHigh = new Language("very high", "很高").get();

	//environment level
	public final static String freezing = new Language("freezing", "过冷").get();
	public final static String cold = new Language("cold", "冷").get();
	public final static String normal = new Language("normal", "正常").get();
	public final static String burning = new Language("burning", "热").get();
	public final static String very_burning = new Language("very burning", "过热").get();
	public final static String very_dry = new Language("very dry", "过干").get();
	public final static String dry = new Language("dry", "干").get();
	public final static String moist = new Language("Moist", "潮湿").get();
	public final static String very_moist = new Language("very moist", "过湿").get();
	public final static String dark = new Language("dark", "黑暗").get();
	public final static String dim = new Language("dim", "昏暗").get();
	public final static String glare = new Language("glare", "明亮").get();
	public final static String very_glare = new Language("very glare", "过亮").get();

	//wave level
	public final static String big = new Language("big", "不稳定").get();
	public final static String steady = new Language("steady", "稳定").get();

	//room level
	public final static String comfort = new Language("comfort", "舒适").get();
	public final static String uncomfort = new Language("uncomfort", "不舒适").get();
	public final static String warning = new Language("warning", "警告").get();

	//UI static data
	public final static String comfortable_level = new Language("comfortable level", "舒适度").get();


	//state
	public final static String refrigeration = new Language("refrigeration", "制冷").get();
	public final static String heating = new Language("heating", "制热").get();
	public final static String open = new Language("open", "开").get();
	public final static String close = new Language("close", "关").get();
	public final static String openOrClose = new Language("state", "状态").get();
	public final static String refrigerationOrHeating = new Language("refrigeration or heating", "制冷制热").get();


	//session title
	public final static String sessionTitleId = new Language("ID", "ID").get();
	public final static String sessionTitlePosition = new Language("position", "位置").get();
	public final static String sessionTitleCapability = new Language("capability", "能力").get();
	public final static String sessionTitleName = new Language("name", "名称").get();
	public final static String sessionTitleSet_read = new Language("set or read", "设置/读数").get();
	public final static String sessionTitleState = new Language("state", "状态").get();
	public final static String sessionTitleCollectionPeriod = new Language("collection period", "采集周期").get();


	//capability name
	public final static String measureTemperature = new Language("measure temperature", "T传感").get();
	public final static String measureHumidity = new Language("measure humidity", "H传感").get();
	public final static String measureLight = new Language("measure light", "L传感").get();
	public final static String measureVoc = new Language("measure voc", "V传感").get();
	public final static String measurePM25 = new Language("measure pm2.5", "P传感").get();
	public final static String temperatureControl = new Language("temperature control", "温控").get();
	public final static String lightControl = new Language("light control", "光控").get();
	public final static String humidityControl = new Language("humidity control", "湿控").get();
	public final static String airOptimize = new Language("air optimize", "净化").get();


	//conjunction
	public final static String or = new Language("or", "或").get();
	public final static String and = new Language("and", "和").get();
	public final static String but = new Language("but", "但是").get();

	public final static String controlMachine = new Language("control machine", "调控设备").get();
	public final static String no = new Language("no", "没有").get();


	//
	public final static String comfortDescription = new Language("Comfort Description", "舒适度").get();


	//time frame
	public final static String lateAtNight = new Language("late at night", "深夜").get();
	public final static String activityTime = new Language("activity time", "活动时间").get();


	// advertisement
	public final static String information = new Language("Address ：No.2305, Building 9, Hongfengling(Phase 3), Chenghua District, Chengdu, Sichuan\n" +
			"Customer Services Hotline ： air conditioning maintenance 6896325   air cleaner  maintenance 6545632", "住址：四川省成都市成华区红枫岭三期9栋2305号\n" +
			"  维修电话：空调维修6896325    空气净化器维修6545632").get();
	public final static String ad = new Language("Smart Home. Intelligent Living. Smart Home. Better Life.", "@ 智能家居，让生活更美好！@").get();

}
