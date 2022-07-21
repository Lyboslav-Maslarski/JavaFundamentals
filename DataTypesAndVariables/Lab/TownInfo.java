package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String town = scan.nextLine();
        int population = Integer.parseInt(scan.nextLine());
        short area = Short.parseShort(scan.nextLine());
        System.out.printf("Town %s has population of %d and area %d square km.", town, population, area);
    }
}
