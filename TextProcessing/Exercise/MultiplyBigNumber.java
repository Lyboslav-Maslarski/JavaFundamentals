package TextProcessing.Exercise;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String num1 = scan.nextLine();
        String num2 = scan.nextLine();
        num1 = new StringBuffer(num1).reverse().toString();
        int[] multiply = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            multiply[i] = (num1.charAt(i) - '0') * (num2.charAt(0) - '0');
        }
        String finalNum = "";
        for (int i = 0; i < multiply.length; i++) {
            int digit = multiply[i] % 10;
            int carry = multiply[i] / 10;
            if (i < multiply.length - 1) {
                multiply[i + 1] += carry;
            }
            finalNum = digit + finalNum;
        }
        while (finalNum.length() > 1 && finalNum.charAt(0) == '0') {
            finalNum = finalNum.substring(1);
        }
        System.out.println(finalNum);
    }
}
