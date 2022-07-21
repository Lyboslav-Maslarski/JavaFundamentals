package MidExamPreparation.Mid07April2020;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] targets = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();
        int counter = 0;
        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (0 > index || index >= targets.length) {
                input = scan.nextLine();
                continue;
            }
            if (targets[index] == -1) {
                input = scan.nextLine();
                continue;
            }
            counter++;
            for (int i = 0; i < targets.length; i++) {
                if (targets[i] > targets[index] && targets[i] != -1 && i != index) {
                    targets[i] -= targets[index];
                } else if (targets[i] <= targets[index] && targets[i] != -1 && i != index) {
                    targets[i] += targets[index];
                }
            }
            targets[index] = -1;


            input = scan.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", counter);
        Arrays.stream(targets).forEach(value -> System.out.print(value + " "));
    }
}
