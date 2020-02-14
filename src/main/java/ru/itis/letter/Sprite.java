package ru.itis.letter;

public class Sprite {
    private int[] pixels;

    public Sprite(int[] pixels) {
        this.pixels = pixels;
    }

    public static Sprite getLetterSprite(int row, int column) {
        int[] pixels = new int[Parameters.getPixelSize() * Parameters.getPixelSize()
                * LetterSheet.LETTER_SIZE * LetterSheet.LETTER_SIZE];
    }
}
