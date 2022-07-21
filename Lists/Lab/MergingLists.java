package Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list1 = new ArrayList<>(Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        List<Integer> list2 = new ArrayList<>(Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        List<Integer> finalList = new ArrayList<>();
        int a = 0;
        int b = 0;
        while (a < list1.size() || b < list2.size()) {
            if (a < list1.size()) {
                finalList.add(list1.get(a));
                a++;
            }
            if (b < list2.size()) {
                finalList.add(list2.get(b));
                b++;
            }
        }
        for (Integer number : finalList) {
            System.out.print(number + " ");
        }

    }
}
