package Arrays.Exercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wagons = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int[] passengers = new int[wagons];
        for (int i = 0; i < passengers.length; i++) {
            int ppl = Integer.parseInt(scan.nextLine());
            passengers[i] = ppl;
            sum += passengers[i];
        }
        //  Arrays.stream(passengers).forEach(wagon -> System.out.print(wagon + " "));
        for (int passenger : passengers) {
            System.out.printf("%d ", passenger);
        }
        System.out.println();
        System.out.print(sum);
    }
}
