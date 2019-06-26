package ru.itis.screensaver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.WindowConstants.*;

public class SimpleScreenSaver {
    private static int id = 0;
    private Robot robot;

    public SimpleScreenSaver() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ') {
                    try {
                        BufferedImage image = robot.createScreenCapture(
                                new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                        ImageIO.write(image, "png",
                                new File("src/main/resources/homework/screens/" + getId() + ".png"));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static int getId() {
        id++;
        return id;
    }

    public static void main(String[] args) {
        new SimpleScreenSaver();
    }
}
