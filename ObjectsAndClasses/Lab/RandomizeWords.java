package ObjectsAndClasses.Lab;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Random rnd = new Random();
        for (int i = 0; i < input.length; i++) {
            int position = rnd.nextInt(input.length);
            String temp = input[i];
            input[i] = input[position];
            input[position] = temp;
        }
        System.out.println(String.join(System.lineSeparator(), input));
    }
}
