package com.github.artemkoloshva.view;

import com.github.artemkoloshva.view.dialog.RussianLetterDialog;

import java.util.List;
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
        System.out.println(ViewMessages.SHOW_WORD_MASSAGE + maskedWord);
    }

    public void showErrors(List<Character> errorLetters) {
        String letters = errorLetters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(ViewMessages.ERRORS_SEPARATOR));

        String output = String.format("Ошибки (%d): %s", errorLetters.size(), letters);

        System.out.println(output);
    }

    public void showRepeatingLetterError() {
        System.out.println(ViewMessages.SHOW_REPEATING_ERROR);
    }

    public void showWin() {
        System.out.println(ViewMessages.SHOW_WIN);
    }

    public void showLoose(String secretWord) {
        System.out.println(ViewMessages.SHOW_LOOSE + secretWord);
        System.out.println();
    }

    public char getLetter() {
        return dialog.input();
    }
}
