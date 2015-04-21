package com.thijsjuuhh.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Display implements Runnable {

	private static JFrame frame;
	private Thread thread;
	private boolean running;

	public Display() {
		thread = new Thread(this, Refs.getTitle());
	}

	public static void main(String[] args) {
		Display disp = new Display();

		frame = new Window(Refs.getTitle(), Refs.getWidth(), Refs.getHeight(), true);

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
		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, Refs.getWidth(), Refs.getHeight());
		g.dispose();
		bs.show();

	}

	private void update() {
		Game.update();
	}
}
