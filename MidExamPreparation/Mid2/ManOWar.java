package MidExamPreparation.Mid2;

import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] pirateShip = Arrays.stream(scan.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int[] warShip = Arrays.stream(scan.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int maxHealth = Integer.parseInt(scan.nextLine());
        boolean endedWithStalemate = true;

        String input = scan.nextLine();
        while (!"Retire".equals(input)) {
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];
            if ("Fire".equals(command)) {
                int index = Integer.parseInt(commandParts[1]);
                int damage = Integer.parseInt(commandParts[2]);
                if (validIndex(index, warShip)) {
                    if (damage >= warShip[index]) {
                        System.out.println("You won! The enemy ship has sunken.");
                        endedWithStalemate = false;
                        break;
                    } else {
                        warShip[index] -= damage;
                    }
                }

            } else if ("Defend".equals(command)) {
                int startIndex = Integer.parseInt(commandParts[1]);
                int endIndex = Integer.parseInt(commandParts[2]);
                int damage = Integer.parseInt(commandParts[3]);
                boolean haveLost = false;
                if (validIndex(startIndex, pirateShip) && validIndex(endIndex, pirateShip)) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        pirateShip[i] -= damage;
                        if (pirateShip[i] <= 0) {
                            haveLost = true;
                            break;
                        }
                    }
                    if (haveLost) {
                        System.out.println("You lost! The pirate ship has sunken.");
                        endedWithStalemate = false;
                        break;
                    }
                }

            } else if ("Repair".equals(command)) {
                int index = Integer.parseInt(commandParts[1]);
                int health = Integer.parseInt(commandParts[2]);
                if (validIndex(index, pirateShip)) {
                    pirateShip[index] = Math.min(maxHealth, pirateShip[index] + health);
                }

            } else if ("Status".equals(command)) {
                long repairNeededSections = Arrays.stream(pirateShip).filter(section -> section < maxHealth * 0.20).count();
                System.out.println(repairNeededSections + " sections need repair.");
            }
            input = scan.nextLine();
        }
        if (endedWithStalemate) {
            System.out.println("Pirate ship status: " + Arrays.stream(pirateShip).sum());
            System.out.println("Warship status: " + Arrays.stream(warShip).sum());
        }
    }

    private static boolean validIndex(int index, int[] ship) {
        return 0 <= index && index < ship.length;
    }
}
