package ru.itis.robot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

public class Clicker {
    private static final int DELAY = 5000;

    private Robot robot;

    public Clicker() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public Robot getRobot() {
        return robot;
    }

    public static void main(String[] args) {
        Clicker clicker = new Clicker();
        clicker.getRobot().delay(DELAY);

        Timer timer = new Timer(DELAY, e -> clicker.getRobot().delay(DELAY));
        timer.start();

        while (true) {
            clicker.getRobot().mousePress(InputEvent.BUTTON1_DOWN_MASK);
            clicker.getRobot().mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            clicker.getRobot().delay(50);
        }
    }
}
