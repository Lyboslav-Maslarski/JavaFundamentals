package TextProcessing.Exercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] usernames = scan.nextLine().split(", ");
        for (String user : usernames) {
            boolean isValid = true;
            if (3 <= user.length() && user.length() <= 16) {
                for (int i = 0; i < user.length(); i++) {
                    if (!Character.isAlphabetic(user.charAt(i)) && !Character.isDigit(user.charAt(i)) && user.charAt(i) != '-' && user.charAt(i) != '_') {
                        isValid = false;
                    }
                }
                if (isValid) {
                    System.out.println(user);
                }
            }
        }
    }
}
