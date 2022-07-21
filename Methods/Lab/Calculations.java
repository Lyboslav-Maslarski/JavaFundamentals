package Methods.Lab;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        switch (command) {
            case "add":
                add(number1, number2);
                break;
            case "multiply":
                multiply(number1, number2);
                break;
            case "subtract":
                subtract(number1, number2);
                break;
            case "divide":
                divide(number1, number2);
                break;
        }
    }

    static void add(int num1, int num2) {
        System.out.println(num1 + num2);
    }

    static void multiply(int num1, int num2) {
        System.out.println(num1 * num2);
    }

    static void subtract(int num1, int num2) {
        System.out.println(num1 - num2);
    }

    static void divide(int num1, int num2) {
        System.out.println(num1 / num2);
    }

}
