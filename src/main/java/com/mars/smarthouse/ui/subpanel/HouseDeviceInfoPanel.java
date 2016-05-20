package com.mars.smarthouse.ui.subpanel;

import com.mars.smarthouse.bean.DeviceInfoItem;
import com.mars.smarthouse.constant.CssItemList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import resource.ResourceLoader;
import sun.dc.pr.PRError;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/2.
 */
public class HouseDeviceInfoPanel extends GridPane{
	@FXML
	private TableView deviceInfoTableView;

	private TableColumn deviceIDTableColumn;
	private TableColumn devicePositionTableColumn;
	private TableColumn deviceCapabilityTabelColumn;
	private TableColumn deviceNameTableColumn;
	private TableColumn deviceValueTableColumn;
	private TableColumn deviceStateTableColumn;
	private TableColumn devicePeriodTableColumn;

	private final ObservableList<DeviceInfoItem> device_info_data = FXCollections.observableArrayList();

	public HouseDeviceInfoPanel(){
		FXMLLoader fxmlLoader = new FXMLLoader(ResourceLoader.getResource("fxml/house_device_info_panel.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		default_init();

	}

	private void default_init(){
		//列表框初始化
		deviceIDTableColumn = new TableColumn();
		deviceIDTableColumn.setText("ID");
		deviceIDTableColumn.setCellValueFactory(new PropertyValueFactory<DeviceInfoItem,String>("deviceId"));
		devicePositionTableColumn = new TableColumn();
		devicePositionTableColumn.setText("位置");
		devicePositionTableColumn.setCellValueFactory(new PropertyValueFactory<DeviceInfoItem,String>("devicePosition"));
		deviceCapabilityTabelColumn = new TableColumn();
		deviceCapabilityTabelColumn.setText("能力");
		deviceCapabilityTabelColumn.setCellValueFactory(new PropertyValueFactory<DeviceInfoItem,String>("deviceCapability"));
		deviceNameTableColumn = new TableColumn();
		deviceNameTableColumn.setText("名称");
		deviceNameTableColumn.setCellValueFactory(new PropertyValueFactory<DeviceInfoItem,String>("deviceName"));
		deviceValueTableColumn = new TableColumn();
		deviceValueTableColumn.setText("设置/读数");
		deviceValueTableColumn.setCellValueFactory(new PropertyValueFactory<DeviceInfoItem,String>("deviceValue"));
		deviceStateTableColumn = new TableColumn();
		deviceStateTableColumn.setText("状态");
		deviceStateTableColumn.setCellValueFactory(new PropertyValueFactory<DeviceInfoItem,String>("deviceState"));
		devicePeriodTableColumn = new TableColumn();
		devicePeriodTableColumn.setText("采集周期");
		devicePeriodTableColumn.setCellValueFactory(new PropertyValueFactory<DeviceInfoItem, String>("devicePeriod"));


		deviceInfoTableView.setItems(device_info_data);
		deviceInfoTableView.getColumns().addAll(deviceIDTableColumn,devicePositionTableColumn,deviceCapabilityTabelColumn,deviceNameTableColumn,deviceValueTableColumn,deviceStateTableColumn,devicePeriodTableColumn);

		//todo: for test
		device_info_data.addAll(
				new DeviceInfoItem("device_AC_01","走廊","温度","空调","睡眠","——","0.02s"),
				new DeviceInfoItem("device_AC_01","走廊","湿度","空调","睡眠","——","0.02s"),
				new DeviceInfoItem("device_Tem_03","客厅","传感","温度","31.43°C","过热","0.02s"),
				new DeviceInfoItem("device_Bulb_06","客厅","光控","电灯","关","——","0.04s"),
				new DeviceInfoItem("device_AC_09","餐厅","温度","空调","31.10°C","过热","0.02s"),
				new DeviceInfoItem("device_Tem_011","厨房","传感","温度","30.27°C","过热","0.02s"),
				new DeviceInfoItem("device_Light_07","客厅","传感","光照","45.11lx","昏暗","0.02s"),
				new DeviceInfoItem("device_VOC_023","厨房","传感","VOC","30mg/m3","偏低","0.04s"),
				new DeviceInfoItem("device_Hum_012","餐厅","传感","湿度","30.23%RH","干燥","0.02s"),
				new DeviceInfoItem("device_Tem_031","餐厅","传感","温度","29.71°C","过热","0.02s"),
				new DeviceInfoItem("device_AC_04","客厅","温度","空调","睡眠","——","0.02s")
		);

		//set css
		deviceInfoTableView.getStyleClass().add(CssItemList.table_content_color);

	}

	public void updateHouseDeviceInfo(String  currentFloorId){

	}
}
