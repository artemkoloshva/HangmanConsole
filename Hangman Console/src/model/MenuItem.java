package model;

public class MenuItem {
    private final String _text;
    private final Runnable _action;

    public MenuItem(String text, Runnable action){
        _text = text;
        _action = action;
    }

    public String getText() {
        return _text;
    }

    public void choose(){
        if (_action != null) {
            _action.run();
        }
    }
}
