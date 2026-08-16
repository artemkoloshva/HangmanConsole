import com.github.artemkoloshva.controller.*;
import com.github.artemkoloshva.model.game.Game;
import com.github.artemkoloshva.model.menu.Menu;
import com.github.artemkoloshva.model.dictionary.FileDictionary;
import com.github.artemkoloshva.view.*;
import com.github.artemkoloshva.view.dialog.*;

void main() {
    FileDictionary dictionary = new FileDictionary("src\\com\\github\\artemkoloshva\\resources\\dictionary.txt");

    Menu menu = Menu.addTitle("Добро пожаловать в консольную игру \"Виселица\"!")
            .addItem("1. Новая игра", () -> start(dictionary))
            .addItem("2. Выйти из игры", () -> System.exit(0))
            .build();
    MenuView menuView = new MenuView(new IntegerMinMaxDialog("Выберите пункт меню: ", "Неверный ввод.", 1, menu.getItemsSize()));
    MenuController menuController = new MenuController(menu, menuView);

    menuController.start();
}

private static void start(FileDictionary dictionary) {
    String word =  dictionary.getRandom();

    Game game = new Game(word);
    GameView view = new GameView(new RussianLetterDialog("Введите букву:", "Неверныйы ввод"));
    GameController controller = new GameController(game, view);

    controller.start();
}