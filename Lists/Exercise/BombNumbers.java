package Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int[] bomb = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < numbers.size(); i++) {
            if (bomb[0] == numbers.get(i)) {
                for (int j = 0; j < bomb[1]; j++) {
                    if (i < numbers.size() - 1) {
                        numbers.remove(i + 1);
                    }
                    if (i > 0) {
                        numbers.remove(i - 1);
                        i--;
                    }
                }
                numbers.remove(i);
                i--;
            }
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
