package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double displayPrice = Double.parseDouble(scan.nextLine());
        int trashedHeadsets = lostGamesCount / 2;
        int trashedMouses = lostGamesCount / 3;
        int trashedKeyboards = 0;
        int trashedDisplays = 0;
        for (int i = 6; i <= lostGamesCount; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                trashedKeyboards++;
                if (trashedKeyboards % 2 == 0) {
                    trashedDisplays++;
                }
            }
        }
        double money = trashedDisplays * displayPrice + trashedKeyboards * keyboardPrice + trashedMouses * mousePrice + trashedHeadsets * headsetPrice;
        System.out.printf("Rage expenses: %.2f lv.", money);
    }
}
