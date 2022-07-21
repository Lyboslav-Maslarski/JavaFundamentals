package DataTypesAndVariables.MoreExercise;

import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = Double.parseDouble(scan.nextLine());
        double b = Double.parseDouble(scan.nextLine());
        double delta = 0.000001;
        if (Math.abs(a - b) <= delta) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
