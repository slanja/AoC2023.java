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
        long result = 1;

        long time = 0;
        long distance = 0;

        for (String line : lines) {

            // removing unnesecarry spaces and spliting whole file to one array
            split = line.trim().replaceAll(" +", "").split(":");

            if (timeFull == false) {
                time = Long.parseLong(split[1]);
                timeFull = true;
            } else {
                distance = Long.parseLong(split[1]);
            }

        }
        int sum = 0;
        for (int a = 0; a < time+1; a++) {
            speed = a;
            long tr = (time - a) * speed;

            if (tr > distance) {
                    sum += 1;
            }
        }

        result = sum;
        System.out.println("Result: " + result);

            // vezmu rychlost tu odečtu od celkového času a potom vynásobím rychlostí, pokud bude vzdálenost větší než rekord přičtu sum
            // for loop na opakování po velikosti čísla
    }
}