package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] line = scan.nextLine().split(" ");
        int[] numbers = new int[line.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }
        int maxCounter = 0;
        int digit = 0;
        int counter = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                counter++;
                if (counter > maxCounter) {
                    maxCounter = counter;
                    digit = numbers[i];
                }
            } else {
                counter = 0;
            }
        }
        for (int i = 0; i <= maxCounter; i++) {
            System.out.printf("%d ", digit);
        }
    }
}