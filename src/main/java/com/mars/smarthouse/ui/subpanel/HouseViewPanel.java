package com.mars.smarthouse.ui.subpanel;

import com.mars.smarthouse.constant.BoundarySize;
import com.mars.smarthouse.constant.CssItemList;
import com.mars.smarthouse.constant.RelevantResource;
import com.mars.smarthouse.constant.Setting;
import com.mars.smarthouse.ui.subpanel.unit.RoomIcon;
import com.mars.smarthouse.ui.subpanel.unit.RoomIconAnchorPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import resource.ResourceLoader;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/2.
 */
public class HouseViewPanel extends GridPane{

	@FXML
	private TabPane floorTabPane;
	@FXML
	private AnchorPane floor01ShowAnchorPane;
	@FXML
	private AnchorPane floor02ShowAnchorPane;
	@FXML
	private Tab floor01Tab;
	@FXML
	private Tab floor02Tab;

	private ImageView floor01ImageView;
	private ImageView floor02ImageView;

	public HouseViewPanel(){

		FXMLLoader fxmlLoader = new FXMLLoader(ResourceLoader.getResource("fxml/house_view_panel.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		default_init();
		itemBindingOrListener();
	}

	private void default_init(){
		//add css
		floor01ShowAnchorPane.getStyleClass().add(CssItemList.panel_background_color_css);
		floor02ShowAnchorPane.getStyleClass().add(CssItemList.panel_background_color_css);

		//add image
		floor01ImageView = new ImageView(new Image(ResourceLoader.getResource("imgs/floor01.png").toString()));
		floor02ImageView = new ImageView(new Image(ResourceLoader.getResource("imgs/floor02.png").toString()));
		floor01ShowAnchorPane.getChildren().add(floor01ImageView);
		floor02ShowAnchorPane.getChildren().add(floor02ImageView);
		floor01Tab.setText(RelevantResource.floor01_name);
		floor02Tab.setText(RelevantResource.floor02_name);



		this.widthProperty().addListener((observable, oldValue, newValue) -> {
//			System.out.println("width : " + observable.getValue().doubleValue() + "; height: " + this.getHeight());
//			System.out.println("anchorpane width : " + floor01ShowAnchorPane.getWidth() + "; height:" + floor01ShowAnchorPane.getHeight());
			floor01ImageView.setFitWidth(observable.getValue().doubleValue());
			floor02ImageView.setFitWidth(observable.getValue().doubleValue());
			setRoomIcon();
		});

		this.heightProperty().addListener((observable, oldValue, newValue) -> {
			floor01ImageView.setFitHeight(observable.getValue().doubleValue() - BoundarySize.tabpane_head_height);
			floor02ImageView.setFitHeight(observable.getValue().doubleValue() - BoundarySize.tabpane_head_height);
			setRoomIcon();
		});


	}

	private void itemBindingOrListener(){
		floorTabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
			@Override
			public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab currentTab) {
				if (currentTab!=null){
					MainPanel.currentFloorId = currentTab.getText();
					MainPanel.currentRoomId = getFloorCurrentRoom(MainPanel.currentFloorId);
					MainPanel.mainPad.setFloorChangeMonitor(true);
					MainPanel.mainPad.setRoomChangeMonitor(true);
				}
			}
		});
	}




	private void setRoomIcon(){
		//第一层
		double floor_width = floor01ImageView.getFitWidth();
		double floor_height = floor01ImageView.getFitHeight();
		floor01ShowAnchorPane.getChildren().clear();
		floor01ShowAnchorPane.getChildren().add(floor01ImageView);
		for(RoomIcon currentRoomIconData : RelevantResource.floor_1_room){
			RoomIconAnchorPane currentRoomIcon = new RoomIconAnchorPane(RelevantResource.floor01_name,currentRoomIconData.getRoomId(),floor_width*currentRoomIconData.getLayoutX(),
					floor_height*currentRoomIconData.getLayoutY(),floor_width*currentRoomIconData.getWidth(),floor_height*currentRoomIconData.getHeight());
			floor01ShowAnchorPane.getChildren().add(currentRoomIcon);

		}
		//第二层
		floor02ShowAnchorPane.getChildren().clear();
		floor02ShowAnchorPane.getChildren().add(floor02ImageView);
		for(RoomIcon currentRoomIconData: RelevantResource.floor_2_room){
			RoomIconAnchorPane currentRoomIcon = new RoomIconAnchorPane(RelevantResource.floor02_name,currentRoomIconData.getRoomId(),floor_width*currentRoomIconData.getLayoutX(),
					floor_height*currentRoomIconData.getLayoutY(),floor_width*currentRoomIconData.getWidth(),floor_height*currentRoomIconData.getHeight());
			floor02ShowAnchorPane.getChildren().add(currentRoomIcon);
		}
	}

	public static String getFloorCurrentRoom(String floor){
		if(floor.equals(RelevantResource.floor01_name)){
			return RelevantResource.floor_1_room[0].getRoomId();
		}
		if(floor.equals(RelevantResource.floor02_name)){
			return RelevantResource.floor_2_room[0].getRoomId();
		}
		return null;
	}

	public void updateHouseView(String  currentFloorId){

	}
}
