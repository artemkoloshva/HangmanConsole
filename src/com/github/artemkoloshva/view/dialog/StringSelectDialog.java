package com.github.artemkoloshva.view.dialog;

import java.util.List;

public class StringSelectDialog extends ConsoleDialog<String>{
    private final List<String> keys;

    public StringSelectDialog(String title, String error, List<String> keys) {
        super(title,
                error,
                s -> s,
                s -> getValidator(s, keys));
        this.keys = keys;
    }

    private static boolean getValidator(String s, List<String> keys) {
        for (String key : keys) {
            if (key.equalsIgnoreCase(s)) {
                return true;
            }
        }

        return false;
    }
}
