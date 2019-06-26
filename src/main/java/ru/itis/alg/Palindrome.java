package ru.itis.alg;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(findMax("1232144122"));
    }

    private static String findMax(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        String max = "" + text.charAt(0);
        for (int i = 0; i < text.length(); i++) {
            mark:
            for (int j = text.length() - 1; j > i; j--) {
                if (j - i >= max.length()) {
                    int left = i;
                    int right = j;
                    while (right > left) {
                        if (text.charAt(left) == text.charAt(right)) {
                            left++;
                            right--;
                        } else {
                            continue mark;
                        }
                    }
                    max = text.substring(i, j + 1);
                    break;
                } else {
                    break mark;
                }
            }
        }
        return max;
    }
}
