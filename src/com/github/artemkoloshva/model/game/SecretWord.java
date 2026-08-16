package com.github.artemkoloshva.model.game;

public class SecretWord {
    private final String word;

    public SecretWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public boolean contains(char letter) {
        for (char c : word.toCharArray()) {
            if (c == letter) {
                return true;
            }
        }

        return false;
    }
}
