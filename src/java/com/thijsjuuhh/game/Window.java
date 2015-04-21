package com.thijsjuuhh.game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;

	public Window(String t, int w, int h, boolean u) {
		setTitle(t);
		setSize(new Dimension(w, h));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(u);
		setLocationRelativeTo(null);
	}

}
