package hogwarts.app.ui;
import java.util.Scanner;

public class TextUI {

    public TextUI() {
    }

    public static int promptText(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);//Stille brugeren et spørgsmål
        int input = Integer.parseInt(scan.nextLine());          //Give brugere et sted at placere sit svar og vente på svaret
        return input;
    }

    public static String promptText2(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);//Stille brugeren et spørgsmål
        String input = scan.nextLine();          //Give brugere et sted at placere sit svar og vente på svaret
        return input;
    }
}
