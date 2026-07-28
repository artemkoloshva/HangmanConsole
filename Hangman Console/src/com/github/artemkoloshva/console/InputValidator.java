package com.github.artemkoloshva.console;

import com.github.artemkoloshva.model.InputType;

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
        if (value == null || value.length() != 1) {
            return false;
        }

        return Character.UnicodeBlock.of(value.charAt(0)) == Character.UnicodeBlock.CYRILLIC;
    }
}
