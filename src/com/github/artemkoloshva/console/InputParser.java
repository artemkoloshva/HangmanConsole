package com.github.artemkoloshva.console;

import com.github.artemkoloshva.model.InputType;

public class InputParser {
    public InputParser() {}

    @SuppressWarnings("unchecked")
    public <T> T parse(String value, InputType type) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("The value cannot be null or empty.");
        }

        return switch (type) {
            case InputType.NUMBER -> (T) parseInteger(value);
            case InputType.LETTER -> (T) parseCharacter(value);
            default -> throw new IllegalArgumentException("Unsupported type: " + type);
        };
    }

    private Integer parseInteger(String value) {
        if (!value.matches("-?\\d+")) {
            throw new IllegalArgumentException("Incorrect number: " + value);
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The number goes beyond int: " + value);
        }
    }

    private Character parseCharacter(String value) {
        if (value.length() != 1 || !Character.isLetter(value.charAt(0))) {
            throw new IllegalArgumentException("Invalid character: " + value);
        }

        return value.charAt(0);
    }
}