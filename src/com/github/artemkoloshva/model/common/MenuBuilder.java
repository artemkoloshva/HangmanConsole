package com.github.artemkoloshva.model.common;

import com.github.artemkoloshva.model.menu.MenuItem;
import com.github.artemkoloshva.model.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuBuilder implements Builder {
    private final String title;
    private final List<MenuItem> items = new ArrayList<>();

    public MenuBuilder(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("The title cannot be empty.");
        }

        this.title = title;
    }

    public MenuBuilder addItem(String label, Runnable action) {
        this.items.add(new MenuItem(label, action));
        return this;
    }

    @Override
    public Menu build() {
        if (items.isEmpty()) {
            throw new IllegalStateException("The menu must contain at least one item.");
        }

        return new Menu(title, items);
    }
}
