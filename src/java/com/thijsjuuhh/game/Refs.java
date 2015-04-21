package com.thijsjuuhh.game;

public class Refs extends Object {

	private static String title = "game";
	private static int width = 800;
	private static int height = width / 16 * 9;
	private static int scale = 3;

	public static String getTitle() {
		return title;
	}

	public static void setTitle(String title) {
		Refs.title = title;
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		Refs.width = width;
	}

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		Refs.height = height;
	}

	public static int getScale() {
		return scale;
	}

	public static void setScale(int scale) {
		Refs.scale = scale;
	}

}
