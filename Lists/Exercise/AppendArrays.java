package Lists.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> input = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        Collections.reverse(input);
        String print = input.toString().replaceAll("[\\[\\],]","");
        System.out.println(print.replaceAll("\\s+"," "));
    }
}
