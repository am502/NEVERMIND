package ru.itis.screensaver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AreaScreenSaver {
    public static final String PATH_TO_SCREENS = "src/main/resources/homework/screens/";

    private DateFormat dateFormat;
    private Robot robot;
    private Rectangle area;

    public AreaScreenSaver() {
        dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        JButton button = new JButton();
        button.setText("Start");
        button.addKeyListener(new KeyAdapter() {
            Point start;

            @Override
            public void keyTyped(KeyEvent event) {
                if (event.getKeyChar() == ' ') {
                    if (start == null) {
                        start = MouseInfo.getPointerInfo().getLocation();
                        button.setText("End");
                    } else if (area == null) {
                        Point end = MouseInfo.getPointerInfo().getLocation();
                        area = new Rectangle(start.x, start.y, end.x - start.x, end.y - start.y);
                        button.setText("Screen");
                    } else {
                        try {
                            BufferedImage image = robot.createScreenCapture(area);
                            ImageIO.write(image, "png",
                                    new File(PATH_TO_SCREENS + dateFormat.format(new Date()) + ".png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        JFrame frame = new JFrame();
        frame.add(button);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AreaScreenSaver();
    }
}
