package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            long num1 = scan.nextLong();
            long num2 = scan.nextLong();
            int sum = 0;
            int lastDigit = 0;
            if (num1 > num2) {
                while (num1 != 0) {
                    lastDigit = (int) (num1 % 10);
                    sum += lastDigit;
                    num1 /= 10;
                }
            } else {
                while (num2 != 0) {
                    lastDigit = (int) (num2 % 10);
                    sum += lastDigit;
                    num2 /= 10;
                }
            }
            System.out.println(Math.abs(sum));
        }
    }
}
