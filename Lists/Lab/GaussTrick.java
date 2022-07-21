package Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        List<Integer> newNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size() / 2; i++) {
            newNumbers.add(i, numbers.get(i) + numbers.get(numbers.size() - 1 - i));
        }
        if (numbers.size() % 2 != 0){
            newNumbers.add(numbers.get(numbers.size()/2));
        }
            for (Integer number : newNumbers) {
                System.out.print(number + " ");
            }

    }
}
