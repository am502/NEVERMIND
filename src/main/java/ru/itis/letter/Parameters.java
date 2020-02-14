package ru.itis.letter;

public class Parameters {
    private static int pixelSize = 1;
    private static int letterGap = 1;

    public static int getPixelSize() {
        return pixelSize;
    }

    public static void setPixelSize(int pixelSize) {
        Parameters.pixelSize = pixelSize;
    }

    public static int getLetterGap() {
        return letterGap;
    }

    public static void setLetterGap(int letterGap) {
        Parameters.letterGap = letterGap;
    }
}
