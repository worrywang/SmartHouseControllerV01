package com.mars.smarthouse.constant;

import com.mars.smarthouse.bean.Language;
/**
 * Created by Administrator on 2016/5/9.
 */
public class Lexicon {
	//floor id
	public final static String floor = "/floor";
	//room id
	public final static String living_room_id = new Language(floor + "/living_room", "����").get();
	public final static String bedroom_id = new Language(floor + "/bedroom", "����").get();
	public final static String toilet_id = new Language(floor + "/toilet", "������").get();
	public final static String kitchen_id = new Language(floor + "/kitchen", "����").get();
	//room name
	public final static String living_room_name = new Language("living room", "����").get();
	public final static String bedroom_name = new Language("bedroom", "����").get();
	public final static String toilet_name = new Language("toilet", "������").get();
	public final static String kitchen_name = new Language("kitchen", "����").get();
	//device
	public final static String temperatureSensor = new Language("Temp", "�¶ȴ�����").get();
	public final static String humiditySensor = new Language("Humidity", "ʪ�ȴ�����").get();
	public final static String lightSensor = new Language("Light", "���մ�����").get();
	public final static String vocSensor = new Language("Voc", "Voc̽����").get();
	public final static String pm25Sensor = new Language("Pm2.5 sensor", "pm2.5̽����").get();
	public final static String bulb = new Language("Bulb", "��").get();
	public final static String airCleaner = new Language("air cleaner", "����������").get();
	public final static String humidifier = new Language("humidifier", "��ʪ��").get();
	public final static String electricCurtains = new Language("Curtain", "�綯����").get();
	public final static String airCondition = new Language("AC", "�յ�").get();

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

	public final static String temperature = new Language("Temp", "�¶�").get();
	public final static String humidity = new Language("Humidity", "ʪ��").get();
	public final static String light = new Language("Light", "����").get();
	public final static String voc = new Language("Voc", "voc").get();
	public final static String pm25 = new Language("Pm2.5", "pm2.5").get();

	//sensor measure level
	public final static String veryLow = new Language("very low", "�ܵ�").get();
	public final static String low = new Language("low", "��").get();
	public final static String moderation = new Language("moderation", "����").get();
	//    public final static String littleHigh = new Language("little high", "ƫ��").get();
	public final static String high = new Language("high", "ƫ��").get();
	public final static String veryHigh = new Language("very high", "�ܸ�").get();

	//environment level
	public final static String freezing = new Language("freezing", "����").get();
	public final static String cold = new Language("cold", "��").get();
	public final static String normal = new Language("normal", "����").get();
	public final static String burning = new Language("burning", "��").get();
	public final static String very_burning = new Language("very burning", "����").get();
	public final static String very_dry = new Language("very dry", "����").get();
	public final static String dry = new Language("dry", "��").get();
	public final static String moist = new Language("Moist", "��ʪ").get();
	public final static String very_moist = new Language("very moist", "��ʪ").get();
	public final static String dark = new Language("dark", "�ڰ�").get();
	public final static String dim = new Language("dim", "�谵").get();
	public final static String glare = new Language("glare", "����").get();
	public final static String very_glare = new Language("very glare", "����").get();

	//wave level
	public final static String big = new Language("big", "���ȶ�").get();
	public final static String steady = new Language("steady", "�ȶ�").get();

	//room level
	public final static String comfort = new Language("comfort", "����").get();
	public final static String uncomfort = new Language("uncomfort", "������").get();
	public final static String warning = new Language("warning", "����").get();

	//UI static data
	public final static String comfortable_level = new Language("comfortable level", "���ʶ�").get();


	//state
	public final static String refrigeration = new Language("refrigeration", "����").get();
	public final static String heating = new Language("heating", "����").get();
	public final static String open = new Language("open", "��").get();
	public final static String close = new Language("close", "��").get();
	public final static String openOrClose = new Language("state", "״̬").get();
	public final static String refrigerationOrHeating = new Language("refrigeration or heating", "��������").get();


	//session title
	public final static String sessionTitleId = new Language("ID", "ID").get();
	public final static String sessionTitlePosition = new Language("position", "λ��").get();
	public final static String sessionTitleCapability = new Language("capability", "����").get();
	public final static String sessionTitleName = new Language("name", "����").get();
	public final static String sessionTitleSet_read = new Language("set or read", "����/����").get();
	public final static String sessionTitleState = new Language("state", "״̬").get();
	public final static String sessionTitleCollectionPeriod = new Language("collection period", "�ɼ�����").get();


	//capability name
	public final static String measureTemperature = new Language("measure temperature", "T����").get();
	public final static String measureHumidity = new Language("measure humidity", "H����").get();
	public final static String measureLight = new Language("measure light", "L����").get();
	public final static String measureVoc = new Language("measure voc", "V����").get();
	public final static String measurePM25 = new Language("measure pm2.5", "P����").get();
	public final static String temperatureControl = new Language("temperature control", "�¿�").get();
	public final static String lightControl = new Language("light control", "���").get();
	public final static String humidityControl = new Language("humidity control", "ʪ��").get();
	public final static String airOptimize = new Language("air optimize", "����").get();


	//conjunction
	public final static String or = new Language("or", "��").get();
	public final static String and = new Language("and", "��").get();
	public final static String but = new Language("but", "����").get();

	public final static String controlMachine = new Language("control machine", "�����豸").get();
	public final static String no = new Language("no", "û��").get();


	//
	public final static String comfortDescription = new Language("Comfort Description", "���ʶ�").get();


	//time frame
	public final static String lateAtNight = new Language("late at night", "��ҹ").get();
	public final static String activityTime = new Language("activity time", "�ʱ��").get();


	// advertisement
	public final static String information = new Language("Address ��No.2305, Building 9, Hongfengling(Phase 3), Chenghua District, Chengdu, Sichuan\n" +
			"Customer Services Hotline �� air conditioning maintenance 6896325   air cleaner  maintenance 6545632", "סַ���Ĵ�ʡ�ɶ��гɻ������������9��2305��\n" +
			"  ά�޵绰���յ�ά��6896325    ����������ά��6545632").get();
	public final static String ad = new Language("Smart Home. Intelligent Living. Smart Home. Better Life.", "@ ���ܼҾӣ�����������ã�@").get();

}
