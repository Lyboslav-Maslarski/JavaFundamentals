package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            char symbol = scan.nextLine().charAt(0);
            int newSymbol = symbol + key;
            System.out.printf("%c",newSymbol);
        }
    }
}
