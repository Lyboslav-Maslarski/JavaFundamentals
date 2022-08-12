package MidExamPreparation.Mid1;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int healthPoints = 100;
        int bitcoins = 0;
        int roomCounter = 0;
        String[] input = scan.nextLine().split("\\|");
        for (String s : input) {
            roomCounter++;
            String command = s.split(" ")[0];
            int number = Integer.parseInt(s.split(" ")[1]);
            switch (command) {
                case "potion":
                    if (healthPoints + number <= 100) {
                        healthPoints += number;
                    } else {
                        number = 100 - healthPoints;
                        healthPoints = 100;
                    }
                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", healthPoints);
                    break;
                case "chest":
                    bitcoins += number;
                    System.out.printf("You found %d bitcoins.%n", number);
                    break;
                default:
                    healthPoints -= number;
                    if (healthPoints > 0) {
                        System.out.printf("You slayed %s.%n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.println("Best room: " + roomCounter);
                        return;
                    }
                    break;
            }
        }
        System.out.println("You've made it!");
        System.out.println("Bitcoins: " + bitcoins);
        System.out.println("Health: " + healthPoints);
    }
}
