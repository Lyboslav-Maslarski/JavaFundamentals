package MidExamPreparation.Mid1;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scan.nextLine());
        int numberOfLectures = Integer.parseInt(scan.nextLine());
        int additionalBonus = Integer.parseInt(scan.nextLine());
        int maxAttendance = 0;
        for (int i = 0; i < numberOfStudents; i++) {
            int studentAttendance = Integer.parseInt(scan.nextLine());
            if (studentAttendance > maxAttendance) {
                maxAttendance = studentAttendance;
            }
        }
        int maxBonus = (int) Math.ceil(maxAttendance * 1.0 / numberOfLectures * (5 + additionalBonus));
        System.out.println("Max Bonus: " + maxBonus + ".");
        System.out.println("The student has attended " + maxAttendance + " lectures.");
    }
}
