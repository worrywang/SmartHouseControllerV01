package com.mars.smarthouse.ui.subpanel;

import com.mars.smarthouse.constant.BoundarySize;
import com.mars.smarthouse.constant.CssItemList;
import com.mars.smarthouse.constant.RelevantResource;
import com.mars.smarthouse.constant.Setting;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import resource.ResourceLoader;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/2.
 */
public class RoomViewPanel extends GridPane {

	@FXML
	private Button button00;
	@FXML
	private Button button01;
	@FXML
	private Button button02;
	@FXML
	private Button button03;
	@FXML
	private Button button04;
	@FXML
	private Button button05;
	@FXML
	private Button button06;
	@FXML
	private AnchorPane roomShowAnchorPane;

	private ImageView roomShowImageView;
	public RoomViewPanel(){
		FXMLLoader fxmlLoader = new FXMLLoader(ResourceLoader.getResource("fxml/room_view_panel.fxml"));
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

		button00.getStyleClass().add(CssItemList.button_content_font_size);
		button01.getStyleClass().add(CssItemList.button_content_font_size);
		button02.getStyleClass().add(CssItemList.button_content_font_size);
		button03.getStyleClass().add(CssItemList.button_content_font_size);
		button04.getStyleClass().add(CssItemList.button_content_font_size);
		button05.getStyleClass().add(CssItemList.button_content_font_size);
		button06.getStyleClass().add(CssItemList.button_content_font_size);

		//add image
		roomShowImageView = new ImageView(new Image(ResourceLoader.getResource(Setting.livingroom_img_path).toString()));
		roomShowAnchorPane.getChildren().add(roomShowImageView);
		//自适应
		this.widthProperty().addListener((observable, oldValue, newValue) -> {
//			button00.setPrefWidth(observable.getValue().doubleValue()* BoundarySize.room_device_button_width*BoundarySize.middle_button_width);
			button00.setMinWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button00.setMaxWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button01.setMinWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button01.setMaxWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button02.setMinWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button02.setMaxWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button03.setMinWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button03.setMaxWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button04.setMinWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button04.setMaxWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button05.setMinWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button05.setMaxWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button06.setMinWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);
			button06.setMaxWidth(observable.getValue().doubleValue() * BoundarySize.room_device_button_width * BoundarySize.middle_button_width);

			roomShowAnchorPane.setPrefWidth(observable.getValue().doubleValue() * BoundarySize.room_view_width);
			roomShowImageView.setFitWidth(roomShowAnchorPane.getPrefWidth());
		});
		this.heightProperty().addListener((observable, oldValue, newValue) -> {
			roomShowAnchorPane.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.room_view_height);
			roomShowImageView.setFitHeight(roomShowAnchorPane.getPrefHeight());
		});
	}

	public void updateRoomView(String currentRoom){
		//更新背景
		String room_img_url = Setting.livingroom_img_path;
		if(currentRoom.equals(RelevantResource.living_room)){
			room_img_url = Setting.livingroom_img_path;
		}else if(currentRoom.equals(RelevantResource.kitchen)){
			room_img_url = Setting.kitchen_img_path;
		}else if (currentRoom.equals(RelevantResource.dining_room)){
			room_img_url = Setting.diningroom_img_path;
		}else if (currentRoom.equals(RelevantResource.garage)){
			room_img_url = Setting.garage_img_path;
		}else if(currentRoom.equals(RelevantResource.study_room)){
			room_img_url = Setting.studyroom_img_path;
		}else if (currentRoom.equals(RelevantResource.bathroom00)){
			room_img_url = Setting.bathroom00_img_path;
		}else if (currentRoom.equals(RelevantResource.bathroom01)){
			room_img_url = Setting.bathroom01_img_path;
		}else if (currentRoom.equals(RelevantResource.bedroom00)){
			room_img_url = Setting.bedroom00_img_path;
		}else if (currentRoom.equals(RelevantResource.bedroom01)){
			room_img_url = Setting.bedroom01_img_path;
		}else if (currentRoom.equals(RelevantResource.hovel)){
			room_img_url = Setting.hovel_img_path;
		}

		roomShowImageView.setImage(new Image(ResourceLoader.getResource(room_img_url).toString()));
//		System.out.println("current room png path :"+room_img_url);
	}
}
