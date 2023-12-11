package org.puzzles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle06 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/home/slanja/IdeaProjects/AoC2023.java/src/main/java/org/puzzles/inputPuzzle06.txt"));

        String[] split;
        int speed = 0;
        boolean timeFull = false;
        int result = 1;

        int[] time = new int[4];
        int[] distance = new int[4];

        for (String line : lines) {

            // removing unnesecarry spaces and spliting whole file to one array
            split = line.trim().replaceAll(" +", " ").split(" ");

            if (timeFull == false) {
                time = new int[]{Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4])};
                timeFull = true;
            } else {
                distance = new int[]{Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4])};
            }

        }

        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int a = 0; a < time[i]+1; a++) {
                speed = a;
                int tr = (time[i] - a) * speed;

                if (tr > distance[i]) {
                    sum += 1;
                }
            }
            result *= sum;
        }
        System.out.println("Result: " + result);

            // vezmu rychlost tu odečtu od celkového času a potom vynásobím rychlostí, pokud bude vzdálenost větší než rekord přičtu sum
            // for loop na opakování po velikosti čísla
    }
}