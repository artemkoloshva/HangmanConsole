package com.github.artemkoloshva.view;

import com.github.artemkoloshva.view.dialog.RussianLetterDialog;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameView {
    private final RussianLetterDialog dialog;

    public GameView(RussianLetterDialog dialog) {
        this.dialog = dialog;
    }

    public void showHangmanArt(int errorCount) {
        String picture = HangmanAscii.getPicture(errorCount);
        System.out.print(picture);
    }

    public void showWord(String maskedWord) {
        System.out.println("Слово: " + maskedWord);
    }

    public void showErrors(List<Character> errorLetters) {
        String letters = errorLetters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        String output = String.format("Ошибки (%d): %s", errorLetters.size(), letters);

        System.out.println(output);
    }

    public char getLetter() {
        return dialog.input();
    }
}
