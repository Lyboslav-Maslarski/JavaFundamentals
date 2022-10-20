package MidExamPreparation.Mid12August2020;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int peopleInQueue = Integer.parseInt(scan.nextLine());
        int[] theLift = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < theLift.length; i++) {
            if (theLift[i] < 4 && peopleInQueue > 0) {
                int freeSpaces = 4 - theLift[i];
                if (peopleInQueue >= freeSpaces) {
                    theLift[i] = 4;
                    peopleInQueue -= freeSpaces;
                } else {
                    theLift[i] += peopleInQueue;
                    peopleInQueue = 0;
                }
            }
        }
        boolean hasFreeSpace = false;
        for (int cabin : theLift) {
            if (cabin != 4) {
                hasFreeSpace = true;
                break;
            }
        }
        if (peopleInQueue != 0) {
            System.out.println("There isn't enough space! " + peopleInQueue + " people in a queue!");
        } else if (hasFreeSpace) {
            System.out.println("The lift has empty spots!");
        }
        Arrays.stream(theLift).forEach(cabin -> System.out.print(cabin + " "));
    }
}
