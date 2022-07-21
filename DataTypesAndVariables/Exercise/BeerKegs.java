package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        double maxSize = Double.NEGATIVE_INFINITY;
        String maxSizeKeg = "";
        for (int i = 0; i < count; i++) {
            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            double size = Math.PI * Math.pow(radius, 2) * height;
            if (size >= maxSize) {
                maxSize = size;
                maxSizeKeg = model;
            }
        }
        System.out.println(maxSizeKeg);
    }
}
