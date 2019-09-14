package ru.itis.worker;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class StartPauseFrame extends JFrame {
	private static final String START = "Start";
	private static final String PAUSE = "Pause";

	private JButton startPauseButton;
	private AtomicBoolean isPaused;

	public StartPauseFrame(Worker worker) {
		isPaused = new AtomicBoolean(true);

		startPauseButton = new JButton(START);
		startPauseButton.addActionListener(e -> startPause());

		add(startPauseButton);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();

		new Thread(() -> {
			while (true) {
				checkPause();
				worker.workOneTime();
			}
		}).start();
	}

	private synchronized void checkPause() {
		if (isPaused.get()) {
			try {
				wait();
			} catch (InterruptedException ignored) {
			}
		}
	}

	private synchronized void startPause() {
		isPaused.set(!isPaused.get());
		if (isPaused.get()) {
			startPauseButton.setText(START);
		} else {
			startPauseButton.setText(PAUSE);
			notifyAll();
		}
	}
}
