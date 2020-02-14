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

        int rowIndex = 1 + LetterSheet.LETTER_SIZE * row + row;
        int columnIndex = 1 + LetterSheet.LETTER_SIZE * column + column;

        for (int i = 0; i < LetterSheet.LETTER_SIZE; i++) {
            for (int j = 0; j < LetterSheet.LETTER_SIZE; j++) {
//                int currentPixel = LetterSheet.getPixels()[] convert to matrix ?
            }
        }

        return new Sprite(pixels);
    }

    public static Sprite getColorSprite(int height, int width, int color) {
        int[] pixels = new int[height * width * Parameters.getPixelSize() * Parameters.getPixelSize()];
        Arrays.fill(pixels, color);
        return new Sprite(pixels);
    }
}
