package Methods.Exercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        if (!between6and10(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!onlyLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!haveTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (between6and10(password) && haveTwoDigits(password) && onlyLettersAndDigits(password)) {
            System.out.println("Password is valid");
        }
    }

    static boolean between6and10(String s) {
        return 6 <= s.length() && s.length() <= 10;
    }

    static boolean haveTwoDigits(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                counter++;
            }
        }
        return counter >= 2;
    }

    static boolean onlyLettersAndDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || '9' < s.charAt(i) && s.charAt(i) < 'A' || 'Z' < s.charAt(i) && s.charAt(i) < 'a' || 'z' < s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
