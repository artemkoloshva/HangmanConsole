package com.github.artemkoloshva.model;

public class MenuItem {
    private final String text;
    private final Runnable action;

    public MenuItem(String newText, Runnable newAction) {
        text = newText;
        action = newAction;
    }

    public String getText() {
        return text;
    }

    public void choose() {
        if (action != null) {
            action.run();
        }
    }
}
