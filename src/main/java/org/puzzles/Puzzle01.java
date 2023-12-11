package org.puzzles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Character.isDigit;

public class Puzzle01 {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("/home/slanja/IdeaProjects/AoC2023.java/src/main/java/org/puzzles/inputPuzzle01.txt"));

            int sum = 0;

            // creating hash map
            HashMap<String, Integer> numberInstance = new HashMap<>();

            numberInstance.put("one", 1);
            numberInstance.put("two", 2);
            numberInstance.put("three", 3);
            numberInstance.put("four", 4);
            numberInstance.put("five", 5);
            numberInstance.put("six", 6);
            numberInstance.put("seven", 7);
            numberInstance.put("eight", 8);
            numberInstance.put("nine", 9);

            for (String line : lines) {

                // replacing words with numbers using hash map
                for (Map.Entry<String, Integer> entry : numberInstance.entrySet()) {
                    line = line.replace(entry.getKey(), String.valueOf(entry.getValue()));
                }
                System.out.println(line);

                int first = 0;

                // checking number from start
                for (int f = 0; f < line.length(); f++) {
                    // checking if current character is number
                    if (isDigit(line.charAt(f))) {
                        // System.out.println(line.charAt(f));
                        first = Integer.parseInt(String.valueOf(line.charAt(f)));
                        break;
                    }
                }

                int last = 0;

                // checking number from end
                for (int l = line.length() - 1; l > 0; l--) {
                    // checking if current character is number
                    if (isDigit(line.charAt(l))) {
                        // System.out.println(line.charAt(l));
                        last = Integer.parseInt(String.valueOf(line.charAt(l)));
                        break;
                    }
                }

                // combining first and last number to one string
                System.out.println();
                System.out.println("First: " + first);
                System.out.println("Last: " + last);
                System.out.println();

                int result = first * 10 + last;
                sum += result;
            }
            // 29, 83, 13, 24, 42, 14, 76 = 281
            System.out.println("Result: " + sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}