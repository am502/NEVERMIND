package ru.itis.letter;

import java.util.LinkedList;
import java.util.List;

public class TextProcessor {
    public static List<String> process(String text, int rowSymbolCount) {
        StringBuilder processed = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (Dictionary.getSymbolMap().containsKey(currentSymbol)) {
                processed.append(currentSymbol);
            }
        }

        List<String> lines = new LinkedList<>();

        StringBuilder line = new StringBuilder();
        for (String word : processed.toString().split("\\s+")) {
            if (line.length() + word.length() == rowSymbolCount) {
                line.append(word);
                lines.add(line.toString());
                line = new StringBuilder();
            } else if (line.length() + word.length() > rowSymbolCount) {
                for (int i = 0; i < rowSymbolCount - line.length(); i++) {
                    line.append(' ');
                }
                lines.add(line.toString());
                line = new StringBuilder();
                line.append(word);
                line.append(' ');
            } else {
                line.append(word);
                line.append(' ');
            }
        }

        return lines;
    }
}
