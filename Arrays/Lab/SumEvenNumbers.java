package Arrays.Lab;

import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numbersAsString = scan.nextLine();
        String[] s = numbersAsString.split(" ");
        int sum = 0;
        int[] numbers = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            numbers[i] = Integer.parseInt(s[i]);
            if (numbers[i] % 2 == 0) {
                sum += numbers[i];
            }
        }
        System.out.println(sum);
    }
}
