package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int end = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int number = 0;
        for (int digit = 1; digit <= end; digit++) {
            number = digit;
            while (digit > 0) {
                sum += digit % 10;
                digit = digit / 10;
            }
            if ((sum == 5) || (sum == 7) || (sum == 11)) {
                System.out.printf("%d -> True%n", number);
            }else {
                System.out.printf("%d -> False%n", number);
            }
            sum = 0;
            digit = number;
        }
    }
}
