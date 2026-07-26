package core;

import io.InputHandler;
import io.Printer;
import model.InputType;
import model.Round;

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

    public String getRandomWord(){
        Random random = new Random();
        return _wordLoader.getWord(random.nextInt(_wordLoader.getWordsLength()));
    }

    public void newRound(){
        _round.clear();
        _round.setWord(getRandomWord());
    }

    public void start(){
        newRound();
        _printer.println(_round.getWord());
        while (!_round.isWin()){
            _printer.println("[РИСУНОК ВИСЕЛИЦЫ]");
            _printer.println("Cлово: _ _ _ _ _ _ _");
            _printer.println("Ошибки ("+_round.getErrors()+"): п, в, е, а");
            _input.getInput("Введите букву: ", InputType.Letter);
        }
    }
}
