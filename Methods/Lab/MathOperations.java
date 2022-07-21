package Methods.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number1 = Integer.parseInt(scan.nextLine());
        String operator = scan.nextLine();
        int number2 = Integer.parseInt(scan.nextLine());
        double result = calculated(number1, number2, operator);
        System.out.println(new DecimalFormat("0.##").format(result));
    }

    private static double calculated(int number1, int number2, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1*1.0 / number2;
                break;
        }
        return result;
    }

}
