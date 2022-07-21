package BasicSyntaxConditionalStatementsAndLoops.MoreExercise;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        if (num1 > num2 && num1 > num3) {
            if (num2 > num3) {
                System.out.printf("%d%n%d%n%d", num1, num2, num3);
            } else {
                System.out.printf("%d%n%d%n%d", num1, num3, num2);
            }
        } else if (num2 > num1 && num2 > num3) {
            if (num1 > num3) {
                System.out.printf("%d%n%d%n%d", num2, num1, num3);
            } else {
                System.out.printf("%d%n%d%n%d", num2, num3, num1);
            }
        } else {
            if (num1 > num2) {
                System.out.printf("%d%n%d%n%d", num3, num1, num2);
            } else {
                System.out.printf("%d%n%d%n%d", num3, num2, num1);
            }
        }
    }
}
