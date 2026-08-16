package com.github.artemkoloshva.model.game;

import com.github.artemkoloshva.model.GameConstants;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final SecretWord secretWord;
    private final List<Character> usedLetters;

    public Game(String word) {
        secretWord = new SecretWord(word);
        usedLetters = new ArrayList<>();
    }

    public String getSecretWord() {
        return secretWord.getWord();
    }

    public int getErrorCount() {
        return (int) usedLetters.stream()
                .filter(letter -> !secretWord.contains(letter))
                .count();
    }

    public String getMaskedWord() {
        StringBuilder sb = new StringBuilder();

        for (char c : secretWord.getWord().toCharArray()) {
            if (usedLetters.contains(c)) {
                sb.append(Character.toUpperCase(c)).append(" ");
            } else {
                sb.append("_ ");
            }
        }

        return sb.toString().trim();
    }

    public List<Character> getErrorLetters() {
        List<Character> errorLetters = new ArrayList<>();

        for (char c : usedLetters) {
            if (!secretWord.contains(c)) {
                errorLetters.add(c);
            }
        }

        return errorLetters;
    }

    public void addLetter(char letter) {
        usedLetters.add(letter);
    }

    public boolean checkLetter(char letter) {
        return usedLetters.contains(letter);
    }

    public boolean checkLoose() {
        return getErrorCount() >= GameConstants.MAX_ERRORS;
    }

    public boolean checkWin() {
        return secretWord.getWord().chars()
                .allMatch(c -> usedLetters.contains((char) c));
    }
}
