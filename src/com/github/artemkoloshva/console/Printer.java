package com.github.artemkoloshva.console;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Printer {
    public Printer() {}

    public void println(String text) {
        System.out.println(text);
    }

    public void println() {
        System.out.println();
    }

    public void print(String text) {
        System.out.print(text);
    }

    public void printHangmanArt(int errors) {
        String picture = HangmanAscii.getPicture(errors);
        System.out.println(picture);
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

        System.out.printf("Ошибки (%d): %s  %n", errorsCount, lettersString);
    }
}