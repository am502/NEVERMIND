package ru.itis.worker.impl;

import ru.itis.worker.StartPauseFrame;
import ru.itis.worker.Worker;

import java.awt.*;
import java.awt.event.InputEvent;

public class CenterClicker implements Worker {
	private static final int DELAY = 10000;

	private Robot robot;
	private int x;
	private int y;

	public CenterClicker() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		Dimension screenArea = Toolkit.getDefaultToolkit().getScreenSize();
		x = (int) screenArea.getWidth() / 2;
		y = (int) screenArea.getHeight() / 2;
	}

	@Override
	public void workOneTime() {
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(DELAY);
	}

	public static void main(String[] args) {
		Worker worker = new CenterClicker();
		EventQueue.invokeLater(() -> new StartPauseFrame(worker));
	}
}
