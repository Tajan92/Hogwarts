package hogwarts.app.ui;

import java.util.Scanner;

public class TextUI {

    public TextUI() {
    }

    public static int promptNumeric(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);//Stille brugeren et spørgsmål
        int input = Integer.parseInt(scan.nextLine());          //Give brugere et sted at placere sit svar og vente på svaret
        return input;
    }

    public static String promptText(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);//Stille brugeren et spørgsmål
        String input = scan.nextLine();          //Give brugere et sted at placere sit svar og vente på svaret
        return input;
    }

    public static String promptText(String msg, String defaultValue) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg + (defaultValue));
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return defaultValue;
        } else {
            return input;
        }
    }

    public static int promptNumeric(String msg, int defaultValue) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String input = scan.nextLine().trim();
            if (input.isEmpty()) {
                return defaultValue;
            }
            try {
                int input2 = Integer.parseInt(input);
                return input2;
            } catch (NumberFormatException e) {
                System.out.println("Please try with a whole positive number");
            }

        }
    }
}
