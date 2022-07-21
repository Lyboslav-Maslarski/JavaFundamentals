package TextProcessing.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] key = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();
        while (!input.equals("find")) {
            StringBuilder massage = new StringBuilder();
            int indexOfNumber = 0;
            for (int i = 0; i < input.length(); i++) {
                char charToAdd = input.charAt(i);
                charToAdd -= key[indexOfNumber];
                massage.append(charToAdd);
                indexOfNumber++;
                if (indexOfNumber == key.length) {
                    indexOfNumber = 0;
                }
            }
            String treasure = massage.substring(massage.indexOf("&") + 1, massage.lastIndexOf("&"));
            String coordinates = massage.substring(massage.indexOf("<") + 1, massage.indexOf(">"));
            System.out.printf("Found %s at %s%n", treasure, coordinates);
            input = scan.nextLine();
        }
    }
}
