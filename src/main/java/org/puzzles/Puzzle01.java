package org.puzzles;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Character.isDigit;

public class Puzzle01 {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            List<String> lines = Files.readAllLines(Paths.get("/home/slanja/IdeaProjects/AoC2023.java/src/main/java/org/puzzles/inputPuzzle01.txt"));

            String replace;
            int sum = 0;

            for (String line : lines) {

                int first = 0;
                int firstIndex = 999;

                // replacing words with numbers
                if (line.contains("one") && firstIndex > line.indexOf(String.valueOf(line.contains("one")))) {
                    first = 1;
                    firstIndex = line.indexOf("one");
                }
                if (line.contains("two") && firstIndex > line.indexOf(String.valueOf(line.contains("two")))) {
                    first = 2;
                    firstIndex = line.indexOf("two");
                }
                if (line.contains("three") && firstIndex > line.indexOf(String.valueOf(line.contains("three")))) {
                    first = 3;
                    firstIndex = line.indexOf("three");
                }
                if (line.contains("four") && firstIndex > line.indexOf(String.valueOf(line.contains("four")))) {
                    first = 4;
                    firstIndex = line.indexOf("four");
                }
                if (line.contains("five") && firstIndex > line.indexOf(String.valueOf(line.contains("five")))) {
                    first = 5;
                    firstIndex = line.indexOf("five");
                }
                if (line.contains("six") && firstIndex > line.indexOf(String.valueOf(line.contains("six")))) {
                    first = 6;
                    firstIndex = line.indexOf("six");
                }
                if (line.contains("seven") && firstIndex > line.indexOf(String.valueOf(line.contains("seven")))) {
                    first = 7;
                    firstIndex = line.indexOf("seven");
                }
                if (line.contains("eight") && firstIndex > line.indexOf(String.valueOf(line.contains("eight")))) {
                    first = 8;
                    firstIndex = line.indexOf("eight");
                }
                if (line.contains("nine") && firstIndex > line.indexOf(String.valueOf(line.contains("nine")))) {
                    first = 9;
                    firstIndex = line.indexOf("nine");
                }

                // checking number from start
                for (int f = 0; f < line.length(); f++) {
                    // checking if current character is number
                    if (isDigit(line.charAt(f)) && firstIndex > line.indexOf(line.charAt(f))) {
                        // System.out.println(line.charAt(f));
                        first = Integer.parseInt(String.valueOf(line.charAt(f)));
                        break;
                    }
                }

                int last = 0;
                int lastIndex = 0;

                if (line.contains("one") && lastIndex < line.indexOf(String.valueOf(line.contains("one"))) || line.contains("one") && line.indexOf(String.valueOf(line.contains("one"))) == -1) {
                    last = 1;
                    lastIndex = line.indexOf("one");
                }
                if (line.contains("two") && lastIndex < line.indexOf(String.valueOf(line.contains("two"))) || line.contains("two") && line.indexOf(String.valueOf(line.contains("two"))) == -1) {
                    last = 2;
                    lastIndex = line.indexOf("two");
                }
                if (line.contains("three") && lastIndex < line.indexOf(String.valueOf(line.contains("three"))) || line.contains("three") && line.indexOf(String.valueOf(line.contains("three"))) == -1) {
                    last = 3;
                    lastIndex = line.indexOf("three");
                }
                if (line.contains("four") && lastIndex < line.indexOf(String.valueOf(line.contains("four"))) || line.contains("four") && line.indexOf(String.valueOf(line.contains("four"))) == -1) {
                    last = 4;
                    lastIndex = line.indexOf("four");
                }
                if (line.contains("five") && lastIndex < line.indexOf(String.valueOf(line.contains("five"))) || line.contains("five") && line.indexOf(String.valueOf(line.contains("five"))) == -1) {
                    last = 5;
                    lastIndex = line.indexOf("five");
                }
                if (line.contains("six") && lastIndex < line.indexOf(String.valueOf(line.contains("six"))) || line.contains("six") && line.indexOf(String.valueOf(line.contains("six"))) == -1) {
                    last = 6;
                    lastIndex = line.indexOf("six");
                }
                if (line.contains("seven") && lastIndex < line.indexOf(String.valueOf(line.contains("seven"))) || line.contains("seven") && line.indexOf(String.valueOf(line.contains("seven"))) == -1) {
                    last = 7;
                    lastIndex = line.indexOf("seven");
                }
                if (line.contains("eight") && lastIndex < line.indexOf(String.valueOf(line.contains("eight"))) || line.contains("eight") && line.indexOf(String.valueOf(line.contains("eight"))) == -1) {
                    last = 8;
                    lastIndex = line.indexOf("eight");
                }
                if (line.contains("nine") && lastIndex < line.indexOf(String.valueOf(line.contains("nine"))) || line.contains("nine") && line.indexOf(String.valueOf(line.contains("nine"))) == -1) {
                    last = 9;
                    lastIndex = line.indexOf("nine");
                }

                // checking number from end
                for (int l = line.length() - 1; l > 0; l--) {
                    // checking if current character is number
                    if (isDigit(line.charAt(l)) && firstIndex < line.indexOf(line.charAt(l)) || isDigit(line.charAt(l)) && line.indexOf(line.charAt(l)) == -1) {
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