package ru.itis.worker.impl;

import ru.itis.worker.StartPauseFrame;
import ru.itis.worker.Worker;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RightClicker implements Worker {
	private static final int DELAY = 2000;

	private Robot robot;

	public RightClicker() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void workOneTime() {
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.delay(DELAY);
	}

	public static void main(String[] args) {
		Worker worker = new RightClicker();
		EventQueue.invokeLater(() -> new StartPauseFrame(worker, 5000));
	}
}
