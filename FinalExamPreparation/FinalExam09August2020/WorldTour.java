package FinalExamPreparation.FinalExam09August2020;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destinations = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Travel")) {
            String[] command = input.split(":");
            switch (command[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(command[1]);
                    if (validIndex(index, destinations)) {
                        destinations = destinations.substring(0, index) + command[2] + destinations.substring(index);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    if (startIndex <= endIndex && validIndex(startIndex, destinations) && validIndex(endIndex , destinations)) {
                        destinations = destinations.substring(0, startIndex) + destinations.substring(endIndex + 1);
                    }
                    break;
                case "Switch":
                    if (destinations.contains(command[1])) {
                        destinations = destinations.replace(command[1], command[2]);
                    }
                    break;
            }
            System.out.println(destinations);
            input = scan.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + destinations);
    }

    public static boolean validIndex(int index, String s) {
        return 0 <= index && index < s.length();
    }
}
