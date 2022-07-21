package Methods.Lab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());
        orderPrice(product, quantity);
    }

    static void orderPrice(String product, int quantity) {
        double price = 0;
        switch (product) {
            case "coffee":
                price = quantity * 1.50;
                break;
            case "water":
                price = quantity * 1.00;
                break;
            case "coke":
                price = quantity * 1.40;
                break;
            case "snacks":
                price = quantity * 2.00;
                break;
        }
        System.out.printf("%.2f", price);
    }
}
