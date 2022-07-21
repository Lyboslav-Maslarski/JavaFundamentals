package Arrays.Lab;

import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] array = line.split("\\s+");
        int[] numbers = new int[array.length];
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < array.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];
            } else {
                oddSum += numbers[i];
            }
        }
        System.out.println(evenSum - oddSum);
    }
}
