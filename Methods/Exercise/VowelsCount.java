package Methods.Exercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int count = vowelsCount(input);
        System.out.println(count);
    }

    private static int vowelsCount(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'A' || input.charAt(i) == 'a' || input.charAt(i) == 'E' || input.charAt(i) == 'e' || input.charAt(i) == 'I' ||
                    input.charAt(i) == 'i' || input.charAt(i) == 'O' || input.charAt(i) == 'o' || input.charAt(i) == 'U' || input.charAt(i) == 'u') {
                counter++;
            }
        }
        return counter;
    }
}
