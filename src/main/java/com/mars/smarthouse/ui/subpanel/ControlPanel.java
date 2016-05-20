package com.mars.smarthouse.ui.subpanel;

import com.mars.smarthouse.constant.BoundarySize;
import com.mars.smarthouse.constant.Setting;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import resource.ResourceLoader;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/2.
 */
public class ControlPanel extends GridPane {

	@FXML
	private Button individuationButton;
	@FXML
	private Button autoControlButton;
	public ControlPanel(){
		FXMLLoader fxmlLoader = new FXMLLoader(ResourceLoader.getResource("fxml/control_panel.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		default_init();
		buttonBindingEvent();
	}

	private void default_init(){
		this.widthProperty().addListener((observable, oldValue, newValue) -> {
			individuationButton.setPrefWidth(observable.getValue().doubleValue() * BoundarySize.cell_padding);
			autoControlButton.setPrefWidth(observable.getValue().doubleValue() * BoundarySize.cell_padding);
		});
		this.heightProperty().addListener((observable, oldValue, newValue) -> {
			individuationButton.setPrefHeight(observable.getValue().doubleValue() * 0.3);
			autoControlButton.setPrefHeight(observable.getValue().doubleValue() * 0.3);
		});

		individuationButton.setText(Setting.IndividuationButtonName);
		autoControlButton.setText(Setting.AutoControlButtonName);
	}

	public static Stage device_management_stage;

	private void buttonBindingEvent(){
		individuationButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("个性化按钮按下");
				device_management_stage = new Stage();
				Parent root;
				try {
					if (MainPanel.IsDeviceMangementHasUnistall) {
						root = FXMLLoader.load(ResourceLoader.getResource("fxml/device_management_panel.fxml"));
					} else {
						root = FXMLLoader.load(ResourceLoader.getResource("fxml/device_management_panel_v2.fxml"));
					}
					Scene scene = new Scene(root, 400, 300);
					device_management_stage.initOwner(MainPanel.currentMainStage);
					device_management_stage.setTitle("智能别墅验证系统");
					device_management_stage.setScene(scene);
				}catch (Exception e){
					e.printStackTrace();
				}

				device_management_stage.initStyle(StageStyle.UTILITY);
				device_management_stage.initModality(Modality.APPLICATION_MODAL);
				device_management_stage.setResizable(false);
				device_management_stage.show();
			}
		});

		autoControlButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("自动控制按钮按下");
				Setting.count++;
				Setting.count = Setting.count%Setting.length;
				System.out.println("current count : "+Setting.count);
				MainPanel.mainPad.setStreetRootMonitor(true);

			}
		});
	}


}
