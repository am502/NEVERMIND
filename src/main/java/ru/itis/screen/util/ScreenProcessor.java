package ru.itis.screen.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ScreenProcessor {
    public static void main(String[] args) {
        float strokeSize = 10;
        if (args.length == 0) {
            JOptionPane.showMessageDialog(null, "java -jar *.jar arg");
        } else {
            strokeSize = Float.parseFloat(args[0]);
        }
        try {
            for (File file : Objects.requireNonNull(new File(".").listFiles())) {
                try {
                    BufferedImage screen = ImageIO.read(file);
                    Graphics2D g2 = (Graphics2D) screen.getGraphics();
                    g2.setStroke(new BasicStroke(strokeSize));
                    g2.setColor(Color.BLACK);
                    g2.drawRect(0, 0, screen.getWidth(), screen.getHeight());
                    ImageIO.write(screen, "png", file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Not found");
        }
    }
}
