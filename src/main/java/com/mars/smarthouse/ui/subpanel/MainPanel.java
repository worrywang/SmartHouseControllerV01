package com.mars.smarthouse.ui.subpanel;

import com.mars.smarthouse.constant.Setting;
import com.mars.smarthouse.datacenter.MainPad;
import com.mars.smarthouse.constant.BoundarySize;
import com.mars.smarthouse.constant.CssItemList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import resource.ResourceLoader;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/1.
 */
public class MainPanel extends GridPane{

	public static  Stage currentMainStage;

	public static MainPad mainPad = new MainPad();
	public static String currentFloorId;
	public static String currentRoomId;

	public static boolean AUTO_REFRESH = true;
	public static boolean IsDeviceMangementHasUnistall  = true;
	public static boolean control_refresh_data_structure = false;
	public static boolean DUMMY_DATA = true;

	private HouseViewPanel houseViewPanel;
	private HouseInfoPanel houseInfoPanel;
	private HouseDeviceInfoPanel houseDeviceInfoPanel;
	private MainLogoPanel mainLogoPanel;
	private ControlPanel controlPanel;
	private LegendPanel legendPanel;
	private RoomViewPanel roomViewPanel;
	private RoomInfoPanel roomInfoPanel;
	private ApplicationInfoPanel applicationInfoPanel;

	@FXML
	private GridPane mainGridPane;
	@FXML
	private GridPane leftGridPane;
	@FXML
	private GridPane middleGridPane;
	@FXML
	private GridPane rightGridPane;
	@FXML
	private Label mainTitleLabel;

	public MainPanel(Stage stage){
		this.currentMainStage = stage;
		FXMLLoader fxmlLoader = new FXMLLoader(ResourceLoader.getResource("fxml/main_panel.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.getStylesheets().add(CssItemList.main_theme_default_dir);
		default_init();
		itemBindingOrListener();
	}


	private void default_init(){
		//
		mainPad.setLogMsgMonitor(false);
		mainPad.setFloorChangeMonitor(false);
		mainPad.setRoomChangeMonitor(false);
		//子面板初始化
		houseViewPanel = new HouseViewPanel();
		houseInfoPanel =new HouseInfoPanel();
		houseDeviceInfoPanel = new HouseDeviceInfoPanel();
		mainLogoPanel = new MainLogoPanel();
		controlPanel = new ControlPanel();
		legendPanel = new LegendPanel();
		roomViewPanel = new RoomViewPanel();
		roomInfoPanel = new RoomInfoPanel();
		applicationInfoPanel = new ApplicationInfoPanel();

		leftGridPane.add(houseViewPanel,0,0);
		leftGridPane.add(houseInfoPanel,0,2);
		leftGridPane.add(houseDeviceInfoPanel,0,4);
		middleGridPane.add(mainLogoPanel,0,0);
		middleGridPane.add(controlPanel,0,1);
		middleGridPane.add(legendPanel,0,2);
		rightGridPane.add(roomViewPanel,0,0);
		rightGridPane.add(roomInfoPanel,0, 2);
		rightGridPane.add(applicationInfoPanel, 0, 4);

		//子面板自适应
		leftGridPane.widthProperty().addListener((observable, oldValue, newValue) ->{
			houseViewPanel.setPrefWidth(observable.getValue().doubleValue());
			houseInfoPanel.setPrefWidth(observable.getValue().doubleValue());
			houseDeviceInfoPanel.setPrefWidth(observable.getValue().doubleValue());
		});
		leftGridPane.heightProperty().addListener((observable, oldValue, newValue) -> {
			houseViewPanel.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.house_view_panel_height_scale);
			houseInfoPanel.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.house_info_panel_height_scale);
			houseDeviceInfoPanel.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.house_device_info_panel_height_scale);
		});

		middleGridPane.widthProperty().addListener((observable, oldValue, newValue) -> {
			mainLogoPanel.setPrefWidth(observable.getValue().doubleValue());
			controlPanel.setPrefWidth(observable.getValue().doubleValue());
			legendPanel.setPrefWidth(observable.getValue().doubleValue());
		});
		middleGridPane.heightProperty().addListener((observable, oldValue, newValue) -> {
			mainLogoPanel.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.main_logo_panel_height_scale);
			controlPanel.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.control_panel_height_scale);
			legendPanel.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.legend_panel_height_scale);
		});

		rightGridPane.widthProperty().addListener((observable, oldValue, newValue) -> {
			roomViewPanel.setPrefWidth(observable.getValue().doubleValue());
			roomInfoPanel.setPrefWidth(observable.getValue().doubleValue());
			applicationInfoPanel.setPrefWidth(observable.getValue().doubleValue());
		});

		rightGridPane.heightProperty().addListener((observable, oldValue, newValue) -> {
			roomViewPanel.setPrefHeight(observable.getValue().doubleValue()*BoundarySize.room_view_panel_height_scale);
			roomInfoPanel.setPrefHeight(observable.getValue().doubleValue() * BoundarySize.room_info_panel_height_scale);
			applicationInfoPanel.setPrefHeight(observable.getValue().doubleValue()*BoundarySize.application_info_panel_height_scale);
		});


	}


	private void itemBindingOrListener(){
		mainPad.floorChangeMonitorProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (mainPad.getFloorChangeMonitor()){
					RenderHouseInfoPane();
					mainPad.setFloorChangeMonitor(false);
				}
			}
		});

		mainPad.roomChangeMonitorProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (mainPad.getRoomChangeMonitor()){
//					System.out.println("room change is true ....");
					RenderRoomInfoPane();
					mainPad.setRoomChangeMonitor(false);
				}
			}
		});

		mainPad.streetRootMonitorProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(mainPad.getStreetRootMonitor()){
//					synchronized (mainPad.getBuilding()){
//						mainPad.UpdateDataBuffer();
//						mainPad.startReasoning();
//					}
					System.out.println("maiPad street root monitor .....change"+Setting.count);
					houseInfoPanel.setLabelInfo(Setting.count);
					roomInfoPanel.setLabelInfo(Setting.count);
					mainPad.setFloorChangeMonitor(true);
					mainPad.setRoomChangeMonitor(true);
					mainPad.setStreetRootMonitor(false);
				}
			}
		});
	}

	private void RenderHouseInfoPane(){
		houseViewPanel.updateHouseView(currentFloorId);
		houseInfoPanel.updateHouseInfo(currentFloorId);
		houseDeviceInfoPanel.updateHouseDeviceInfo(currentFloorId);
////////////////////////////////////////////////////
		houseInfoPanel.setLabelInfo(Setting.count);
	}

	private void RenderRoomInfoPane(){
		roomViewPanel.updateRoomView(currentRoomId);
		roomInfoPanel.updateRoomInfo(currentRoomId);
		//////////////////////////////////////////
		roomInfoPanel.setLabelInfo(Setting.count);

	}


}
