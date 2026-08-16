package com.github.artemkoloshva.model;

public interface MenuBuilder extends Builder<Menu> {
    MenuBuilder addItem(String label, Runnable action);
    Menu build();
}
