package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startingYield = Integer.parseInt(scan.nextLine());
        int totalYield = 0;
        int days = 0;
        while (startingYield >= 100) {
            days++;
            totalYield += startingYield;
            if (totalYield >= 26) {
                totalYield -= 26;
            }
            startingYield -= 10;
        }
        if (totalYield >= 26) {
            totalYield -= 26;
        }
        System.out.println(days);
        System.out.println(totalYield);
    }
}
