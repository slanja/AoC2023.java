package org.puzzles;


import java.io.*;

import static java.lang.Character.isDigit;

public class Puzzle01 {
    public static void main(String[] args) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader("/home/slanja/IdeaProjects/AoC2023.java/src/main/java/org/puzzles/input.txt"))) {
            String line, replace;
            int sum = 0;

            while ((line = br.readLine()) != null) {
                // replacing words with numbers


                /*
                one
                two
                three

                four
                five

                six
                seven

                eight

                nine

                 */

                // checking number from start
                char first = 0;
                for (int f = 0; f < line.length(); f++) {
                    // checking if current character is number
                    if (isDigit(line.charAt(f))) {
                        // System.out.println(line.charAt(f));
                        first = line.charAt(f);
                        break;
                    }
                }
                // checking number from end
                char last = 0;
                for (int l = line.length() - 1; l >= 0; l--) {
                    // checking if current character is number
                    if (isDigit(line.charAt(l))) {
                        // System.out.println(line.charAt(l));
                        last = line.charAt(l);
                        break;
                    }
                }

                // combining first and last number to one string
                int result = Integer.parseInt(Character.toString(first) + Character.toString(last));
                sum += result;
            }
            System.out.println("Result: " + sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}