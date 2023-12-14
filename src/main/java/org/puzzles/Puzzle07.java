package org.puzzles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Puzzle07 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/home/slanja/IdeaProjects/AoC2023.java/src/main/java/org/puzzles/inputPuzzle07.txt"));

        HashMap<Integer, Integer> stats = new HashMap<>();

        String[] split;
        int bid = 0;


        for (String line : lines) {
            split = line.split(" ");
            System.out.println();

            bid = Integer.parseInt(split[1]);

            char[] cards = split[0].toCharArray();

            int force = CardType(cards);

            switch (cards[0]) {
                case 'A':
                    force += 14;
                    break;
                case 'K':
                    force += 13;
                    break;
                case 'Q':
                    force += 12;
                    break;
                case 'J':
                    force += 11;
                    break;
                case 'T':
                    force += 10;
                    break;
                case '9':
                    force += 9;
                    break;
                case '8':
                    force += 8;
                    break;
                case '7':
                    force += 7;
                    break;
                case '6':
                    force += 6;
                    break;
                case '5':
                    force += 5;
                    break;
                case '4':
                    force += 4;
                    break;
                case '3':
                    force += 3;
                    break;
                case '2':
                    force += 2;
                    break;
            }
            stats.put(force, bid);
            System.out.println(force);
        }

        List<Integer> byKey = new ArrayList<>(stats.keySet());
        Collections.sort(byKey);

        int sum = 0;

        for (int k = 0; k < 4; k++) {
            sum += stats.get(byKey.get(k)) * (k+1);
        }
        // get value na pozici sortnutého klíče a vynásobit value k+1
        System.out.println();
        System.out.println(stats);
        System.out.println(sum);


        // vytvoření hash mapy s key hodnotou síly karet v ruce a value bude sázka
    }

    public static int CardType(char[] cards) {
        HashMap<Character, Integer> labels = new HashMap<>();

        for (int c = 0; c < cards.length; c++) {
            char label = cards[c];
            int cur_value = labels.getOrDefault(label, 0);
            labels.put(label, cur_value + 1);
        }

        // Five of a kind
        if (labels.containsValue(5)) return 700;

        // Four of a kind
        if (labels.containsValue(4)) return 600;

        // Full house
        if (labels.containsValue(3) && labels.containsValue(2)) return 500;

        // Three of a kind
        if (labels.containsValue(3)) return 400;

        // Two pair
        boolean twopair = labels.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .count() == 2;
        if (twopair) return 300;

        // One pair
        if (labels.containsValue(2)) return 200;

        // High card
        return 100;
    }
}