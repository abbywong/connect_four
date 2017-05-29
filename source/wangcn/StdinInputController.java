package wangcn;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StdinInputController implements InputController {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int getColumn() {
        System.out.println("Please choose a column, by typing it's number (first one is zero)");
        try {
            return this.scanner.nextInt();
        } catch (InputMismatchException ex) {
            this.scanner.next();
            System.out.println("That is not a valid input!");
            return getColumn();
        }
    }
}
