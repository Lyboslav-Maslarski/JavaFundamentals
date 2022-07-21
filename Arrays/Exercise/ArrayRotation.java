package Arrays.Exercise;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] array = line.split(" ");
        int countRotations = Integer.parseInt(scan.nextLine());
        for (int rotation = 0; rotation < countRotations; rotation++) {
            for (int i = 0; i < array.length - 1; i++) {
                String temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
    //    System.out.println(String.join(" ", array));
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
