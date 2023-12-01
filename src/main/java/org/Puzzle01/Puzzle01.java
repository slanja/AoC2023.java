package org.Puzzle01;


import java.io.*;

import static java.lang.Character.isDigit;

public class Puzzle01 {
    public static void main(String[] args) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader("/home/slanja/IdeaProjects/AoC2023.java/src/main/java/org/Puzzle01/input.txt"))) {
            String line;
            int sum = 0;
            while ((line = br.readLine()) != null) {
                // process the line
                char first = 0;
                for (int f = 0; f < line.length(); f++) {
                    // checking if current character is number
                    if (isDigit(line.charAt(f))) {
                        // System.out.println(line.charAt(f));
                        first = line.charAt(f);
                        break;
                    }
                }
                char last = 0;
                for (int l = line.length() - 1; l >= 0; l--) {
                    // checking if current character is number
                    if (isDigit(line.charAt(l))) {
                        // System.out.println(line.charAt(l));
                        last = line.charAt(l);
                        break;
                    }
                }

                String result = Character.toString(first) + Character.toString(last);
                int num = Integer.parseInt(result);
                sum += num;
            }
            System.out.println("Result: " + sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}