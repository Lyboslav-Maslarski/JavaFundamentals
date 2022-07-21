package ObjectsAndClasses.Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger a = scan.nextBigInteger();
      //  BigInteger a = new BigInteger(scan.nextLine());
      //  BigInteger b = new BigInteger(scan.nextLine());
        BigInteger b = scan.nextBigInteger();
        BigInteger sum= a.add(b);
        System.out.println(sum);
    }
}
