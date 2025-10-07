package hogwarts.data;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUI {
    private ArrayList<String> menuOptions = new ArrayList<>();
    private String menuHeading;
    private boolean endWithZero;
    private Scanner scanner = new Scanner(System.in);
    public MenuUI() {

    }

    public int promptMenuChoice(String menuHeading, ArrayList<String> menuOptions, boolean endWithZero) {
        System.out.println(menuHeading + "\n" + "-".repeat(menuHeading.length()));

        int i = 1;
        int bit = endWithZero ? 1 : 0;

        for (String menuOption : menuOptions) {
            if (bit < menuOptions.size()) {
                System.out.println(i + ") " + menuOption);
                i++;
                bit++;
            } else {
                i = 0;
                System.out.println();
                System.out.println(i + ") " + menuOption);
            }
        }
        while (true) {
            System.out.println("Type a number from the list");
            int choice = Integer.parseInt(scanner.nextLine());
            try {

                if (choice <= menuOptions.size() && choice >= 0) {
                    return choice;
                } else {
                    System.err.println(("Please enter a valid number"));
                }
            } catch (InputMismatchException | NumberFormatException ex) {
                System.err.println("Please input a number");
            }

        }
    }
}
