package BasicSyntaxConditionalStatementsAndLoops.MoreExercise;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            String input = scan.nextLine();
            if (input.equals("0")) {
                System.out.print(" ");
                continue;
            }
            int countDigits = input.length();
            int mainDigit = Integer.parseInt(input) % 10;
            int offset = (mainDigit - 2) * 3;
            if (mainDigit == 8 || mainDigit == 9) {
                offset += 1;
            }
            int letterIndex = offset + countDigits - 1;
            int letter = 97 + letterIndex;
            System.out.printf("%c", letter);
        }
    }
}
