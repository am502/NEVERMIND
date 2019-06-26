package ru.itis.singledraft;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class SingleDraft {
    private static final int K = 3;

    public static void main(String[] args) {
        List<String> heroes = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("src/main/resources/heroes.txt"))) {
            while (scanner.hasNextLine()) {
                heroes.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int size = heroes.size();
        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i);
            String temp = heroes.get(i);
            heroes.set(i, heroes.get(j));
            heroes.set(j, temp);
        }
        System.out.println(heroes.stream().limit(K).collect(Collectors.toList()));
    }
}
