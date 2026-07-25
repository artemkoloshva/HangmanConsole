package io;

import model.InputType;

public class InputValidator {
    public InputValidator() {}

    public boolean isValid(String value, InputType type) {
        if (value == null || value.isEmpty() || type == null) {
            return false;
        }

        return switch (type) {
            case InputType.Number -> isNumber(value);
            case InputType.Letter -> isLetter(value);
        };
    }

    private boolean isNumber(String value) {
        return value.matches("-?\\d+");
    }

    private boolean isLetter(String value) {
        return value.length() == 1 && Character.isLetter(value.charAt(0));
    }
}
