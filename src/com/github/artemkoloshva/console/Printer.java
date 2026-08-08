package com.github.artemkoloshva.console;

import com.github.artemkoloshva.model.HangmanAscii;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Printer {
    public Printer() {}

    public void println(String text) {
        System.out.println(text);
    }

    public void print(String text) {
        System.out.print(text);
    }

    public void printHangmanArt(int errors) {
        String art = switch (errors) {
            case 0 -> HangmanAscii.STAGE_0.getArt();
            case 1 -> HangmanAscii.STAGE_1.getArt();
            case 2 -> HangmanAscii.STAGE_2.getArt();
            case 3 -> HangmanAscii.STAGE_3.getArt();
            case 4 -> HangmanAscii.STAGE_4.getArt();
            case 5 -> HangmanAscii.STAGE_5.getArt();
            default -> HangmanAscii.STAGE_6.getArt();
        };

        System.out.println(art);
    }

    public void printDisplayWord(List<Character> wordLetters, Set<Character> usedLetters) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < wordLetters.size(); i++) {
            Character letter = wordLetters.get(i);

            if (usedLetters.contains(letter)) {
                char displayChar = (i == 0) ? Character.toUpperCase(letter) : letter;
                result.append(displayChar).append(" ");
            } else {
                result.append("_ ");
            }
        }

        System.out.println("Слово: " + result.toString().trim());
    }

    public void printErrorLetters(int errorsCount, Set<Character> errorLetters) {
        String lettersString = "";

        if (!errorLetters.isEmpty()) {
            lettersString = errorLetters.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
        }

        System.out.println("Ошибки (" + errorsCount + "): " + lettersString);
    }
}