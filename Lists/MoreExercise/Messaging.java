package Lists.MoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> numbers = new ArrayList<>(Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList()));
        StringBuilder string = new StringBuilder(scan.nextLine());
        StringBuilder massage = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            int index = 0;
            for (int j = 0; j < numbers.get(i).length(); j++) {
                index += (numbers.get(i).charAt(j) - '0');
            }
            if (index >= string.length()) {
                index -= string.length();
            }
            massage.append(string.charAt(index));
            string.deleteCharAt(index);
        }
        System.out.println(massage);
    }
}
