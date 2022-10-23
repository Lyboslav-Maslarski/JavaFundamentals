package MidExam;

import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int numberOfPlayers = Integer.parseInt(scan.nextLine());
        double groupEnergy = Double.parseDouble(scan.nextLine());
        double waterForDayPerPerson = Double.parseDouble(scan.nextLine());
        double foodForDayPerPerson = Double.parseDouble(scan.nextLine());
        double totalWaterNeeded = waterForDayPerPerson * numberOfPlayers * days;
        double totalFoodNeeded = foodForDayPerPerson * numberOfPlayers * days;
        boolean haveEnoughEnergy = true;
        for (int i = 1; i <= days; i++) {
            double energyLost = Double.parseDouble(scan.nextLine());
            groupEnergy -= energyLost;
            if (groupEnergy <= 0) {
                haveEnoughEnergy = false;
                break;
            }
            if (i % 2 == 0) {
                groupEnergy += groupEnergy * 0.05;
                totalWaterNeeded -= totalWaterNeeded * 0.3;
            }
            if (i % 3 == 0) {
                groupEnergy += groupEnergy * 0.10;
                totalFoodNeeded -= totalFoodNeeded / numberOfPlayers;
            }
        }
        if (haveEnoughEnergy) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", totalFoodNeeded, totalWaterNeeded);
        }
    }
}
