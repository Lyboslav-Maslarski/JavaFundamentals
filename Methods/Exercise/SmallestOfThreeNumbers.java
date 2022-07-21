package Methods.Exercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        int min = minNumber(num1, num2, num3);
        System.out.println(min);
    }

    private static int minNumber(int num1, int num2) {
        return Math.min(num1, num2);
    }

    private static int minNumber(int num1, int num2, int num3) {
        return Math.min(minNumber(num1, num2), num3);
    }
}
