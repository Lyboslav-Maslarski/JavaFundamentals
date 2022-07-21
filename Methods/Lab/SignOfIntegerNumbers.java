package Methods.Lab;

import java.util.Scanner;

public class SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        signOfNumber(number);
    }

    static void signOfNumber(int number) {
        if (number == 0) {
            System.out.printf("The number %d is zero.", number);
        } else if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        } else {
            System.out.printf("The number %d is negative.", number);
        }
    }
}
