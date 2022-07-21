package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int power = Integer.parseInt(scan.nextLine());
        double powerForExhaustion = power * 0.5;
        int distance = Integer.parseInt(scan.nextLine());
        int exhaustionFactor = Integer.parseInt(scan.nextLine());

        int counter = 0;

        while (power >= distance) {
            counter++;
            power -= distance;
            if (power == powerForExhaustion && exhaustionFactor != 0) {
                power /= exhaustionFactor;
            }
        }

        System.out.println(power);
        System.out.println(counter);
    }
}
