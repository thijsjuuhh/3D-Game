package com.thijsjuuhh.game;

import com.thijsjuuhh.game.input.Keys;
import com.thijsjuuhh.game.registry.Sprites;

public class Game {

	public static int time = 0;
	public static int seconds = 0;

	public static void update() {
		Keys.update();

		time++;
		if (time % 60 == 0) {
			seconds++;
			System.out.println(seconds);
		}

		basicKeys();
	}

	private static void basicKeys() {
		if (Keys.ESCAPE)
			System.exit(0);
	}

	public static void preInit() {
		Sprites.init();
	}
}
