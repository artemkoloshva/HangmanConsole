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
                view.showRepeatingLetterError();
            }

            if (game.checkLoose()) {
                view.showLoose(game.getSecretWord());

                break;
            }

            if (game.checkWin()) {
                view.showWin();

                break;
            }
        }
    }
}