package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ordersCount = Integer.parseInt(scan.nextLine());
        double totalPrice = 0;
        for (int i = 0; i < ordersCount; i++) {
            double priceCapsule = Double.parseDouble(scan.nextLine());
            int days = Integer.parseInt(scan.nextLine());
            int capsuleCount = Integer.parseInt(scan.nextLine());
            double orderPrice = days * capsuleCount * priceCapsule;
            totalPrice += orderPrice;
            System.out.printf("The price for the coffee is: $%.2f\n", orderPrice);
        }
        System.out.printf("Total: $%.2f", totalPrice);
    }
}
