package com.mars.smarthouse.ui.subpanel;

import com.mars.smarthouse.constant.BoundarySize;
import com.mars.smarthouse.constant.CssItemList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import resource.ResourceLoader;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/2.
 */
public class LegendPanel extends GridPane{

	@FXML
	private Label legendTitleLabel;
	@FXML
	private Label lightTagLabel;
	@FXML
	private Label acTagLabel;
	@FXML
	private Label curtainTagLabel;
	@FXML
	private Label temSensorTagLabel;
	@FXML
	private Label lightSensorTagLabel;
	@FXML
	private Label humSensorTagLabel;
	@FXML
	private Label vocSensorTagLabel;
	@FXML
	private Label dayTagLabel;
	@FXML
	private Label nightTagLabel;
	@FXML
	private Label lightLabel;
	@FXML
	private Label acLabel;
	@FXML
	private Label curtainLabel;
	@FXML
	private Label temSensorLabel;
	@FXML
	private Label lightSensorLabel;
	@FXML
	private Label humSensorLabel;
	@FXML
	private Label vocSensorLabel;
	@FXML
	private Label dayLabel;
	@FXML
	private Label nightLabel;

	public LegendPanel(){
		FXMLLoader fxmlLoader = new FXMLLoader(ResourceLoader.getResource("fxml/legend_panel.fxml"));
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
		this.getStyleClass().add(CssItemList.panel_background_color_css);
		//×ÖÌå
		legendTitleLabel.getStyleClass().add(CssItemList.infor_tag_font);
		lightTagLabel.getStyleClass().add(CssItemList.infor_content_font);
		acTagLabel.getStyleClass().add(CssItemList.infor_content_font);
		curtainTagLabel.getStyleClass().add(CssItemList.infor_content_font);
		temSensorTagLabel.getStyleClass().add(CssItemList.infor_content_font);
		humSensorTagLabel.getStyleClass().add(CssItemList.infor_content_font);
		lightSensorTagLabel.getStyleClass().add(CssItemList.infor_content_font);
		vocSensorTagLabel.getStyleClass().add(CssItemList.infor_content_font);
		dayTagLabel.getStyleClass().add(CssItemList.infor_content_font);
		nightTagLabel.getStyleClass().add(CssItemList.infor_content_font);
		//Í¼±ê
		lightLabel.getStyleClass().add(CssItemList.light_icon_css);
		acLabel.getStyleClass().add(CssItemList.ac_icon_css);
		curtainLabel.getStyleClass().add(CssItemList.curtain_icon_css);
		temSensorLabel.getStyleClass().add(CssItemList.tem_sensor_css);
		humSensorLabel.getStyleClass().add(CssItemList.hum_sensor_css);
		lightSensorLabel.getStyleClass().add(CssItemList.light_sensor_css);
		vocSensorLabel.getStyleClass().add(CssItemList.voc_sensor_css);
		dayLabel.getStyleClass().add(CssItemList.day_icon_css);
		nightLabel.getStyleClass().add(CssItemList.night_icon_css);

		lightLabel.setText("");
		acLabel.setText("");
		curtainLabel.setText("");
		temSensorLabel.setText("");
		humSensorLabel.setText("");
		lightSensorLabel.setText("");
		vocSensorLabel.setText("");
		dayLabel.setText("");
		nightLabel.setText("");

//		this.widthProperty().addListener((observable, oldValue, newValue) -> {
//
//		});
		this.heightProperty().addListener((observable, oldValue, newValue) -> {
			lightLabel.setPrefWidth(observable.getValue().doubleValue()* BoundarySize.cell_padding);
			lightLabel.setPrefHeight(observable.getValue().doubleValue()*BoundarySize.cell_padding);
			acLabel.setPrefWidth(observable.getValue().doubleValue()* BoundarySize.cell_padding);
			acLabel.setPrefHeight(observable.getValue().doubleValue()*BoundarySize.cell_padding);
			curtainLabel.setPrefWidth(observable.getValue().doubleValue()* BoundarySize.cell_padding);
			curtainLabel.setPrefHeight(observable.getValue().doubleValue()*BoundarySize.cell_padding);
			temSensorLabel.setPrefWidth(observable.getValue().doubleValue()* BoundarySize.cell_padding);
			temSensorLabel.setPrefHeight(observable.getValue().doubleValue()*BoundarySize.cell_padding);
			humSensorLabel.setPrefWidth(observable.getValue().doubleValue()* BoundarySize.cell_padding);
			humSensorLabel.setPrefHeight(observable.getValue().doubleValue()*BoundarySize.cell_padding);
			lightSensorLabel.setPrefWidth(observable.getValue().doubleValue()* BoundarySize.cell_padding);
			lightSensorLabel.setPrefHeight(observable.getValue().doubleValue()*BoundarySize.cell_padding);
			vocSensorLabel.setPrefWidth(observable.getValue().doubleValue()* BoundarySize.cell_padding);
			vocSensorLabel.setPrefHeight(observable.getValue().doubleValue()*BoundarySize.cell_padding);
			dayLabel.setPrefWidth(observable.getValue().doubleValue()* BoundarySize.cell_padding);
			dayLabel.setPrefHeight(observable.getValue().doubleValue()*BoundarySize.cell_padding);
			nightLabel.setPrefWidth(observable.getValue().doubleValue()* BoundarySize.cell_padding);
			nightLabel.setPrefHeight(observable.getValue().doubleValue()*BoundarySize.cell_padding);
		});
	}
}
