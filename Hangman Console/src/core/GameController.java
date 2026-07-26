package core;

import io.*;
import model.*;
import java.util.Random;
import java.util.stream.Collectors;

public class GameController {
    private final Printer _printer;
    private final InputHandler _input;
    private final WordLoader _wordLoader;
    private final Round _round;
    private final Random _random;

    public GameController(){
        _printer = new Printer();
        _input = new InputHandler();
        _wordLoader = new WordLoader("C:\\Users\\kArtem\\IdeaProjects\\Hangman Console\\src\\resources\\words.txt");
        _round = new Round();
        _random = new Random();
    }

    public void newRound(){
        _round.clear();
        _round.setWord(getRandomWord());
    }

    public String getRandomWord(){
        return _wordLoader.getWord(_random.nextInt(_wordLoader.getWordsLength()));
    }

    public void start(){
        newRound();
        while (!_round.isWin() && _round.getErrors() < 6){
            displayGameState();
            processPlayerInput();
        }
        endGame();
    }

    private void displayGameState(){
        _printer.printHangmanArt(_round.getErrors());
        _printer.printDisplayWord(_round.getWordLetters(), _round.getUsedLetters());
        _printer.printErrorLetters(_round.getErrors(), _round.getErrorLetters());
    }

    private void processPlayerInput(){
        char letter = _input.getInput("Введите букву: ", InputType.Letter);
        letter = Character.toLowerCase(letter);

        if (!_round.isUsedLetter(letter)){
            _round.addUsedLetter(letter);

            if (_round.hasLetter(letter)){
                _printer.println("Правильно! Буква '" + letter + "' есть в слове.");
                checkWin();
            }
            else{
                _round.addError(letter);
                _printer.println("Неправильно! Буквы '" + letter + "' нет в слове.");
            }
        }
        else{
            _printer.println("Вы уже вводили эту букву. Попробуйте другую.");
        }
    }

    private void checkWin(){
        boolean allLettersGuessed = _round.getWordLetters().stream()
                .allMatch(letter -> _round.isUsedLetter(letter));
        if (allLettersGuessed){
            _round.setWin(true);
        }
    }

    private void endGame(){
        _printer.printHangmanArt(_round.getErrors());

        if (_round.isWin()){
            _printer.println("Поздравляем! Вы угадали слово!");
        }
        else{
            _printer.println("Игра окончена. Вы проиграли.");
        }

        String fullWord = _round.getWordLetters().stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        if (!fullWord.isEmpty()) {
            fullWord = Character.toUpperCase(fullWord.charAt(0)) + fullWord.substring(1);
        }

        _printer.println("Правильное слово было: " + fullWord);
    }
}