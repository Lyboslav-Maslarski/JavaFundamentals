package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int meters = Integer.parseInt(scan.nextLine());
        double kms = meters * 1.0 / 1000;
        System.out.printf("%.2f", kms);
    }
}
