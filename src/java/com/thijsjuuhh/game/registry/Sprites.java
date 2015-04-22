package com.thijsjuuhh.game.registry;

import com.thijsjuuhh.game.graphics.Sprite;
import com.thijsjuuhh.game.graphics.SpriteSheet;

public class Sprites {

	public static SpriteSheet tests;

	public static Sprite test;

	public static void init() {
		tests = new SpriteSheet("/test/test.png");

		test = new Sprite(16, 16, 0, 0, tests);
	}

}
