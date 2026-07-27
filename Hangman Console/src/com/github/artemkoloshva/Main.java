import com.github.artemkoloshva.core.GameController;
import com.github.artemkoloshva.core.MenuController;
import com.github.artemkoloshva.model.MenuItem;

void main() {
    MenuController menu = new MenuController("Добро пожаловать в консольную игру \"Виселица\"!",
            new MenuItem("1. Новая игра", () -> new GameController().start()),
            new MenuItem("2. Выход из игры", () -> System.exit(0)));

    while (true){
        menu.open();
    }
}
