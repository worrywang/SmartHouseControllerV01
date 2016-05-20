package com.mars.smarthouse.ui.subpanel.unit;

/**
 * Created by Administrator on 2016/5/4.
 */
public class RoomIcon {
	private String roomId;
	private double layoutX;
	private double layoutY;
	private double width;
	private double height;
	public RoomIcon(String roomId,double layoutX,double layoutY,double width,double height){
		this.roomId = roomId;
		this.layoutX = layoutX;
		this.layoutY = layoutY;
		this.width = width;
		this.height = height;
	}

	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public double getLayoutX() {
		return layoutX;
	}
	public void setLayoutX(double layoutX) {
		this.layoutX = layoutX;
	}
	public double getLayoutY() {
		return layoutY;
	}
	public void setLayoutY(double layoutY) {
		this.layoutY = layoutY;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

}
