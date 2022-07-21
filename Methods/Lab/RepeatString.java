package Methods.Lab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int repetitionCount = Integer.parseInt(scan.nextLine());
        String newString = newString(input, repetitionCount);
        System.out.println(newString);
    }

    static String newString(String s, int count) {
        String[] strings = new String[count];
        for (int i = 0; i < count; i++) {
            strings[i] = s;
        }
        return String.join("", strings);
    }
}
