package com.thijsjuuhh.game.graphics;

public class Sprite {

	private int w, h, x, y;
	private SpriteSheet s;
	public int[] pixels;

	public Sprite(int w, int h, int x, int y, SpriteSheet s) {
		this.w = w;
		this.h = h;
		this.x = x * w;
		this.y = y * h;
		this.s = s;

		pixels = new int[w * h];

		load();
	}

	public Sprite(SpriteSheet s, int w, int h, int x, int y) {
		this.w = w;
		this.h = h;
		System.out.println("h set");
		this.x = x;
		this.y = y;
		this.s = s;

		pixels = new int[w * h];

		load();
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	private void load() {
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				pixels[x + y * w] = s.pixels[(x + this.x) + (y + this.y) * s.getWidth()];
			}
		}
	}

}
