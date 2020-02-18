package ru.itis.letter;

import java.util.Arrays;

public class Sprite {
    private int[][] pixels;

    public Sprite(int[][] pixels) {
        this.pixels = pixels;
    }

    public static Sprite getLetterSprite(int row, int column) {
        int[][] pixels = new int[SymbolSheet.LETTER_SIZE][SymbolSheet.LETTER_SIZE];

        int rowIndex = 1 + SymbolSheet.LETTER_SIZE * row + row;
        int columnIndex = 1 + SymbolSheet.LETTER_SIZE * column + column;

        for (int i = 0; i < SymbolSheet.LETTER_SIZE; i++) {
            for (int j = 0; j < SymbolSheet.LETTER_SIZE; j++) {
                pixels[i][j] = SymbolSheet.getPixels()[i + rowIndex][j + columnIndex];
            }
        }

        return new Sprite(pixels);
    }

    public static Sprite getColorSprite(int height, int width, int color) {
        int[][] pixels = new int[height][width];
        for (int[] row : pixels) {
            Arrays.fill(row, color);
        }
        return new Sprite(pixels);
    }

    public int[][] getPixels() {
        return pixels;
    }
}
