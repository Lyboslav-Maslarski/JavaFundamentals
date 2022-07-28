package Lists.MoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Integer> numbers = new ArrayList<>();
        StringBuilder massage = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ('0' <= c && c <= '9') {
                numbers.add(c - '0');
            } else {
                massage.append(c);
            }
        }
        List<Integer> take = new ArrayList<>();
        List<Integer> skip = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                take.add(numbers.get(i));
            } else {
                skip.add(numbers.get(i));
            }
        }
        StringBuilder decryptedMassage = new StringBuilder();
        for (int i = 0; i < take.size(); i++) {
            int charsToTake = take.get(i);
            int charsToSkip = skip.get(i);
            if (massage.length() > charsToTake) {
                decryptedMassage.append(massage.substring(0, charsToTake));
                massage.delete(0, charsToTake + charsToSkip);
            } else {
                decryptedMassage.append(massage.substring(0));
            }

        }
        System.out.println(decryptedMassage);
    }
}
