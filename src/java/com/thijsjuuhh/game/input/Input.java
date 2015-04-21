package com.thijsjuuhh.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.thijsjuuhh.game.Display;
import com.thijsjuuhh.game.Game;

public class Input implements MouseListener, MouseMotionListener, KeyListener, MouseWheelListener {

	static boolean[] keys = new boolean[10000];
	static boolean left = false, right = false, middle = false;

	static boolean scrollUp = false;
	static boolean scrollDown = false;

	static int x = 0, y = 0;

	private int startX = 0, startY = 0;
	private boolean start = false;

	static int time = Game.time;
	static int i = 0;
	private static int scroll;

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Display.moved = true;

		if (!start) {
			startX = e.getX();
			startY = e.getY();
			start = true;
		}
		if (start) {
			Display.moveFrame(e.getXOnScreen() - startX, e.getYOnScreen() - startY);
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:
			left = true;
			break;
		case 2:
			middle = true;
			break;
		case 3:
			right = true;
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		start = false;
		switch (e.getButton()) {
		case 1:
			left = false;
			break;
		case 2:
			middle = false;
			break;
		case 3:
			right = false;
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll = e.getWheelRotation();
		i++;
	}

	public static void update() {
		if (time - i >= 1) {
			scroll = 0;
			i = time;
		}

		if (scroll < 0) {
			scrollUp = true;
			scrollDown = false;
		} else if (scroll > 0) {
			scrollDown = true;
			scrollUp = false;
		} else if (scroll == 0) {
			scrollDown = false;
			scrollUp = false;
		}
		time = Game.time;
	}

}