package com.mars.smarthouse.ui.subpanel;

import com.mars.smarthouse.constant.CssItemList;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import resource.ResourceLoader;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/2.
 */
public class ApplicationInfoPanel extends GridPane{

	public ApplicationInfoPanel(){
		FXMLLoader fxmlLoader = new FXMLLoader(ResourceLoader.getResource("fxml/application_info_panel.fxml"));
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
//		this.getStyleClass().add(CssItemList.grid_pane_backeground_color_css);
//		this.getStyleClass().add(CssItemList.grid_pane_backeground_color_odd_css);
	}
}
