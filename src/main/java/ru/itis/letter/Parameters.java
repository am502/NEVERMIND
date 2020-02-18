package ru.itis.letter;

public class Parameters {
    private static int pixelSize = 1;
    private static int letterGap = 1;
    private static int rowSymbolCount = 1;

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

    public static int getRowSymbolCount() {
        return rowSymbolCount;
    }

    public static void setRowSymbolCount(int rowSymbolCount) {
        Parameters.rowSymbolCount = rowSymbolCount;
    }
}
