package com.github.artemkoloshva.controller;

import com.github.artemkoloshva.model.menu.Menu;
import com.github.artemkoloshva.model.menu.MenuItem;
import com.github.artemkoloshva.view.MenuView;

public class MenuController {
    private final Menu menu;
    private final MenuView view;

    public MenuController(Menu menu, MenuView view) {
        this.menu = menu;
        this.view = view;
    }

    public void start() {
        while (true) {
            view.show(menu);

            int selectedIndex = view.select();

            MenuItem selectedItem = menu.getItem(selectedIndex);

            selectedItem.action().run();
        }
    }
}
