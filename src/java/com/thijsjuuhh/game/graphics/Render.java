package com.thijsjuuhh.game.graphics;

public class Render {

	public final int width, height;
	public int[] pixels;

	public Render(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void renderSprite(int xO, int yO, Sprite s) {
		if (s == null) {
			System.out.println(xO + "" + s);
		}
		for (int y = 0; y < s.getHeight(); y++) {
			int yOff = y + yO;
			for (int x = 0; x < s.getWidth(); x++) {
				int xOff = x + xO;
				int color = s.pixels[x + y * s.getWidth()];
				if (color != 0xffff00ff)
					pixels[xOff + yOff * width] = color;

			}
		}
	}
}
