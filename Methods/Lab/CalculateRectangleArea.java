package Methods.Lab;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double width = Double.parseDouble(scan.nextLine());
        double length = Double.parseDouble(scan.nextLine());
        double area = area(width, length);
        System.out.printf("%.0f", area);
    }

    static double area(double a, double b) {
        return a * b;
    }
}
