package Methods.Exercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 17; i <= n; i++) {
            if (sumDivisibleByEight(i) && atLeastOneOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean atLeastOneOddDigit(int i) {
        while (i > 0) {
            int digit = i % 10;
            if (digit % 2 != 0) {
                return true;
            }
            i /= 10;
        }
        return false;
    }

    private static boolean sumDivisibleByEight(int i) {
        int sum = 0;
        while (i > 0) {
            int digit = i % 10;
            sum += digit;
            i /= 10;
        }
        return sum % 8 == 0;
    }
}
