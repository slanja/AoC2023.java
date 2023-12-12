package org.puzzles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Puzzle07 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/home/slanja/IdeaProjects/AoC2023.java/src/main/java/org/puzzles/inputPuzzle07.txt"));

        HashMap<Integer, Integer> stats = new HashMap<>();

        String[] split;
        int bid = 0;


        for (String line : lines) {
            split = line.split(" ");
            System.out.println();

            bid = Integer.parseInt(split[1]);

            char[] cards = split[0].toCharArray();

            int force = CardType(cards);

            for (int i = 0; i < split[0].length(); i++) {
                switch (cards[i]) {
                    case 'A':
                        force += 14;
                        break;
                    case 'K':
                        force += 13;
                        break;
                    case 'Q':
                        force += 12;
                        break;
                    case 'J':
                        force += 11;
                        break;
                    case 'T':
                        force += 10;
                        break;
                    case '9':
                        force += 9;
                        break;
                    case '8':
                        force += 8;
                        break;
                    case '7':
                        force += 7;
                        break;
                    case '6':
                        force += 6;
                        break;
                    case '5':
                        force += 5;
                        break;
                    case '4':
                        force += 4;
                        break;
                    case '3':
                        force += 3;
                        break;
                    case '2':
                        force += 2;
                        break;
                }
            }

            stats.put(force, bid);
        }

        List<Integer> byKey = new ArrayList<>(stats.keySet());
        Collections.sort(byKey);

        int sum = 0;

        for (int k = 0; k < lines.size(); k++) {
            System.out.println(stats.get(byKey.get(k)));
            sum += stats.get(byKey.get(k)) * k+1;
        }
        // get value na pozici sortnutého klíče a vynásobit value k+1

        System.out.println(stats);
        System.out.println(sum);


        // vytvoření hash mapy s key hodnotou síly karet v ruce a value bude sázka
    }

    public static int CardType(char[] cards) {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
        int ten = 0;
        int jack = 0;
        int queen = 0;
        int king = 0;
        int ace = 0;

        for (int c = 0; c < cards.length; c++) {
            switch (cards[c]) {
                case '1':
                    one += 1;
                    break;
                case '2':
                    two += 1;
                    break;
                case '3':
                    three += 1;
                    break;
                case '4':
                    four += 1;
                    break;
                case '5':
                    five += 1;
                    break;
                case '6':
                    six += 1;
                    break;
                case '7':
                    seven += 1;
                    break;
                case '8':
                    eight += 1;
                    break;
                case '9':
                    nine += 1;
                    break;
                case 'T':
                    ten += 1;
                    break;
                case 'J':
                    jack += 1;
                    break;
                case 'Q':
                    queen += 1;
                    break;
                case 'K':
                    king += 1;
                    break;
                case 'A':
                    ace += 1;
                    break;
            }
        }

        if (one == 5 || two == 5 || three == 5 || four == 5 || five == 5 || six == 5 || seven == 5 || eight == 5 || nine == 5 || ten == 5 || jack == 5 || queen == 5 || king == 5 || ace == 5) {
            return 700;
        }

        else if (one == 4 || two == 4 || three == 4 || four == 4 || five == 4 || six == 4 || seven == 4 || eight == 4 || nine == 4 || ten == 4 || jack == 4 || queen == 4 || king == 4 || ace == 4) {
            return 600;
        }

        else if ((one == 3 || one == 2) && (two == 3 || two == 2 || three == 3 || three == 2 || four == 3 || four == 2 || five == 3 || five == 2 || six == 3 || six == 2 || seven == 3 || seven == 2 || eight == 3 || eight == 2 || nine == 3 || nine == 2 || ten == 3 || ten == 2 || jack == 3 || jack == 2 || queen == 3 || queen == 2 || king == 3 || king == 2 || ace == 3 || ace == 2)) {
            return 500;
        }

        else if (one == 3 || two == 3 || three == 4 || four == 3 || five == 3 || six == 3 || seven == 3 || eight == 3 || nine == 3 || ten == 3 || jack == 3 || queen == 3 || king == 3 || ace == 3) {
            return 400;
        }

        else if ((one == 2 && two == 2) || (three == 2 && two == 2) || (four == 2 && three == 2) || (five == 2 && four == 2) || (six == 2 && five == 2) || (seven == 2 && six == 2) || (eight == 2 && seven == 2) || (nine == 2 && eight == 2) || (ten == 2 && nine == 2) || (jack == 2 && ten == 2) || (queen == 2 && jack == 2) || (king == 2 && queen == 2) || (ace == 2 && king == 2)) {
            return 300;
        }

        else if (one == 2 || two == 2 || three == 2 || four == 2 || five == 2 || six == 2 || seven == 2 || eight == 2 || nine == 2 || ten == 2 || jack == 2 || queen == 2 || king == 2 || ace == 2) {
            return 200;
        }

        else if ((one == 1 && two == 1 && three == 1 && four == 1 && five == 1) || (two == 1 && three == 1) || (three == 1 && four == 1) || (four == 1 && five == 1) || (five == 1 && six == 1) || (six == 1 && seven == 1) || (seven == 1 && eight == 1) || (eight == 1 && nine == 1) || (nine == 1 && ten == 1) || (ten == 1 && jack == 1) || (jack == 1 && queen == 1) || (queen == 1 && king == 1) || (king == 1 && ace == 1)) {
            return 100;
        }

        else {
            return 0;
        }

        // analýza typu karet v ruce, pokud budou tři stejné a jinak nic, tak je to tři stejné
        // pokud budou všechny postupně je to vysoká karta

        /*

        500 - Five of a kind, where all five cards have the same label: AAAAA
        400 - Four of a kind, where four cards have the same label and one card has a different label: AA8AA
        300 - Full house, where three cards have the same label, and the remaining two cards share a different label: 23332
        200 - Three of a kind, where three cards have the same label, and the remaining two cards are each different from any other card in the hand: TTT98
        100 - Two pair, where two cards share one label, two other cards share a second label, and the remaining card has a third label: 23432
        One pair, where two cards share one label, and the other three cards have a different label from the pair and each other: A23A4
        High card, where all cards' labels are distinct: 23456

         */
    }
}
