import com.github.artemkoloshva.model.ConsoleMenu;
import com.github.artemkoloshva.model.Menu;

void main() {
    Menu menu = ConsoleMenu.addTitle("Добро пожаловать в консольную игру \"Виселица\"!")
            .addItem("1. Новая игра", () -> )
            .addItem("2. Выйти из игры", () -> System.exit(0))
            .build();
}
