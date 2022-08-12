package MidExamPreparation.Mid12August2020;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double totalPriceWithoutTaxes = 0;
        String input = scan.nextLine();
        while (!input.equals("regular") && !input.equals("special")) {
            double price = Double.parseDouble(input);
            if (price > 0) {
                totalPriceWithoutTaxes += price;
            } else {
                System.out.println("Invalid price!");
            }
            input = scan.nextLine();
        }
        if (totalPriceWithoutTaxes == 0) {
            System.out.println("Invalid order!");
        } else {
            double taxes = totalPriceWithoutTaxes * 0.2;
            double totalPrice = totalPriceWithoutTaxes + taxes;
            if (input.equals("special")) {
                totalPrice *= 0.9;
            }
            System.out.printf("Congratulations you've just bought a new computer!%nPrice without taxes: %.2f$%nTaxes: %.2f$%n-----------%nTotal price: %.2f$", totalPriceWithoutTaxes, taxes, totalPrice);
        }
    }
}
