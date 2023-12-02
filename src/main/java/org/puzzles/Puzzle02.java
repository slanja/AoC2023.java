package org.puzzles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Spliterator;

import static java.lang.Character.isDigit;

public class Puzzle02 {
    public static void main(String[] args) {
        // 12 red cubes, 13 green cubes, and 14 blue
        int id = 1;
        int digit;
        String[] split;
        try {
            List<String> allLines = Files.readAllLines(Paths.get("/home/slanja/IdeaProjects/AoC2023.java/src/main/java/org/puzzles/inputPuzzle02.txt"));


            for (String line : allLines) {
                split = line.split(",");
                for (int i = 0; i < split.length; i++) {
                    if (split[i].contains("red")) {

                    }
                    System.out.println(id + ": " + split[i]);
                }
                id++;
                // System.out.println(line);
            }
        } catch (IOException e) {

        }
    }
}
