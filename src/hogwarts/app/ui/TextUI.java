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
    public static String promptText(String msg, String defaultValue){
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg+(defaultValue));
        String input = scanner.nextLine().trim();
        if (input.isEmpty()){
            return defaultValue;
        } else {
            return input;
        }
    }
    public static int promptNumeric (String msg, int defaultValue){
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);
        scan.nextLine();

        try {
            int input = Integer.parseInt(scan.nextLine());
            return input;
        } catch (NumberFormatException e) {
            return promptNumeric(msg, defaultValue);
        }


    }
}
