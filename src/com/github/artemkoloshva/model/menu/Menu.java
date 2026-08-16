package com.github.artemkoloshva.model.menu;

import com.github.artemkoloshva.model.common.MenuBuilder;

import java.util.*;

public class Menu {
    private final String title;
    private final List<MenuItem> items;

    public Menu(String title, List<MenuItem> items) {
        this.title = title;
        this.items = List.copyOf(items);
    }

    public String getTitle() {
        return title;
    }

    public MenuItem getItem(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("There is no such item: " + index);
        }
        return items.get(index);
    }

    public int getItemsSize() {
        return items.size();
    }

    public static MenuBuilder addTitle(String title) {
        return new MenuBuilder(title);
    }
}
