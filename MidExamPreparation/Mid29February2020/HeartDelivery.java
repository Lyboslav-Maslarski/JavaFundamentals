package MidExamPreparation.Mid29February2020;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] neighborhood = Arrays.stream(scan.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();
        String[] command = scan.nextLine().split(" ");
        int position = 0;
        while (!command[0].equals("Love!")) {
            position += Integer.parseInt(command[1]);
            if (position >= neighborhood.length) {
                position = 0;
            }
            if (neighborhood[position] > 0) {
                neighborhood[position] -= 2;
                if (neighborhood[position] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", position);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", position);
            }
            command = scan.nextLine().split(" ");
        }
        System.out.printf("Cupid's last position was %d.%n", position);
        int counter = 0;
        for (int house : neighborhood) {
            if (house != 0) {
                counter++;
            }
        }
        if (counter == 0) {
            System.out.printf("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", counter);
        }
    }
}
