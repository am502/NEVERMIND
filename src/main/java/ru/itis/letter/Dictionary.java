package ru.itis.letter;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private static Map<Character, Sprite> symbolMap = new HashMap<>();

    static {
        symbolMap.put('a', Sprite.getLetterSprite(0, 0));
        symbolMap.put('b', Sprite.getLetterSprite(0, 1));
        symbolMap.put('c', Sprite.getLetterSprite(0, 2));
        symbolMap.put('d', Sprite.getLetterSprite(0, 3));
        symbolMap.put('e', Sprite.getLetterSprite(0, 4));
        symbolMap.put('f', Sprite.getLetterSprite(0, 5));
        symbolMap.put('g', Sprite.getLetterSprite(0, 6));
        symbolMap.put('h', Sprite.getLetterSprite(0, 7));
        symbolMap.put('i', Sprite.getLetterSprite(0, 8));
        symbolMap.put('j', Sprite.getLetterSprite(0, 9));
        symbolMap.put('k', Sprite.getLetterSprite(0, 10));
        symbolMap.put('l', Sprite.getLetterSprite(0, 11));
        symbolMap.put('m', Sprite.getLetterSprite(0, 12));
        symbolMap.put('n', Sprite.getLetterSprite(0, 13));
        symbolMap.put('o', Sprite.getLetterSprite(0, 14));
        symbolMap.put('p', Sprite.getLetterSprite(0, 15));
        symbolMap.put('q', Sprite.getLetterSprite(0, 16));
        symbolMap.put('r', Sprite.getLetterSprite(0, 17));
        symbolMap.put('s', Sprite.getLetterSprite(0, 18));
        symbolMap.put('t', Sprite.getLetterSprite(0, 19));
        symbolMap.put('u', Sprite.getLetterSprite(0, 20));
        symbolMap.put('v', Sprite.getLetterSprite(0, 21));
        symbolMap.put('w', Sprite.getLetterSprite(0, 22));
        symbolMap.put('x', Sprite.getLetterSprite(0, 23));
        symbolMap.put('y', Sprite.getLetterSprite(0, 24));
        symbolMap.put('z', Sprite.getLetterSprite(0, 25));

        symbolMap.put('0', Sprite.getLetterSprite(1, 0));
        symbolMap.put('1', Sprite.getLetterSprite(1, 1));
        symbolMap.put('2', Sprite.getLetterSprite(1, 2));
        symbolMap.put('3', Sprite.getLetterSprite(1, 3));
        symbolMap.put('4', Sprite.getLetterSprite(1, 4));
        symbolMap.put('5', Sprite.getLetterSprite(1, 5));
        symbolMap.put('6', Sprite.getLetterSprite(1, 6));
        symbolMap.put('7', Sprite.getLetterSprite(1, 7));
        symbolMap.put('8', Sprite.getLetterSprite(1, 8));
        symbolMap.put('9', Sprite.getLetterSprite(1, 9));
        symbolMap.put('.', Sprite.getLetterSprite(1, 10));
        symbolMap.put(',', Sprite.getLetterSprite(1, 11));
        symbolMap.put('-', Sprite.getLetterSprite(1, 12));
        symbolMap.put(' ', Sprite.getLetterSprite(1, 13));

        symbolMap.put('а', Sprite.getLetterSprite(2, 0));
        symbolMap.put('б', Sprite.getLetterSprite(2, 1));
        symbolMap.put('в', Sprite.getLetterSprite(2, 2));
        symbolMap.put('г', Sprite.getLetterSprite(2, 3));
        symbolMap.put('д', Sprite.getLetterSprite(2, 4));
        symbolMap.put('е', Sprite.getLetterSprite(2, 5));
        symbolMap.put('ж', Sprite.getLetterSprite(2, 6));
        symbolMap.put('з', Sprite.getLetterSprite(2, 7));
        symbolMap.put('и', Sprite.getLetterSprite(2, 8));
        symbolMap.put('к', Sprite.getLetterSprite(2, 9));
        symbolMap.put('л', Sprite.getLetterSprite(2, 10));
        symbolMap.put('м', Sprite.getLetterSprite(2, 11));
        symbolMap.put('н', Sprite.getLetterSprite(2, 12));
        symbolMap.put('о', Sprite.getLetterSprite(2, 13));
        symbolMap.put('п', Sprite.getLetterSprite(2, 14));
        symbolMap.put('р', Sprite.getLetterSprite(2, 15));
        symbolMap.put('с', Sprite.getLetterSprite(2, 16));
        symbolMap.put('т', Sprite.getLetterSprite(2, 17));
        symbolMap.put('у', Sprite.getLetterSprite(2, 18));
        symbolMap.put('ф', Sprite.getLetterSprite(2, 19));
        symbolMap.put('х', Sprite.getLetterSprite(2, 20));
        symbolMap.put('ц', Sprite.getLetterSprite(2, 21));
        symbolMap.put('ч', Sprite.getLetterSprite(2, 22));
        symbolMap.put('ш', Sprite.getLetterSprite(2, 23));
        symbolMap.put('щ', Sprite.getLetterSprite(2, 24));
        symbolMap.put('ъ', Sprite.getLetterSprite(2, 25));
        symbolMap.put('ы', Sprite.getLetterSprite(2, 26));
        symbolMap.put('ь', Sprite.getLetterSprite(2, 27));
        symbolMap.put('э', Sprite.getLetterSprite(2, 28));
        symbolMap.put('ю', Sprite.getLetterSprite(2, 29));
        symbolMap.put('я', Sprite.getLetterSprite(2, 30));
    }

    public static Map<Character, Sprite> getSymbolMap() {
        return symbolMap;
    }
}
