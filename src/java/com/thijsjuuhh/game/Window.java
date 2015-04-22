package com.thijsjuuhh.game;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;

	public Window(String t, int w, int h, boolean u, boolean full, int mon) {
		setTitle(t);
		setSize(new Dimension(w, h));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(u);
		if (mon == 0) {
			setLocationRelativeTo(null);

			if (full) {
				setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		}
		if (mon == 1) {
			GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice[] devices = g.getScreenDevices();

			setLocation(0 - devices[1].getDisplayMode().getWidth(), 0);

			if (full) {
				setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		}
	}

}
