package Lists.MoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list1 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> finalList = new ArrayList<>();
        if (list1.size() > list2.size()) {
            int top;
            int bottom;
            if (list1.get(list1.size() - 1) > list1.get(list1.size() - 2)) {
                top = list1.get(list1.size() - 1);
                bottom = list1.get(list1.size() - 2);
            } else {
                top = list1.get(list1.size() - 2);
                bottom = list1.get(list1.size() - 1);
            }
            for (int i = 0; i < list2.size(); i++) {
                if (bottom < list1.get(i) && list1.get(i) < top) {
                    finalList.add(list1.get(i));
                }
                if (bottom < list2.get(i) && list2.get(i) < top) {
                    finalList.add(list2.get(i));
                }
            }
        } else {
            int top;
            int bottom;
            if (list2.get(0) > list2.get(1)) {
                top = list2.get(0);
                bottom = list2.get(1);
            } else {
                top = list2.get(1);
                bottom = list2.get(0);
            }
            for (int i = 0; i < list1.size(); i++) {
                if (bottom < list1.get(i) && list1.get(i) < top) {
                    finalList.add(list1.get(i));
                }
                if (bottom < list2.get(i + 2) && list2.get(i + 2) < top) {
                    finalList.add(list2.get(i + 2));
                }
            }
        }
        Collections.sort(finalList);
        finalList.forEach(integer -> System.out.print(integer + " "));
    }
}
