package Arrays.Exercise;

import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] chest = scan.nextLine().split("\\|");
        String input = scan.nextLine();
        while (!input.equals("Yohoho!")) {
            String[] command = input.split(" ");
            if (command[0].equals("Loot")) {
                for (int i = 1; i < command.length; i++) {
                    boolean notPresent = true;
                    for (int j = 0; j < chest.length; j++) {
                        if (command[i].equals(chest[j])) {
                            notPresent = false;
                            break;
                        }
                    }
                    if (notPresent) {
                        String[] newChest = new String[chest.length + 1];
                        for (int j = 0; j < chest.length; j++) {
                            newChest[j + 1] = chest[j];
                        }
                        newChest[0] = command[i];
                        chest = newChest;
                    }
                }
            } else if (command[0].equals("Drop")) {
                int index = Integer.parseInt(command[1]);
                if (index < 0 || index >= chest.length) {
                    input = scan.nextLine();
                    continue;
                }
                String temp = chest[index];
                for (int i = index; i < chest.length - 1; i++) {
                    chest[i] = chest[i + 1];
                }
                chest[chest.length - 1] = temp;
            } else if (command[0].equals("Steal")) {
                int count = Integer.parseInt(command[1]);
                if (count < chest.length) {
                    for (int i = chest.length - count; i < chest.length; i++) {
                        if (i == chest.length - 1) {
                            System.out.printf("%s%n", chest[i]);
                        } else {
                            System.out.printf("%s, ", chest[i]);
                        }
                    }
                    String[] newChest = new String[chest.length - count];
                    for (int i = 0; i < chest.length - count; i++) {
                        newChest[i] = chest[i];
                    }
                    chest = newChest;
                } else {
                    for (int i = 0; i < chest.length; i++) {
                        if (i == chest.length - 1) {
                            System.out.printf("%s%n", chest[i]);
                        } else {
                            System.out.printf("%s, ", chest[i]);
                        }
                    }
                    chest = new String[0];
                }
            }
            input = scan.nextLine();
        }
        if (chest.length == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            double sum = 0;
            for (int i = 0; i < chest.length; i++) {
                sum += chest[i].length();
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.", sum / chest.length);
        }
    }
}
