package com.mars.smarthouse.ui.subpanel;

import com.mars.smarthouse.constant.BoundarySize;
import com.mars.smarthouse.constant.CssItemList;
import com.mars.smarthouse.constant.Setting;
import com.mars.smarthouse.utils.Clock;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import resource.ResourceLoader;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2016/5/2.
 */
public class MainLogoPanel extends GridPane{

	@FXML
	private Label dateShowLabel;
	@FXML
	private Label appNameLabel;
	@FXML
	private Group clockGroup;
	@FXML
	private StackPane logoImgStackPane;


	private Clock clock;
	private ImageView logoImgImageView;

	public MainLogoPanel(){
		FXMLLoader fxmlLoader = new FXMLLoader(ResourceLoader.getResource("fxml/main_logo_panel.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		logoImgImageView = new ImageView(new Image(ResourceLoader.getResource("imgs/home.png").toString()));
		logoImgStackPane.getChildren().add(logoImgImageView);
		default_init();
	}

	private void default_init(){
		//Ìí¼Ócss
		this.getStyleClass().add(CssItemList.panel_background_color_css);
		dateShowLabel.getStyleClass().add(CssItemList.clock_label_css);
		appNameLabel.getStyleClass().add(CssItemList.application_name_cass);
//		logoImgStackPane.getStyleClass().add(CssItemList.image_border_color);
		appNameLabel.setText(Setting.ApplicationName);
		renderClock();

		this.widthProperty().addListener((observable, oldValue, newValue) -> {
			logoImgStackPane.setPrefWidth(observable.getValue().doubleValue()*0.98);
			logoImgImageView.setFitWidth(logoImgStackPane.getPrefWidth()*0.98);
		});

		this.heightProperty().addListener((observable, oldValue, newValue) -> {
			logoImgStackPane.setPrefHeight(observable.getValue().doubleValue()* BoundarySize.main_logo_img_height_scale*0.98);
			logoImgImageView.setFitHeight(logoImgStackPane.getPrefHeight() * 0.98);

		});

	}

	private void renderClock(){
		clock = new Clock(Color.ORANGE, Color.WHITE);
		clock.setLayoutX(0);
		clock.setLayoutY(0);
		clockGroup.getChildren().add(clock);
		clock.play();

		Date date = new Date();
		SimpleDateFormat dateFm = new SimpleDateFormat("EEE, dd MMM yyyy", Locale.US);
		String currentTime = dateFm.format(date).toString();
		dateShowLabel.setText(currentTime);

	}

	public void setLabelPrefWidth(double value){
		dateShowLabel.setPrefWidth(value);

	}

	public void setLabelPreHeight(double value){

	}

}
