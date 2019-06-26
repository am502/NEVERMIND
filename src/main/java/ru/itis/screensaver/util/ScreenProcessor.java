package ru.itis.screensaver.util;

import ru.itis.screensaver.AreaScreenSaver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenProcessor {
    public static void main(String[] args) {
        for (File file : new File(AreaScreenSaver.PATH_TO_SCREENS).listFiles()) {
            try {
                BufferedImage screen = ImageIO.read(file);
                Graphics2D g2 = (Graphics2D) screen.getGraphics();
                g2.setStroke(new BasicStroke(10));
                g2.setColor(Color.BLACK);
                g2.drawRect(0, 0, screen.getWidth(), screen.getHeight());
                ImageIO.write(screen, "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
