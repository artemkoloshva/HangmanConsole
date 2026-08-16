package com.github.artemkoloshva.view;

import com.github.artemkoloshva.model.menu.MenuItem;
import com.github.artemkoloshva.view.dialog.IntegerMinMaxDialog;
import com.github.artemkoloshva.model.menu.Menu;

public class MenuView {
    private final IntegerMinMaxDialog dialog;

    public MenuView(IntegerMinMaxDialog dialog) {
        this.dialog = dialog;
    }

    public void show(Menu menu) {
        System.out.println(menu.getTitle());

        for (int i = 0; i < menu.getItemsSize(); i++) {
            System.out.println(menu.getItem(i).label());
        }
    }

    public int select() {
        return dialog.input() - 1;
    }
}
