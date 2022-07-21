package Methods.Exercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        int n3 = Integer.parseInt(scan.nextLine());
        int result = subtract(sumTwoNumbers(n1, n2), n3);
        System.out.println(result);
    }

    private static int subtract(int sumTwoNumbers, int n3) {
        return sumTwoNumbers - n3;
    }

    private static int sumTwoNumbers(int n1, int n2) {

        return n1 + n2;
    }

}
