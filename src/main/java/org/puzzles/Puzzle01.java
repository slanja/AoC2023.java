package org.puzzles;


import java.io.*;

import static java.lang.Character.isDigit;

public class Puzzle01 {
    public static void main(String[] args) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader("/home/slanja/IdeaProjects/AoC2023.java/src/main/java/org/puzzles/inputPuzzle01.txt"))) {
            String line, replace;
            int sum = 0;

            while ((line = br.readLine()) != null) {
                // replacing words with numbers
                replace = line.replace("one", "1")
                        .replace("two", "2")
                        .replace("three", "3")
                        .replace("four", "4")
                        .replace("five", "5")
                        .replace("six", "6")
                        .replace("seven", "7")
                        .replace("eight", "8")
                        .replace("nine", "9");

                // checking number from start
                char first = 0;
                for (int f = 0; f < replace.length(); f++) {
                    // checking if current character is number
                    if (isDigit(replace.charAt(f))) {
                        // System.out.println(line.charAt(f));
                        first = replace.charAt(f);
                        break;
                    }
                }

                String newString = "";
                char letter;

                for (int index = 0; index < line.length(); index++)
                {
                    letter = line.charAt(index); //extracts each character
                    newString = letter + newString; //adds each character in front of the existing string
                }

                String replaceReverse;

                // replacing from end
                replaceReverse = newString.replace("eno", "1")
                        .replace("owt", "2")
                        .replace("eerht", "3")
                        .replace("ruof", "4")
                        .replace("evif", "5")
                        .replace("xis", "6")
                        .replace("neves", "7")
                        .replace("thgie", "8")
                        .replace("enin", "9");

                //System.out.println(replaceReverse);

                // checking number from end
                char last = 0;
                for (int l = 0; l < replaceReverse.length(); l++) {
                    // checking if current character is number
                    if (isDigit(replaceReverse.charAt(l))) {
                        // System.out.println(line.charAt(l));
                        last = replaceReverse.charAt(l);
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