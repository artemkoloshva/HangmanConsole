package com.github.artemkoloshva.model;

import com.github.artemkoloshva.console.IntegerMinMaxDialog;
import com.github.artemkoloshva.console.Printer;

import java.util.*;

public class ConsoleMenu implements Menu {
    private final String title;
    private final List<MenuItem> items;
    private final Printer printer = new Printer();

    public ConsoleMenu(String title, List<MenuItem> items) {
        this.title = title;
        this.items = items;
    }

    @Override
    public void show() {
        printer.println(title);

        for(MenuItem item : items) {
            printer.println(item.label());
        }
    }

    @Override
    public void execute() {
        int selectedItem = new IntegerMinMaxDialog(
                "Выберите пункт меню:",
                "Неверный ввод.",
                1,
                items.size()).input();

        items.get(selectedItem).action().run();
    }

    public static ConsoleMenuBuilder addTitle(String title) {
        return new ConsoleMenuBuilder(title);
    }
}
