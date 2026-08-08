package com.github.artemkoloshva.model;

public class MenuItem {
    private final String text;
    private final Runnable action;

    public MenuItem(String text, Runnable action) {
        this.text = text;
        this.action = action;
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
