package com.thijsjuuhh.game;

import com.thijsjuuhh.game.graphics.Render;
import com.thijsjuuhh.game.registry.Sprites;

public class Hotbar {

	public static void render(Render r) {

		r.renderSprite(0, 0, Sprites.cornerL);
		r.renderSprite(Sprites.cornerL.getWidth(), 0, Sprites.middle);
		r.renderSprite(Sprites.cornerL.getWidth() + Sprites.middle.getWidth(), 0, Sprites.cornerR);

	}

	public static void update() {

	}

}
