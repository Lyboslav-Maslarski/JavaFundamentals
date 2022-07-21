package Lists.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        String[] command = scan.nextLine().split(" ");
        while (!command[0].equals("end")) {
            int num = Integer.parseInt(command[1]);
            switch (command[0]) {
                case "Delete":
                    numbers.removeIf(number -> number == num);
                   /* for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == num) {
                            numbers.remove(i);
                            i--;
                        }
                    }*/
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    numbers.add(index, num);
                    break;
            }
            command = scan.nextLine().split(" ");
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
