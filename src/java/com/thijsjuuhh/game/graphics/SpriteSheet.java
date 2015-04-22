package com.thijsjuuhh.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private int w, h;
	private String path;
	public int[] pixels;

	public SpriteSheet(String p) {
		path = p;

		load();
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	private void load() {
		try {
			BufferedImage i = ImageIO.read(SpriteSheet.class.getResource(path));
			w = i.getWidth();
			h = i.getHeight();
			pixels = new int[w * h];
			i.getRGB(0, 0, w, h, pixels, 0, w);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
