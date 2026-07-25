package core;

import java.util.*;
import model.MenuItem;

public class Menu {
    private final String _text;
    private List<MenuItem> _items;

    public Menu(String text, MenuItem... items){
        _text = text;
        for(MenuItem item : items){
            _items.add(item);
        }
    }

    public String getText(){
        return _text;
    }

    public List<MenuItem> getItems(){
        return _items;
    }
}
