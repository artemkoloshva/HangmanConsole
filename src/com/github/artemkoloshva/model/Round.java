package com.github.artemkoloshva.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Round {
    private List<Character> letters;
    private Set<Character> errorLetters;
    private Set<Character> usedLetters;
    private int errorsCount;
    private boolean isWin;

    public Round() {
        clear();
    }

    public void clear() {
        letters = new ArrayList<>();
        errorLetters = new HashSet<>();
        usedLetters = new HashSet<>();
        errorsCount = 0;
        isWin = false;
    }

    public void setWord(String word) {
        for (Character letter : word.toCharArray()) {
            this.letters.add(letter);
        }
    }

    public Character getWordLetter(int index) {
        return letters.get(index);
    }

    public List<Character> getWordLetters() {
        return new ArrayList<>(letters);
    }

    public int getWordLength() {
        return letters.size();
    }

    public boolean hasLetter(Character letter) {
        for (Character let : letters) {
            if (let.equals(letter)) {
                return true;
            }
        }

        return false;
    }

    public void addUsedLetter(Character letter) {
        usedLetters.add(letter);
    }

    public boolean isUsedLetter(Character letter) {
        return usedLetters.contains(letter);
    }

    public Set<Character> getUsedLetters() {
        return new HashSet<>(usedLetters);
    }

    public Set<Character> getErrorLetters() {
        return new HashSet<>(errorLetters);
    }

    public int getErrors() {
        return errorsCount;
    }

    public void addError(Character letter) {
        errorLetters.add(letter);
        errorsCount++;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }
}