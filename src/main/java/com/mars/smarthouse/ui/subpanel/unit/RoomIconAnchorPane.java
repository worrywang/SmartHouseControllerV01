package com.mars.smarthouse.ui.subpanel.unit;

import com.mars.smarthouse.constant.RelevantResource;
import com.mars.smarthouse.ui.subpanel.MainPanel;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Created by Administrator on 2016/5/4.
 */
public class RoomIconAnchorPane extends AnchorPane {
	private Label roomLabel = new Label();
	private Rectangle rect = new Rectangle();
	private Circle circle = new Circle();
	private FadeTransition fadeTransition = new FadeTransition();
	private String roomName;

	public RoomIconAnchorPane(String currentFloorId, String currentRoomIdNum,
	                          double layoutx, double layouty, double width, double height) {
		roomName = currentRoomIdNum;
		double radius = width <= height ? (width / 2)*0.9: (height / 2)*0.9;
		this.setLayoutX(layoutx);
		this.setLayoutY(layouty);
		this.setMinWidth(width);
		this.setMinHeight(height);
		this.setPrefWidth(width);
		this.setPrefHeight(height);

		roomLabel.setLayoutX(0);
		roomLabel.setLayoutY(0);
		roomLabel.setPrefWidth(width);
		roomLabel.setPrefHeight(height);
		RadialGradient gradient = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true,
				CycleMethod.REPEAT, new Stop[] {
				new Stop(0, Color.valueOf("#ff0000")),
				new Stop(0.3, Color.valueOf("#ff0000")),
				new Stop(0.3, Color.valueOf("#f13535")),
				new Stop(0.64, Color.valueOf("#f13535")),
				new Stop(0.64, Color.valueOf("#ff5f5f")),
				new Stop(1, Color.valueOf("#ff5f5f")) });
		circle.setLayoutX(width / 2);
		circle.setLayoutY(height / 2);
		circle.setRadius(radius);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(0);
		// circle.setFill(Color.FIREBRICK);
		circle.setFill(gradient);
		circle.setVisible(false);
		fadeTransition = new FadeTransition(Duration.seconds(1), circle);
		fadeTransition.setFromValue(0.8);
		fadeTransition.setToValue(0.2);
		fadeTransition.setCycleCount(Timeline.INDEFINITE);
		fadeTransition.setAutoReverse(true);

		rect.setLayoutX(0);
		rect.setLayoutY(0);
		rect.setWidth(width);
		rect.setHeight(height);
		// rect.setStrokeWidth(0);
		rect.setStrokeWidth(3);
		rect.setStroke(Color.BLACK);
		rect.setFill(Color.POWDERBLUE);
		rect.setOpacity(0.3);
		rect.setCursor(Cursor.HAND);
		roomLabel.setText(roomName);
		roomLabel.setAlignment(Pos.CENTER);
		roomLabel.setTextFill(Color.RED);
		setId("roomName");
		getChildren().addAll(roomLabel, circle, rect);

		setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				MainPanel.currentFloorId = currentFloorId;
				// FXMLMainPadController.currentRoomId =
				// currentFloorId+currentRoomIdNum;
				MainPanel.currentRoomId = currentRoomIdNum;
				MainPanel.mainPad.setRoomChangeMonitor(true);
				System.out.println("room is clicked; "+"current floor: "+currentFloorId+"; current room: "+currentRoomIdNum);
			}
		});

	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public void setRoomStatusShow(String status) {
		if (status.equals(RelevantResource.ROOM_SECURITY)) {
			// rect.setFill(Paint.valueOf("#007eed"));
			rect.setFill(Color.LIGHTGREEN);
			rect.setOpacity(0.3);
			circle.setVisible(false);
			fadeTransition.stop();


		} else if (status.equals(RelevantResource.ROOM_WARNING)) {
			rect.setFill(Color.ORANGERED);
			rect.setOpacity(0.3);
			circle.setVisible(false);
			fadeTransition.stop();
		} else if (status.equals(RelevantResource.ROOM_UNSECURITY)) {
			rect.setFill(Color.LIGHTCYAN);
			rect.setOpacity(0.3);
			circle.setVisible(true);
			fadeTransition.play();
		}
	}

}
