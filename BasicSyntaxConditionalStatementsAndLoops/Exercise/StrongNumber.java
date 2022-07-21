package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        String input = "" + number;
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            int digit = number % 10;
            number /= 10;
            int factorial = 1;
            for (int j = 1; j <= digit; j++) {
                factorial *= j;
            }
            sum += factorial;
        }
        if (sum == Integer.parseInt(input)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
