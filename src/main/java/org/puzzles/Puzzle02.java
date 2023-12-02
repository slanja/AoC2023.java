package org.puzzles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.List;
import java.util.Spliterator;

import static java.lang.Character.isDigit;

public class Puzzle02 {
    public static void main(String[] args) {
        int id = 1;
        int num = 0, sum = 0, power = 0;

        String[] split;
        try {
            List<String> allLines = Files.readAllLines(Paths.get("/home/slanja/IdeaProjects/AoC2023.java/src/main/java/org/puzzles/inputPuzzle02.txt"));

            for (String line : allLines) {
                // spliting input file one value on each row
                split = line.split(" ");
                boolean possible = true;
                int rHigh = 1, gHigh = 1, bHigh = 1;

                for (int i = 0; i < split.length; i++) {
                    // removing unnecessary string, which is game and game id
                    if (split[i].contains("Game")) {
                        i += 2;
                    }

                    // checking if value of specific color is highest one
                    switch (i) {
                        case 2:
                        case 4:
                        case 6:
                        case 8:
                        case 10:
                        case 12:
                        case 14:
                        case 16:
                        case 18:
                        case 20:
                        case 22:
                        case 24:
                        case 26:
                        case 28:
                        case 30:
                        case 32:
                        case 34:
                        case 36:
                        case 38:
                        case 40:
                            if (Integer.parseInt(split[i]) > rHigh && split[i+1].contains("red")) {
                                rHigh = Integer.parseInt(split[i]);
                                break;
                            }
                            else if (Integer.parseInt(split[i]) > gHigh && split[i+1].contains("green")) {
                                gHigh = Integer.parseInt(split[i]);
                                break;
                            }

                            else if (Integer.parseInt(split[i]) > bHigh && split[i+1].contains("blue")) {
                                bHigh = Integer.parseInt(split[i]);
                                break;
                            }
                    }

                    try {
                        num = Integer.parseInt(split[i]);
                    } catch (NumberFormatException e) {
                        // 12 red cubes, 13 green cubes, and 14 blue

                        // checking if the game is possible
                        if (split[i].contains("red") && num > 12) {
                            possible = false;
                        }
                        else if (split[i].contains("green") && num > 13) {
                            possible = false;
                        }
                        else if (split[i].contains("blue") && num > 14) {
                            possible = false;
                        }
                    }
                }
                // adding up ids, when the game was possible
                if (possible) {
                    sum += id;
                }
                // counting total amount of power
                power += (rHigh * gHigh * bHigh);

                id++;
            }
            // printing results
            System.out.println("Sum: " + sum);
            System.out.println("Power: " + power);
        } catch (IOException e) {

        }
    }
}