package ru.itis.letter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class LetterSheet {
    private static int[] pixels;

    static {
        try {
            BufferedImage image = ImageIO.read(new FileInputStream("/resources/letter/symbols.png"));
            int width = image.getWidth();
            int height = image.getHeight();
            pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] getPixels() {
        return pixels;
    }
}
