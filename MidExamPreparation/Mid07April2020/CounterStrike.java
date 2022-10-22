package MidExamPreparation.Mid07April2020;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int initialEnergy = Integer.parseInt(scan.nextLine());
        int battlesWon = 0;
        boolean hasEnergyLeft = true;
        String input = scan.nextLine();
        while (!"End of battle".equals(input)) {
            int distance = Integer.parseInt(input);
            if (distance <= initialEnergy) {
                battlesWon++;
                initialEnergy -= distance;
                if (battlesWon % 3 == 0) {
                    initialEnergy += battlesWon;
                }
            } else {
                hasEnergyLeft = false;
                System.out.println("Not enough energy! Game ends with " + battlesWon + " won battles and " + initialEnergy + " energy");
                break;
            }

            input = scan.nextLine();
        }

        if (hasEnergyLeft) {
            System.out.println("Won battles: " + battlesWon + ". Energy left: " + initialEnergy);
        }
    }
}
