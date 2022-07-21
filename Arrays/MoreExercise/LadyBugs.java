package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scan.nextLine());
        int[] field = new int[fieldSize];
        int[] ladybugs = Arrays.stream(scan.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
        for (int i = 0; i < ladybugs.length; i++) {
            int index = 0;
            if (0 <= ladybugs[i] && ladybugs[i] < field.length) {
                index = ladybugs[i];
                field[index] = 1;
            }
        }
        String input = scan.nextLine();
        int counter = 0;
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            int index = Integer.parseInt(command[0]);
            int distance = Integer.parseInt(command[2]) + counter;
            if (distance==0){
                input = scan.nextLine();
                continue;
            }
            if (0 <= index && index < field.length && field[index] == 1)
                if (command[1].equals("right") && index + distance < field.length) {
                    if (field[index + distance] == 0) {
                        field[index + distance] = 1;
                        field[index] = 0;
                        counter = 0;
                    } else {
                        counter+=distance;
                        continue;
                    }
                } else if (command[1].equals("right") && index + distance >= field.length) {
                    field[index] = 0;
                    counter = 0;
                } else if (command[1].equals("left") && index - distance >= 0) {
                    if (field[index - distance] == 0) {
                        field[index - distance] = 1;
                        field[index] = 0;
                        counter = 0;
                    } else {
                        counter+=distance;
                        continue;
                    }
                } else if (command[1].equals("left") && index - distance < 0) {
                    field[index] = 0;
                    counter = 0;
                }
            input = scan.nextLine();
        }
        Arrays.stream(field).forEach(value -> System.out.printf("%d ", value));
    }
}
