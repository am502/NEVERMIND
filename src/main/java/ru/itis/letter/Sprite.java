package ru.itis.letter;

import java.util.Arrays;

public class Sprite {
    private int[] pixels;

    public Sprite(int[] pixels) {
        this.pixels = pixels;
    }

    public static Sprite getLetterSprite(int row, int column) {
        int[] pixels = new int[Parameters.getPixelSize() * Parameters.getPixelSize()
                * LetterSheet.LETTER_SIZE * LetterSheet.LETTER_SIZE];

        return new Sprite(pixels);
    }

    public static Sprite getColorSprite(int height, int width, int color) {
        int[] pixels = new int[height * width * Parameters.getPixelSize() * Parameters.getPixelSize()];
        Arrays.fill(pixels, color);
        return new Sprite(pixels);
    }
}
