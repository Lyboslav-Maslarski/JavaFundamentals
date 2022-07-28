package Lists.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double leftSum = 0;
        double rightSum = 0;
        for (int i = 0; i < numbers.length / 2; i++) {
            if (numbers[i] == 0) {
                leftSum *= 0.8;
            } else {
                leftSum += numbers[i];
            }
        }
        for (int i = numbers.length - 1; i > numbers.length / 2; i--) {
            if (numbers[i] == 0) {
                rightSum *= 0.8;
            } else {
                rightSum += numbers[i];
            }
        }
        if (leftSum < rightSum) {
            System.out.printf("The winner is left with total time: %.1f", leftSum);
        } else {
            System.out.printf("The winner is right with total time: %.1f", rightSum);
        }
    }
}
