package core;

import java.util.*;

import io.InputHandler;
import io.Printer;
import model.InputType;
import model.MenuItem;

public class MenuController {
    private final String _text;
    private final List<MenuItem> _items;
    private final Printer _printer;
    private final InputHandler _input;


    public MenuController(String text, MenuItem... items){
        _text = text;
        _items = new ArrayList<>();
        _printer = new Printer();
        _input = new InputHandler();
        Collections.addAll(_items, items);
    }

    public void open(){
        _printer.println(_text);
        for(MenuItem item : _items){
            _printer.println(item.getText());
        }

        int index;
        do {
            index = _input.getInput("Выберите пункт меню: ", InputType.Number);
            if (index < 1 || index > _items.size()) {
                _printer.print("Ошибка. Пункт меню не найден. ");
            }
        } while (index < 1 || index > _items.size());

        _items.get(index - 1).choose();
    }
}
