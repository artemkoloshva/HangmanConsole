package core;

import java.util.*;

import io.InputHandler;
import io.Printer;
import model.InputType;
import model.MenuItem;

public class Menu {
    private final String _text;
    private final List<MenuItem> _items;
    private final Printer _printer;
    private final InputHandler _input;


    public Menu(String text, MenuItem... items){
        _text = text;
        _items = new ArrayList<>();
        _printer = new Printer();
        _input = new InputHandler();
        Collections.addAll(_items, items);
    }

    public void start(){
        _printer.println(_text);
        for(MenuItem item : _items){
            _printer.println(item.getText());
        }

        int selectedItem = _input.getInput("Выберите пункт меню: ", InputType.Number);
        _items.get(selectedItem - 1).choose();
    }
}
