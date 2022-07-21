package MidExamPreparation.Mid05July2020;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int employee1 = Integer.parseInt(scan.nextLine());
        int employee2 = Integer.parseInt(scan.nextLine());
        int employee3 = Integer.parseInt(scan.nextLine());
        int studentsCount = Integer.parseInt(scan.nextLine());
        int studentsPerHour = employee1 + employee2 + employee3;
        int hoursNeeded = studentsCount / studentsPerHour;
        if (studentsCount % studentsPerHour != 0) {
            hoursNeeded += 1;
        }
        if (hoursNeeded > 3) {
            if (hoursNeeded % 3 != 0) {
                hoursNeeded += hoursNeeded / 3;
            } else {
                hoursNeeded += hoursNeeded / 3 - 1;
            }
        }
        System.out.printf("Time needed: %dh.", hoursNeeded);
    }

}
