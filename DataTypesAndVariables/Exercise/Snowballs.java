package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countSnowballs = Integer.parseInt(scan.nextLine());
        double maxValue = Double.NEGATIVE_INFINITY;
        int maxSnow = 0;
        int maxTime = 0;
        int maxQuality = 0;
        for (int i = 0; i < countSnowballs; i++) {
            int snowballSnow = Integer.parseInt(scan.nextLine());
            int snowballTime = Integer.parseInt(scan.nextLine());
            int snowballQuality = Integer.parseInt(scan.nextLine());
            double snowballValue = Math.pow(snowballSnow * 1.0 / snowballTime, snowballQuality);
            if (snowballValue > maxValue) {
                maxValue = snowballValue;
                maxSnow = snowballSnow;
                maxTime = snowballTime;
                maxQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnow, maxTime, maxValue, maxQuality);
    }
}
