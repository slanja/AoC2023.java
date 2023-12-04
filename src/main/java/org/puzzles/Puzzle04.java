package org.puzzles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle04 {
    public static void main(String[] args) {
        int id = 1;
        int num = 0, sum = 0, power = 0;

        String[] split;
        try {
            List<String> lines = Files.readAllLines(Paths.get("/home/slanja/IdeaProjects/AoC2023.java/src/main/java/org/puzzles/inputPuzzle04.txt"));

            for (String line : lines) {
                // spliting input file one value on each row
                split = line.split(" ");

                // 10
                String[] yours = new String[5];
                // 25
                String[] winning = new String[8];

                for (int i = 0; i < split.length; i++) {
                    // removing unnecessary string, which is game and game id
                    if (split[i].contains("Card")) {
                        i += 2;
                    }

                    else {
                        for (int y = 0; y < yours.length; y++) {
                            yours[y] = split[i];
                        }
                    }

                }
                for (int k = 0; k < yours.length; k++) {
                    System.out.println(winning[k]);
                    // if (winning)
                }

                id++;
            }
        } catch (IOException e) {

        }
    }
}
