package com.github.artemkoloshva.model;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMenuBuilder implements MenuBuilder {
    private final String title;
    private final List<MenuItem> items = new ArrayList<>();

    public ConsoleMenuBuilder(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("The title cannot be empty.");
        }

        this.title = title;
    }

    @Override
    public ConsoleMenuBuilder addItem(String label, Runnable action) {
        this.items.add(new MenuItem(label, action));
        return this;
    }

    @Override
    public ConsoleMenu build() {
        if (items.isEmpty()) {
            throw new IllegalStateException("The menu must contain at least one item.");
        }

        return new ConsoleMenu(title, items);
    }
}
