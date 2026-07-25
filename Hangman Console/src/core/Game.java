package core;

import io.InputHandler;
import io.Printer;

public class Game {
    private final Printer _printer;
    private final InputHandler _input;
    private final WordLoader _wordLoader;

    public Game(){
        _printer = new Printer();
        _input = new InputHandler();
        _wordLoader = new WordLoader();
    }

    public void start(){
        System.out.println("...начало игры");
    }
}
