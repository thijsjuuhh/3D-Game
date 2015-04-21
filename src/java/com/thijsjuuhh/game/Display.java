package com.thijsjuuhh.game;

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
		while (running) {
			System.out.println("run: running");
		}
	}

}
