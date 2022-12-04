package FinalExam;

import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();

        String command = scan.nextLine();
        while (!"Complete".equals(command)) {
            String[] commandParts = command.split("\\s+");

            if (command.contains("Make Upper")) {
                int index = Integer.parseInt(commandParts[2]);
                password = changeCharCaseing(password, index, commandParts[1]);
                System.out.println(password);

            } else if (command.contains("Make Lower")) {
                int index = Integer.parseInt(commandParts[2]);
                password = changeCharCaseing(password, index, commandParts[1]);
                System.out.println(password);

            } else if (command.contains("Insert")) {
                int index = Integer.parseInt(commandParts[1]);
                String charToInsert = commandParts[2];

                if (0 <= index && index < password.length()) {
                    password = password.substring(0, index) + charToInsert + password.substring(index);
                    System.out.println(password);
                }

            } else if (command.contains("Replace")) {
                String searchedChar = commandParts[1];
                int value = Integer.parseInt(commandParts[2]);
                if (password.contains(searchedChar)) {
                    char newChar = (char) (searchedChar.charAt(0) + value);
                    password = password.replace(searchedChar.charAt(0), newChar);
                    System.out.println(password);
                }

            } else if (command.contains("Validation")) {
                if (password.length() < 8) {
                    System.out.println("Password must be at least 8 characters long!");
                }
                if (passwordContainsNotAllowedSymbol(password)) {
                    System.out.println("Password must consist only of letters, digits and _!");
                }
                if (checkForUpperCaseLetter(password)) {
                    System.out.println("Password must consist at least one uppercase letter!");
                }
                if (checkForLowerCaseLetter(password)) {
                    System.out.println("Password must consist at least one lowercase letter!");
                }
                if (checkForDigit(password)) {
                    System.out.println("Password must consist at least one digit!");
                }
            }
            command = scan.nextLine();
        }
    }

    private static boolean checkForDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkForLowerCaseLetter(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkForUpperCaseLetter(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean passwordContainsNotAllowedSymbol(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return true;
            }
        }
        return false;
    }

    private static String changeCharCaseing(String password, int index, String predicate) {
        StringBuilder newPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            if (i == index && predicate.equals("Upper")) {
                newPassword.append(Character.toUpperCase(password.charAt(index)));
            } else if (i == index && predicate.equals("Lower")) {
                newPassword.append(Character.toLowerCase(password.charAt(index)));
            } else {
                newPassword.append(password.charAt(i));
            }
        }
        return newPassword.toString();
    }
}
