package com.github.artemkoloshva.console;

import java.util.*;
import com.github.artemkoloshva.model.InputType;

public class InputHandler {
    private final Scanner scanner;
    private final InputValidator validator;
    private final InputParser parser;
    private final Printer printer;

    public InputHandler() {
        scanner = new Scanner(System.in);
        validator = new InputValidator();
        parser = new InputParser();
        printer = new Printer();
    }

    public <T> T getInput(String text, InputType type) {
        while (true) {
            printer.println(text);

            String value = scanner.next();

            if (validator.isValid(value, type)) {
                return parser.parse(value, type);
            }
            else {
                printer.print("Ошибка ввода. ");
            }
        }
    }

    public <T> T getInput(InputType type) {
        while (true){
            String value = scanner.next();

            if (validator.isValid(value, type)) {
                return parser.parse(value, type);
            }
            else {
                printer.print("Ошибка ввода. Попробуйте еще раз.");
            }
        }
    }
}
