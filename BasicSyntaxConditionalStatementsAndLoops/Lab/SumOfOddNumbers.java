package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int num = 1;
        for (int i = 1; i <= n; i++) {

            System.out.println(num);
            sum += num;
            num += 2;
        }
        System.out.println("Sum: " + sum);
    }
}
