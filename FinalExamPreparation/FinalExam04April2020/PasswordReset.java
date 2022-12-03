package FinalExamPreparation.FinalExam04April2020;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        String command = scan.nextLine();

        while (!"Done".equals(command)) {

            if (command.equals("TakeOdd")) {

                password = takeOddCharsFromPass(password);

            } else if (command.contains("Cut")) {

                int index = Integer.parseInt(command.split("\\s+")[1]);
                int length = Integer.parseInt(command.split("\\s+")[2]);

                password = password.replaceFirst(password.substring(index, index + length), "");

            } else if (command.contains("Substitute")) {

                String substring = command.split("\\s+")[1];
                String substitute = command.split("\\s+")[2];

                if (password.contains(substring)) {

                    password = password.replace(substring, substitute);

                } else {

                    System.out.println("Nothing to replace!");
                    command = scan.nextLine();
                    continue;

                }
            }

            System.out.println(password);
            command = scan.nextLine();
        }

        System.out.println("Your password is: " + password);
    }

    private static String takeOddCharsFromPass(String password) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < password.length(); i += 2) {
            sb.append(password.charAt(i));
        }
        return sb.toString();
    }
}
