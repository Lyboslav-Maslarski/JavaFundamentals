package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String password = "";
        for (int i = username.length() - 1; i >= 0; i--) {
            password += username.charAt(i);
        }
        String input = scan.nextLine();
        int counter = 0;
        while (!input.equals(password)) {
            counter++;
            if (counter == 4) {
                break;
            }
            System.out.println("Incorrect password. Try again.");
            input = scan.nextLine();
        }
        if (input.equals(password)) {
            System.out.printf("User %s logged in.", username);
        } else {
            System.out.printf("User %s blocked!", username);
        }
    }
}
