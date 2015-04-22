package com.thijsjuuhh.game.registry;

import com.thijsjuuhh.game.graphics.Sprite;
import com.thijsjuuhh.game.graphics.SpriteSheet;

public class Sprites {

	public static SpriteSheet hotbar;

	public static Sprite cornerL;
	public static Sprite middle;
	public static Sprite cornerR;

	public static void init() {
		hotbar = new SpriteSheet("/layout/hotbar.png");

		cornerL = new Sprite(hotbar, 19, 20, 0, 0);
		middle = new Sprite(hotbar, 62, 20, 20, 0);
		cornerR = new Sprite(hotbar, 19, 20, 80, 0);

		System.out.println(cornerL);

	}

}
