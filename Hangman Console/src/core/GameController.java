package core;

import io.*;
import model.*;
import java.util.Random;
import java.util.stream.Collectors;

public class GameController {
    private final Printer printer;
    private final InputHandler input;
    private final WordLoader wordLoader;
    private final Round round;
    private final Random random;

    public GameController(){
        printer = new Printer();
        input = new InputHandler();
        wordLoader = new WordLoader("src\\resources\\words.txt");
        round = new Round();
        random = new Random();
    }

    public void newRound(){
        round.clear();
        round.setWord(getRandomWord());
    }

    public String getRandomWord(){
        return wordLoader.getWord(random.nextInt(wordLoader.getWordsLength()));
    }

    public void start(){
        newRound();
        while (!round.isWin() && round.getErrors() < 6){
            displayGameState();
            processPlayerInput();
        }
        endGame();
    }

    private void displayGameState(){
        printer.printHangmanArt(round.getErrors());
        printer.printDisplayWord(round.getWordLetters(), round.getUsedLetters());
        printer.printErrorLetters(round.getErrors(), round.getErrorLetters());
    }

    private void processPlayerInput(){
        char letter = input.getInput("Введите букву: ", InputType.Letter);
        letter = Character.toLowerCase(letter);

        if (!round.isUsedLetter(letter)){
            round.addUsedLetter(letter);

            if (round.hasLetter(letter)){
                printer.println("Правильно! Буква '" + letter + "' есть в слове.");
                checkWin();
            }
            else{
                round.addError(letter);
                printer.println("Неправильно! Буквы '" + letter + "' нет в слове.");
            }
        }
        else{
            printer.println("Вы уже вводили эту букву. Попробуйте другую.");
        }
    }

    private void checkWin(){
        boolean allLettersGuessed = round.getWordLetters().stream()
                .allMatch(letter -> round.isUsedLetter(letter));
        if (allLettersGuessed){
            round.setWin(true);
        }
    }

    private void endGame(){
        printer.printHangmanArt(round.getErrors());

        if (round.isWin()){
            printer.println("Поздравляем! Вы угадали слово!");
        }
        else{
            printer.println("Игра окончена. Вы проиграли.");
        }

        String fullWord = round.getWordLetters().stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        if (!fullWord.isEmpty()) {
            fullWord = Character.toUpperCase(fullWord.charAt(0)) + fullWord.substring(1);
        }

        printer.println("Правильное слово было: " + fullWord);
        printer.println("");
    }
}