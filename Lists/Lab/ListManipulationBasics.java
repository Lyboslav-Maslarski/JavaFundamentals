package Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
        String[] input = scan.nextLine().split(" ");
        while (!input[0].equals("end")) {
            switch (input[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(input[1]));
                    break;
                case "Remove":
                    Integer num = Integer.parseInt(input[1]);
                    numbers.remove(num);
                    break;
                case "RemoveAt":
                    numbers.remove(Integer.parseInt(input[1]));
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(input[2]), Integer.parseInt(input[1]));
                    break;
            }
            input = scan.nextLine().split(" ");
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}
