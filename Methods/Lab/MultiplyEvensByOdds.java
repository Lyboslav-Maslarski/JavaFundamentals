package Methods.Lab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int result = getEvenMultipliedByOdd(number);
        System.out.println(result);
    }

    private static int getEvenMultipliedByOdd(int number) {
        int evenSum = getEvenSum(number);
        int oddSum = getOddSum(number);
        return evenSum * oddSum;
    }

    private static int getOddSum(int number) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 != 0) {
                sum += digit;
            }
            number /= 10;
        }
        return sum;
    }

    static int getEvenSum(int number) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                sum += digit;
            }
            number /= 10;
        }
        return sum;
    }
}
