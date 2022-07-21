package Methods.Exercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char start = scan.nextLine().charAt(0);
        char end = scan.nextLine().charAt(0);
        printCharSequence(start, end);
    }

    private static void printCharSequence(char start, char end) {
        for (int i = Math.min(start, end) + 1; i < Math.max(start, end); i++) {
            System.out.printf("%c ", i);
        }
    }
}
