package ru.itis.letter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class SymbolSheet {
    public static final int LETTER_SIZE = 5;

    private static int[][] pixels;

    static {
        try {
            BufferedImage image = ImageIO.read(new FileInputStream("/resources/letter/symbols.png"));
            int height = image.getHeight();
            int width = image.getWidth();
            pixels = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    pixels[i][j] = image.getRGB(i, j);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] getPixels() {
        return pixels;
    }
}
