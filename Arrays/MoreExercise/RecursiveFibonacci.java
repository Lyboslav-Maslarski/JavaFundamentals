package Arrays.MoreExercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        System.out.println(GetFibonacci(n));
    }

    private static int GetFibonacci(int num) {
        if (num < 2) {
            return num;
        }
        return GetFibonacci(num - 1) + GetFibonacci(num - 2);
    }
}
