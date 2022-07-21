package Methods.Exercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        long factorial1 = getFactorial(n1);
        long factorial2 = getFactorial(n2);
        double result = factorial1 * 1.0 / factorial2;
        System.out.println(new DecimalFormat("0.00").format(result));
    }

    private static long getFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        long sum = 1;
        for (int i = 2; i <= num; i++) {
            sum *= i;
        }
        return sum;
    }
}

