package com.mars.smarthouse.utils;

import javafx.scene.Parent;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Shear;

/**
 * Created by Administrator on 2016/5/2.
 */
public class Digit extends Parent {
	private static final boolean[][] DIGIT_COMBINATIONS = new boolean[][]{

			new boolean[]{true, false, true, true, true, true, true},

			new boolean[]{false, false, false, false, true, false, true},

			new boolean[]{true, true, true, false, true, true, false},

			new boolean[]{true, true, true, false, true, false, true},

			new boolean[]{false, true, false, true, true, false, true},

			new boolean[]{true, true, true, true, false, false, true},

			new boolean[]{true, true, true, true, false, true, true},

			new boolean[]{true, false, false, false, true, false, true},

			new boolean[]{true, true, true, true, true, true, true},

			new boolean[]{true, true, true, true, true, false, true}};

	private final Polygon[] polygons = new Polygon[]{

//			new Polygon(2, 0, 22, 0, 17, 5, 7, 5),
			new Polygon(2, 0, 18, 0, 14, 5, 5, 5),

			new Polygon(7, 18, 16, 18, 20, 20, 16, 23, 7f, 23f, 2f, 20f),

			new Polygon(7, 36, 16, 36, 18, 41, 2, 41),

			new Polygon(0, 2, 5, 5, 5, 16, 0, 18),

			new Polygon(15, 5, 20, 2, 20, 18, 15, 16),
//			new Polygon(2, 0, 18, 0, 14, 5, 5, 5),

			new Polygon(0, 22, 5, 25, 5, 36, 0, 38),

			new Polygon(15, 25, 20, 22, 20, 38, 15, 36)};

	private final Polygon[] polygons_2 = new Polygon[]{

			new Polygon(2, 0, 22, 0, 17, 5, 7, 5),

			new Polygon(7, 18, 17, 18, 22, 20, 17, 23, 7f, 23f, 2f, 20f),

			new Polygon(7, 36, 17, 36, 22, 41, 2, 41),

			new Polygon(0, 2, 5, 5, 5, 16, 0, 18),

			new Polygon(19, 5, 24, 2, 24, 18, 19, 16),

			new Polygon(0, 22, 5, 25, 5, 36, 0, 38),

			new Polygon(19, 25, 24, 22, 24, 38, 19, 36)};

	private final Color onColor;

	private final Color offColor;

	private final Effect onEffect;

	private final Effect offEffect;



	public Digit(Color onColor, Color offColor, Effect onEffect, Effect offEffect) {

		this.onColor = onColor;

		this.offColor = offColor;

		this.onEffect = onEffect;

		this.offEffect = offEffect;


		getChildren().addAll(polygons);

		getTransforms().add(new Shear(-0.1, 0));

		showNumber(0);

	}



	public final void showNumber(Integer num) {

		if (num < 0 || num > 9) {

			num = 0; // default to 0 for non-valid numbers

		}

		for (int i = 0; i < 7; i++) {

			polygons[i].setFill(DIGIT_COMBINATIONS[num][i] ? onColor : offColor);

			polygons[i].setEffect(DIGIT_COMBINATIONS[num][i] ? onEffect : offEffect);

		}

	}
}
