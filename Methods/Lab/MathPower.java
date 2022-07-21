package Methods.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number = Double.parseDouble(scan.nextLine());
        int power = Integer.parseInt(scan.nextLine());
        double result = mathPower(number, power);
        System.out.println(new DecimalFormat("0.####").format(result));
    }

    static double mathPower(double a, int b) {
        return Math.pow(a, b);
    }
}
