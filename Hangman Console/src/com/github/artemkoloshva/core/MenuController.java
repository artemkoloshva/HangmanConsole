package com.github.artemkoloshva.core;

import java.util.*;

import com.github.artemkoloshva.console.InputHandler;
import com.github.artemkoloshva.console.Printer;
import com.github.artemkoloshva.model.InputType;
import com.github.artemkoloshva.model.MenuItem;

public class MenuController {
    private final String text;
    private final List<MenuItem> items;
    private final Printer printer;
    private final InputHandler input;


    public MenuController(String newText, MenuItem... item){
        text = newText;
        this.items = new ArrayList<>();
        printer = new Printer();
        input = new InputHandler();
        Collections.addAll(this.items, item);
    }

    public void open(){
        printer.println(text);
        for(MenuItem item : items){
            printer.println(item.getText());
        }

        int index;
        do {
            index = input.getInput("Выберите пункт меню: ", InputType.Number);
            if (index < 1 || index > items.size()) {
                printer.print("Ошибка. Пункт меню не найден. ");
            }
        } while (index < 1 || index > items.size());

        items.get(index - 1).choose();
    }
}
