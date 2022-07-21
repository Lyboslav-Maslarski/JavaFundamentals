package Arrays.Lab;

import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scan.nextLine());
        }
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
