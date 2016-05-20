package com.mars.smarthouse.ui.subpanel;

import com.mars.smarthouse.bean.uibean.Building;
import com.mars.smarthouse.bean.uibean.Floor;
import com.mars.smarthouse.bean.uibean.Room;
import com.mars.smarthouse.constant.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import resource.ResourceLoader;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/2.
 */
public class HouseInfoPanel extends GridPane{

	@FXML
	private Label floorLabel;
	@FXML
	private Label dayIconLabel;
	@FXML
	private Label room01Label;
	@FXML
	private Label room01StateLabel;
	@FXML
	private Label room01SuggestionLabel;
	@FXML
	private Button room01ControllerButton;
	@FXML
	private Label room02Label;
	@FXML
	private Label room02StateLabel;
	@FXML
	private Label room02SuggestionLabel;
	@FXML
	private Button room02ControllerButton;
	@FXML
	private Label room03Label;
	@FXML
	private Label room03StateLabel;
	@FXML
	private Label room03SuggestionLabel;
	@FXML
	private Button room03ControllerButton;
	@FXML
	private Label room04Label;
	@FXML
	private Label room04StateLabel;
	@FXML
	private Label room04SuggestionLabel;
	@FXML
	private Button room04ControllerButton;
	@FXML
	private Label room05Label;
	@FXML
	private Label room05StateLabel;
	@FXML
	private Label room05SuggestionLabel;
	@FXML
	private Button room05ControllerButton;
	@FXML
	private Label room06Label;
	@FXML
	private Label room07Label;
	@FXML
	private Label room06InfoLabel;
	@FXML
	private Label room07InfoLabel;

	public HouseInfoPanel(){
		FXMLLoader fxmlLoader = new FXMLLoader(ResourceLoader.getResource("fxml/house_info_panel.fxml"));
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
		//set css
		this.getStyleClass().add(CssItemList.panel_background_color_css);
		floorLabel.getStyleClass().add(CssItemList.infor_tag_font);
		room01Label.getStyleClass().add(CssItemList.infor_tag_font);
		room01StateLabel.getStyleClass().add(CssItemList.infor_tag_font);
		room01SuggestionLabel.getStyleClass().add(CssItemList.infor_content_font_small);
		room02Label.getStyleClass().add(CssItemList.infor_tag_font);
		room02StateLabel.getStyleClass().add(CssItemList.infor_tag_font);
		room02SuggestionLabel.getStyleClass().add(CssItemList.infor_content_font_small);
		room03Label.getStyleClass().add(CssItemList.infor_tag_font);
		room03StateLabel.getStyleClass().add(CssItemList.infor_tag_font);
		room03SuggestionLabel.getStyleClass().add(CssItemList.infor_content_font_small);
		room04Label.getStyleClass().add(CssItemList.infor_tag_font);
		room04StateLabel.getStyleClass().add(CssItemList.infor_tag_font);
		room04SuggestionLabel.getStyleClass().add(CssItemList.infor_content_font_small);
		room05Label.getStyleClass().add(CssItemList.infor_tag_font);
		room05StateLabel.getStyleClass().add(CssItemList.infor_tag_font);
		room05SuggestionLabel.getStyleClass().add(CssItemList.infor_content_font_small);
		room06Label.getStyleClass().add(CssItemList.infor_tag_font);
		room07Label.getStyleClass().add(CssItemList.infor_tag_font);
		room06InfoLabel.getStyleClass().add(CssItemList.infor_content_font_small);
		room06InfoLabel.getStyleClass().add(CssItemList.infor_content_font_small);
		room01ControllerButton.getStyleClass().add(CssItemList.button_content_font_size);
		room02ControllerButton.getStyleClass().add(CssItemList.button_content_font_size);
		room03ControllerButton.getStyleClass().add(CssItemList.button_content_font_size);
		room04ControllerButton.getStyleClass().add(CssItemList.button_content_font_size);
		room05ControllerButton.getStyleClass().add(CssItemList.button_content_font_size);

		deleteLabelInfo();
		setDayICon(Setting.currentTimeState);

		//自适应
		this.widthProperty().addListener((observable, oldValue, newValue) -> {
			room01ControllerButton.setPrefWidth(observable.getValue().doubleValue() * BoundarySize.house_info_button_width_scale * BoundarySize.middle_button_width);
			room02ControllerButton.setPrefWidth(observable.getValue().doubleValue() * BoundarySize.house_info_button_width_scale * BoundarySize.middle_button_width);
			room03ControllerButton.setPrefWidth(observable.getValue().doubleValue() * BoundarySize.house_info_button_width_scale * BoundarySize.middle_button_width);
			room04ControllerButton.setPrefWidth(observable.getValue().doubleValue() * BoundarySize.house_info_button_width_scale * BoundarySize.middle_button_width);
			room05ControllerButton.setPrefWidth(observable.getValue().doubleValue() * BoundarySize.house_info_button_width_scale * BoundarySize.middle_button_width);
		});
		this.heightProperty().addListener((observable, oldValue, newValue) -> {
			room01ControllerButton.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room01ControllerButton.setMaxHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room01ControllerButton.setMinHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room02ControllerButton.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room02ControllerButton.setMaxHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room02ControllerButton.setMinHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room03ControllerButton.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room03ControllerButton.setMaxHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room03ControllerButton.setMinHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room04ControllerButton.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room04ControllerButton.setMaxHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room04ControllerButton.setMinHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room05ControllerButton.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room05ControllerButton.setMaxHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
			room05ControllerButton.setMinHeight(observable.getValue().doubleValue() * BoundarySize.house_info_button_height_scale * BoundarySize.middle_button_height);
//			System.out.println("HouseInfoPanel some info : observable height--"+observable.getValue().doubleValue()+"; column height--"+observable.getValue().doubleValue()*BoundarySize.house_info_button_height_scale+
//					"; button height--"+observable.getValue().doubleValue()*BoundarySize.house_info_button_height_scale*BoundarySize.middle_button_height);

			dayIconLabel.setPrefWidth(observable.getValue().doubleValue() * BoundarySize.cell_padding);
			dayIconLabel.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.cell_padding);
		});

		//todo: test
		setLabelInfo();
	}

	private void deleteLabelInfo(){
		floorLabel.setText("");
		dayIconLabel.setText("");
		room01Label.setText("");
		room01StateLabel.setText("");
		room01SuggestionLabel.setText("");
		room01ControllerButton.setText(Setting.OneButtonForComfortName);
		room02Label.setText("");
		room02StateLabel.setText("");
		room02SuggestionLabel.setText("");
		room02ControllerButton.setText(Setting.OneButtonForComfortName);
		room03Label.setText("");
		room03StateLabel.setText("");
		room03SuggestionLabel.setText("");
		room03ControllerButton.setText(Setting.OneButtonForComfortName);
		room04Label.setText("");
		room04StateLabel.setText("");
		room04SuggestionLabel.setText("");
		room04ControllerButton.setText(Setting.OneButtonForComfortName);
		room05Label.setText("");
		room05StateLabel.setText("");
		room05SuggestionLabel.setText("");
		room05ControllerButton.setText(Setting.OneButtonForComfortName);
		room06Label.setText("");
		room07Label.setText("");
		room06InfoLabel.setText("");
		room07InfoLabel.setText("");
		room01ControllerButton.setVisible(false);
		room02ControllerButton.setVisible(false);
		room03ControllerButton.setVisible(false);
		room04ControllerButton.setVisible(false);
		room05ControllerButton.setVisible(false);

	}

	//todo : test
	private void setLabelInfo(){
		floorLabel.setText(Setting.FloorInfo_Prefix+"floor1");
		room01Label.setText("餐厅");
		setLevelLabel(room01StateLabel, Setting.ComLevel.UnComfort);
		room01SuggestionLabel.setText("建议：打开空调，调节温度至26℃，设置打开加湿功能；打开灯；打开窗帘");
		room01ControllerButton.setText(Setting.OneButtonForComfortName);
		room02Label.setText("客厅");
		setLevelLabel(room02StateLabel, Setting.ComLevel.UnComfort);
		room02SuggestionLabel.setText("建议：打开空调，调节温度至26℃，设置打开加湿功能；打开灯；打开窗帘");
		room02ControllerButton.setText(Setting.OneButtonForComfortName);
		room03Label.setText("厨房");
		setLevelLabel(room03StateLabel, Setting.ComLevel.UnComfort);
		room03SuggestionLabel.setText("建议：打开灯");
		room03ControllerButton.setText(Setting.OneButtonForComfortName);
		room04Label.setText("");
		room04StateLabel.setText("");
		room04SuggestionLabel.setText("");
		room04ControllerButton.setText(Setting.OneButtonForComfortName);
		room05Label.setText("");
		room05StateLabel.setText("");
		room05SuggestionLabel.setText("");
		room05ControllerButton.setText(Setting.OneButtonForComfortName);
		room06Label.setText("");
		room07Label.setText("");
		room06InfoLabel.setText("");
		room07InfoLabel.setText("");

		room06Label.setText("门禁");
		room07Label.setText("车库");
		room06InfoLabel.setText("无信息");
		room07InfoLabel.setText("车库00空闲，车库01占用");
		room01ControllerButton.setVisible(true);
		room02ControllerButton.setVisible(true);
		room03ControllerButton.setVisible(true);
	}

	public  void setLabelInfo(int temp){
		switch (temp){
			case 0:
				floorLabel.setText(Setting.FloorInfo_Prefix + "floor1");
				room01Label.setText("餐厅");
				setLevelLabel(room01StateLabel, Setting.ComLevel.UnComfort);
				room01SuggestionLabel.setText("建议：打开空调，调节温度至26℃，设置打开加湿功能；打开灯；打开窗帘");
				room01ControllerButton.setText(Setting.OneButtonForComfortName);
				room02Label.setText("客厅");
				setLevelLabel(room02StateLabel, Setting.ComLevel.UnComfort);
				room02SuggestionLabel.setText("建议：打开空调，调节温度至26℃，设置打开加湿功能；打开灯；打开窗帘");
				room02ControllerButton.setText(Setting.OneButtonForComfortName);
				room03Label.setText("厨房");
				setLevelLabel(room03StateLabel, Setting.ComLevel.UnComfort);
				room03SuggestionLabel.setText("建议：打开灯");
				room03ControllerButton.setText(Setting.OneButtonForComfortName);
				room04Label.setText("");
				room04StateLabel.setText("");
				room04SuggestionLabel.setText("");
				room04ControllerButton.setText(Setting.OneButtonForComfortName);
				room05Label.setText("");
				room05StateLabel.setText("");
				room05SuggestionLabel.setText("");
				room05ControllerButton.setText(Setting.OneButtonForComfortName);
				room06Label.setText("");
				room07Label.setText("");
				room06InfoLabel.setText("");
				room07InfoLabel.setText("");
				room06Label.setText("门禁");
				room07Label.setText("车库");
				room06InfoLabel.setText("无信息\n");
				room07InfoLabel.setText("车库00空闲，车库01占用");
				room01ControllerButton.setVisible(true);
				room02ControllerButton.setVisible(true);
				room03ControllerButton.setVisible(true);
				break;
			case 1:
				floorLabel.setText(Setting.FloorInfo_Prefix + "floor1");
				room01Label.setText("餐厅");
				setLevelLabel(room01StateLabel, Setting.ComLevel.UnComfort);
				room01SuggestionLabel.setText("建议：打开空调，调节温度至26℃，设置打开加湿功能；打开灯；打开窗帘");
				room01ControllerButton.setText(Setting.OneButtonForComfortName);
				room02Label.setText("客厅");
				setLevelLabel(room02StateLabel, Setting.ComLevel.UnComfort);
				room02SuggestionLabel.setText("建议：打开空调，调节温度至26℃，设置打开加湿功能；打开灯；打开窗帘");
				room02ControllerButton.setText(Setting.OneButtonForComfortName);
				room03Label.setText("厨房");
				setLevelLabel(room03StateLabel, Setting.ComLevel.UnComfort);
				room03SuggestionLabel.setText("建议：打开灯");
				room03ControllerButton.setText(Setting.OneButtonForComfortName);
				room04Label.setText("");
				room04StateLabel.setText("");
				room04SuggestionLabel.setText("");
				room04ControllerButton.setText(Setting.OneButtonForComfortName);
				room05Label.setText("");
				room05StateLabel.setText("");
				room05SuggestionLabel.setText("");
				room05ControllerButton.setText(Setting.OneButtonForComfortName);
				room06Label.setText("");
				room07Label.setText("");
				room06InfoLabel.setText("");
				room07InfoLabel.setText("");
				room06Label.setText("门禁");
				room07Label.setText("车库");
				room06InfoLabel.setText("检测到用户ID：MARS010203，符合要求，打开别墅大门\n");
				room07InfoLabel.setText("车库00空闲，车库01占用");
				room01ControllerButton.setVisible(true);
				room02ControllerButton.setVisible(true);
				room03ControllerButton.setVisible(true);
				break;
			case 2:
				floorLabel.setText(Setting.FloorInfo_Prefix + "floor1");
				room01Label.setText("餐厅");
				setLevelLabel(room01StateLabel, Setting.ComLevel.UnComfort);
				room01SuggestionLabel.setText("建议：打开空调，调节温度至26℃，设置打开加湿功能；打开灯；打开窗帘");
				room01ControllerButton.setText(Setting.OneButtonForComfortName);
				room02Label.setText("客厅");
				setLevelLabel(room02StateLabel, Setting.ComLevel.UnComfort);
				room02SuggestionLabel.setText("建议：打开空调，调节温度至26℃，设置打开加湿功能；打开灯；打开窗帘");
				room02ControllerButton.setText(Setting.OneButtonForComfortName);
				room03Label.setText("厨房");
				setLevelLabel(room03StateLabel, Setting.ComLevel.UnComfort);
				room03SuggestionLabel.setText("建议：打开灯");
				room03ControllerButton.setText(Setting.OneButtonForComfortName);
				room04Label.setText("");
				room04StateLabel.setText("");
				room04SuggestionLabel.setText("");
				room04ControllerButton.setText(Setting.OneButtonForComfortName);
				room05Label.setText("");
				room05StateLabel.setText("");
				room05SuggestionLabel.setText("");
				room05ControllerButton.setText(Setting.OneButtonForComfortName);
				room06Label.setText("");
				room07Label.setText("");
				room06InfoLabel.setText("");
				room07InfoLabel.setText("");
				room06Label.setText("门禁");
				room07Label.setText("车库");
				room06InfoLabel.setText("无信息");
				room07InfoLabel.setText("车库00空闲，车库01占用");
				room01ControllerButton.setVisible(true);
				room02ControllerButton.setVisible(true);
				room03ControllerButton.setVisible(true);
				break;
			case 3:
				floorLabel.setText(Setting.FloorInfo_Prefix + "floor1");
				room01Label.setText("餐厅");
				setLevelLabel(room01StateLabel, Setting.ComLevel.UnComfort);
				room01SuggestionLabel.setText("建议：打开空调，调节温度至26℃，设置打开加湿功能；打开灯；打开窗帘");
				room01ControllerButton.setText(Setting.OneButtonForComfortName);
				room02Label.setText("客厅");
				setLevelLabel(room02StateLabel, Setting.ComLevel.Comfort);
				room02SuggestionLabel.setText("");
				room02ControllerButton.setText(Setting.OneButtonForComfortName);
				room03Label.setText("厨房");
				setLevelLabel(room03StateLabel, Setting.ComLevel.UnComfort);
				room03SuggestionLabel.setText("建议：打开灯");
				room03ControllerButton.setText(Setting.OneButtonForComfortName);
				room04Label.setText("");
				room04StateLabel.setText("");
				room04SuggestionLabel.setText("");
				room04ControllerButton.setText(Setting.OneButtonForComfortName);
				room05Label.setText("");
				room05StateLabel.setText("");
				room05SuggestionLabel.setText("");
				room05ControllerButton.setText(Setting.OneButtonForComfortName);
				room06Label.setText("");
				room07Label.setText("");
				room06InfoLabel.setText("");
				room07InfoLabel.setText("");
				room06Label.setText("门禁");
				room07Label.setText("车库");
				room06InfoLabel.setText("无信息");
				room07InfoLabel.setText("车库00空闲，车库01占用");
				room01ControllerButton.setVisible(true);
				room02ControllerButton.setVisible(false);
				room03ControllerButton.setVisible(true);
				break;
			default:
				break;
		}

	}

	private void setLevelLabel(Label label,Setting.ComLevel level){
		switch (level){
			case Comfort:
				label.setText("舒适");
				label.getStyleClass().removeAll(CssItemList.device_info_color_soso_css);
				label.getStyleClass().add(CssItemList.device_info_color_good_css);
				break;
			case UnComfort:
				label.setText("不舒适");
				label.getStyleClass().add(CssItemList.device_info_color_soso_css);
				break;
			case Warning:
				label.setText("舒适");
				label.getStyleClass().add(CssItemList.device_info_color_warning_css);
				break;
		}
	}

	private void setDayICon(Setting.TimeState timeState) {
		switch (timeState) {
			case DAY:
				dayIconLabel.getStyleClass().clear();
				dayIconLabel.getStyleClass().add(CssItemList.day_icon_css);
				break;
			case NIGHT:
				dayIconLabel.getStyleClass().clear();
				dayIconLabel.getStyleClass().add(CssItemList.night_icon_css);
				break;
			default:
				break;
		}
	}

	public void updateHouseInfo(String  currentFloorId){
		System.out.println("===========================update house info.........");
		Building building  = MainPanel.mainPad.getBuilding();
		Floor floor = building.getFloorByID(currentFloorId);
		deleteLabelInfo();
		room06Label.setText("门禁");
		room07Label.setText("车库");
//		if(currentFloorId.equals(RelevantResource.floor01_name)){
			floorLabel.setText(Setting.FloorInfo_Prefix+currentFloorId);
		if(floor!=null) {
			if (floor.getRoomList() != null && floor.getRoomList().size() > 0) {
				int count = 1;
				for (String key : floor.getRoomList().keySet()) {
					if (key.contains(RelevantResource.corridor_tag)) continue;
					if (key.contains(RelevantResource.garage)) continue;
					setRoomInfoInLabel(count, floor.getRoomList().get(key));
					count++;
				}
			}
		}
//
//		}else if (currentFloorId.equals(RelevantResource.floor02_name)){
//			floorLabel.setText(Setting.FloorInfo_Prefix+currentFloorId);
//			if(floor.getRoomList()!=null&&floor.getRoomList().size()>0){
//
//			}
//		}
	}

	public void setRoomInfoInLabel(int count,Room room){
		if (room==null) return;
		switch (count){
			case 1:
				room01Label.setText(RelevantResource.convertName(room.getRoomId()));
				room01StateLabel.setText(room.getLevel());
				room01SuggestionLabel.setText(room.getControlSuggestions());
				if(room.getLevel().trim().equals(Lexicon.comfort)) room01ControllerButton.setVisible(false);
				else {
					room01ControllerButton.setVisible(true);
				}
				break;
			case 2:
				room02Label.setText(RelevantResource.convertName(room.getRoomId()));
				room02StateLabel.setText(room.getLevel());
				room02SuggestionLabel.setText(room.getControlSuggestions());
				if(room.getLevel().trim().equals(Lexicon.comfort)) room02ControllerButton.setVisible(false);
				else {
					room02ControllerButton.setVisible(true);
				}
				break;
			case 3:
				room03Label.setText(RelevantResource.convertName(room.getRoomId()));
				room03StateLabel.setText(room.getLevel());
				room03SuggestionLabel.setText(room.getControlSuggestions());
				if(room.getLevel().trim().equals(Lexicon.comfort)) room03ControllerButton.setVisible(false);
				else {
					room03ControllerButton.setVisible(true);
				}
				break;
			case 4:
				room04Label.setText(RelevantResource.convertName(room.getRoomId()));
				room04StateLabel.setText(room.getLevel());
				room04SuggestionLabel.setText(room.getControlSuggestions());
				if(room.getLevel().trim().equals(Lexicon.comfort)) room04ControllerButton.setVisible(false);
				else {
					room04ControllerButton.setVisible(true);
				}
				break;
			case 5:
				room05Label.setText(RelevantResource.convertName(room.getRoomId()));
				room05StateLabel.setText(room.getLevel());
				room05SuggestionLabel.setText(room.getControlSuggestions());
				if(room.getLevel().trim().equals(Lexicon.comfort)) room05ControllerButton.setVisible(false);
				else {
					room05ControllerButton.setVisible(true);
				}
				break;
			default:
				break;

		}
	}
}
