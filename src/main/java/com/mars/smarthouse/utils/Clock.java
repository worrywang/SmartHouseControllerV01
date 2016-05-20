package com.mars.smarthouse.utils;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/5/2.
 */
public class Clock extends Parent {
	private Calendar calendar = Calendar.getInstance();

	private Digit[] digits;

	private Timeline delayTimeline, secondTimeline;



	public Clock(Color onColor, Color offColor) {

		// create effect for on LEDs

		Glow onEffect = new Glow(1.3f);

		onEffect.setInput(new InnerShadow());

		// create effect for on dot LEDs

		Glow onDotEffect = new Glow(1.0f);

		onDotEffect.setInput(new InnerShadow(5, Color.GRAY));

		// create effect for off LEDs

		InnerShadow offEffect = new InnerShadow(5,Color.GRAY);

		// create digits

		digits = new Digit[7];

		for (int i = 0; i < 6; i++) {

			Digit digit = new Digit(onColor, offColor, onEffect, offEffect);

			digit.setLayoutX(i * 30 + ((i + 1) % 2) * 3);

			digits[i] = digit;

			getChildren().add(digit);

		}

		// create dots

		Group dots = new Group( //todo: 修改大小！！！

				new Circle(60-5, 16, 3, onColor),

				new Circle(60-7, 29, 3, onColor),

				new Circle((60 * 2-5), 16, 3, onColor),

				new Circle((60 * 2-7), 29, 3, onColor));

		dots.setEffect(onDotEffect);

		getChildren().add(dots);

		// update digits to current time and start timer to update every second

		refreshClocks();

	}



	private void refreshClocks() {

		calendar.setTimeInMillis(System.currentTimeMillis());

		int hours = calendar.get(Calendar.HOUR_OF_DAY);

		int minutes = calendar.get(Calendar.MINUTE);

		int seconds = calendar.get(Calendar.SECOND);

		digits[0].showNumber(hours / 10);

		digits[1].showNumber(hours % 10);

		digits[2].showNumber(minutes / 10);

		digits[3].showNumber(minutes % 10);

		digits[4].showNumber(seconds / 10);

		digits[5].showNumber(seconds % 10);

	}



	public void play() {

		// wait till start of next second then start a timeline to call refreshClocks() every second

		delayTimeline = new Timeline();

		delayTimeline.getKeyFrames().add(

				new KeyFrame(new Duration(1000 - (System.currentTimeMillis() % 1000)), new EventHandler<ActionEvent>() {

					@Override public void handle(ActionEvent event) {

						if (secondTimeline != null) {

							secondTimeline.stop();

						}

						secondTimeline = new Timeline();

						secondTimeline.setCycleCount(Timeline.INDEFINITE);

						secondTimeline.getKeyFrames().add(

								new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {



									@Override public void handle(ActionEvent event) {

										refreshClocks();

									}

								}));

						secondTimeline.play();

					}

				}));

		delayTimeline.play();

	}



	public void stop() {

		delayTimeline.stop();

		if (secondTimeline != null) {

			secondTimeline.stop();

		}

	}
}
