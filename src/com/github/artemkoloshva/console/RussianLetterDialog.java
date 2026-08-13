package com.github.artemkoloshva.console;

public class RussianLetterDialog extends ConsoleDialog<Character>{
    public RussianLetterDialog(String title, String error) {
        super(title,
                error,
                s -> {
                    if (s.length() != 1) {
                        throw new IllegalArgumentException("The entered value is not a character.");
                    }

                    return s.charAt(0);
                },
                c -> {
                    c = Character.toLowerCase(c);
                    return (c >= 'а' && c <= 'я') || c == 'ё';
                }
        );
    }
}
