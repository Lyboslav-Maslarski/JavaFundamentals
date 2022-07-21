package Lists.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
     /*   for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 0) {
                numbers.remove(i);
                i--;
            }
        }*/
        numbers.removeIf(element -> element < 0);
        // if (numbers.size() == 0) {
        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            Collections.reverse(numbers);
           /* for (Integer number : numbers) {
                System.out.print(number + " ");
            }*/
            System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
