package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int studentsCount = Integer.parseInt(scan.nextLine());
        double priceLightSabers = Double.parseDouble(scan.nextLine());
        double priceRobes = Double.parseDouble(scan.nextLine());
        double priceBelts = Double.parseDouble(scan.nextLine());
        double lightSabersCount = Math.ceil(studentsCount * 1.1);
        double robesCount = studentsCount;
        double beltsCount = studentsCount - studentsCount / 6;
        double totalMoneyNeeded = priceLightSabers * lightSabersCount + priceRobes * robesCount + priceBelts * beltsCount;
        if (budget >= totalMoneyNeeded) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalMoneyNeeded);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalMoneyNeeded - budget);
        }
    }
}
