package com.github.artemkoloshva.controller;

import com.github.artemkoloshva.model.game.Game;
import com.github.artemkoloshva.view.GameView;

public class GameController {
    private final Game game;
    private final GameView view;

    public GameController(Game game, GameView view) {
        this.game = game;
        this.view = view;
    }

    public void start() {
        while (true) {
            view.showHangmanArt(game.getErrorCount());
            view.showWord(game.getMaskedWord());
            view.showErrors(game.getErrorLetters());

            char letter = Character.toLowerCase(view.getLetter());

            if (!game.checkLetter(letter)) {
                game.addLetter(letter);
            }
            else {
                System.out.println("Вы уже вводили эту букву.");
            }

            if (game.checkLoose()) {
                System.out.println("Вы проиграли!");
                System.out.println("Слово: " + game.getSecretWord());
                System.out.println();

                break;
            }

            if (game.checkWin()) {
                System.out.println("Вы выиграли!");
                System.out.println();

                break;
            }
        }
    }
}