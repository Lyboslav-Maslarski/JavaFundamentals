package MidExamPreparation.Mid05July2020;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        double average = Arrays.stream(numbers).average().getAsDouble();
        List<Integer> greaterNumbers = Arrays.stream(numbers).filter(num -> num > average).boxed().sorted().collect(Collectors.toList());
        if (greaterNumbers.isEmpty()) {
            System.out.println("No");
        } else {
            Collections.reverse(greaterNumbers);
            System.out.println(greaterNumbers.stream().limit(5).map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
