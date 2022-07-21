package Methods.Exercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        System.out.println(middleChar(line));
    }

    private static String middleChar(String line) {
        if (line.length() % 2 == 0) {
            return "" + line.charAt(line.length() / 2 - 1) + line.charAt(line.length() / 2);
        }
        return "" + line.charAt(line.length() / 2);
    }
}
