package com.thijsjuuhh.game;

public class Game {

	public static int time = 0;
	public static int seconds = 0;

	public static void update() {
		time++;
		if (time % 60 == 0) {
			seconds++;
			System.out.println(seconds);
		}
	}

}
