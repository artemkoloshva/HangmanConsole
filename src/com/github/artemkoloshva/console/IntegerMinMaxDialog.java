package com.github.artemkoloshva.console;

public class IntegerMinMaxDialog extends ConsoleDialog<Integer> {
    private final int min;
    private final int max;

    public IntegerMinMaxDialog(String title, String error, int min, int max) {
        super(title,
                error,
                Integer::parseInt,
                n -> n >= min && n <= max);
        this.min = min;
        this.max = max;
    }
}
