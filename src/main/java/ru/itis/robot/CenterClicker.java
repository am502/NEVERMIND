package ru.itis.robot;

import java.awt.*;
import java.awt.event.InputEvent;

public class CenterClicker {
    private static final int DELAY = 5000;

    public static void main(String[] args) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Dimension screenArea = Toolkit.getDefaultToolkit().getScreenSize();
        while (true) {
            robot.delay(DELAY);
            robot.mouseMove((int) screenArea.getWidth() / 2, (int) screenArea.getHeight() / 2);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }
}
