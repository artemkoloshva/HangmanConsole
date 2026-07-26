package io;

import java.util.*;
import model.InputType;

public class InputHandler{
    private final Scanner _scanner;
    private final InputValidator _validator;
    private final InputParser _parser;
    private final Printer _printer;

    public InputHandler(){
        _scanner = new Scanner(System.in);
        _validator = new InputValidator();
        _parser = new InputParser();
        _printer = new Printer();
    }

    public <T> T getInput(String text, InputType type){
        while (true){
            _printer.println(text);
            String value = _scanner.next();

            if(_validator.isValid(value, type)){
                return _parser.parse(value, type);
            }
            else {
                _printer.print("Ошибка ввода. ");
            }
        }
    }

    public <T> T getInput(InputType type){
        while (true){
            String value = _scanner.next();

            if(_validator.isValid(value, type)){
                return _parser.parse(value, type);
            }
            else {
                _printer.print("Ошибка ввода. Попробуйте еще раз.");
            }
        }
    }
}
