package FinalExamPreparation.FinalExam4April2020;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder activationKey = new StringBuilder(scan.nextLine());
        String input = scan.nextLine();
        int startIndex ;
        int endIndex ;
        while (!input.equals("Generate")) {
            String[] command = input.split(">>>");
            switch (command[0]) {

                case "Contains":
                    if (activationKey.toString().contains(command[1])) {
                        System.out.printf("%s contains %s%n", activationKey, command[1]);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    startIndex = Integer.parseInt(command[2]);
                    endIndex = Integer.parseInt(command[3]);
                    if (command[1].equals("Upper")) {
                        activationKey.replace(startIndex, endIndex, activationKey.substring(startIndex, endIndex).toUpperCase());
                    } else {
                        activationKey.replace(startIndex, endIndex, activationKey.substring(startIndex, endIndex).toLowerCase());
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(command[1]);
                    endIndex = Integer.parseInt(command[2]);
                    activationKey.delete(startIndex, endIndex);
                    System.out.println(activationKey);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Your activation key is: " + activationKey);
    }
}
