package com.thijsjuuhh.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.thijsjuuhh.game.graphics.Render;
import com.thijsjuuhh.game.input.Input;
import com.thijsjuuhh.game.registry.Sprites;

public class Display implements Runnable {

	private static JFrame frame;
	private Thread thread;
	private boolean running;
	public static boolean moved = false;

	private Render r;
	private BufferedImage i;
	private int[] pixels;

	public Display() {
		thread = new Thread(this, Refs.getTitle());

		r = new Render(Refs.getWidth(), Refs.getHeight());
		i = new BufferedImage(Refs.getWidth(), Refs.getHeight(), BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) i.getRaster().getDataBuffer()).getData();

		Input i = new Input();
		frame.addKeyListener(i);
		frame.addMouseMotionListener(i);
		frame.addMouseListener(i);
		frame.addMouseWheelListener(i);

	}

	public static void main(String[] args) {
		Game.preInit();
		frame = new Window(Refs.getTitle(), Refs.getWidth(), Refs.getHeight(), true);

		Display disp = new Display();

		disp.start();
	}

	private void start() {
		frame.setVisible(true);
		running = true;
		thread.start();
	}

	@Override
	public void run() {
		frame.requestFocus();

		int frames = 0;
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		int tickCount = 0;
		boolean ticked = false;
		while (running) {
			long currentTime = System.nanoTime();
			long passedTime = currentTime - previousTime;
			previousTime = currentTime;
			unprocessedSeconds += passedTime / 1000000000.0;
			while (unprocessedSeconds > secondsPerTick) {
				update();
				unprocessedSeconds -= secondsPerTick;
				ticked = true;
				tickCount++;
				if (tickCount % 60 == 0) {
					System.out.println(frames + "fps ");
					previousTime += 1000;
					frames = 0;
				}
			}
			if (ticked) {
				render();
				frames++;
			}
			render();
			frames++;
		}
	}

	private void render() {
		BufferStrategy bs = frame.getBufferStrategy();
		if (bs == null) {
			frame.createBufferStrategy(3);
			return;
		}

		r.renderSprite(20, 20, Sprites.test);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = r.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, Refs.getWidth(), Refs.getHeight());
		g.drawImage(i, 0, 0, Refs.getWidth() * Refs.getScale(), Refs.getHeight() * Refs.getScale(), null);
		g.dispose();
		bs.show();
	}

	private void update() {
		Game.update();
	}

	public static void moveFrame(int x, int y) {
		if (moved) {
			frame.setLocation(x, y);
		}
	}

}
