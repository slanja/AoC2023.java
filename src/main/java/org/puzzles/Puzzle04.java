package org.puzzles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle04 {
    public static void main(String[] args) {
        int match = 0;

        String[] split;
        try {
            List<String> lines = Files.readAllLines(Paths.get("/home/slanja/IdeaProjects/AoC2023.java/src/main/java/org/puzzles/inputPuzzle04.txt"));

            for (String line : lines) {
                // spliting input file one value on each row
                split = line.split(" ");

                // 10
                int[] winning = new int[5];

                // 25
                int[] yours = new int[8];

                int w = 0, y = 0;

                for (int i = 0; i < split.length; i++) {
                    // removing unnecessary string, which is game and game id
                    if (split[i].contains("Card")) {
                        i += 2;
                    }

                    if (w < 5) {
                        try {
                            winning[w] = Integer.parseInt(split[i]);
                        } catch (NumberFormatException e) {
                            w--;
                        }
                    }

                    else if (w > 5) {
                        try {
                            yours[y] = Integer.parseInt(split[i]);
                            y++;
                        } catch (NumberFormatException e) {

                        }
                    }

                    w++;
                }
                int sum = 0;

                for (int k = 0; k < winning.length; k++) {
                    for (int n = 0; n < yours.length; n++) {
                        if (winning[k] == yours[n]) {
                            sum += 1;
                            System.out.println(sum);
                            System.out.println("Match: " + yours[n] + " : " + winning[k]);
                        }
                    }
                }

                match += sum ^ 2;
                System.out.println("m: " + match);

            }
            System.out.println();
            System.out.println(match);

        } catch (IOException e) {

        }
    }
}
