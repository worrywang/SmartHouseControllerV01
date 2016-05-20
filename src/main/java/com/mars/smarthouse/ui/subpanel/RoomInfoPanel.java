package com.mars.smarthouse.ui.subpanel;

import com.mars.smarthouse.constant.CssItemList;
import com.mars.smarthouse.constant.RelevantResource;
import com.mars.smarthouse.constant.Setting;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import resource.ResourceLoader;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/2.
 */
public class RoomInfoPanel extends GridPane{

	@FXML
	private Label roomLabel;
	@FXML
	private Label deviceInfoLabel;
	@FXML
	private Label roomInfoLabel;
	@FXML
	private Label roomStateLabel;


	@FXML
	private Label temSensorIconLabel;
	@FXML
	private Label temSensorNumLabel;
	@FXML
	private Label temSensorNameLabel;
	@FXML
	private Label humSensorIconLabel;
	@FXML
	private Label humSensorNumLabel;
	@FXML
	private Label humSensorNameLabel;
	@FXML
	private Label lightSensorIconLabel;
	@FXML
	private Label lightSensorNumLabel;
	@FXML
	private Label lightSensorNameLabel;
	@FXML
	private Label vocSensorIconLabel;
	@FXML
	private Label vocSensorNumLabel;
	@FXML
	private Label vocSensorNameLabel;
	@FXML
	private Label lightIconLabel;
	@FXML
	private Label lightNumLabel;
	@FXML
	private Label lightNameLabel;
	@FXML
	private Label curtainIconLabel;
	@FXML
	private Label curtainNumLabel;
	@FXML
	private Label curtainNameLabel;
	@FXML
	private Label acIconLabel;
	@FXML
	private Label acNumLabel;
	@FXML
	private Label acNameLabel;


	@FXML
	private Label temSensorStateValueLabel;
	@FXML
	private Label temSensorSteadyLabel;
	@FXML
	private Label humSensorStateValueLabel;
	@FXML
	private Label humSensorSteadyLabel;
	@FXML
	private Label lightSensorStateValueLabel;
	@FXML
	private Label lightSensorSteadyLabel;
	@FXML
	private Label vocSensorStateValueLabel;
	@FXML
	private Label vocSensorSteadyLabel;

	@FXML
	private Label lightOnNumLabel;
	@FXML
	private Label lightOnLabel;
	@FXML
	private Label lightOffNumLabel;
	@FXML
	private Label lightOffLabel;
	@FXML
	private Label curtainOnNumLabel;
	@FXML
	private Label curtainOnLabel;
	@FXML
	private Label curtainOffNumLabel;
	@FXML
	private Label curtainOffLabel;
	@FXML
	private Label acOnNumLabel;
	@FXML
	private Label acOnLabel;
	@FXML
	private Label acOffNumLabel;
	@FXML
	private Label acOffLabel;

	@FXML
	private Label confortTagLabel;
	@FXML
	private Label uncomfortTagLabel;
	@FXML
	private Label warningTagLabel;

	public RoomInfoPanel(){
		FXMLLoader fxmlLoader = new FXMLLoader(ResourceLoader.getResource("fxml/room_info_panel.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		default_init();
		setLabelInfo(1);
	}

	private void default_init(){
		//set css
		addCss();

		//自适应
		this.widthProperty().addListener((observable, oldValue, newValue) -> {

		});
		this.heightProperty().addListener((observable, oldValue, newValue) -> {

		});
	}

	private void addCss(){
		this.getStyleClass().add(CssItemList.panel_background_color_css);
		roomLabel.getStyleClass().add(CssItemList.infor_tag_font);
		deviceInfoLabel.getStyleClass().add(CssItemList.infor_tag_font_small);
		roomInfoLabel.getStyleClass().add(CssItemList.infor_tag_font_small);
		roomStateLabel.getStyleClass().add(CssItemList.infor_tag_font_small);
		//device
		temSensorIconLabel.getStyleClass().add(CssItemList.light_sensor_css);
		humSensorIconLabel.getStyleClass().add(CssItemList.hum_sensor_css);
		lightSensorIconLabel.getStyleClass().add(CssItemList.light_sensor_css);
		vocSensorIconLabel.getStyleClass().add(CssItemList.voc_sensor_css);
		lightIconLabel.getStyleClass().add(CssItemList.light_icon_css);
		curtainIconLabel.getStyleClass().add(CssItemList.curtain_icon_css);
		acIconLabel.getStyleClass().add(CssItemList.ac_icon_css);

		temSensorNumLabel.getStyleClass().add(CssItemList.color_label_content_font);
		temSensorNameLabel.getStyleClass().add(CssItemList.color_label_content_font);
		humSensorNumLabel.getStyleClass().add(CssItemList.color_label_content_font);
		humSensorNameLabel.getStyleClass().add(CssItemList.color_label_content_font);
		lightSensorNumLabel.getStyleClass().add(CssItemList.color_label_content_font);
		lightSensorNameLabel.getStyleClass().add(CssItemList.color_label_content_font);
		vocSensorNumLabel.getStyleClass().add(CssItemList.color_label_content_font);
		vocSensorNameLabel.getStyleClass().add(CssItemList.color_label_content_font);
		lightNumLabel.getStyleClass().add(CssItemList.color_label_content_font);
		lightNameLabel.getStyleClass().add(CssItemList.color_label_content_font);
		curtainNumLabel.getStyleClass().add(CssItemList.color_label_content_font);
		curtainNameLabel.getStyleClass().add(CssItemList.color_label_content_font);
		acNumLabel.getStyleClass().add(CssItemList.color_label_content_font);
		acNameLabel.getStyleClass().add(CssItemList.color_label_content_font);

		temSensorStateValueLabel.getStyleClass().add(CssItemList.color_label_content_font);
		temSensorSteadyLabel.getStyleClass().add(CssItemList.color_label_content_font);
		humSensorStateValueLabel.getStyleClass().add(CssItemList.color_label_content_font);
		humSensorSteadyLabel.getStyleClass().add(CssItemList.color_label_content_font);
		lightSensorStateValueLabel.getStyleClass().add(CssItemList.color_label_content_font);
		lightSensorSteadyLabel.getStyleClass().add(CssItemList.color_label_content_font);
		vocSensorStateValueLabel.getStyleClass().add(CssItemList.color_label_content_font);
		vocSensorSteadyLabel.getStyleClass().add(CssItemList.color_label_content_font);
		lightOnLabel.getStyleClass().add(CssItemList.color_label_content_font);
		lightOnNumLabel.getStyleClass().add(CssItemList.color_label_content_font);
		lightOffLabel.getStyleClass().add(CssItemList.color_label_content_font);
		lightOffNumLabel.getStyleClass().add(CssItemList.color_label_content_font);
		curtainOnLabel.getStyleClass().add(CssItemList.color_label_content_font);
		curtainOnNumLabel.getStyleClass().add(CssItemList.color_label_content_font);
		curtainOffLabel.getStyleClass().add(CssItemList.color_label_content_font);
		curtainOffNumLabel.getStyleClass().add(CssItemList.color_label_content_font);
		acOnLabel.getStyleClass().add(CssItemList.color_label_content_font);
		acOnNumLabel.getStyleClass().add(CssItemList.color_label_content_font);
		acOffLabel.getStyleClass().add(CssItemList.color_label_content_font);
		acOffNumLabel.getStyleClass().add(CssItemList.color_label_content_font);

		confortTagLabel.getStyleClass().add(CssItemList.color_label_content_font);
		uncomfortTagLabel.getStyleClass().add(CssItemList.color_label_content_font);
		warningTagLabel.getStyleClass().add(CssItemList.color_label_content_font);
		//add color
		lightOnLabel.getStyleClass().add(CssItemList.device_info_color_good_css);
		lightOffLabel.getStyleClass().add(CssItemList.device_info_color_warning_css);
		curtainOnLabel.getStyleClass().add(CssItemList.device_info_color_good_css);
		curtainOffLabel.getStyleClass().add(CssItemList.device_info_color_warning_css);
		acOnLabel.getStyleClass().add(CssItemList.device_info_color_good_css);
		acOffLabel.getStyleClass().add(CssItemList.device_info_color_warning_css);
	}

	public void updateRoomInfo(String currentRoom){
		roomLabel.setText(RelevantResource.convertName(currentRoom)+"_信息");
	}


	public void setLabelInfo(int temp){
		switch (temp){
			case 1:
				setLevelLabel(temSensorStateValueLabel,"过热", Setting.InfoLevel.High);
				setLevelLabel(humSensorStateValueLabel,"干燥", Setting.InfoLevel.High);
				setLevelLabel(lightSensorStateValueLabel, "昏暗", Setting.InfoLevel.Low);
				setLevelLabel(vocSensorStateValueLabel, "正常", Setting.InfoLevel.Moderation);

				setLevelLabel(temSensorSteadyLabel, "稳定", Setting.InfoLevel.Moderation);
				setLevelLabel(humSensorSteadyLabel, "不稳定", Setting.InfoLevel.TooHigh);
				setLevelLabel(lightSensorSteadyLabel, "不稳定", Setting.InfoLevel.TooHigh);
				setLevelLabel(vocSensorSteadyLabel, "稳定", Setting.InfoLevel.Moderation);

				uncomfortTagLabel.getStyleClass().add(CssItemList.device_info_color_soso_css);
				confortTagLabel.getStyleClass().add(CssItemList.device_info_color_default_css);
				warningTagLabel.getStyleClass().add(CssItemList.device_info_color_default_css);

				temSensorNumLabel.setText("3");
				humSensorNumLabel.setText("3");
				lightSensorNumLabel.setText("4");
				vocSensorNumLabel.setText("2");
				lightNumLabel.setText("2");
				curtainNumLabel.setText("1");
				acNumLabel.setText("1");
				lightOnNumLabel.setText("0");
				lightOffNumLabel.setText("2");
				curtainOnNumLabel.setText("0");
				curtainOffNumLabel.setText("1");
				acOnNumLabel.setText("0");
				acOffNumLabel.setText("1");


				break;
			case 2:

				break;
			case 3:
				setLevelLabel(temSensorStateValueLabel,"舒适", Setting.InfoLevel.Moderation);
				setLevelLabel(humSensorStateValueLabel,"舒适", Setting.InfoLevel.Moderation);
				setLevelLabel(lightSensorStateValueLabel, "明亮", Setting.InfoLevel.Moderation);
				setLevelLabel(vocSensorStateValueLabel, "正常", Setting.InfoLevel.Moderation);

				setLevelLabel(temSensorSteadyLabel, "稳定", Setting.InfoLevel.Moderation);
				setLevelLabel(humSensorSteadyLabel, "稳定", Setting.InfoLevel.Moderation);
				setLevelLabel(lightSensorSteadyLabel, "不稳定", Setting.InfoLevel.TooHigh);
				setLevelLabel(vocSensorSteadyLabel, "稳定", Setting.InfoLevel.Moderation);

				uncomfortTagLabel.getStyleClass().add(CssItemList.device_info_color_default_css);
				confortTagLabel.getStyleClass().add(CssItemList.device_info_color_good_css);
				warningTagLabel.getStyleClass().add(CssItemList.device_info_color_default_css);

				temSensorNumLabel.setText("3");
				humSensorNumLabel.setText("3");
				lightSensorNumLabel.setText("4");
				vocSensorNumLabel.setText("2");
				lightNumLabel.setText("2");
				curtainNumLabel.setText("1");
				acNumLabel.setText("1");
				lightOnNumLabel.setText("2");
				lightOffNumLabel.setText("0");
				curtainOnNumLabel.setText("1");
				curtainOffNumLabel.setText("0");
				acOnNumLabel.setText("1");
				acOffNumLabel.setText("0");
				break;
			default:
				break;
		}

	}

	private void setLevelLabel(Label label,String value,Setting.InfoLevel level ){
		label.getStyleClass().removeAll(CssItemList.device_info_color_good_css);
		label.getStyleClass().removeAll(CssItemList.device_info_color_soso_css);
		label.getStyleClass().removeAll(CssItemList.device_info_color_warning_css);
		label.getStyleClass().removeAll(CssItemList.device_info_color_default_css);
		switch (level){
			case TooHigh:
			case TooLow:

				label.getStyleClass().add(CssItemList.device_info_color_warning_css);
				break;
			case Moderation:
				label.getStyleClass().add(CssItemList.device_info_color_good_css);
				break;
			default:
				label.getStyleClass().add(CssItemList.device_info_color_soso_css);
				break;
		}
		label.setText(value);
	}


}
