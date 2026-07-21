import java.util.Scanner;

public class InputHandler{
    private final Scanner _scanner;
    private final Validator _validator;

    public InputHandler(){
        _scanner = new Scanner(System.in);
        _validator = new Validator();
    }
}
