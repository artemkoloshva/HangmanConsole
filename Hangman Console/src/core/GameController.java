package core;

import io.*;
import model.*;
import java.util.Random;

public class GameController {
    private final Printer _printer;
    private final InputHandler _input;
    private final WordLoader _wordLoader;
    private final Round _round;

    public GameController(){
        _printer = new Printer();
        _input = new InputHandler();
        _wordLoader = new WordLoader("C:\\Users\\kArtem\\IdeaProjects\\Hangman Console\\src\\resources\\words.txt");
        _round = new Round();
    }

    public void newRound(){
        _round.clear();
        _round.setWord(getRandomWord());
    }

    public String getRandomWord(){
        Random random = new Random();
        return _wordLoader.getWord(random.nextInt(_wordLoader.getWordsLength()));
    }

    public String getArtByErrors(int error){
        return switch (_round.getErrors()) {
            case 0 -> HangmanASCII.Stage0.getArt();
            case 1 -> HangmanASCII.Stage1.getArt();
            case 2 -> HangmanASCII.Stage2.getArt();
            case 3 -> HangmanASCII.Stage3.getArt();
            case 4 -> HangmanASCII.Stage4.getArt();
            case 5 -> HangmanASCII.Stage5.getArt();
            default -> HangmanASCII.Stage6.getArt();
        };
    }

    public

    public void start(){
        newRound();
        _printer.println(_round.getWord());
        while (!_round.isWin()){
            _printer.println(getArtByErrors(_round.getErrors()));
            _printer.println("Cлово: _ _ _ _ _ _ _");
            _printer.println("Ошибки ("+_round.getErrors()+"): п, в, е, а");
            _input.getInput("Введите букву: ", InputType.Letter);
        }
    }
}
